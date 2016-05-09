package com.itis.inf.java.department.jdbc.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rumia on 03/05/16.
 */
@Component
public class ParamsMapperImpl implements ParamsMapper{

    @Override
    public Map<String, Object> asMap(List<String> keys, List<?> values) {
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException();
        } else {
            Map<String, Object> map = new HashMap<String, Object>();
            for (int i = 0; i < keys.size(); i++) {
                map.put(keys.get(i), values.get(i));
            }
            return map;
        }
    }
}

