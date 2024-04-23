<%@ include file="../init.jsp" %>

<%
    AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute(WebKeys.ASSET_RENDERER);
    String viewEntryURL = assetRenderer.getURLView(liferayPortletResponse, WindowState.MAXIMIZED);
    Coke coke = (Coke) request.getAttribute("coke");
%>

<aui:a cssClass="title-link" href="<%= viewEntryURL %>">
    <h3 class="title">
        <%= HtmlUtil.escape(coke.getName()) %>
    </h3>
</aui:a>
<div class="autofit-col autofit-col-expand">
    <%= HtmlUtil.escape(coke.getName()) %>
</div>