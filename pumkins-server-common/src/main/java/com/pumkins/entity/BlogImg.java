package com.pumkins.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: dengKai
 * @date: 2023/01/17 09:33
 * @description: TODO
 */
@Entity
@Table(name = "pumkins_blog_img")
@Data
@Accessors(chain = true)
public class BlogImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "blog_id", nullable = false)
    private Integer blogId;

    @Column(name = "img_id", nullable = false)
    private Integer imgId;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;
}
