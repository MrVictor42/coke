package br.com.victor.coke.model.dto;

public class UserRelationDTO {
    private String userMondayId;
    private String userId;

    public UserRelationDTO() {

    }

    public String getUserMondayId() {
        return userMondayId;
    }

    public void setUserMondayId(String userMondayId) {
        this.userMondayId = userMondayId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}