package br.com.victor.coke.model.dto;

import br.com.victor.coke.model.Coke;
import br.com.victor.coke.model.UserCoke;
import com.liferay.portal.kernel.model.User;

import java.util.List;

public class CokeDTO {

    private Coke coke;
    private User user;
    private String initialDate;
    private List<User> usersInUserCokeList;
    private List<User> usersNotInUserCokeList;
    private List<UserCoke> userCokeList;
    private List<User> nextUsersList;

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

    public List<UserCoke> getUserCokeList() {
        return userCokeList;
    }

    public void setUserCokeList(List<UserCoke> userCokeList) {
        this.userCokeList = userCokeList;
    }

    public List<User> getNextUsersList() {
        return nextUsersList;
    }

    public void setNextUsersList(List<User> nextUsersList) {
        this.nextUsersList = nextUsersList;
    }
}