<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>战斗人生游戏网站</title>
  </head>
  <body>
    <bean:include id="showDeity" page="/deity.do?action=view"></bean:include>
    <bean:write name="showDeity" filter="false"/>
    <bean:include id="addFighter" page="/fighter.do?action=initAdd"></bean:include>
    <bean:write name="addFighter" filter="false"/>
    <jsp:include page="WEB-INF/jsp/pk.jsp" flush="true"></jsp:include>
    <bean:include id="listFighters" page="/fighter.do?action=listByDeity"></bean:include>
    <bean:write name="listFighters" filter="false"/>
  </body>
</html>
