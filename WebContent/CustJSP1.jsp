<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
First Name: ${session_FirstName}
Last Name: ${session_LastName}
Address: ${session_StreetAddress}
City: ${session_City}
State: ${session_State}
ZipCode: ${session_ZipCode}
EmailAddress: ${session_EmailAddress}
Position: ${session_Position}
AddressID: ${session_customers.AddressID}



</body>
</html>