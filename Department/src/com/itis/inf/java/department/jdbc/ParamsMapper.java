package com.itis.inf.java.department.jdbc;

import java.util.List;
import java.util.Map;

/**
 * Created by rumia on 03/05/16.
 */
public interface ParamsMapper {
    Map<String, Object> asMap(List<String> keys, List<?> values);
}
