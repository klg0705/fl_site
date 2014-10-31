<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<div style="clear:both;">
  <div>
    <p style="display:none">${DEITY.id}</p>
    <fmt:message bundle="${ siteRes }" key="message.welcome">
      <fmt:param>${DEITY.name}</fmt:param>
    </fmt:message>
    <br />
    <br />
    <br />
  </div>
</div>
