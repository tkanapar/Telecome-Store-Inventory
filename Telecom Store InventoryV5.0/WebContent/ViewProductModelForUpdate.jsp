<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page import="java.util.*" %>
<%@ page import="com.telecom.datavo.ProductModelVO" %>
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
    	ArrayList<ProductModelVO> prodModList = new ArrayList<ProductModelVO>();	
    ProductModelVO prodModVO = new ProductModelVO();
    prodModList = (ArrayList<ProductModelVO>) session.getAttribute("ProdModList");
    %>
    <!-- Start HTML form -->
	<form name="form" method="post" id="third" class="niceform" action="/Telecom_Store/IMServlet?action=UPDATEPRODUCTMODEL" >
		<input name="prod_mod_id" type="text"  style="display:none" size="25" value="<%=prodModList.get(0).getProductModelId() %>"/>
		<table style="margin-top:20px; ">
			<tr style="height:50px;">
				
				<td>
					<label style="margin-right:0px;"><strong style="float: left;"><span class="blue">*</span> Name : </strong></label></br>
				</td>
				<td >
					<input name="name" type="text"  size="25" value="<%=prodModList.get(0).getProductModelName() %>" minlength="2" required/>
				</td>
				<td style="padding-left:10px;">
					<label><strong style="float: left;"><span class="blue">*</span> Description : </strong></label>
				</td>
				<td >
					<input name="desc" type="text"  size="25" value="<%=prodModList.get(0).getProductModelDesc() %>" minlength="2" required/>
				</td>
			</tr>
			<tr style="height:50px;">
				<td>
					<label><strong style="float: left;"><span class="blue">*</span> Feature : </strong></label>
				</td>
				<td >
					<input name="feature" type="text"  size="25" value="<%=prodModList.get(0).getProductModelFeature() %>" minlength="2" required/>
				</td>
				
				<td style="padding-left:10px;">
					<label><strong style="float: left;"><span class="blue">*</span> Price : </strong></label>
				</td>
				<td >
					<input name="price" type="text"  size="25" value="<%=prodModList.get(0).getProductModelPrice() %>" minlength="2" required/>
				</td>
				
			</tr>
			<tr style="height:50px;">
				<td>
					<label><strong style="float: left;"><span class="blue">*</span> Threshold : </strong></label>
				</td>
				<td >
					<input name="threshold" type="text"  size="25" value="<%=prodModList.get(0).getProductModelThreshold() %>" minlength="2" required/>
				</td>
				<td style="padding-left:10px;">
						<label><strong style="float: left;"><span class="blue">*</span> New Products to Add(#) : </strong></label><br />
				</td>
				<td >
					<input name="quantity" type="text"  size="25" minlength="2" required></input>
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td style="padding-left:20px; padding-top:10px;">
					<input type="submit" class="buttonSubmit" value="Update" ></input>
				</td>
			</tr>
			
			</table>
	       

</form>

