<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"	prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<div style="clear:both; height:250px;">
<div style="float:left; width:600px;">
  <b>培养新人</b>
  <html:form action="/fighter" onsubmit="return validateAddInput();">
    姓名：<html:text property="fighter.name" /><html:errors property="fighter.name" /><br />
    昵称：<html:text property="fighter.nickName" /><html:errors property="fighter.nickName" /><br />
    <html:hidden property="fighter.deity.id" value="${sessionScope.DEITY_ID}" />
    <html:hidden property="action" value="add" />
    <html:submit value="提交" />
  </html:form>
</div>
<c:if test="${ newFighter != null }">
<div style="float:left;">
  <i>您刚刚培养出新的战士：</i><br />
  ${newFighter.name} (${newFighter.nickName})<br />
  <fmt:message bundle="${ siteRes }" key="fighter.hp"></fmt:message>: ${newFighter.hp} / ${newFighter.maxHp} <br />
  <fmt:message bundle="${ siteRes }" key="fighter.attack"></fmt:message>: ${newFighter.attack}<br />
  <fmt:message bundle="${ siteRes }" key="fighter.defence"></fmt:message>: ${newFighter.defence}<br />
</div>
</c:if>
</div>

<script type="text/javascript">
  function validateAddInput() {
    if(fighterForm["fighter.name"].value == "") {
      alert("请输入姓名");
      return false;
    } else if (fighterForm["fighter.nickName"].value == "") {
      alert("请输入昵称");
      return false;
    }
  }
</script>

