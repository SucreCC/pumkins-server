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
 * @date: 2023/03/17 15:15
 * @description: TODO
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name="pumkins_time_node_link_blog")
public class TimeNodeLinkBlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "blog_id", nullable = false)
    private Integer blogId;

    @Column(name = "time_node_id", nullable = false)
    private Integer timeNodeId;

    @Column(name = "blog_title", nullable = false)
    private String blogTitle;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "update_date", nullable = false)
    private Date updateDate;
}
