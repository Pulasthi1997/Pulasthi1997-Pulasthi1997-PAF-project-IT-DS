<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.DoctorService" %>
	<%@ page import="model.Doctor" %>
	<% 
		//Save---------------------------------
		if (request.getParameter("D_Name") != null) {
			Doctor
			d1 = new Doctor();
			String
			stsMsg = "";
			//Insert--------------------------
			if (request.getParameter("hidDoctorIDSave") == "") {
				stsMsg = d1.insertDoctors(request.getParameter("D_Name"),
						request.getParameter("D_Type"), request
								.getParameter("D_Contact_Number"), request
								.getParameter("D_Address"), request
								.getParameter("D_Email"), request
								.getParameter("D_NIC"));
			} else//Update----------------------
			{
				stsMsg = d1
						.updateDoctors(request.getParameter("hidDoctorIDSave"),
								request.getParameter("D_Name"),
								request.getParameter("D_Type"), 
								request.getParameter("D_Contact_Number"),
								request.getParameter("D_Address"), 
								request.getParameter("D_Email"), 
								request.getParameter("D_NIC"));
			}
			session.setAttribute("statusMsg", stsMsg);
		}
		//Delete-----------------------------
		if (request.getParameter("hidDoctorIDDelete") != null) {
			Doctor
			d1 = new Doctor();
			String
			stsMsg = d1.deleteDoctor(request.getParameter("hidDoctorIDDelete"));
			session.setAttribute("statusMsg", stsMsg);
		}
	%>
	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form id="formDoctor" name="formDoctor" method="post"
		action="Doctor_Insert.jsp">
		Doctor name: <input id="D_Name" name="D_Name" type="text"
			class="form-control form-control-sm"> <br> Doctor Type:
		<input id="D_Type" name="D_Type" type="text"
			class="form-control form-control-sm"> <br> Contact
		Number: <input id="D_Contact_Number" name="D_Contact_Number"
			type="text" class="form-control form-control-sm"> <br>
		Address: <input id="D_Address" name="D_Address" type="text"
			class="form-control form-control-sm"> <br> Email: <input
			id="D_Email" name="D_Email" type="text"
			class="form-control form-control-sm"> <br> NIC: <input
			id="D_NIC" name="D_NIC" type="text"
			class="form-control form-control-sm"> <br> <input
			id="btnSave" name="btnSave" type="button" value="Save"
			class="btn btn-primary"> <input type="hidden"
			id="hidDoctorIDSave" name="hidDoctorIDSave" value="">
	</form>

	<% 
	     Doctor d1=new Doctor();
	     out.print(d1.readDoctors());
	     %>

</body>
</html>