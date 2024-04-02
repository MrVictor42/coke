<%@ include file="/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% List<CokeDTO> cokeDTOList = (List<CokeDTO>) renderRequest.getAttribute("cokeDTOList"); %>

<br>

<% if(cokeDTOList.isEmpty()) { %>
	<h1>Sua bancada ainda não possui um gerenciamento de coquinha? Cadastre uma agora mesmo</h1>
	
	<portlet:renderURL var="addCokeURL">
		<portlet:param name="mvcPath" value="/coke/edit_coke.jsp"></portlet:param>
	</portlet:renderURL>
	<aui:button-row>
		<aui:button onClick="<%= addCokeURL.toString() %>" value="Adicionar"></aui:button>
	</aui:button-row>
<% } else {
	int aux = 0;
	for(CokeDTO cokeDTO : cokeDTOList) { %>
		<portlet:renderURL var="viewMoreURL">
			<portlet:param name="mvcPath" value="/coke/edit_coke.jsp" />
			<portlet:param name="cokeId" value="<%= String.valueOf(cokeDTO.getCoke().getCokeId()) %>" />
		</portlet:renderURL>

		<div class="panel-group">
			<div class="panel panel-secondary">
				<button aria-controls="collapsePanel<%= cokeDTO.getCoke().getCokeId() %>" aria-expanded="<%= aux == 0 ? "true" : "false" %>"
					class="btn btn-unstyled panel-header panel-header-link collapse-icon collapse-icon-middle"
					data-target="#collapsePanel<%= cokeDTO.getCoke().getCokeId() %>" data-toggle="collapse"
				>
					<span class="panel-title">
						<%= cokeDTO.getCoke().getName() %>
					</span>
					<span class="collapse-icon-closed">
						<clay:icon symbol="angle-right" />
					</span>
					<span class="collapse-icon-open">
						<clay:icon symbol="angle-down" />
					</span>
				</button>
				
				<div class="panel-collapse <%= aux == 0 ? "" : "collapse" %>" id="collapsePanel<%= cokeDTO.getCoke().getCokeId() %>">
					<div class="card card-horizontal">
						<div class="card-row">
							<div class="autofit-col autofit-col-expand">
								<h3 class="card-title">Quem Vai Pagar a Coca Hoje? </h3>
								<h4 class="card-subtitle mb-2 text-muted">Próximo: </h4>
								<a href="<%= viewMoreURL %>" class="card-link">Ver Mais</a>
							</div>
							<div class="autofit-col autofit-col-expand">
								<section class="autofit-section">
									<h2 class="card-title">Criado Dia: </h2> <h3 class="card-subtitle mb-2 text-muted"><%=  cokeDTO.getInitialDate() %></h3>
								</section>
							</div>
						</div>
					</div>
				</div>
			</div>	

			<br>

			<aui:button-row>
				<aui:button onClick="<%= viewMoreURL.toString() %>" value="Hum"></aui:button>
			</aui:button-row>
		</div>
	<% 
		aux++;
	}
}%> 

<br>