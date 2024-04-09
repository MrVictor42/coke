package br.com.victor.coke.model.dto;

import br.com.victor.coke.model.Coke;
import com.liferay.portal.kernel.model.User;

import java.util.Date;
import java.util.List;

public class CokeDTO {

    private Coke coke;
    private User user;
    private String initialDate;
    private Date createdAt;
    private String position;
    private int order;
    private List<User> usersInUserCokeList;
    private List<User> usersNotInUserCokeList;

    public CokeDTO() {

    }

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public Coke getCoke() {
        return coke;
    }

    public void setCoke(Coke coke) {
        this.coke = coke;
    }

    public List<User> getUsersInUserCokeList() {
        return usersInUserCokeList;
    }

    public void setUsersInUserCokeList(List<User> usersInUserCokeList) {
        this.usersInUserCokeList = usersInUserCokeList;
    }

    public List<User> getUsersNotInUserCokeList() {
        return usersNotInUserCokeList;
    }

    public void setUsersNotInUserCokeList(List<User> usersNotInUserCokeList) {
        this.usersNotInUserCokeList = usersNotInUserCokeList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}