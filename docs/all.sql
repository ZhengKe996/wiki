# 电子书表
drop table if exists `ebook`;

create table `ebook`
(
    `id`           bigint not null comment "ID",
    `name`         varchar(50) comment "名称",
    `category1_id` bigint comment "分类1",
    `category2_id` bigint comment "分类2",
    `description`  varchar(200) comment "描述",
    `cover`        varchar(200) comment "封面",
    `doc_count`    int comment "文档数",
    `view_count`   int comment "阅读数",
    `vote_count`   int comment "点赞数",
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ="电子书";

insert into `ebook` (id, name, description)
values (1, 'SpringBoot入门教程', '零基础入门Java开发');
insert into `ebook` (id, name, description)
values (2, 'Vue入门教程', '零基础入门Web开发');
insert into `ebook` (id, name, description)
values (3, 'Python入门教程', '零基础入门Python开发');
insert into `ebook` (id, name, description)
values (4, 'Golang入门教程', '零基础入门Go开发');

# 分类
drop table if exists `category`;
create table `category`
(
    `id`     bigint      not null comment "id",
    `parent` bigint      not null comment "父ID",
    `name`   varchar(50) not null comment "名称",
    `sort`   int comment "顺序",
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment "分类";

insert into `category`(id, parent, name, sort) value (100, 000, '前端开发', 100);
insert into `category`(id, parent, name, sort) value (101, 100, 'Vue', 101);
insert into `category`(id, parent, name, sort) value (102, 100, 'HTML & CSS', 102);
insert into `category`(id, parent, name, sort) value (200, 000, 'Java', 200);
insert into `category`(id, parent, name, sort) value (201, 200, 'SpringBoot', 201);
insert into `category`(id, parent, name, sort) value (202, 200, 'Spring MVC', 202);

insert into `category`(id, parent, name, sort) value (300, 000, 'Python', 300);
insert into `category`(id, parent, name, sort) value (301, 300, 'Scrapy', 301);
insert into `category`(id, parent, name, sort) value (302, 300, 'XPath', 302);


# 文档表
drop table if exists `doc`;
create table `doc`
(
    `id`         bigint      not null comment "id",
    `ebook_id`   bigint      not null default 0 comment "电子书ID",
    `parent`     bigint      not null default 0 comment "父ID",
    `name`       varchar(50) not null comment "名称",
    `sort`       int comment "顺序",
    `view_count` int                  default 0 comment "阅读数",
    `vote_count` int                  default 0 comment "点赞数",
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ="文档";

insert into `doc`(id, ebook_id, parent, name, sort, view_count, vote_count)
values (1, 1, 0, '文档1', 1, 0, 0);
insert into `doc`(id, ebook_id, parent, name, sort, view_count, vote_count)
values (2, 1, 1, '文档1.1', 1, 0, 0);
insert into `doc`(id, ebook_id, parent, name, sort, view_count, vote_count)
values (3, 1, 0, '文档2', 2, 0, 0);
insert into `doc`(id, ebook_id, parent, name, sort, view_count, vote_count)
values (4, 1, 3, '文档2.1', 1, 0, 0);
insert into `doc`(id, ebook_id, parent, name, sort, view_count, vote_count)
values (5, 1, 3, '文档2.2', 2, 0, 0);
insert into `doc`(id, ebook_id, parent, name, sort, view_count, vote_count)
values (6, 1, 5, '文档2.2.1', 1, 0, 0);


CREATE TABLE `content`
(
    `id`      bigint     NOT NULL COMMENT '文档ID',
    `content` mediumtext NOT NULL COMMENT '内容',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='文档内容';

# 用户
drop table if exists `user`;
create table `user`
(
    `id`         bigint      not null comment "ID",
    `login_name` varchar(50) not null comment "用户名",
    `nickname`   varchar(50) comment "昵称",
    `password`   char(32)    not null comment "昵称",
    primary key (`id`),
    unique key `login_name_unique` (`login_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户';


update doc
set view_count = view_count + 1
where id = 1;

# 电子书快照表
drop table if exists `ebook_snapshot`;
create table `ebook_snapshot`
(
    `id`            bigint auto_increment not null comment "ID",
    `ebook_id`      bigint                not null default 0 comment "电子书ID",
    `data`          date                  not null comment "快照日期",
    `view_count`    int                            default 0 comment "阅读数",
    `vote_count`    int                            default 0 comment "点赞数",
    `view_increase` int                            default 0 comment "阅读增长",
    `vote_increase` int                            default 0 comment "点赞增长",
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='电子书快照表';
