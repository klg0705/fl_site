<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="fl.core.domain.*" %>
<%@ page import="fl.core.service.*" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://struts.apache.org/tags-html"	prefix="html"%>

<% 
Fighter fighter = (Fighter) request.getAttribute("newFighter"); 
String deityId = String.valueOf(session.getAttribute("DEITY_ID"));
%>
<div style="clear:both; height:250px;">
<div style="float:left; width:600px;">
  <b>培养新人</b>
  <html:form action="/fighter" onsubmit="validateAddInput();">
    姓名：<html:text property="fighter.name" /><html:errors property="fighter.name" /><br />
    昵称：<html:text property="fighter.nickName" /><html:errors property="fighter.nickName" /><br />
    <html:hidden property="fighter.deity.id" value="<%= deityId %>" />
    <html:hidden property="action" value="add" />
    <html:submit value="提交" />
  </html:form>
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
    if(fighterForm["fighter.name"].value == "") {  
      alert("请输入姓名");  
      return false;  
    } else if (fighterForm["fighter.nickName"].value == "") {  
      alert("请输入昵称");  
      return false;  
    }
  }
</script>

