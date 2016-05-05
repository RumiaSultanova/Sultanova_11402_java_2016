package com.itis.inf.java.department.services;

import com.itis.inf.java.department.dao.models.Doc;

import java.util.List;

/**
 * Created by rumia on 04/05/16.
 */
public interface DocService {
    Doc getDocById(int id);

    List<Doc> getDoc(int userID);

    boolean setDoc(Doc doc);
}
