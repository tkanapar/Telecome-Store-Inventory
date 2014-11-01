<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page import="java.util.*" %>
<%@ page import="com.telecom.datavo.InventoryManagerInfoVO" %>
<title>Insert title here</title>
<link href="css/kickstart-forms.css" rel="stylesheet" type="text/css" />
	<link href="css/kickstart-buttons.css" rel="stylesheet" type="text/css" />
	<link href="css/fonts/fontawesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	  
	<link rel="stylesheet" href="css/main.css" type="text/css" media="screen" />
	<link href="css/template.css" rel="stylesheet" type="text/css" />
	<link href="css/styles.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div class="cform" style="min-height:276px; border:1px solid #99ebff;">
<h1 style="padding-top:20px;">:::Inventory Managers:::</h1>
		<br /><br />
		<div style="width:800px;">
					<strong  style="float:left; width:250px; font-size: 13px;">Email ID : </strong>
					<strong  style="float:left; width:250px; font-size: 13px;">Manager Name : </strong>
					<strong  style="float:left; width:250px; font-size: 13px;">Mobile Number : </strong>
		</div>
				<br/><br/><br/><br/>
			
		
<%ArrayList<InventoryManagerInfoVO> retList = new ArrayList<InventoryManagerInfoVO>();
	
	InventoryManagerInfoVO imVO = new InventoryManagerInfoVO();
	retList = (ArrayList)session.getAttribute("IMList");
	
	for(int i=0;i<retList.size();i++)
	{
		imVO = retList.get(i);
	%>
	<form name="form" method="post" id="updateim" class="niceform" action="/Telecom_Store/AdminServlet?action=UPDATEIMUSER" >
		<div style="width:800px;">
			<div  style="width:250px; float:left;"><input name="email" id="email" type="text"  size="20" value="<%=imVO.getEmail()%>"></div>
			<div  style="width:250px; float:left;"><input name="name" id="name" type="text"  size="20" value="<%=imVO.getInventoryManagerName()%>"></div>
			<div  style="width:250px; float:left;"><input name="number" id="number" type="text"  size="20" value="<%=imVO.getContactNumber()%>"></div>
		<br><br/><br><br/>
		</div>
	<%} %>
	<input type="submit" id="update" value="Update"/>
	<input type="button" id="delete" value="Delete" onClick="deleteIMRecords()" />
	</form>
	</div>
</body>

</html>