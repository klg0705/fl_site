<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<div>
  <html:form action="/person">
    <html:hidden property="action" value="add" />
    账号：<html:text property="person.account" /><html:errors property="person.account" /><br />
    密码：<html:password property="person.password" /><html:errors property="person.password" /><br />
    确认密码：<html:password property="password" /><html:errors property="password" /><br />
    姓名：<html:text property="person.name" /><html:errors property="person.name" /><br />
    性别：<html:select property="person.sex" >
       <html:option value="男">男</html:option>
       <html:option value="女">女</html:option>
     </html:select><br />
    电子邮件：<html:text property="person.email" /><html:errors property="person.email" /><br />
    生日：<html:text property="person.birthday" /><br />
    <html:submit value="注册" />
  </html:form>
</div>