package com.itis.inf.java.department.controllers.dto;

import com.itis.inf.java.department.dao.models.Doc;
import com.itis.inf.java.department.dao.models.User;

/**
 * Created by rumia on 04/05/16.
 */
public class DocDto {
    private int id;
    private int userID;
    private String railwayName;
    private String railwayAdmin;
    private String trainStation;
    private String trainDepot;
    private String trainRailRoad;
    private String trainModel;
    private String trainContentType;
    private String trainStartDate;
    private String trainEndDate;
    private String trainRepairType;
    private String trainRepairDate;

    public DocDto(Doc doc) {
        this.id = doc.getId();
        this.userID = doc.getUserID();
        this.railwayName = doc.getRailwayName();
        this.railwayAdmin = doc.getRailwayAdmin();
        this.trainStation = doc.getTrainStation();
        this.trainDepot = doc.getTrainDepot();
        this.trainRailRoad = doc.getTrainRailRoad();
        this.trainModel = doc.getTrainModel();
        this.trainContentType = doc.getTrainContentType();
        this.trainStartDate = doc.getTrainStartDate();
        this.trainEndDate = doc.getTrainEndDate();
        this.trainRepairType = doc.getTrainRepairType();
        this.trainRepairDate = doc.getTrainRepairDate();
    }

    public int getId() {
        return id;
    }

    public int getUserID() {
        return userID;
    }

    public String getRailwayName() {
        return railwayName;
    }

    public String getRailwayAdmin() {
        return railwayAdmin;
    }

    public String getTrainStation() {
        return trainStation;
    }

    public String getTrainDepot() {
        return trainDepot;
    }

    public String getTrainRailRoad() {
        return trainRailRoad;
    }

    public String getTrainModel() {
        return trainModel;
    }

    public String getTrainContentType() {
        return trainContentType;
    }

    public String getTrainStartDate() {
        return trainStartDate;
    }

    public String getTrainEndDate() {
        return trainEndDate;
    }

    public String getTrainRepairType() {
        return trainRepairType;
    }

    public String getTrainRepairDate() {
        return trainRepairDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setRailwayName(String railwayName) {
        this.railwayName = railwayName;
    }

    public void setRailwayAdmin(String railwayAdmin) {
        this.railwayAdmin = railwayAdmin;
    }

    public void setTrainStation(String trainStation) {
        this.trainStation = trainStation;
    }

    public void setTrainDepot(String trainDepot) {
        this.trainDepot = trainDepot;
    }

    public void setTrainRailRoad(String trainRailRoad) {
        this.trainRailRoad = trainRailRoad;
    }

    public void setTrainModel(String trainModel) {
        this.trainModel = trainModel;
    }

    public void setTrainContentType(String trainContentType) {
        this.trainContentType = trainContentType;
    }

    public void setTrainStartDate(String trainStartDate) {
        this.trainStartDate = trainStartDate;
    }

    public void setTrainEndDate(String trainEndDate) {
        this.trainEndDate = trainEndDate;
    }

    public void setTrainRepairType(String trainRepairType) {
        this.trainRepairType = trainRepairType;
    }

    public void setTrainRepairDate(String trainRepairDate) {
        this.trainRepairDate = trainRepairDate;
    }
}
