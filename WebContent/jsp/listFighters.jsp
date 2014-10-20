<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="fl.core.domain.*" %>
<%@ page import="fl.core.service.*" %>
<%@ page import="fl.core.service.impl.*" %>
<%@ page import="java.util.List" %>

<div style="clear:both;">
<% 
FighterService fs = new FighterServiceImpl();
List<Fighter> fighters = fs.listAllFighters();

for(Fighter fighter : fighters) {
%>
  <div style="float:left; width:220px;">
    <p style="display:none"><%= fighter.getId() %></p>
    <img src="<%=request.getContextPath() %>/images/defaultFighter.jpg" /><br />
    <%= fighter.getName() + " (" + fighter.getNickName() + ")" %><br />
    <%= "生命: " + fighter.getHp() + " / " + fighter.getMaxHp() %><br />
    <%= "攻击: " + fighter.getAttack() %><br />
    <%= "防御: " + fighter.getDefence() %><br />
  </div>
<% } %>
</div>
