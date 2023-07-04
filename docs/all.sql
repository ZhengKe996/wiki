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