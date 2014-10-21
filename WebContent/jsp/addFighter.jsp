<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="fl.core.domain.*" %>
<%@ page import="fl.core.service.*" %>
<%@ page import="java.util.List" %>

<% 
Fighter fighter = (Fighter) request.getAttribute("newFighter"); 
String errorMsg = (String) request.getAttribute("error");
%>
<div style="clear:both; height:250px;">
<div style="float:left; width:600px;">
  <b>培养新人</b>
  <form name="addFighterForm" method="post" action="<%= request.getContextPath() %>/addFighter" onsubmit="return validateAddInput();">
    姓名：<input type="text" name="name"><br />
    昵称：<input type="text" name="nickName"><br />
    <input type="hidden" name="deityId" value="<%= request.getAttribute("DEITY_ID") %>">
    <input type="submit" value="提交">
  </form>
<% if(errorMsg != null) { %>
  <span><%= errorMsg %></span>
<% } %>
</div>
<% if(fighter != null) { %>
<div style="float:left;">
  <i>您刚刚培养出新的战士：</i>
  <%= fighter.getName() + " (" + fighter.getNickName() + ")" %><br />
  <%= "生命: " + fighter.getHp() + " / " + fighter.getMaxHp() %><br />
  <%= "攻击: " + fighter.getAttack() %><br />
  <%= "防御: " + fighter.getDefence() %><br />
</div>
<% } %>
</div>

<script type="text/javascript">  
  function validateAddInput(channelform) {
    if(addFighterForm.name.value == "") {  
      alert("请输入姓名");  
      return false;  
    } else if (addFighterForm.nickName.value == "") {  
      alert("请输入昵称");  
      return false;  
    }
  }
</script>

