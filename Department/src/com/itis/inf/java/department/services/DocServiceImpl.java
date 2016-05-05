package com.itis.inf.java.department.services;

import com.itis.inf.java.department.dao.docsDao.DocsDao;
import com.itis.inf.java.department.dao.models.Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by rumia on 04/05/16.
 */
@Component
public class DocServiceImpl implements DocService {

    @Autowired
    DocsDao dao;

    @Override
    public Doc getDocById(int id) {
        return dao.getDoc(id);
    }

    @Override
    public List<Doc> getDoc(int userID) {
        return dao.getDocs(userID);
    }

    @Override
    public boolean setDoc(Doc doc) {
        return false;
    }
}
