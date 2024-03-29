<%@ include file="../init.jsp" %>

<h1>COQUINHA</h1>

<p>
	<b><liferay-ui:message key="cokeweb.caption"/></b>
</p>

<div id="myAlert"></div>

<script>
YUI().use(
  'aui-alert',
  function(Y) {
    new Y.Alert(
      {
        animated: true,
        bodyContent: 'Thank You Mario! But Our Princess Is In That Castle!',
        boundingBox: '#myAlert',
        closeable: true,
        cssClass: 'alert-warning',
        destroyOnHide: false,
        duration: 1,
        render: true
      }
    );
  }
);
</script>

