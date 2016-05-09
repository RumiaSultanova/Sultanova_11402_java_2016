package com.itis.inf.java.department.dao.userDao;

import com.itis.inf.java.department.dao.DaoArgumentsVerifier;
import com.itis.inf.java.department.dao.models.User;
import com.itis.inf.java.department.jdbc.utils.ParamsMapper;
import com.itis.inf.java.department.jdbc.utils.SqlQueryExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Logger;

import static java.util.Arrays.asList;

/**
 * Created by rumia on 04/05/16.
 */
@Component
public class UserDaoImpl implements UserDao {

    private static Logger logger = Logger.getLogger(UserDaoImpl.class.getName());

    @Autowired
    DaoArgumentsVerifier verifier;
    @Autowired
    ParamsMapper mapper;
    @Autowired
    SqlQueryExecutor executor;

    //language=SQL
    private static final String SQL_GET_USER_BY_ID = "SELECT * FROM users WHERE (id = :ID)";

    //language=SQL
    private static final String SQL_GET_USER_BY_MAIL = "SELECT * FROM users WHERE (mail = :mail)";

    //language=SQL
    private static final String SQL_SET_USER_INTO_USERS = "INSERT INTO users values(:ID, :name, :surname, :company)";

    //language=SQL
    private static final String SQL_GET_COMPANY_BY_NAME = "SELECT * FROM companies WHERE (name = :name)";

    //language=SQL
    private static final String SQL_SET_COMPANY_INTO_COMPANIES = "INSERT INTO companies VALUES (:ID, :name, :address, :admin, :worker)";

    private static final RowMapper<User> USER_ROW_MAPPER = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            try {
                return new User(resultSet.getInt("ID"), resultSet.getString("name"),
                        resultSet.getString("surname"), resultSet.getString("company"));
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
        }
    };

    @Override
    public User getUser(int ID) {
        logger.info("try to get user with " + ID + " ID");
        verifier.verifyUser(ID);
        Map<String, Object> paramMap = mapper.asMap(asList("ID"), asList(ID));
        return executor.queryForObject(SQL_GET_USER_BY_ID, paramMap, USER_ROW_MAPPER);
    }

    @Override
    public User getUser(String mail) {
        logger.info("try to get user with " + mail + " mail");
        verifier.verifyUser(mail);
        Map<String, Object> paramMap = mapper.asMap(asList("mail"), asList(mail));
        return executor.queryForObject(SQL_GET_USER_BY_MAIL, paramMap, USER_ROW_MAPPER);
    }

    @Override
    public boolean addUser(User user) {
        verifier.verifyUser(user.getID());
        Map<String, Object> paramMap = mapper.asMap(asList("ID", "name", "surname", "company"),
                asList(user.getID(),user.getName(), user.getSurname(), user.getCompany()));
        executor.updateQuery(SQL_SET_USER_INTO_USERS, paramMap);
        // TODO: 04/05/16 if (...) return true; else return false;
        return true;
    }
}
