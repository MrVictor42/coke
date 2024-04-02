<%@ include file="/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	List<Coke> cokeList = (List<Coke>) renderRequest.getAttribute("cokeList");
%>

<br>

<portlet:renderURL var="addCokeURL">
	<portlet:param name="mvcPath" value="/coke/edit_coke.jsp"></portlet:param>
</portlet:renderURL>

<% if(cokeList.isEmpty()) { %>
	<h1>Sua bancada ainda não possui um gerenciamento de coquinha? Cadastre uma agora mesmo</h1>
	
	<aui:button-row>
		<aui:button onClick="<%= addCokeURL.toString() %>" value="Adicionar"></aui:button>
	</aui:button-row>
<% } else { 
	for(Coke coke : cokeList) { %>
		<div class="panel-group">
			<div class="panel panel-secondary">
				<button aria-controls="collapsePanelOne" aria-expanded="true"
					class="btn btn-unstyled panel-header panel-header-link collapse-icon collapse-icon-middle"
					data-target="#collapsePanel" data-toggle="collapse"
				>
					<span class="panel-title">
						<%= coke.getName() %>
					</span>
					<span class="collapse-icon-closed">
						<clay:icon symbol="angle-right" />
					</span>
					<span class="collapse-icon-open">
						<clay:icon symbol="angle-down" />
					</span>
				</button>
				<div class="panel-collapse in" id="collapsePanelOne">
					<div class="panel-body">
						Here is some content inside for number One
					</div>
				</div>
			</div>	

			<br>

			<aui:button-row>
				<aui:button onClick="<%= addCokeURL.toString() %>" value="Adicionar"></aui:button>
			</aui:button-row>
		</div>
	<% }
}%>


<br>