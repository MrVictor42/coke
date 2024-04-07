<%@ include file="../init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    long cokeId = ParamUtil.getLong(renderRequest, "cokeId");
    Coke coke = null;
    List<User> usersNotInUserCokeList = null;
    List<User> usersInUserCokeList = null;
    List<User> userList = null;
    List<UserCoke> userCokeList = null;
    List<CokeDTO> cokeDTOList = new ArrayList<>();

    if(cokeId > 0) {
        coke = CokeLocalServiceUtil.getCoke(cokeId);
        userCokeList = UserCokeLocalServiceUtil.getUserCokeByCokeId(coke.getCokeId());
        int quantityMembers = userCokeList.size();

        userList = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS)
                .stream()
                .filter(userItem -> !userItem.getEmailAddress().equalsIgnoreCase("default@liferay.com"))
                .filter(userItem -> !userItem.getEmailAddress().contains("anonymous"))
                .collect(Collectors.toList());
        final List<UserCoke> finalUserCokeList = userCokeList; 

        usersNotInUserCokeList = userList.stream()
                .filter(userItem -> finalUserCokeList.stream()
                        .noneMatch(userCoke -> userCoke.getUserId() == userItem.getUserId()))
                .collect(Collectors.toList());

        usersInUserCokeList = userList.stream()
                .filter(userItem -> finalUserCokeList.stream() 
                        .anyMatch(userCoke -> userCoke.getUserId() == userItem.getUserId()))
                .collect(Collectors.toList());

        for(UserCoke userCoke : userCokeList) {
            CokeDTO cokeDTO = new CokeDTO();

            User currentUser = UserLocalServiceUtil.getUser(userCoke.getUserId());

            cokeDTO.setUser(currentUser);
            cokeDTO.setCreatedAt(userCoke.getCreateDate());
            cokeDTO.setPosition(userCoke.getPosition());
            cokeDTO.setOrder(userCoke.getOrder());

            cokeDTOList.add(cokeDTO);
        }
    }
%>

<div class="card" id="membersCard">
    <div class="card-body">
        <h3 class="card-title">Membros Atuais</h3>
        <% int counter = 0; %>
        <% for (CokeDTO cokeDTO : cokeDTOList) { %>
            <% if (counter % 2 == 0) { %>
                <div class="row">
            <% } %>
                    <div class="col-md-6 member" style="<%= counter < 4 ? "" : "display: none;" %>">
                        <div class="card card-horizontal card-rounded">
                            <div class="card-row">
                                <div class="autofit-col">
                                    <img class="card-item-last rounded-circle" style="width: 50px"
                                        src="<%= cokeDTO.getUser().getPortraitURL(themeDisplay) %>"
                                    />
                                </div>
                                <div class="autofit-col autofit-col-expand autofit-col-gutters">
                                    <section class="autofit-section">
                                        <h3 class="card-title"><%= cokeDTO.getUser().getFullName() %></h3>
                                        <h4 class="card-subtitle mb-2 text-muted"><%= cokeDTO.getPosition() %></h4>
                                        <h4 class="card-subtitle mb-2 text-muted">Membro há: <%= LittleCokeUtil.memberSince(cokeDTO.getCreatedAt()) %> dia(s)</h4>
                                    </section>
                                </div>
                            </div>
                        </div>
                    </div>
            <% if (counter % 2 != 0) { %>
                </div>
            <% } %>
            <% counter++; %>
        <% } %>
        <% if (userList != null && userList.size() % 2 != 0) { %>
            </div>
        <% } %>
        <button id="loadMore" class="btn btn-primary">
            Mostre mais <clay:icon symbol="plus" />
        </button>
    </div>
</div>

<portlet:resourceURL var="resourceURL">
    <portlet:param name="cokeId" value="<%= String.valueOf(cokeId) %>" />
    <portlet:param name="mvcPath" value="/coke/edit_coke.jsp" />
</portlet:resourceURL>

<% cokeDTOList.sort(Comparator.comparingInt(CokeDTO::getOrder)); %>

<div class="card" id="nextToPayCard">
    <div class="card-body">
        <div class="col-md-6">
            <div class="card card-horizontal card-rounded">
                <div class="card-row">
                    <div class="autofit-col">
                        <div class="text-center mt-3">
                            <h3 class="card-title">Próximos a Pagar</h3>
                        </div>
                    </div>
                </div>
                <div class="autofit-col autofit-col-expand autofit-col-gutters">
                    <section class="autofit-section">
                        <button id="refresh-btn" class="btn btn-primary" onclick="">
                            Atualizar Lista <clay:icon symbol="reload" />
                        </button>
                    </section>
                </div>
            </div>
        </div>

        <% int next = 0; %>
        <% for (CokeDTO cokeDTO : cokeDTOList) { %>
            <% if (next % 2 == 0) { %>
                <div class="row">
            <% } %>
                    <div class="col-md-6 member" style="<%= next < 4 ? "" : "display: none;" %>">
                        <div class="card card-horizontal card-rounded">
                            <div class="card-row">
                                <div class="autofit-col">
                                    <img class="card-item-last rounded-circle" style="width: 50px"
                                        src="<%= cokeDTO.getUser().getPortraitURL(themeDisplay) %>"
                                    />
                                </div>
                                <div class="autofit-col autofit-col-expand autofit-col-gutters">
                                    <section class="autofit-section">
                                        <h3 class="card-title"><%= cokeDTO.getUser().getFullName() %></h3>
                                        <h4 class="card-subtitle mb-2 text-muted"><%= cokeDTO.getPosition() %></h4>
                                        <h4 class="card-subtitle mb-2 text-muted">Membro há: <%= LittleCokeUtil.memberSince(cokeDTO.getCreatedAt()) %> dia(s)</h4>
                                    </section>
                                </div>
                            </div>
                        </div>
                    </div>
            <% if (next % 2 != 0) { %>
                </div>
            <% } %>
            <% next++; %>
        <% } %>
        <% if (userList != null && userList.size() % 2 != 0) { %>
            </div>
        <% } %>
        <button id="loadMoreNext" class="btn btn-primary">
            Mostre mais <clay:icon symbol="plus" />
        </button>
    </div>
</div>

<div class="card" style="width: 18rem;">
	<div class="card-body">
		<h3 class="card-title">Média de Coca Por Pessoa</h3>
        <p class="card-text">
            Você Sabia? Ao comprar uma coca cola de 2L, e levando em consideração que temos <%= userCokeList.size() %> associados,
            ao bebermos em um copo de 300 ML, cada um toma em média <%= LittleCokeUtil.averageCokeByPersonFormatted(userCokeList.size()) %>
        </p>
	</div>
</div>

<portlet:actionURL name="updateCoke" var="updateCokeURL" />

<portlet:renderURL var="updateCoke">
    <portlet:param name="mvcPath" value="/coke/view.jsp"></portlet:param>
</portlet:renderURL>

<aui:form action="<%= updateCokeURL %>" name="<portlet:namespace />fm">
    <aui:model-context bean="<%= coke %>" model="<%= Coke.class %>" />

        <aui:fieldset>
        <aui:input name="cokeId" type="hidden" value='<%= coke == null ? cokeId : coke.getCokeId() %>'/>

        <div class="form-group">
            <div class="clay-dual-listbox">
                <div class="clay-dual-listbox-item clay-dual-listbox-item-expand">
                    <label for="_9d5cxj5xm">
                        <span class="text-truncate-inline">
                            <span class="text-truncate">Possiveis Associados</span>
                        </span>
                    </label>
        
                    <div class="clay-reorder clay-reorder-footer-end">
                        <select class="form-control form-control-inset" id="notAssociated" name="_br_com_victor_littleCoke_web_LittleCokeWebPortlet_notAssociated" multiple size="10">
                            <% for(User userNotInCoke : usersNotInUserCokeList != null ? usersNotInUserCokeList : userList) { %>
                                <option value="<%= userNotInCoke.getUserId() %>"><%= userNotInCoke.getFullName() %></option>
                            <% } %>
                        </select>
                        <div class="clay-reorder-underlay form-control"></div>
                    </div>
                </div>
        
                <div class="clay-dual-listbox-item clay-dual-listbox-actions">
                    <div class="btn-group-vertical">
                        <button class="btn btn-monospaced btn-secondary btn-sm" type="button">
                            <clay:icon symbol="caret-right" />
                        </button>
                        <button class="btn btn-monospaced btn-secondary btn-sm" type="button">
                            <clay:icon symbol="caret-left" />
                        </button>
                    </div>
                </div>
        
                <div class="clay-dual-listbox-item clay-dual-listbox-item-expand">
                    <label for="_957gwvjvl">
                        <span class="text-truncate-inline">
                            <span class="text-truncate">Membros Atuais</span>
                        </span>
                    </label>
                    <div class="clay-reorder">
                        <select class="form-control form-control-inset" id="associated" name="_br_com_victor_littleCoke_web_LittleCokeWebPortlet_associated" multiple size="10">
                            <% if(usersInUserCokeList != null) {
                                for(User userInCoke : usersInUserCokeList) { %>
                                    <option value="<%= userInCoke.getUserId() %>"><%= userInCoke.getFullName() %></option>
                                <% }
                            } %>
                        </select>
                        <div class="clay-reorder-underlay form-control"></div>
                    </div>
                </div>
            </div>
        </div>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= updateCoke.toString() %>"></aui:button>
    </aui:button-row>
</aui:form>

<h1> Notificar monday </h1>

<script>
    document.querySelector('.clay-dual-listbox-actions button:nth-child(1)').addEventListener('click', function() {
        var selectedOptions = document.querySelectorAll('#notAssociated option:checked');
        selectedOptions.forEach(function(option) {
            option.selected = false;
            document.querySelector('#associated').appendChild(option);
        });
        document.querySelectorAll('#associated option, #notAssociated option').forEach(function(option) {
            option.selected = true;
        });
    });

    document.querySelector('.clay-dual-listbox-actions button:nth-child(2)').addEventListener('click', function() {
        var selectedOptions = document.querySelectorAll('#associated option:checked');
        selectedOptions.forEach(function(option) {
            option.selected = false; 
            document.querySelector('#notAssociated').appendChild(option);
        });
        document.querySelectorAll('#associated option, #notAssociated option').forEach(function(option) {
            option.selected = true;
        });
    });

    document.getElementById('refresh-btn').addEventListener('click', function() {
        AUI().use('aui-io-request', function(A){
            A.io.request('<%=resourceURL.toString()%>', {
                method: 'POST',
                data: {
                    cokeId: <%= cokeId %>,
                },
                on: {
                    complete: function() {
                        location.reload();
                    }
                }
            });
        });
    });

    $(document).ready(function () {
        $("#loadMore").on("click", function (e) {
            e.preventDefault();
            $("#membersCard .member:hidden").slice(0, 4).slideDown();
            if ($("#membersCard .member:hidden").length == 0) {
                $("#loadMore").text("Não há mais resultados").addClass("noContent");
            }
        });
    });

    $(document).ready(function () {
        $("#loadMoreNext").on("click", function (e) {
            e.preventDefault();
            $("#nextToPayCard .member:hidden").slice(0, 4).slideDown();
            if ($("#nextToPayCard .member:hidden").length == 0) {
                $("#loadMoreNext").text("Não há mais resultados").addClass("noContent");
            }
        });
    });
</script>