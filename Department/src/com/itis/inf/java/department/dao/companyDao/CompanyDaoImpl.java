package com.itis.inf.java.department.dao.companyDao;

import com.itis.inf.java.department.dao.DaoArgumentsVerifier;
import com.itis.inf.java.department.dao.models.Auth;
import com.itis.inf.java.department.dao.models.Company;
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
 * Created by rumia on 09/05/16.
 */
@Component
public class CompanyDaoImpl implements CompanyDao {

    @Autowired
    DaoArgumentsVerifier verifier;
    @Autowired
    ParamsMapper mapper;
    @Autowired
    SqlQueryExecutor executor;

    static final RowMapper<Company> COMPANY_ROW_MAPPER = new RowMapper<Company>() {
        @Override
        public Company mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Company(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("address"),
                    resultSet.getString("admin"), resultSet.getString("worker"));
        }
    };

    //language=SQL
    public static final String SQL_GET_COMPANY_BY_ID = "SELECT * FROM companies WHERE (id = :ID)";

    //language=SQL
    public static final String SQL_GET_COMPANY_BY_NAME = "SELECT * FROM companies WHERE (name = :name)";

    //language=SQL
    public static final String SQL_SET_COMPANY_INTO_COMPANIES = "INSERT INTO company values(:id, :name, :address, :admin, :worker)";

    @Override
    public Company getCompany(int ID) {
        verifier.verifyCompany(ID);
        Map<String, Object> paramMap = mapper.asMap(asList("ID"), asList(ID));
        return executor.queryForObject(SQL_GET_COMPANY_BY_ID, paramMap, COMPANY_ROW_MAPPER);
    }

    @Override
    public Company getCompany(String name) {
        verifier.verifyCompany(name);
        Map<String, Object> paramMap = mapper.asMap(asList("name"), asList(name));
        return executor.queryForObject(SQL_GET_COMPANY_BY_NAME, paramMap, COMPANY_ROW_MAPPER);}

    @Override
    public boolean addCompany(Company company) {
        verifier.verifyAuth(company.getID());
        Map<String,Object> paramMap = mapper.asMap(asList("id", "name", "address", "admin", "worker"), asList(company.getID(), company.getName(),
                company.getAddress(), company.getAdmin(), company.getWorker()));
        executor.updateQuery(SQL_SET_COMPANY_INTO_COMPANIES, paramMap);
        return true;
    }
}
