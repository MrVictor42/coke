package br.com.victor.coke.model.dto;

public class UserCokeDTO {

    private long userCokeId;
    private String position;
    private UserDTO userDTO = new UserDTO();
    private int order;

    public UserCokeDTO() {

    }

    public long getUserCokeId() {
        return userCokeId;
    }

    public void setUserCokeId(long userCokeId) {
        this.userCokeId = userCokeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "UserCoke{" +
                "userCokeId=" + userCokeId +
                ", position='" + position + '\'' +
                ", userDTO=" + userDTO +
                ", order=" + order +
                '}';
    }
}