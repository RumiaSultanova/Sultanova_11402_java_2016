package com.itis.inf.java.department.controllers.dto;

import com.itis.inf.java.department.dao.models.Doc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rumia on 04/05/16.
 */
public class DocsDto {
    private List<DocDto> docs = new ArrayList<>();

    public List<DocDto> getDoc(){
        return docs;
    }

    public void addDocuments(List<Doc> list){
        if(!list.isEmpty()){
            for (int i = 0; i <list.size(); i++) {
                DocDto dto = new DocDto(list.get(i));
                docs.add(dto);
            }
        }
    }
}
