<%@ include file="../init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    Coke coke = null;
    long cokeId = ParamUtil.getLong(renderRequest, "cokeId");


    // if(cokeId > 0) {
    //     coke = CokeLocalServiceUtil.getCoke(cokeId);
    // }

	// List<User> usersNotInUserCokeList = (List<User>) renderRequest.getAttribute("usersNotInUserCokeList");
	// List<User> usersInUserCokeList = (List<User>) renderRequest.getAttribute("usersInUserCokeList");
	// List<User> userList = (List<User>) renderRequest.getAttribute("userList");
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/coke/view.jsp"></portlet:param>
</portlet:renderURL>

<h1>Consagrados da Coquinha</h1>
<h1><%= cokeId %></h1>

<%-- <portlet:actionURL name="addCoke" var="addCokeURL" />
<aui:form action="<%= addCokeURL %>" name="<portlet:namespace />fm">
    <aui:model-context bean="<%= coke %>" model="<%= Coke.class %>" />

    <aui:fieldset>
        <aui:input name="name" required="true">
            <aui:validator name="name" errorMessage="Enter characters that exist in the alphabet next time, please." />
        </aui:input>
        <aui:input name="cokeId" type="hidden" value='<%= coke == null ? cokeId : coke.getCokeId() %>'/>

        <div class="form-group">
            <div class="clay-dual-listbox">
                <div class="clay-dual-listbox-item clay-dual-listbox-item-expand">
                    <label for="_9d5cxj5xm">
                        <span class="text-truncate-inline">
                            <span class="text-truncate">Participantes</span>
                        </span>
                    </label>
        
                    <div class="clay-reorder clay-reorder-footer-end">
                        <select class="form-control form-control-inset" id="notconsagrated" name="notconsagrated" multiple size="10">
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
                            <span class="text-truncate">Presidente e Vice Presidente</span>
                        </span>
                    </label>
                    <div class="clay-reorder">
                        <select class="form-control form-control-inset" id="consagrated" name="_br_com_victor_littleCoke_web_LittleCokeWebPortlet_consagrated" multiple size="2">
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
        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
    </aui:button-row>
</aui:form>


<script>
    document.querySelector('.clay-dual-listbox-actions button:nth-child(1)').addEventListener('click', function() {
        var selectedOptions = Array.from(document.querySelectorAll('#notconsagrated option:checked'));
        selectedOptions.forEach(function(option) {
            if (document.querySelectorAll('#consagrated option').length < 2) { 
                var clone = option.cloneNode(true);
                clone.selected = true;
                document.querySelector('#consagrated').appendChild(clone);
                document.querySelector('#notconsagrated').removeChild(option);
            }      
        });
    });

    document.querySelector('.clay-dual-listbox-actions button:nth-child(2)').addEventListener('click', function() {
        var selectedOptions = Array.from(document.querySelectorAll('#consagrated option:checked'));
        selectedOptions.forEach(function(option) {
            var clone = option.cloneNode(true);
            clone.selected = true;
            document.querySelector('#notconsagrated').appendChild(clone);
            document.querySelector('#consagrated').removeChild(option);
        });
    });
</script> --%>
