package com.itis.inf.java.department.controllers.dto.convreter;

import com.itis.inf.java.department.controllers.dto.AuthDto;
import com.itis.inf.java.department.controllers.dto.DocDto;
import com.itis.inf.java.department.controllers.dto.DocsDto;
import com.itis.inf.java.department.controllers.dto.UserDto;
import com.itis.inf.java.department.dao.models.Auth;
import com.itis.inf.java.department.dao.models.Doc;
import com.itis.inf.java.department.dao.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by rumia on 04/05/16.
 */
@Component
public class DtoConverterImpl implements DtoConverter {

    @Override
    public DocDto getDocDto(Doc entity) {
        return new DocDto(entity);
    }

    @Override
    public DocsDto getDocsDto(List<Doc> entities) {
        DocsDto dto = new DocsDto();
        dto.addDocuments(entities);
        return dto;
    }

    @Override
    public AuthDto getAuthDto(Auth entity) {
        return new AuthDto(entity);
    }

    @Override
    public UserDto getUserDto(User entity) {
        return new UserDto(entity);
    }
}
