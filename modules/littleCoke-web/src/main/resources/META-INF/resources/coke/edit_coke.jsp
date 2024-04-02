<%@ include file="../init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    long cokeId = ParamUtil.getLong(renderRequest, "cokeId");
    Coke coke = null;
    List<User> usersNotInUserCokeList = null;
    List<User> usersInUserCokeList = null;
    List<User> userList = null;

    if(cokeId > 0) {
        coke = CokeLocalServiceUtil.getCoke(cokeId);
        final List<UserCoke> userCokeList = UserCokeLocalServiceUtil.getUserCokeByCokeId(coke.getCokeId());

        userList = 
            UserLocalServiceUtil
            .getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS)
            .stream()
            .filter(userItem -> !userItem.getEmailAddress().equalsIgnoreCase("default@liferay.com"))
            .filter(userItem -> !userItem.getEmailAddress().contains("anonymous"))
            .collect(Collectors.toList());

        usersNotInUserCokeList = 
            userList
            .stream()
            .filter(userItem -> userCokeList
                    .stream()
                    .noneMatch(userCoke -> userCoke.getUserId() == userItem.getUserId()))
            .collect(Collectors.toList());

        usersInUserCokeList =
            userList
            .stream()
            .filter(userItem -> userCokeList
                    .stream()
                    .anyMatch(userCoke -> userCoke.getUserId() == userItem.getUserId()))
            .collect(Collectors.toList());
    }
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/coke/view.jsp"></portlet:param>
</portlet:renderURL>

<h1>Consagrados da Coquinha</h1>
<h1><%= cokeId %></h1>
<h1><%= coke.getName() %></h1>
