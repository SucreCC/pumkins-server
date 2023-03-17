package com.pumkins.restful.service.timeLine;

import com.pumkins.dto.request.TimeNodeReq;
import com.pumkins.dto.resp.BlogTimelineResp;
import com.pumkins.dto.resp.TimeNodeResp;

import java.util.List;

/**
 * @Author: dengKai
 * @Date: 2023-03-16-15-03
 * @Description: TODO
 */

public interface TimelineService {
    List<BlogTimelineResp> getBlogTimeList();

    void saveTimeNode(TimeNodeReq timeNodeReq);

    List<TimeNodeResp> getBlogTimeNodes();
}
