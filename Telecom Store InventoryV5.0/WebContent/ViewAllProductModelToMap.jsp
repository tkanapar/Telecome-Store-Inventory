<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page import="java.util.*" %>
<%@ page import="com.telecom.datavo.ProductModelVO" %>
<%@ page import="com.telecom.datavo.RetailerInfoVO" %>

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
<h1 style="padding-top:20px;">:::Retailer Information:::</h1>
		
		<div style="width:800px;">
					<strong  style="float:left; width:250px; font-size: 13px;">Retailer Name : </strong>			
					<strong  style="float:left; width:250px; font-size: 13px;">Email ID : </strong>
					<strong  style="float:left; width:250px; font-size: 13px;">Retailer ID : </strong>
		</div>
				</br></br></br></br>
			
		
<%ArrayList<RetailerInfoVO> retList = new ArrayList<RetailerInfoVO>();
	
	RetailerInfoVO retVO = new RetailerInfoVO();
	retList = (ArrayList)session.getAttribute("RetList");
	
	for(int i=0;i<retList.size();i++)
	{
		retVO = retList.get(i);
	%>
		<div style="width:800px;">
			<div  style="width:250px; float:left;"><input name="name" type="text"  size="20" value="<%=retVO.getRetailerName()%>"></div>
			<div  style="width:250px; float:left;"><input  name="email" type="text"  size="20" value="<%=retVO.getEmail()%>"></div>
			<div  style="width:250px; float:left;"><input id="name" name="name" type="text"  size="20" value="<%=retVO.getRetailerNumber()%>" ></div>
			<br></br><br></br>
		</div>
	<%} %>
<div class="cform" style="min-height:276px; border:1px solid #99ebff;">
<h1 style="padding-top:20px;">:::Product Models:::</h1>
		
		<div style="width:1310px;">
					<strong  style="float:left; width:160px; font-size: 13px;"> ID : </strong>			
					<strong  style="float:left; width:160px; font-size: 13px;"> Name : </strong>
					<strong  style="float:left; width:160px; font-size: 13px;"> Description: </strong>
					<strong  style="float:left; width:160px; font-size: 13px;"> Feature: </strong>
					<strong  style="float:left; width:160px; font-size: 13px;"> Price: </strong>
					<strong  style="float:left; width:160px; font-size: 13px;"> Threshold: </strong>
					<strong  style="float:left; width:160px; font-size: 13px;"> Quantity: </strong>
		</div>
				</br></br></br></br>
			
		
<%ArrayList<ProductModelVO> prodModList = new ArrayList<ProductModelVO>();
	
ProductModelVO prodModVO = new ProductModelVO();
prodModList = (ArrayList)session.getAttribute("prodModList");
	
	for(int i=0;i<prodModList.size();i++)
	{
		prodModVO = prodModList.get(i);
	%>
		<div style="width:1310px;">
			<div  style="width:20px; float:left;"><input name="cbox" id="<%=prodModVO.getProductModelId()%>" 
						class="cbox" value=<%=prodModVO.getProductModelId()%> type="checkbox" /></div>
			<div  style="width:160px; float:left;"><input name="id" type="text"  size="20" value="<%=prodModVO.getProductModelId()%>" readonly></div>
			<div  style="width:160px; float:left;"><input  name="name" type="text"  size="20" value="<%=prodModVO.getProductModelName()%>" readonly></div>
			<div  style="width:160px; float:left;"><input name="desc" type="text"  size="20" value="<%=prodModVO.getProductModelDesc()%>" readonly></div>
			<div  style="width:160px; float:left;"><input name="feature" type="text"  size="20" value="<%=prodModVO.getProductModelFeature()%>" readonly></div>
			<div  style="width:160px; float:left;"><input name="price" type="text"  size="20" value="<%=prodModVO.getProductModelPrice()%>" readonly></div>
			<div  style="width:160px; float:left;"><input name="threshold" type="text"  size="20" value="<%=prodModVO.getProductModelThreshold()%>" readonly></div>
			<div  style="width:160px; float:left;"><input name="quantity" type="text"  size="20" value="<%=prodModVO.getProductModelQuantity()%>" readonly></div>
			<br></br><br></br>
		</div>
	<%} %>
	<input type="button" id="toggle" value="Select All" onClick="dothis()" />
	<input type="button" id="delete" value="Map Products" onClick="mapProductModels()" />
	</div>
</body>

</html>