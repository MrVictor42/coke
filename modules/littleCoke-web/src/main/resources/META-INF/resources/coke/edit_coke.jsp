<%@ include file="../init.jsp" %>

<%
    Coke coke = null;
    long cokeId = ParamUtil.getLong(renderRequest, "cokeId");

    if(cokeId > 0) {
        coke = CokeLocalServiceUtil.getCoke(cokeId);
    }
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/coke/view.jsp"></portlet:param>
</portlet:renderURL>

<h1>Consagrados da Coquinha</h1>

<portlet:actionURL name="addCoke" var="addCokeURL" />
<aui:form action="<%= addCokeURL %>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= coke %>" model="<%= Coke.class %>" />

	<aui:fieldset>
		<aui:input name="name" />
		<aui:input name="cokeId" type="hidden" value='<%= coke == null ? cokeId : coke.getCokeId() %>'/>
	</aui:fieldset>

	<div class="form-group">
		<div class="clay-dual-listbox">
			<div class="clay-dual-listbox-item clay-dual-listbox-item-expand">
				<label for="_9d5cxj5xm">
					<span class="text-truncate-inline">
						<span class="text-truncate">In Use</span>
					</span>
				</label>
				<div class="clay-reorder clay-reorder-footer-end">
					<select
						class="form-control form-control-inset"
						id="_9d5cxj5xm"
						multiple
						size="7"
					>
						<option value="twitter">Twitter</option>
						<option value="linkedin">Linkedin</option>
						<option value="facebook">Facebook</option>
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
						<span class="text-truncate">Available</span>
					</span>
				</label>
				<div class="clay-reorder">
					<select
						class="form-control form-control-inset"
						id="_957gwvjvl"
						multiple
						size="7"
					>
						<option value="addthis">AddThis</option>
						<option value="delicious">Delicious</option>
						<option value="digg">Digg</option>
						<option value="evernote">Evernote</option>
					</select>
					<div class="clay-reorder-underlay form-control"></div>
				</div>
			</div>
		</div>
	</div>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
	</aui:button-row>
</aui:form>

<script>
	document.querySelector('.clay-dual-listbox-actions button:nth-child(1)').addEventListener('click', function() {
		var selectedOptions = document.querySelectorAll('#_9d5cxj5xm option:checked');
		selectedOptions.forEach(function(option) {
			document.querySelector('#_957gwvjvl').appendChild(option);
		});
	});

	document.querySelector('.clay-dual-listbox-actions button:nth-child(2)').addEventListener('click', function() {
		var selectedOptions = document.querySelectorAll('#_957gwvjvl option:checked');
		selectedOptions.forEach(function(option) {
			document.querySelector('#_9d5cxj5xm').appendChild(option);
		});
	});
</script>