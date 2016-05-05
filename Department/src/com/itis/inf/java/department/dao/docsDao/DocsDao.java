package com.itis.inf.java.department.dao.docsDao;

import com.itis.inf.java.department.dao.models.Doc;

import java.util.List;

/**
 * Created by rumia on 04/05/16.
 */
public interface DocsDao {
    Doc getDoc(int id);
    List<Doc> getDocs(int userID);
    boolean addDoc(Doc doc);
}
