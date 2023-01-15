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
 * @date: 2023/01/14 10:00
 * @description: TODO
 */
@Entity
@Table(name = "pumkins_img")
@Data
@Accessors(chain = true)
public class Img {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "md5", nullable = false)
    private String md5;

    @Column(name = "size", nullable = false)
    private Long size;

    @Column(name = "suffix", nullable = false)
    private String suffix;

    @Column(name = "img_name", nullable = false)
    private String imgName;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

}
