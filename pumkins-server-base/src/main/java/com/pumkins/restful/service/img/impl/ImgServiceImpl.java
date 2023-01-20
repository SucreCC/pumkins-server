package com.pumkins.restful.service.img.impl;

import com.pumkins.dto.request.ImgReq;
import com.pumkins.dto.resp.ImgResp;
import com.pumkins.entity.Img;
import com.pumkins.entity.QImg;
import com.pumkins.repository.ImgRepository;
import com.pumkins.restful.service.img.ImgService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author: dengKai
 * @date: 2023/01/14 22:14
 * @description: TODO
 */

@Component
public class ImgServiceImpl implements ImgService {

    private final static QImg Q_IMG = QImg.img;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private ImgRepository imgRepository;

    @Override
    public ImgResp checkDuplicateImg(String md5, long size, String suffix) {
        Img img = jpaQueryFactory.selectFrom(Q_IMG)
            .where(Q_IMG.md5.eq(md5))
            .where(Q_IMG.size.eq(size))
            .where(Q_IMG.suffix.eq(suffix))
            .fetchOne();
        return ImgResp.build(img);
    }

    @Override
    public ImgResp save(ImgReq imgReq) {
        Img img = imgRepository.save(imgReq.convertToImg());
        return ImgResp.build(img);
    }
}
