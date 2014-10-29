<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="fl.core.domain.*" %>
<%@ page import="fl.core.service.*" %>
<%@ page import="fl.core.service.impl.*" %>
<%@ page import="fl.core.dao.impl.*" %>
<%@ page import="java.util.List" %>

<div style="clear:both;">
<% 
Deity deity = (Deity) request.getAttribute("DEITY");
%>
  <div>
    <p style="display:none"><%= deity.getId() %></p>
    <%= "尊敬的大神<b>" + deity.getName()  + "</b>，今天您心情可好？" %><br />
    <br />
    <br />
  </div>
</div>
