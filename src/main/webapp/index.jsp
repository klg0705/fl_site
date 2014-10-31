<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:choose>
  <c:when test="${param.locale != null}">
    <fmt:setLocale value="${param.locale}" scope="session" />
  </c:when>
  <c:otherwise>
    <fmt:setLocale value="zh_CN" scope="session" />
  </c:otherwise>
</c:choose>

<% response.sendRedirect(request.getContextPath() + "/index.do"); %>
