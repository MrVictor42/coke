<%@ include file="/init.jsp" %>

<portlet:renderURL var="addCokeURL">
    <portlet:param name="mvcPath" value="/coke/edit_coke.jsp"></portlet:param>
</portlet:renderURL>

<aui:button-row>
    <aui:button onClick="<%= addCokeURL.toString() %>" value="Adicionar"></aui:button>
</aui:button-row>