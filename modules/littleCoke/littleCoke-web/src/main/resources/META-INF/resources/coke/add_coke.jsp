<%@ include file="../init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<liferay-ui:error key="errorUpdateList" message="error-update-list" />
<liferay-ui:error key="errorUpdateCoke" message="error-update-coke"/>

<portlet:renderURL var="backViewURL">
    <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_COKE_LIST %>"></portlet:param>
</portlet:renderURL>
<portlet:actionURL var="addCoke" name="<%=MVCCommandNames.ADD_COKE %>">
    <portlet:param name="redirect" value="${param.redirect}" />
</portlet:actionURL>

<aui:form action="${addCoke}" name="<portlet:namespace />fm">
    <aui:fieldset>
        <aui:input name="name" />
    </aui:fieldset>

    <div class="form-group">
        <div class="clay-dual-listbox">
            <div class="clay-dual-listbox-item clay-dual-listbox-item-expand">
                <label for="_9d5cxj5xm">
                    <span class="text-truncate-inline">
                        <span class="text-truncate">Membros Disponíveis</span>
                    </span>
                </label>
                <div class="clay-reorder clay-reorder-footer-end">
                    <select class="form-control form-control-inset" id="notAssociated" name="_br_com_victor_littleCoke_web_LittleCokeWebPortlet_notAssociated" multiple size="10">
                        <c:choose>
                            <c:when test="${not empty userList}">
                                <c:forEach var="user" items="${userList}">
                                    <option value="${user.userId}">${user.fullName}</option>
                                </c:forEach>
                            </c:when>
                        </c:choose>
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
                        <c:if test="${not empty usersInUserCokeList}">
                            <c:forEach var="userInCoke" items="${usersInUserCokeList}">
                                <option value="${userInCoke.userId}">${userInCoke.fullName}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                    <div class="clay-reorder-underlay form-control"></div>
                </div>
            </div>
        </div>
    </div>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= backViewURL.toString() %>"></aui:button>
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