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
 * @date: 2022/02/05 23:23
 * @description:
 */

@Entity
@Table(name = "pumkins_blog_comment")
@Data
@Accessors(chain = true)
public class BlogComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "blog_id", nullable = false)
    private Integer blogId;

    @Column(name = "parent_id", nullable = false)
    private Integer parentId;

    @Column(name = "comment_content", nullable = false)
    private String commentContent;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;
}
