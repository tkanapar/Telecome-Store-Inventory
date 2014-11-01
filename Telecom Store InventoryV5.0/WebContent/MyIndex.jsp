<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Telecom Store</title>
<link href="css/template.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/styles.css" />

<link rel="stylesheet" href="themes/default/default.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="themes/light/light.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="themes/dark/dark.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="themes/bar/bar.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="nivo-slider.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="demo/style.css" type="text/css"
	media="screen" />


	<link href="css/menu.css" rel="stylesheet" type="text/css" />
	<link href="css/topmenu.css" rel="stylesheet" type="text/css" />

	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
  
	<link href="css/kickstart-forms.css" rel="stylesheet" type="text/css" />
	<link href="css/kickstart-buttons.css" rel="stylesheet" type="text/css" />
	<link href="css/fonts/fontawesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	
	
<style type="text/css">
.main {
	background-color: #dbdbdb;
	min-height:300px;
	width:100%;

}

.preContainer {
	min-height: 2px;
}


.mylogo
{
	background: url('images/3logo.png') ;
	width:250px;
	height:90px;
	float:left;
	margin-left:30px;
	
	    -moz-box-shadow: 0 0 2px rgba(255,255,255,.5);
    -webkit-box-shadow: 0 0 2px rgba(255,255,255,.5);
    box-shadow: 0 0 2px rgba(255,255,255,.5);
    box-shadow: -10px 10px 20px #03344c;	
    -moz-border-radius: 5px;
    border-radius: 5px;
    border-top-left-radius:0px;
    border-top-right-radius:0px;
}

</style>
</head>
<script>
window.history.forward();
</script>
<body onload="check()">
<script type="text/javascript">
function load()
{
if(session.getAttribute(true))
{
	session.invalidate();
	response.sendRedirect("MyIndex.jsp");
}
}
</script>
	<center>
		<div class="main"><!--<%
				String url = (String)request.getSession().getAttribute("lastRequestURL");
				if(url != null){
					%>
					<script>
						var url = "<%=url%>";
						window.location.replace(url);
						window.history.forward();
						//document.location.reload(true);
					</script>
					<%
				}
				%>-->
			<div class="header"><%@ include file="loginHeader.jsp"%>
				<%@ include file="loginHeader2.jsp"%></div>
			<div class="carousel">
				<%@ include file="nSlider.jsp"%>
			</div>
		
			<div class="preContainer"></div>
				<div class="myfooter"><%@ include file="footer.jsp"%>
			</div>
		</div>
	</center>
</body>
</html>