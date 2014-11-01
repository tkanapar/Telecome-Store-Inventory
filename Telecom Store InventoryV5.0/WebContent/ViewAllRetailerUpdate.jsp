<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page import="java.util.*" %>
<%@ page import="com.telecom.datavo.RetailerInfoVO" %>

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="/jquery/jquery.js"></script>
<script src="/jquery/jquery.validate.js"></script>
<script>
$.validator.setDefaults({
	submitHandler: function() { alert("submitted!"); }
});

$().ready(function() {
	// validate the comment form when it is submitted
	$("#third").validate();
});
</script>

</head>
<body>

    <!-- Start HTML form -->
    <%
    	ArrayList<RetailerInfoVO> retList = new ArrayList<RetailerInfoVO>();	
    	RetailerInfoVO retVO = new RetailerInfoVO();
    	retList = (ArrayList<RetailerInfoVO>) session.getAttribute("RetList");
    %>
	<form name="form" method="post" id="third" class="niceform" action="/Telecom_Store/AdminServlet?action=UPDATERETAILER" >
		<input name="retailer_id" type="text"  style="display:none" size="25" value="<%=retList.get(0).getRetailerNumber() %>"/>
		<table style="margin-top:20px; ">
			<tr style="height:50px;">
				<td>
					<label style="margin-right:0px;"><strong style="float: left;">
					<span class="blue">*</span> Retailer Name : </strong></label>
				</td>
				<td >
					<input name="name" type="text"  size="25" value="<%=retList.get(0).getRetailerName() %>" minlength="2" required/>
				</td>
				<td style="padding-left:10px;">
					<label><strong style="float: left;"><span class="blue">*</span> Email ID : </strong></label>
				</td>
				<td>
					<input  name="email" type="email"  size="25" value="<%=retList.get(0).getEmail() %>" minlength="2" required/>
				</td>
			</tr>
			<tr style="height:50px;">
				<td>
					<label><strong style="float: left;"><span class="blue">*</span> Contact Number : </strong></label>
				</td>
				<td >
					<input name="phone" type="text" size="25"  value="<%=retList.get(0).getContactNumber() %>" minlength="2" required />
				</td>
				
				<td style="padding-left:10px;">
					<label><strong style="float: left;"><span class="blue">*</span> Licence Number : </strong></label>
				</td>
				<td>
					<input name="licence" type="text"  size="25" value="<%=retList.get(0).getLicenseNumber() %>" minlength="2" required/>
				</td>
				
			</tr>
			<tr style="height:50px;">
				<td>
					<label><strong style="float: left;"><span class="blue">*</span> Store Location : </strong></label>
				</td>
				<td >
					<input name="loc" type="text" size="25" value="<%=retList.get(0).getStoreLocation() %>" minlength="2" required/>
				</td>
				<td style="padding-left:10px;">
						<label><strong style="float: left;"><span class="blue">*</span> Address : </strong></label><br />
				</td>
				<td>
					<textarea style="line-height:20px; !important" id="addr" name="addr" rows="50" cols="40" minlength="2" required >
					<%=retList.get(0).getAddress() %>
					</textarea>
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td style="padding-left:20px; padding-top:10px;">
					<input type="submit" class="buttonSubmit" value="Update" />
				</td>
			</tr>
			
			</table>
	       

</form>

</body></html>