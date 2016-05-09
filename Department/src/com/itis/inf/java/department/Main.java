package com.itis.inf.java.department;

import com.itextpdf.text.DocumentException;
import com.itis.inf.java.department.dao.models.Doc;
import com.itis.inf.java.department.services.GenerateDoc;

import java.io.IOException;

/**
 * Created by rumia on 09/05/16.
 */
public class Main {
    public static void main(String[] args) {
        Doc doc = new Doc(0, 0, "railway name", "railway admin", "train station", "train depot",
                "train railroad", "train model", "train content type", "train start date", "train end date"
                , "train repair type", "train repair date");

        GenerateDoc temp = new GenerateDoc();
        try {
            temp.justDoIt(doc);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
