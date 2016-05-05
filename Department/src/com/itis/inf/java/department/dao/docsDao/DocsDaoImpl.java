package com.itis.inf.java.department.dao.docsDao;

import com.itis.inf.java.department.dao.DaoArgumentsVerifier;
import com.itis.inf.java.department.dao.models.Doc;
import com.itis.inf.java.department.jdbc.ParamsMapper;
import com.itis.inf.java.department.jdbc.SqlQueryExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by rumia on 04/05/16.
 */
@Component
public class DocsDaoImpl implements DocsDao {
    @Autowired
    DaoArgumentsVerifier verifier;
    @Autowired
    ParamsMapper mapper;
    @Autowired
    SqlQueryExecutor executor;

    //language=SQL
    public static final String SQL_GET_DOC_BY_ID = "SELECT * FROM docs WHERE (id = :ID)";

    //language=SQL
    public static final String SQL_GET_DOCS = "SELECT * FROM document WHERE (userid = :userId)";

    //language=SQL
    public static final String SQL_SET_DOC_INTO_USERS = "INSERT INTO doc values(:ID, :userID, :railwayName, :railwayAdmin, :trainStation," +
            ":trainDepot, :trainRailroad, :trainModel, :trainDate, :trainEndDate, :trainContentType, :trainRepairType, :trainRepairDate)";


    static final RowMapper<Doc> DOC_ROW_MAPPER = new RowMapper<Doc>() {
        @Override
        public Doc mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Doc(resultSet.getInt("ID"), resultSet.getInt("userID"), resultSet.getString("railwayName"),
                    resultSet.getString("railwayAdmin"), resultSet.getString("trainStation"), resultSet.getString("trainDepot"),
                    resultSet.getString("trainRailroad"), resultSet.getString("trainModel"), resultSet.getString("trainDate"),
                    resultSet.getString("trainEndDate"), resultSet.getString("trainContentType"), resultSet.getString("trainRepairType"),
                    resultSet.getString("trainRepairDate"));
        }
    };

    @Override
    public Doc getDoc(int id) {
        verifier.verifyDoc(id);
        Map<String, Object> paramMap = mapper.asMap(asList("id"), asList(id));
        return executor.queryForObject(SQL_GET_DOC_BY_ID, paramMap, DOC_ROW_MAPPER);
    }

    @Override
    public List<Doc> getDocs(int userId) {
        verifier.verifyDoc(userId);
        Map<String, Object> paramMap = mapper.asMap(asList("userID"), asList(userId));
        return executor.queryForObjects(SQL_GET_DOCS , paramMap, DOC_ROW_MAPPER);
    }

    @Override
    public boolean addDoc(Doc doc) {
        verifier.verifyDoc(doc.getId());
        Map<String, Object> paramMap = mapper.asMap(asList("ID", "userID", "railwayName", "railwayAdmin", "trainStation",
                "trainDepot", "trainRailroad", "trainModel", "trainDate", "trainEndDate", "trainContentType", "trainRepairType", "trainRepairDate"),
                asList(doc.getId(), doc.getUserID(), doc.getRailwayName(), doc.getRailwayAdmin(), doc.getTrainStation(), doc.getTrainDepot(),
                        doc.getTrainRailRoad(), doc.getTrainModel(), doc.getTrainStartDate(), doc.getTrainEndDate(), doc.getTrainContentType(),
                        doc.getTrainRepairType(), doc.getTrainRepairDate()));
        executor.updateQuery(SQL_SET_DOC_INTO_USERS, paramMap);
        // TODO: 04/05/16 if (...) return true; else return false;
        return true;
    }
}
