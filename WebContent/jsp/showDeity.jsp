<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="fl.core.domain.*" %>
<%@ page import="fl.core.service.*" %>
<%@ page import="fl.core.service.impl.*" %>
<%@ page import="java.util.List" %>

<div style="clear:both;">
<% 
Deity deity = null;
DeityService serv = new DeityServiceImpl();
List<Deity> deities = serv.getAll();
if(deities == null || deities.size() == 0) {
    deity = new Deity();
    deity.setName("GOD");
    serv.add(deity);
} else {
    deity = deities.get(0);
}
deity = serv.getWithFighters(deity.getId());
request.setAttribute("DEITY_ID", deity.getId());
request.setAttribute("DEITY", deity);
%>
  <div>
    <p style="display:none"><%= deity.getId() %></p>
    <%= "尊敬的大神<b>" + deity.getName()  + "</b>，今天您心情可好？" %><br />
    <br />
    <br />
  </div>
</div>
