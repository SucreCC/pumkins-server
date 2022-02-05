--  --------------------------------------
--  pumkins_blog博客表
--
--  -------------------------------------

drop table if exists pumkins_blog;
create table pumkins_blog
(
    id                int auto_increment comment '主键' primary key,
    img               varchar(255)                       not null comment '博客封面',
    title             varchar(255)                       not null comment '博客标题',
    blog_describe     varchar(255)                       not null comment '博客描述',
    content           longtext                           not null comment '博客内容',
    create_date       varchar(100)                       not null comment '博客创建日期',
    update_date       varchar(100)                       not null comment '博客更新日期'

)
    comment '博客表' charset = utf8mb4;
