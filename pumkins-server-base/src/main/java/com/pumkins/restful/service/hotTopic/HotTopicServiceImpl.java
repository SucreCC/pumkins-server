//package com.pumkins.restful.service.hotTopic;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
///**
// * @author: dengKai
// * @date: 2023/03/30 15:39
// * @description: TODO
// */
//@Component
//public class HotTopicServiceImpl implements HotTopicService{
//
//    @Override
//    public void getCNNHotTopic() throws IOException {
//        String url = "https://www.cnn.com/";
//        Document doc = Jsoup.connect(url).get();
//        Element hotTopic = doc.selectFirst(".cd__headline-text");
//    }
//}
