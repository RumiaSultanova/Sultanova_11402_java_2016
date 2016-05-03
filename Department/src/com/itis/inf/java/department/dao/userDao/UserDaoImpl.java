package com.itis.inf.java.department.dao.userDao;

import com.itis.inf.java.department.dao.DaoArgumentsVerifier;
import com.itis.inf.java.department.dao.models.User;
import com.itis.inf.java.department.jdbc.ParamsMapper;
import com.itis.inf.java.department.jdbc.SqlQueryExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by rumia on 04/05/16.
 */
public class UserDaoImpl implements UserDao {
    @Autowired
    DaoArgumentsVerifier verifier;
    @Autowired
    ParamsMapper mapper;
    @Autowired
    SqlQueryExecutor executor;

    //language=SQL
    public static final String SQL_GET_USER_BY_ID = "SELECT * FROM users WHERE (id = :ID)";

    //language=SQL
    public static final String SQL_SET_USER_INTO_USERS = "INSERT INTO users values(:ID, :name, :surname, :companyID)";

    static final RowMapper<User> USER_ROW_MAPPER = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            try {
                return new User(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("surname"), resultSet.getInt("companyID"));
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
        }
    };

    @Override
    public User getUser(int id) {
        verifier.verifyUser(id);
        Map<String, Object> paramMap = mapper.asMap(asList("id"), asList(id));
        return executor.queryForObject(SQL_GET_USER_BY_ID, paramMap, USER_ROW_MAPPER);
    }

    @Override
    public boolean addUser(User user) {
        verifier.verifyUser(user.getId());
        Map<String, Object> paramMap = mapper.asMap(asList("userid", "name", "surname", "patronymic", "seriesofthepassport", "numberofthepassport", "phonenumber", "email"),
                asList(user.getId(),user.getName(), user.getSurname(), user.getCompanyID()));
        executor.updateQuery(SQL_SET_USER_INTO_USERS, paramMap);
        return true;
    }
}
