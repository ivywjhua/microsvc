---
title: hexo的安装和使用
date: 2016-01-07 11:49:27 
tags: hexo
---

hexo在windows, linux上的安装，配置和使用
## windows上安装hexo和配置
- 安装 node, 下载并安装 node-v4.2.4-x86.msi
- 安装 hexo，npm install -g hexo-cli
- 初始化hexo目录，hexo init [folder]
- cd [folder]
- 安装node依赖的包，npm install
- 安装deployer插件，npm install hexo-deployer-git --save
- 安装feed插件，npm install hexo-generator-feed --save

## hexo常用命令
- hexo new "My New Post"
- hexo s   [server]
- hexo g   [generate]
- hexo d   [deploy]

## hexo 插件和主题
- 插件[https://hexo.io/plugins/](https://hexo.io/plugins/)
- 主题[https://hexo.io/themes/](https://hexo.io/themes/)

## hexo目录结构
- .deploy_git 生成的部署文件夹
- node_modules npm package文件夹
- scaffolds 模版文件夹
- source/_posts/ post文件夹
- source/favicon.ico 网站默认图标
- themes 主题文件夹
- _config.yml hexo blog配置文件
- package.json hexo blog 依赖配置文件



