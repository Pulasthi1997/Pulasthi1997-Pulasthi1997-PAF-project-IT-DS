<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospital_Insert</title>
</head>
<body>
	<form id="formHospital" name="formHospital" method="post" action="Hospital_Insert.jsp">
		Hospital Name: 
		<input id="H_name" name="H_name" type="text"
			class="form-control form-control-sm"> <br>
	    Contact No:
	     <input id="H_contactNumber" name="H_contactNumber" type="text"
			class="form-control form-control-sm"> <br> 
		Address: 
		<input id="H_address" name="H_address" type="text"
			class="form-control form-control-sm"> <br> 
		E-mail:
		 <input id="H_email" name="H_email" type="text"
			class="form-control form-control-sm"> <br> 
		<input id="btnSave" name="btnSave" type="button" value="Save"
			class="btn btn-primary"> 
		<input type="hidden" id="hidhospitalIDSave" name="hidhospitalIDSave" value="">
		
	</form>
	
<script type="text/javascript">	
	if (request.getParameter("H_name") != null)
{
 Hospital Hospital_1 = new Hospital();
 String stsMsg = "";
//Insert--------------------------
if (request.getParameter("hidHospitalIDSave") == "")
 {
 stsMsg = Hospital_1.insertHospital(request.getParameter("H_name"),
 request.getParameter("H_contactNumber"),
 request.getParameter("H_address"),
 request.getParameter("H_email"));
 }
else//Update----------------------
 {
 stsMsg = Hospital_1.updateHospital(request.getParameter("hidHospitalIDSave"),
 request.getParameter("H_name"),
 request.getParameter("H_contactNumber"),
 request.getParameter("H_address"),
 request.getParameter("H_email"));
 }
 session.setAttribute("statusMsg", stsMsg);
}
//Delete-----------------------------
if (request.getParameter("hidHospitalIDDelete") != null)
{
 Hospital Hospital_1 = new Hospital();
 String stsMsg =
 Hospital_1.deleteHospital(request.getParameter("hidHospitalIDDelete"));
 session.setAttribute("statusMsg", stsMsg);
}
</script>	
	
	
</body>
</html>