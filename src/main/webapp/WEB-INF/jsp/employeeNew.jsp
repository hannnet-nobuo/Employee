<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>社員登録</title>
<s:head />
</head>
<body>
	<p>社員登録</p>
	<s:form action="employeeNew">
		<s:textfield label="名前を入力" name="name" />
		<s:textfield label="社員番号を入力" name="enumber" />
		<s:submit type="button" value="insert" name="insert" >確定</s:submit>
	</s:form>
	<a href="<s:url namespace="/" action="employeeSearch" />">一覧に戻る</a>
</body>
</html>