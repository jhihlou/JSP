<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8" %>
<!doctype html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Lab02_01 加入會員</title>
 </head>

 <body onload="javascript:document.insertMemberFormA.mId.focus();">
	<center>
	<form name="insertMemberFormA" action="ProcessMemberServlet" method="post">
		<table>
		<thead>
			<tr bgcolor='tan'>
			<th height="60" colspan="2" align="center">新增會員資料</th>
			</tr>
		</thead>
		<tbody>
			<tr bgcolor="tan">
				<td width="120" height="40">帳號:</td>
				<td width="600" height="40"><input id='num' style='text-align:left' name='mId' type="text" size="14"></td>
			</tr>
			<tr bgcolor="tan">
				<td width="120" height="40">密碼:</td>
				<td width="600" height="40"><input id='num' style='text-align:left' name='pswd' type="password" size="14"></td>
			</tr>
			<tr bgcolor="tan">
				<td width="120" height="40">姓名:</td>
				<td width="600" height="40" align="left">
					<input name="mName" type="text" size="20">
				</td>
			</tr>
			<tr bgcolor="tan">
				<td width="120" height="40">住址:</td>
				<td width="600" height="40" align="left">
					<input name="mAddress" type="text" size="54">
				</td>
			</tr>
			<tr bgcolor="tan">
				<td width="120" height="40">手機:</td>
				<td width="600" height="40" align="left">
					<input name="mPhone" type="text" size="20">
				</td>
			</tr>
			<tr bgcolor="tan">
				<td width="120" height="40">生日:</td>
				<td width="600" height="40" align="left">
					<input name="mBirthday" type="text" size="14">
					<font color='blue' size="-1">&nbsp;&nbsp;格式為yyyy-MM-dd</font>
				</td>
			</tr>
			<tr bgcolor="tan">
				<td height="50" colspan="2" align="center">
					<input type="submit" value="送出">
				</td>
			</tr>
		</tbody>
		</table>
	</form>
	</center>
 </body>
</html>