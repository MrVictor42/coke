<%@ include file="/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<liferay-ui:success key="cokeAdded" message="coke-added" />

<% List<CokeDTO> cokeDTOList = (List<CokeDTO>) renderRequest.getAttribute("cokeDTOList"); %>

<br>

<portlet:renderURL var="addCokeURL">
	<portlet:param name="mvcPath" value="/coke/edit_coke.jsp"></portlet:param>
</portlet:renderURL>
<aui:button-row>
	<aui:button onClick="${addCokeURL}" value="Adicionar"></aui:button>
</aui:button-row>

<c:choose>
	<c:when test="${empty cokeDTOList}">
		<h1>Sua bancada ainda não possui um gerenciamento de coquinha? Cadastre uma agora mesmo</h1>
		
		<portlet:renderURL var="addCokeURL">
			<portlet:param name="mvcPath" value="/coke/edit_coke.jsp"></portlet:param>
		</portlet:renderURL>
		<aui:button-row>
			<aui:button onClick="${addCokeURL}" value="Adicionar"></aui:button>
		</aui:button-row>
	</c:when>
	<c:otherwise>
		<c:forEach items="${cokeDTOList}" var="cokeDTO" varStatus="status">
			<portlet:renderURL var="viewMoreURL">
				<portlet:param name="mvcPath" value="/coke/edit_coke.jsp" />
				<portlet:param name="cokeId" value="${cokeDTO.coke.cokeId}" />
			</portlet:renderURL>

			<div class="panel-group">
				<div class="panel panel-secondary">
					<button aria-controls="collapsePanel${cokeDTO.coke.cokeId}" aria-expanded="${status.index == 0 ? 'true' : 'false'}"
						class="btn btn-unstyled panel-header panel-header-link collapse-icon collapse-icon-middle"
						data-target="#collapsePanel${cokeDTO.coke.cokeId}" data-toggle="collapse"
					>
						<span class="panel-title">
							${cokeDTO.coke.name}
						</span>
						<span class="collapse-icon-closed">
						<clay:icon symbol="angle-right" />
						</span>
						<span class="collapse-icon-open">
							<clay:icon symbol="angle-down" />
						</span>
					</button>

					<div class="panel-collapse ${status.index == 0 ? '' : 'collapse'}" id="collapsePanel${cokeDTO.coke.cokeId}">
						<div class="card card-horizontal">
							<div class="card-row">
								<div class="autofit-col autofit-col-expand">
									<div class="autofit-col">
										<h2 class="card-title" style="margin-top: 20px; margin-left: 20px; margin-bottom:0px">Quem Será o Próximo a Pagar</h2>
										<div style="display: flex; align-items: center;">
											<img class="card-item-last rounded-circle" style="width: 50px; margin: 20px"
												src="${cokeDTO.getNextUsersList().get(0).getPortraitURL(themeDisplay)}"
											/>
											<h3 class="card-title" style="margin-left: 10px;">${cokeDTO.getNextUsersList().get(0).fullName}</h3>
										</div>
										<h2 class="card-title" style="margin-top: 20px; margin-left: 20px; margin-bottom:0px">Depois</h2>
										<div style="display: flex; align-items: center;">
											<img class="card-item-last rounded-circle" style="width: 50px; margin: 20px"
												src="${cokeDTO.getNextUsersList().get(1).getPortraitURL(themeDisplay)}"
											/>
											<h4 class="card-title" style="margin-left: 10px;">${cokeDTO.getNextUsersList().get(1).fullName}</h4>
										</div>
										<a href="<%= viewMoreURL %>" class="card-link">Ver Mais</a>
									</div>
								</div>
								<div class="autofit-col autofit-col-expand">
									<section class="autofit-section">
										<h2 class="card-title">Criado Dia: </h2> <h3 class="card-subtitle mb-2 text-muted">${cokeDTO.initialDate}</h3>
									</section>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</c:otherwise>
</c:choose>