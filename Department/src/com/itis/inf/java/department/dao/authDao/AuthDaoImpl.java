package com.itis.inf.java.department.dao.authDao;

import com.itis.inf.java.department.dao.DaoArgumentsVerifier;
import com.itis.inf.java.department.dao.models.Auth;
import com.itis.inf.java.department.jdbc.utils.ParamsMapper;
import com.itis.inf.java.department.jdbc.utils.SqlQueryExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by rumia on 04/05/16.
 */
@Component
public class AuthDaoImpl implements AuthDao{
    @Autowired
    DaoArgumentsVerifier verifier;
    @Autowired
    ParamsMapper mapper;
    @Autowired
    SqlQueryExecutor executor;

    static final RowMapper<Auth> AUTH_ROW_MAPPER  = new RowMapper<Auth>() {
        @Override
        public Auth mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Auth(resultSet.getInt("id"), resultSet.getString("mail"), resultSet.getString("password"));
        }
    };

    //language=SQL
    public static final String SQL_GET_AUTH_BY_ID = "SELECT * FROM auth WHERE (id = :ID)";

    //language=SQL
    public static final String SQL_GET_AUTH_BY_MAIL = "SELECT * FROM auth WHERE (mail = :mail)";

    //language=SQL
    public static final String SQL_SET_AUTH_INTO_AUTH = "INSERT INTO auth values(:id, :mail, :password)";

    @Override
    public Auth getAuth(int id) {
        verifier.verifyAuth(id);
        Map<String, Object> paramMap = mapper.asMap(asList("id"), asList(id));
        return executor.queryForObject(SQL_GET_AUTH_BY_ID, paramMap, AUTH_ROW_MAPPER);
    }

    @Override
    public Auth getAuth(String mail) {
        verifier.verifyAuth(mail);
        Map<String, Object> paramMap = mapper.asMap(asList("mail"), asList(mail));
        return executor.queryForObject(SQL_GET_AUTH_BY_MAIL, paramMap, AUTH_ROW_MAPPER);
    }

    @Override
    public boolean addAuth(Auth auth) {
        verifier.verifyAuth(auth.getId());
        Map<String,Object> paramMap = mapper.asMap(asList("id", "mail", "password"), asList(auth.getId(), auth.getMail(), auth.getPassword()));
        executor.updateQuery(SQL_SET_AUTH_INTO_AUTH, paramMap);
        // TODO: 04/05/16 if (...) return true; else return false;
        return true;
    }
}
