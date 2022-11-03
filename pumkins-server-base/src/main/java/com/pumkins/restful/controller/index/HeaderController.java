package com.pumkins.restful.controller.index;

import com.pumkins.dto.response.JsonResp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: dengKai
 * @date: 2022/10/28 08:26
 * @description: TODO
 */
@RestController
@RequestMapping("/pumkins/layout/header")
public class HeaderController {

    @PostMapping("/dynamic-picture")
    public JsonResp<String> saveBlog() {
        return JsonResp.success();
    }
}

