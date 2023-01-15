--  --------------------------------------
--  pumkins_word单词表
--
--  -------------------------------------

drop table if exists pumkins_word;
create table pumkins_word
(
    id           int auto_increment comment '主键' primary key,
    word_name    varchar(255) not null comment '单词英文',
    word_content varchar(255) not null comment '单词中文',
    create_date  varchar(100) not null comment '单词创建日期',
    update_date  varchar(100) comment '单词更新日期',
    the_day      int(100)     not null comment '第几天的单词'
)
    comment '单词表' charset = utf8mb4;
