package br.com.victor.coke.model.dto;

public class UserMondayDTO {
    private String userMondayId;
    private String email;
    private String imageUser;

    public UserMondayDTO() {

    }

    public String getUserMondayId() {
        return userMondayId;
    }

    public void setUserMondayId(String userMondayId) {
        this.userMondayId = userMondayId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUser() {
        return imageUser;
    }

    public void setImageUser(String imageUser) {
        this.imageUser = imageUser;
    }
}