# 项目名称

## 项目简介
这是一个基于 Spring Boot 和 Dubbo 的组装线管理系统，结合 Spring Security 提供安全认证，同时集成 SkyWalking 进行性能监测和分析。项目旨在实现组装线缺陷的实时监测、报警以及详细信息查询功能。

## 技术栈
- Spring Boot: 用于构建微服务应用。
- Dubbo: 提供微服务之间的通信和调用。
- Spring Security: 用于提供身份认证和授权功能，确保系统的安全性。
- SkyWalking: 用于监测和分析系统性能，以便及时发现和解决潜在问题。

## 功能特性
- 微服务技术实现组装线服务拆分与逻辑代码的实现。
- 自动发送警报邮件给组装线管理员，当系统检测到组装线的缺陷时。
- 提供查询功能，允许管理员根据时间、部件类型、工作站编号等条件查询缺陷报告的详细信息。
