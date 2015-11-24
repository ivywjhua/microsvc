package net.microsvc.rpc.thrift.server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import tutorial.Calculator;
import tutorial.Calculator.Iface;
import tutorial.Calculator.Processor;

public class JavaServer {

  private static CalculatorHandler handler;
  private static Calculator.Processor<Iface> processor;

  public static void main(String[] args) {
    try {
      handler = new CalculatorHandler();
      processor = new Processor<Iface>(handler);

      Runnable simple = new Runnable() {
        @Override
        public void run() {
          simple(processor);
        }
      };

      Runnable secure = new Runnable() {
        @Override
        public void run() {
          secure(processor);
        }
      };

      new Thread(simple).start();
      new Thread(secure).start();


    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected static void simple(Processor<Iface> processor) {
    try {
      TServerTransport serverTransport = new TServerSocket(9090);
      TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

      System.out.println("Starting the simple server...");
      server.serve();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected static void secure(Processor<Iface> processor) {
    try {
      TSSLTransportParameters params = new TSSLTransportParameters();
      params.setKeyStore("store/.keystore", "thrift", null, null);
      
      TServerTransport serverTransport = TSSLTransportFactory.getServerSocket(9091, 0, null, params);
      TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
      
      System.out.println("Staring the secure server...");
      server.serve();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
}
