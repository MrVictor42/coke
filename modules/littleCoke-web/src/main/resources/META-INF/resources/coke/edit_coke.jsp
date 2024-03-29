<%@ include file="../init.jsp" %>

<%
    long userCokeId = ParamUtil.getLong(renderRequest, "userCokeId");
    UserCoke userCoke = null;

    long cokeId = ParamUtil.getLong(renderRequest, "cokeId"); // Movido para cima

    if(userCokeId > 0) {
        userCoke = UserCokeLocalServiceUtil.getUserCoke(cokeId);
    }
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/coke/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addCoke" var="addCokeURL" />

<aui:form action="<%= addCokeURL %>" name="<portlet:namespace />fm">
    <aui:model-context bean="<%= userCoke %>" model="<%= UserCoke.class %>" />
</aui:form>

<aui:button-row>
    <aui:fieldset>

        <aui:input name="name" type="text"/>
        <aui:input name="userCokeId" type="hidden" />
        <aui:input name="cokeId" type="hidden" value='<%= userCoke == null ? userCokeId : userCoke.getCokeId() %>'/>

    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
    </aui:button-row>
</aui:button-row>