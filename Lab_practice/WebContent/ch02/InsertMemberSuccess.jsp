<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lab02_01</title>
</head>
<body>
	<h1>會員${ memberBean.name } 的資料新增成功 }</h1>
	<p>
	編號:${ memberBean.memberId }
	地址:${ memberBean.address }
	生日:${ memberBean.birthday }
	註冊時間:${ memberBean.registerDate }
	體重:${ memberBean.weight }
	</p>
</body>
</html>