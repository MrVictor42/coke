<%@ include file="../init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<liferay-ui:error key="errorUpdateList" message="error-update-list"/>
<liferay-ui:success key="updatedList" message="updated-list" />

<%
    long cokeId = ParamUtil.getLong(renderRequest, "cokeId");
    Coke coke = null;
    CokeDTO cokeDTO = null;
    List<User> usersNotInUserCokeList = null;
    List<User> nextUsersList = null;
    List<User> usersInUserCokeList = null;
    List<User> userList = (List<User>) request.getAttribute("userList");
    List<UserCoke> userCokeList = null;
    List<CokeDTO> cokeDTOList = new ArrayList<>();
    boolean canDelete = (Boolean) renderRequest.getAttribute("canDelete");

    if(cokeId > 0) {
        cokeDTO = (CokeDTO) request.getAttribute("cokeDTO");
    }
%>

<portlet:renderURL var="backViewURL">
    <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_COKE_LIST %>"></portlet:param>
</portlet:renderURL>

<portlet:actionURL var="deleteCoke" name="<%=MVCCommandNames.DELETE_COKE %>">
    <portlet:param name="cokeId" value="<%= String.valueOf(cokeId) %>" />
</portlet:actionURL>

<portlet:resourceURL var="resourceURL">
    <portlet:param name="cokeId" value="<%= String.valueOf(cokeId) %>" />
    <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.EDIT_COKE %>" />
</portlet:resourceURL>

<portlet:actionURL var="updateCoke" name="<%=MVCCommandNames.EDIT_COKE %>">
    <portlet:param name="cokeId" value="<%= String.valueOf(cokeId) %>" />
</portlet:actionURL>

<aui:form action="<%= updateCoke %>" name="<portlet:namespace />fm">
    <aui:model-context bean="<%= coke %>" model="<%= Coke.class %>" />

    <aui:fieldset>
        <aui:input name="name" value="${cokeDTO.getCoke().name}"/>
        <aui:input name="cokeId" type="hidden" value='<%= coke == null ? cokeId : coke.getCokeId() %>'/>
    </aui:fieldset>

    <div class="card" id="nextToPayCard">
        <div class="card-body">
            <h2>Próximos a Pagar</h2>

            <% int next = 0; %>
            <% for (User nextUser : cokeDTO.getNextUsersList()) { %>
                <% if (next % 2 == 0) { %>
                    <div class="row">
                <% } %>
                        <div class="col-md-6 member" style="<%= next < 4 ? "" : "display: none;" %>">
                            <div class="card card-horizontal card-rounded">
                                <div class="card-row">
                                    <div class="autofit-col">
                                        <img class="card-item-last rounded-circle" style="width: 50px"
                                            src="<%= nextUser.getPortraitURL(themeDisplay) %>"
                                        />
                                    </div>
                                    <div class="autofit-col autofit-col-expand autofit-col-gutters">
                                        <section class="autofit-section">
                                            <h3 class="card-title"><%= (next + 1) + "º " + nextUser.getFullName() %></h3>
                                            <h4 class="card-subtitle mb-2 text-muted">Membro há: <%= LittleCokeUtil.memberSince(nextUser.getCreateDate()) %> dia(s)</h4>
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
        </div>

        <div class="autofit-col autofit-col-expand autofit-col-gutters">
            <section class="autofit-section">
                <button id="refresh-btn" class="btn btn-primary">
                    Atualizar Lista <clay:icon symbol="reload" />
                </button>
            <button id="loadMoreNext" class="btn btn-primary">
                Mostre Mais Membros <clay:icon symbol="plus" />
            </button>
            </section>
        </div>
    </div>

    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h3 class="card-title">Média de Coca Por Pessoa</h3>
            <p class="card-text">
                Você Sabia? Ao comprar uma coca cola de 2L, e levando em consideração que temos ${cokeDTO.getNextUsersList().size()} associados,
                ao bebermos em um copo de 300 ML, cada um toma em média <%= LittleCokeUtil.averageCokeByPersonFormatted(cokeDTO.getNextUsersList().size()) %>
            </p>
        </div>
    </div>

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
                        <% for(User userNotInCoke : cokeDTO.getUsersNotInUserCokeList() != null ? cokeDTO.getUsersNotInUserCokeList() : userList) { %>
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
                        <% if(cokeDTO.getUsersInUserCokeList() != null) {
                            for(User userInCoke : cokeDTO.getUsersInUserCokeList()) { %>
                                <option value="<%= userInCoke.getUserId() %>"><%= userInCoke.getFullName() %></option>
                            <% }
                        } %>
                    </select>
                    <div class="clay-reorder-underlay form-control"></div>
                </div>
            </div>
        </div>
    </div>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= backViewURL.toString() %>"></aui:button>
        <% if(canDelete) { %>
            <aui:button type="delete" onClick="<%= deleteCoke.toString() %>" value="Excluir" style="float: right; color: #fff; background-color: #EB1313; border-color: #EB1313"></aui:button>
        <% } %>
    </aui:button-row>
</aui:form>

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
            var url = '<portlet:resourceURL id="<%=MVCCommandNames.UPDATE_MEMBERS_LIST %>" />';
            url += '?cokeId=' + <%= cokeId %>;
            A.io.request(url, {
                method: 'POST',
                on: {
                    complete: function() {
                        console.log('Lista atualizada!');
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