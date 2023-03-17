package com.pumkins.restful.controller.timeLine;

import com.pumkins.dto.request.TimeNodeReq;
import com.pumkins.dto.resp.BlogCommentResp;
import com.pumkins.dto.resp.BlogResp;
import com.pumkins.dto.resp.BlogTimelineResp;
import com.pumkins.dto.resp.TimeNodeResp;
import com.pumkins.dto.response.JsonResp;
import com.pumkins.restful.service.timeLine.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: dengKai
 * @date: 2023/03/16 15:00
 * @description: TODO
 */
@RestController
@RequestMapping("pumkins/time-line")
public class TimelineController {

    @Autowired
    private TimelineService timelineService;

    @GetMapping("/blog-list")
    public JsonResp<List<BlogTimelineResp>> getBlogTimeList() {
        return JsonResp.success(timelineService.getBlogTimeList());
    }

    @PostMapping("/save-time-node")
    public JsonResp<String> saveTimeNode(@RequestBody TimeNodeReq timeNodeReq) {
        timelineService.saveTimeNode(timeNodeReq);
        return JsonResp.success();
    }


    @GetMapping("/get-time-node")
    public JsonResp<List<TimeNodeResp>> getTimeNodes() {
        return JsonResp.success(timelineService.getBlogTimeNodes());
    }
}
