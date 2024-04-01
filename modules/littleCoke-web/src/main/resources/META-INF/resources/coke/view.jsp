<%@ include file="/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<br>
<div class="panel-group">
	<div class="panel panel-secondary">
		<button
			aria-controls="collapsePanelOne"
			aria-expanded="false"
			class="btn btn-unstyled panel-header panel-header-link collapse-icon collapse-icon-middle collapsed"
			data-target="#collapsePanelOne"
			data-toggle="collapse"
		>
			<span class="panel-title">One</span>
			<span class="collapse-icon-closed">
				<svg
					class="lexicon-icon lexicon-icon-angle-right"
					role="presentation"
				>
					<use xlink:href="/images/icons/icons.svg#angle-right"></use>
				</svg>
			</span>
			<span class="collapse-icon-open">
				<svg
					class="lexicon-icon lexicon-icon-angle-down"
					role="presentation"
				>
					<use xlink:href="/images/icons/icons.svg#angle-down"></use>
				</svg>
			</span>
		</button>
		<div class="panel-collapse collapse" id="collapsePanelOne">
			<div class="panel-body">
				Here is some content inside for number One
			</div>
		</div>
	</div>
	<div class="panel panel-secondary">
		<button
			aria-controls="collapsePanelTwo"
			aria-expanded="false"
			class="btn btn-unstyled panel-header panel-header-link collapse-icon collapse-icon-middle collapsed"
			data-target="#collapsePanelTwo"
			data-toggle="collapse"
		>
			<span class="panel-title">Two</span>
			<span class="collapse-icon-closed">
				<svg
					class="lexicon-icon lexicon-icon-angle-right"
					role="presentation"
				>
					<use xlink:href="/images/icons/icons.svg#angle-right"></use>
				</svg>
			</span>
			<span class="collapse-icon-open">
				<svg
					class="lexicon-icon lexicon-icon-angle-down"
					role="presentation"
				>
					<use xlink:href="/images/icons/icons.svg#angle-down"></use>
				</svg>
			</span>
		</button>
		<div class="panel-collapse collapse" id="collapsePanelTwo">
			<div class="panel-body">
				Here is some content inside for number Two
			</div>
		</div>
	</div>
	<div class="panel panel-secondary">
		<button
			aria-controls="collapsePanelThree"
			aria-expanded="false"
			class="btn btn-unstyled panel-header panel-header-link collapse-icon collapse-icon-middle collapsed"
			data-target="#collapsePanelThree"
			data-toggle="collapse"
		>
			<span class="panel-title">Three</span>
			<span class="collapse-icon-closed">
				<svg
					class="lexicon-icon lexicon-icon-angle-right"
					role="presentation"
				>
					<use xlink:href="/images/icons/icons.svg#angle-right"></use>
				</svg>
			</span>
			<span class="collapse-icon-open">
				<svg
					class="lexicon-icon lexicon-icon-angle-down"
					role="presentation"
				>
					<use xlink:href="/images/icons/icons.svg#angle-down"></use>
				</svg>
			</span>
		</button>
		<div class="panel-collapse collapse" id="collapsePanelThree">
			<div class="panel-body">
				Here is some content inside for number Three
			</div>
		</div>
	</div>
</div>
<br>

<portlet:renderURL var="addCokeURL">
    <portlet:param name="mvcPath" value="/coke/edit_coke.jsp"></portlet:param>
</portlet:renderURL>

<aui:button-row>
    <aui:button onClick="<%= addCokeURL.toString() %>" value="Adicionar"></aui:button>
</aui:button-row>