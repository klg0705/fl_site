<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<div style="clear: both; height: 60px;">
  <c:choose>
    <c:when test="${ personInfo == null }">
      <div style="float: left;">
        <html:form action="/login" onsubmit="return validateLoginInput();">
    账号：<html:text property="person.account" />
          <html:errors property="person.account" />
    密码：<html:password property="password" />
          <html:errors property="password" />
          ${ loginError }
          <html:hidden property="action" value="login" />
          <html:submit value="登陆" />
        </html:form>
      </div>
      <div style="float: left; margin-left: 5px;">
        <html:form action="/person" style="float:left;">
          <html:hidden property="action" value="initAdd" />
          <html:submit value="注册" />
        </html:form>
      </div>
    </c:when>
    <c:otherwise>
      <html:form action="/login">
  您好，${personInfo.account} &nbsp;&nbsp;&nbsp;&nbsp;
        <html:hidden property="action" value="logout" />
        <html:submit value="登出" />
      </html:form>
    </c:otherwise>
  </c:choose>
</div>
<script type="text/javascript">
	function validateLoginInput() {
		if (personForm[0]["person.account"].value == "") {
			alert("请输入账号");
			return false;
		} else if (personForm[0]["password"].value == "") {
			alert("请输入密码");
			return false;
		}
	}
</script>