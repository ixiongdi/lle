# My Framework Pro

# 我的个人框架

编程这么长时间总是用别人的轮子，是因为我不喜欢造轮子，但是现在越发发现，总有些轮子用着不舒服。
所以现在想造一个自己的轮子。

1. 这是一个快速开发的框架（Fast Dev Framework）
2. 这是一个低代码量、低心智负担、可扩展的框架（Low Low Extend）

## 技术选型

1.最多人使用的技术，按GitHub star Top100排序，虽然star多并不一定好，但肯定不坏
2.简单易学，项目比较稳定
3.如无必要，勿增实体

### 后端

1. Spring Boot
2. RxJava
3. Redis
4. Protobuf
5. Guava
6. OkHttp
7. Spring
8. Dubbo

### 前端

1. Vue
2. React
3. Bootstrap
4. Axios
5. Vue-element-admin
6. Jquery
7. Element
8. Lodash

### 从零开始构建属于自己的脚手架

基于RBAC的权限控制的简化版

User：主体（这里主要指用户）
Role：角色（和用户是一种多对多的关系）
Permission：权限（定义一种访问资源的方式）

Menu：菜单（菜单是一种资源，给角色分配菜单实际上就定义了一种权限，这是一种不太安全的简化版，但是从使用习惯是更好理解和操作）

这里是一种基础的定义

```sql
-- auto-generated definition
create table sys_user
(
    id          bigint auto_increment
        primary key,
    username    varchar(15)                         not null,
    password    char(32)                            null,
    create_time timestamp default CURRENT_TIMESTAMP null,
    update_time timestamp                           null,
    deleted     bit       default b'0'              null,
    constraint sys_user_username_uindex
        unique (username)
);

-- auto-generated definition
create table sys_role
(
    id          bigint auto_increment
        primary key,
    name        varchar(16)                         null,
    create_time timestamp default CURRENT_TIMESTAMP null,
    update_time timestamp                           null,
    deleted     bit       default b'0'              null
);

-- auto-generated definition
create table sys_menu
(
    id          int auto_increment
        primary key,
    parent_id   int                                  null,
    name        varchar(16)                          not null,
    url         varchar(1024)                        null,
    create_time timestamp  default CURRENT_TIMESTAMP null,
    update_time timestamp                            null,
    deleted     tinyint(1) default 0                 null
);

```

docker
docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -e TZ="Asia/Shanghai" -d mysql --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
每个表都有最基础的4个字段，主键ID，创建时间createtime，更新时间updatetime，deleted逻辑删除

id: SERIAL BIGINT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE
create_time: not null DEFAULT CURRENT_TIMESTAMP
update_time: default NULL ON UPDATE CURRENT_TIMESTAMP
deleted: BOOL tinyint(1) default false，这里并没有使用阿里推荐的is_deleted是因为这个字段通常并不会暴露给业务端，它存在的意义是防止误删和暴露历史数据，这个特例的存在反而会带来更多麻烦