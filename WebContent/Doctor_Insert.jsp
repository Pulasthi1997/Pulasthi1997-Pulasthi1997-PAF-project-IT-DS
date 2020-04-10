<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form id="formDoctor" name="formDoctor" method="post" action="Doctor_Insert.jsp">
 Doctor name:
<input id="D_Name" name="D_Name" type="text"
 class="form-control form-control-sm">
<br> Doctor Type:
<input id="D_Type" name="D_Type" type="text"
 class="form-control form-control-sm">
<br> Contact Number:
<input id="D_Contact_Number" name="D_Contact_Number" type="text"
 class="form-control form-control-sm">
<br> Address:
<input id="D_Address" name="D_Address" type="text"
 class="form-control form-control-sm">
 <br> Email:
<input id="D_Email" name="D_Email" type="text"
 class="form-control form-control-sm">
 <br> NIC:
<input id="D_NIC" name="D_NIC" type="text"
class="form-control form-control-sm">
<br>
<input id="btnSave" name="btnSave" type="button" value="Save"
 class="btn btn-primary">
<input type="hidden" id="hidDoctorIDSave" name="hidDoctorIDSave" value="">
</form>


</body>
</html>