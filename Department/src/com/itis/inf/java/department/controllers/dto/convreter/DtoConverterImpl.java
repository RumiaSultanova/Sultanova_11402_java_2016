package com.itis.inf.java.department.controllers.dto.convreter;

import com.itis.inf.java.department.controllers.dto.*;
import com.itis.inf.java.department.dao.models.Auth;
import com.itis.inf.java.department.dao.models.Company;
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

    @Override
    public CompanyDto getCompanyDto(Company entity) {
        return new CompanyDto(entity);
    }

    @Override
    public Doc getDocDao(DocDto dto) {
        Doc doc = new Doc(dto.getId(), dto.getUserID(), dto.getRailwayName(),
                dto.getRailwayAdmin(), dto.getTrainStation(), dto.getTrainDepot(),
                dto.getTrainRailRoad(),dto.getTrainModel(),dto.getTrainContentType(),
                dto.getTrainStartDate(),dto.getTrainEndDate(),dto.getTrainRepairType(),
                dto.getTrainRepairDate());
        return doc;
    }

    @Override
    public User getUserDao(UserDto dto) {
        User user = new User(dto.getId(), dto.getName(),dto.getSurname(),dto.getCompany());
        return user;
    }

    @Override
    public Auth getAuthDao(AuthDto dto) {
        Auth auth = new Auth(dto.getId(), dto.getMail(), dto.getPassword());
        return auth;
    }

    @Override
    public Company getCompanyDao(CompanyDto dto) {
        Company company = new Company(dto.getID(),dto.getName(),dto.getAddress(),dto.getAdmin(),dto.getWorker());
        return company;
    }
}
