<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>社員一覧</title>
<s:head />
</head>
<body>
	<p>社員一覧</p>
	<s:form action="employeeSearch" theme="simple">
		<table>
			<tr>
				<th>id</th>
				<th>名前</th>
				<th>社員番号</th>
				<th>編集</th>
				<th>削除</th>
			</tr>
			<s:iterator value="employees">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="enumber" /></td>
					<td>
						<s:submit type="button" value="%{id}" name="id" >編集</s:submit>
					</td>
					<td>
						<s:submit type="button" value="%{id}" name="delid" onclick="return confirm('削除してよろしいですか？')">削除</s:submit>
					</td>
				</tr>
			</s:iterator>
		</table>
	<s:submit type="button" value="newEmployee" name="newEmployee" >新規作成</s:submit>
	</s:form>
</body>
</html>