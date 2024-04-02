package br.com.victor.littleCoke.web.dto;

import br.com.victor.coke.model.Coke;
import com.liferay.portal.kernel.model.User;

import java.util.List;

public class CokeDTO {

    private Coke coke;
    private String initialDate;
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
}