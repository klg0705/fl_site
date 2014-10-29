<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="fl.core.domain.*"%>
<%@ page import="fl.core.service.*"%>
<%@ page import="fl.core.service.impl.*"%>
<%@ page import="java.util.List"%>

<%
    String message = (String) request.getAttribute("message");
%>

<div style="clear: both; height: 30px;">
  <div>
    <form id="pkForm" name="pkForm" method="post" action="<%=request.getContextPath()%>/pk">
      <input type="button" name="pk" onclick="pkClicked()" value="PK" /> &nbsp;&nbsp;&nbsp;
      <%= message == null ? "" : message %>
    </form>
  </div>
</div>
<script>
	function pkClicked() {
		var element = document.getElementById("fighterList");
		var fighterIds = element.getElementsByTagName("p");
		if (fighterIds.length > 1) {
			var form = document.getElementById("pkForm");
			var actionStr = form.getAttribute("action");
			actionStr += "?fighter1=" + fighterIds.item(0).firstChild.nodeValue;
			actionStr += "&fighter2=" + fighterIds.item(1).firstChild.nodeValue;
			form.setAttribute("action", actionStr);
			form.submit();
		} else {
			alert("You need more fighters!");
		}
	}
</script>