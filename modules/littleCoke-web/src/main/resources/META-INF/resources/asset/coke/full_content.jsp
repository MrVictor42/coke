<%@include file="../../init.jsp"%>

<%
	Coke coke = (Coke) request.getAttribute("coke_coke");

	coke = coke.toEscapedModel();
%>

<dl>
        <dt>Name</dt>
        <dd><%= coke.getName() %></dd>
</dl>