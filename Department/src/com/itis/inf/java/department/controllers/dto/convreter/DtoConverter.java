package com.itis.inf.java.department.controllers.dto.convreter;

import com.itis.inf.java.department.controllers.dto.*;
import com.itis.inf.java.department.dao.companyDao.CompanyDao;
import com.itis.inf.java.department.dao.models.Auth;
import com.itis.inf.java.department.dao.models.Company;
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
    CompanyDto getCompanyDto(Company entity);

    Doc getDocDao(DocDto dto);
    User getUserDao(UserDto dto);
    Auth getAuthDao(AuthDto dto);
    Company getCompanyDao(CompanyDto dto);
}
