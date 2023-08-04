package com.pumkins.restful.controller.hotTopic;

import com.pumkins.dto.request.BlogCommentReq;
import com.pumkins.dto.response.JsonResp;
import com.pumkins.restful.service.hotTopic.HotTopicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author: dengKai
 * @date: 2023/03/30 15:35
 * @description: TODO
 */
@RestController
@RequestMapping("pumkins/hot-topic")
public class HotTopicController {

    private HotTopicService hotTopicService;

    @GetMapping("/cnn")
    public JsonResp<String> cnnHotTopic() throws IOException {
        hotTopicService.getCNNHotTopic();
        return JsonResp.success();
    }

}
