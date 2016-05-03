package com.itis.inf.java.department.dao;

import com.itis.inf.java.department.exceptions.*;
import com.itis.inf.java.department.jdbc.ParamsMapper;
import com.itis.inf.java.department.jdbc.SqlQueryExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by rumia on 03/05/16.
 */

@Component
public class DaoArgumentsVerifyerImpl implements DaoArgumentsVerifier {

    //language=SQL
    private static final String SQL_COUNT_USERS_BY_ID = "SELECT COUNT (*) FROM USERS WHERE (id = :ID)";

    //language=SQL
    private static final String SQL_COUNT_COMPANIES_BY_ID = "SELECT COUNT (*) FROM USERS WHERE (id = :ID)";

    //language=SQL
    private static final String SQL_COUNT_DOCS_BY_ID = "SELECT COUNT (*) FROM DOCS WHERE (id = :ID)";

    //language=SQL
    private static final String SQL_COUNT_RAILWAYS_BY_ID = "SELECT COUNT (*) FROM USERS WHERE (id = :ID)";

    //language=SQL
    private static final String SQL_COUNT_TRAINS_BY_ID = "SELECT COUNT (*) FROM USERS WHERE (id = :ID)";

    @Autowired
    private SqlQueryExecutor sqlQueryExecutor;

    @Autowired
    private ParamsMapper paramsMapper;

    @Override
    public void verifyUser(int ID) {
        Map<String, Object> paramMap = paramsMapper.asMap(asList("ID"), asList(ID));
        int count = sqlQueryExecutor.queryForInt(SQL_COUNT_USERS_BY_ID, paramMap);
        if (count != 1){
            throw new UserNotFoundException(ID);
        }
    }

    @Override
    public void verifyCompany(int ID) {
        Map<String, Object> paramMap = paramsMapper.asMap(asList("ID"), asList(ID));
        int count = sqlQueryExecutor.queryForInt(SQL_COUNT_DOCS_BY_ID, paramMap);
        if (count != 1){
            throw new CompanyNotFoundException(ID);
        }
    }

    @Override
    public void verifyDoc(int ID) {
        Map<String, Object> paramMap = paramsMapper.asMap(asList("ID"), asList(ID));
        int count = sqlQueryExecutor.queryForInt(SQL_COUNT_DOCS_BY_ID, paramMap);
        if (count != 1){
            throw new DocumentNotFoundException(ID);
        }
    }
}
