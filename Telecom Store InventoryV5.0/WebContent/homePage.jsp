<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Telecom Store</title>

 	<script src="js/jquery.min.js"></script>
    <script src="javascript/ajax.js"></script>
    
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
  
	<link href="css/kickstart-forms.css" rel="stylesheet" type="text/css" />
	<link href="css/kickstart-buttons.css" rel="stylesheet" type="text/css" />
	<link href="css/fonts/fontawesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	  
	<link rel="stylesheet" href="css/main.css" type="text/css" media="screen" />
	<link href="css/template.css" rel="stylesheet" type="text/css" />
	<link href="css/styles.css" rel="stylesheet" type="text/css" />


<!-- menus -->
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/topmenu.css" rel="stylesheet" type="text/css" />
<style type="text/css">

.fad
{
	border-top-left-radius: 8px;
}
body
{
    width:100%;
    margin:auto;
}
.main
{
background-color:#dbdbdb;
	width:100%;
	
}
.homeContainer
{
	width:90%;
	margin:auto;
}
.mylogo
{
	background: url('images/1logo.png') ;
	width:110px;
	height:70px;
	float:left;
	margin-left:110px;
	
	    -moz-box-shadow: 0 0 2px rgba(255,255,255,.5);
    -webkit-box-shadow: 0 0 2px rgba(255,255,255,.5);
    box-shadow: 0 0 2px rgba(255,255,255,.5);
    box-shadow: -10px 10px 20px #03344c;	
    -moz-border-radius: 5px;
    border-radius: 5px;
    border-top-left-radius:0px;
    border-top-right-radius:0px;
}
.icon-search
{
	color:white;
}

.resultStyle{
float: left;
    position: absolute;
    left: 40%;
    font-size: 20px;
    color: black;
    top:34%;
    }
.resultStyle1{
  	float: center;
    left: 20%;
    font-size: 20px;
    color: black;
    top:34%;
    }   
    
</style>
</head>

<body >
<center>
<div class="main"  >
	<%
	
		if(session.getAttribute("SessionCreated") == null){
			response.sendRedirect("validateLogin");
		}else{
			
	%>
	
	<div class="header">
		<%@ include file="homePageHeader.jsp" %>
		<%@ include file="homePageHeader2.jsp" %>
	</div>
	<div class="homeContainer" style="min-height:570px;">
		<div id="ajaxload" >
		<% 
			String name_searchRetailer2 = (String) session.getAttribute("name");
			String result = request.getParameter("result");
			String operation = request.getParameter("OPERATION");
			if((result == "" || result == null) &&
					(operation == "" || operation == null)){
				if(name_searchRetailer2.equalsIgnoreCase("InventoryManager"))
				{%>
				<div><%@ include file="asd.jsp" %></div><%
				}
				else{
					out.println("<p class='resultStyle'>Welcome to Telecom Store Inventory</p>");
				}
				
			}else if(operation.equalsIgnoreCase("VIEWREVIEW")){
				%>
				<div align="left"><%@ include file="ReviewPage.jsp" %></div><%
			}else if(result.equalsIgnoreCase("success") && operation.equalsIgnoreCase("CREATERETAILER")){
				out.println("<p class=\"resultStyle\">Retailer Created Successfully</p>");
			}else if(result.equalsIgnoreCase("success") && operation.equalsIgnoreCase("UPDATERETAILER")){
				out.println("<p class=\"resultStyle\">Retailer details updated succssfully</p>");
			}else if(result.equalsIgnoreCase("failure") && operation.equalsIgnoreCase("CREATERETAILER")){
				out.println("<p class=\"resultStyle\">Retailer is not Created</p>");
			}else if(result.equalsIgnoreCase("failure") && operation.equalsIgnoreCase("UPDATERETAILER")){
				out.println("<p class=\"resultStyle\">Retailer details are not updated</p>");
			}else if(result.equalsIgnoreCase("failure") && operation.equalsIgnoreCase("CREATEIM")){
				out.println("<p class=\"resultStyle\">Inventory Manager not Created</p>");
			}else if(result.equalsIgnoreCase("Success") && operation.equalsIgnoreCase("CREATEIM")){
				out.println("<p class=\"resultStyle\">Inventory Manager Created Successfully</p>");
			}else if(result.equalsIgnoreCase("failure") && operation.equalsIgnoreCase("UPDATEIMUSER")){
				out.println("<p class=\"resultStyle\">Inventory Manager not Updated</p>");
			}else if(result.equalsIgnoreCase("Success") && operation.equalsIgnoreCase("UPDATEIMUSER")){
				out.println("<p class=\"resultStyle\">Inventory Manager Updated Successfully</p>");
			}else if(result.equalsIgnoreCase("failure") && operation.equalsIgnoreCase("CREATEPRODUCTMODEL")){
				out.println("<p class=\"resultStyle\">Product Model not Created</p>");
			}else if(result.equalsIgnoreCase("Success") && operation.equalsIgnoreCase("CREATEPRODUCTMODEL")){
				out.println("<p class=\"resultStyle\">Product Model created Successfully</p>");
			}else if(result.equalsIgnoreCase("failure") && operation.equalsIgnoreCase("UPDATEPRODUCTMODEL")){
				out.println("<p class=\"resultStyle\">Product Model not Updated</p>");
			}else if(result.equalsIgnoreCase("Success") && operation.equalsIgnoreCase("UPDATEPRODUCTMODEL")){
				out.println("<p class=\"resultStyle\">Product Model Updated Successfully</p>");
			}else if(result.equalsIgnoreCase("failure") && operation.equalsIgnoreCase("PLACEORDERWITHALLDETAILS")){
				out.println("<p class=\"resultStyle\">Order not Placed</p>");
			}else if(result.equalsIgnoreCase("Success") && operation.equalsIgnoreCase("PLACEORDERWITHALLDETAILS")){
				String orderId = request.getParameter("orderId");
				out.println("<p class=\"resultStyle\">Order Placed successfully. Please find the order ID : "+orderId+"</p>");
			}else if(result.equalsIgnoreCase("failure") && operation.equalsIgnoreCase("SEARCHTOUPDATESTATUS")){
				out.println("<p class=\"resultStyle\">Status Not Updated</p>");
			}else if(result.equalsIgnoreCase("Success") && operation.equalsIgnoreCase("SEARCHTOUPDATESTATUS")){
				out.println("<p class=\"resultStyle\">Status Updated Successfully</p>");
			}else if(result.equalsIgnoreCase("failure") && operation.equalsIgnoreCase("UPDATEORDERCUSTDETAILS")){
				out.println("<p class=\"resultStyle\">Customer Details Not Updated</p>");
			}else if(result.equalsIgnoreCase("Success") && operation.equalsIgnoreCase("UPDATEORDERCUSTDETAILS")){
				out.println("<p class=\"resultStyle\">Customer detailes Updated Successfully</p>");
			}else if(result.equalsIgnoreCase("failure") && operation.equalsIgnoreCase("PRODUCTSRAISEDASDEFECT")){
				out.println("<p class=\"resultStyle\">Failed to raise Defect</p>");
			}else if(result.equalsIgnoreCase("Success") && operation.equalsIgnoreCase("PRODUCTSRAISEDASDEFECT")){
				out.println("<p class=\"resultStyle\">Defect Raised Successfully</p>");
			}
		%>
		</div>
	<br/>
	<br/>
	</div>
	<%
		}
	%>
	<div >
	<%@ include file="footer.jsp" %>
	</div>

</div>
</center>
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>

</body>
</html>