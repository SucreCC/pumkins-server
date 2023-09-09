package com.pumkins.config.newsapi.dto.request;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dengKai
 * @Date: 2023-08-05-17-11
 * @Description: TODO
 */

public interface Requester {

     static Map<String, String> convertToQueryMap(Requester requester) throws Exception {
        Map<String, String> query = new HashMap<>();
        Class<?> cla = requester.getClass();
        Field[] fields = cla.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String keyName = field.getName();
            Object value = field.get(requester);
            query.put(keyName, (String) value);
        }
        query.values().removeAll(Collections.singleton(null));
        query.values().removeAll(Collections.singleton("null"));
        return query;
    }

}
