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

<% int counter = 0; %>
<% for (User currentUser : usersInUserCokeList) { %>
    <% if (counter % 2 == 0) { %>
        <div class="row">
    <% } %>
    <div class="col-md-6">
        <div class="card card-horizontal card-rounded">
            <div class="card-row">
                <div class="autofit-col">
                    <img
                        class="card-item-last rounded-circle"
                        src="<%= currentUser.getPortraitURL(themeDisplay) %>"
                        style="width: 50px;"
                    />
                </div>
                <div class="autofit-col autofit-col-expand autofit-col-gutters">
                    <section class="autofit-section">
                        <h3 class="card-title"><%= currentUser.getFullName() %></h3>
                        <p class="card-text">
                            <!-- Aqui você pode adicionar informações adicionais sobre o usuário -->
                        </p>
                    </section>
                </div>
            </div>
        </div>
    </div>
    <% if (counter % 2 != 0) { %>
        </div> <!-- Closing the row -->
    <% } %>
    <% counter++; %>
<% } %>
<% if (userList.size() % 2 != 0) { %>
    </div> <!-- Closing the row if the number of users is odd -->
<% } %>

<h1> Membros </h1>
<h1> Quantidade de Coca </h1>
<h1> Média de Coca </h1>
<h1> Membro Desde </h1>
<h1> Quantidade de Coca </h1>
<h1> Bons Pagadores </h1>
<h1> Notificar via liferay e wpp </h1>
<h1> Atualizar lista (somente presidente ou vice)</h1>