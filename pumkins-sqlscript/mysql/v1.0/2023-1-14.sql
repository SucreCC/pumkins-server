--  --------------------------------------
--  pumkins_img
--
--  -------------------------------------


drop table if exists pumkins_img;
drop table if exists pumkins_img;
create table pumkins_img(
                    id BIGINT PRIMARY key auto_increment,
                    md5 VARCHAR(255) not null comment '文件md5码',
                    size BIGINT not null comment '文件大小',
                    suffix VARCHAR(10) not null comment '后缀名',
                    img_name varchar(50) not null comment '图片名',
                    create_date datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT 'create date',
                    update_date datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT'update date'
) comment 'img table' charset = utf8mb4;
