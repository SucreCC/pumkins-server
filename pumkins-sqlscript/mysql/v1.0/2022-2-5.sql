--  --------------------------------------
--  pumkins_blog博客表
--
--  -------------------------------------

drop table if exists pumkins_blog;
create table pumkins_blog
(
    id                 int auto_increment comment '主键' primary key,
    title              varchar(255) not null comment '博客标题',
    tags               varchar(255) not null comment '博客tag',
    markdown           longtext     not null comment '博客内容',
    blog_describe      varchar(255) not null comment '博客描述',
    username           varchar(255) not null comment '博客作者名',
    images             varchar(255) not null comment '博客封面',
    is_visible         int(1) not null comment '是否对其他人可见',
    category_id        int(11) default null comment '所属栏目id',
    work_or_life       int(1) not null comment '工作或者生活',
    number_of_thumb_up    int default null comment '点赞数',
    number_of_view        int default null comment '查看数',
    number_of_comment     int default null comment '评论数',
    number_of_favorite int default null comment '收藏数',
    create_date        datetime(0) not null comment '博客创建日期',
    update_date        datetime(0) not null comment '博客更新日期'

) comment '博客表' charset = utf8mb4;
