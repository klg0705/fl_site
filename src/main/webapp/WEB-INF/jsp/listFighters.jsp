<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<div style="clear:both;" id="fighterList">
<c:forEach items="${ DEITY.fighters }" var="fighter">
  <div style="float:left; width:220px;">
    <p style="display:none">${ fighter.id }</p>
    <img src="${pageContext.request.contextPath}/images/defaultFighter.jpg" /><br />
    ${fighter.name} (${fighter.nickName})<br />
    <fmt:message bundle="${ siteRes }" key="fighter.hp"></fmt:message>: ${fighter.hp} / ${fighter.maxHp} <br />
    <fmt:message bundle="${ siteRes }" key="fighter.attack"></fmt:message>: ${fighter.attack}<br />
    <fmt:message bundle="${ siteRes }" key="fighter.defence"></fmt:message>: ${fighter.defence}<br />
  </div>
</c:forEach>
</div>
