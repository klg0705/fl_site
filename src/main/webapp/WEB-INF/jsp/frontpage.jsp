<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<fmt:setBundle basename="site_resources" var="siteRes" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><tiles:getAsString name="title" ignore="true" /></title>
</head>
<body>
  <div>
    <tiles:insert name="login" />
  </div>
  <c:if test="${sessionScope.DEITY_ID != null}">
    <div>
      <tiles:insert name="deityInfo" />
    </div>
    <div>
      <tiles:insert name="addFigher" />
    </div>
    <div>
      <tiles:insert name="pkZone" />
    </div>
    <div>
      <tiles:insert name="myFighters" />
    </div>
  </c:if>
</body>
</html>
