<%@ include file="./init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<liferay-ui:error key="serviceErrorDetails">
    <liferay-ui:message arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>' key="error.assignment-service-error" />
</liferay-ui:error>
<liferay-ui:success key="cokeAdded" message="coke-added" />
<liferay-ui:success key="updatedCoke" message="updated-list" />
<liferay-ui:success key="cokeDeleted" message="coke-deleted-successfully" />

<% List<CokeDTO> cokeDTOList = (List<CokeDTO>) renderRequest.getAttribute("cokeDTOList"); %>

<br>

<portlet:renderURL var="addCokeURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.ADD_COKE %>"></portlet:param>
</portlet:renderURL>
<aui:button-row>
	<aui:button onClick="${addCokeURL}" value="Adicionar Outro Portlet da Coquinha" style="float: right; color: #fff; background-color: #28a745; border-color: #28a745"></aui:button>
</aui:button-row>

<c:choose>
	<c:when test="${empty cokeDTOList}">
		<h1>Sua bancada ainda não possui um gerenciamento de coquinha? Cadastre uma agora mesmo!!!</h1>
		<aui:button-row>
			<aui:button onClick="${addCokeURL}" value="Adicionar"></aui:button>
		</aui:button-row>
	</c:when>
	<c:otherwise>
		<c:forEach items="${cokeDTOList}" var="cokeDTO" varStatus="status">
			<portlet:renderURL var="viewMoreURL">
				<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.EDIT_COKE %>"/>
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
										<c:if test="${not empty cokeDTO.getNextUsersList() and cokeDTO.getNextUsersList().size() > 1}">
											<div style="display: flex; align-items: center;">
												<img class="card-item-last rounded-circle" style="width: 50px; margin: 20px"
													src="${cokeDTO.getNextUsersList().get(1).getPortraitURL(themeDisplay)}"
												/>
												<h4 class="card-title" style="margin-left: 10px;">${cokeDTO.getNextUsersList().get(1).fullName}</h4>
											</div>
										</c:if>
										<c:if test="${empty cokeDTO.getNextUsersList() or cokeDTO.getNextUsersList().size() <= 1}">
											<div style="display: flex; align-items: center;">
												<img class="card-item-last rounded-circle" style="width: 50px; margin: 20px"
													src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Brazil.svg/275px-Flag_of_Brazil.svg.png"
												/>
												<h4 class="card-title" style="margin-left: 10px;">Brasil</h4>
											</div>
										</c:if>
										<aui:button onClick="${viewMoreURL}" style="background-color: #007bff; color: white;" value="Mostre Mais"></aui:button>
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