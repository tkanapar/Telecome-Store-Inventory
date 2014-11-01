<html>
<head>
<title>JS Charts</title>
<script type="text/javascript" src="2jscharts.js"></script>

<%@ page import="java.util.*" %>
<%@ page import="com.telecom.datavo.TheresholdProductsGraphVO" %>
 <%
   
   
ArrayList<TheresholdProductsGraphVO> graphVO = new ArrayList<TheresholdProductsGraphVO>();	
graphVO = (ArrayList<TheresholdProductsGraphVO>) session.getAttribute("prodModCountList");
int size = graphVO.size();
%>
</head>
<body>
<p class='resultStyle1'>Welcome to Telecom Store Inventory</p>
<input type="text" style="display:none" id="displayStr"/>
<div id="chart_container" style="position: fixed;
   left:400px;
   top:200px;"><%if(size>0){ %>Loading chart...<%} %></div>
  <%
if(graphVO == null ){
	out.println("yes..");
}
String displayStr = "";
String colorStr = "";
if(size>0){
for(int i=0;i<size-1;i++){
	displayStr = displayStr +"['"+graphVO.get(i).getProdModId()+"',"+graphVO.get(i).getProdQuantity()+"],";
	colorStr = colorStr + "'"+graphVO.get(i).getColor()+"',";
}


	displayStr = displayStr +"['"+graphVO.get(size-1).getProdModId()+"',"+
	                           graphVO.get(size-1).getProdQuantity()+"]";
	colorStr = colorStr +"'"+graphVO.get(size-1).getColor()+"'";
	
	displayStr = "["+displayStr+"]";
	colorStr = "["+colorStr+"]";
}
	
%>

<script type="text/javascript">



var myChart = new JSChart('chart_container', 'bar', '');
var ele = document.getElementById("displayStr");
ele.value = <%=displayStr%>;
myChart.setDataArray(<%=displayStr%>);
myChart.colorize(<%=colorStr%>);
myChart.setSize(500, 400);
myChart.setIntervalEndY(30);
myChart.setTitle('Products Threshold');
myChart.setTitleFontSize(10);
myChart.setBarSpacingRatio(50);
myChart.setBarOpacity(1);
myChart.setAxisWidth(1);
myChart.setAxisNameX('PRODUCT MODEL');
myChart.setAxisNameY('NUMBER OF PRODUCTS');
myChart.set3D(true);
myChart.setBarValues(false);
myChart.draw();

</script>

</body>
</html>