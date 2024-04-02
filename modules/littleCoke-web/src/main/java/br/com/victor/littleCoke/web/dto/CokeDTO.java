package br.com.victor.littleCoke.web.dto;

import br.com.victor.coke.model.UserCoke;

import java.util.List;

public class CokeDTO {

    private String name;
    private long cokeId;
    private String createdBy;
    private String createdAt;
    private List<UserCoke> userCokeList;

    public CokeDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCokeId() {
        return cokeId;
    }

    public void setCokeId(long cokeId) {
        this.cokeId = cokeId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<UserCoke> getUserCokeList() {
        return userCokeList;
    }

    public void setUserCokeList(List<UserCoke> userCokeList) {
        this.userCokeList = userCokeList;
    }
}