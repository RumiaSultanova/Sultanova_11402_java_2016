package com.itis.inf.java.department.controllers.dto.convreter;

import com.itis.inf.java.department.controllers.dto.AuthDto;
import com.itis.inf.java.department.controllers.dto.DocDto;
import com.itis.inf.java.department.controllers.dto.DocsDto;
import com.itis.inf.java.department.controllers.dto.UserDto;
 import com.itis.inf.java.department.dao.models.Auth;
import com.itis.inf.java.department.dao.models.Doc;
import com.itis.inf.java.department.dao.models.User;

import java.util.List;

/**
 * Created by rumia on 04/05/16.
 */
public interface DtoConverter {
    DocDto getDocDto(Doc entity);
    DocsDto getDocsDto(List<Doc> entities);
    AuthDto getAuthDto(Auth entity);
    UserDto getUserDto(User entity);
}
