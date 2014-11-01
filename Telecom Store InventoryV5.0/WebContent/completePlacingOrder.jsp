<%@ page import="java.util.*" %>
<%@ page import="com.telecom.datavo.ProductModelVO" %>
<%@ page import="com.telecom.datavo.OrderVO" %>
    <!-- Start HTML form -->
	<form name="form" method="post" id="third" class="niceform" action="/Telecom_Store/RetailerServlet?action=PLACEORDERWITHALLDETAILS" >
		<div class="cform" style="min-height:276px; border:1px solid #99ebff;">
<h1 style="padding-top:20px;">:::Products Selected:::</h1>
		
		<div style="width:800px;">
					<strong  style="float:left; width:250px; font-size: 13px;">Product Id : </strong>			
					<strong  style="float:left; width:250px; font-size: 13px;">Product Name : </strong>
					<strong  style="float:left; width:250px; font-size: 13px;">Quantity Selected : </strong>
		</div>
				</br></br></br></br>
			
		
<%ArrayList<OrderVO> OrderList = new ArrayList<OrderVO>();
	
	OrderVO orderVO = new OrderVO();
	OrderList = (ArrayList)session.getAttribute("orderVoHalf");
	
	for(int i=0;i<OrderList.size();i++)
	{
		orderVO = OrderList.get(i);
	%>
		<div style="width:800px;">
			<div  style="width:250px; float:left;"><input name="prodId" type="text"  size="20" value="<%=orderVO.getProdModId()%>"></div>
			<div  style="width:250px; float:left;"><input  name="prodName" type="text"  size="20" value="<%=orderVO.getProdName()%>"></div>
			<div  style="width:250px; float:left;"><input  name="quantity" type="text"  size="20" value="<%=orderVO.getQuantity()%>" ></div>
			<br></br><br></br>
		</div>
	<%} %>
		<table style="margin-top:20px; ">
			<tr style="height:50px;">
				
				<td>
					<label style="margin-right:0px;"><strong style="float: left;"><span class="blue">*</span> Customer Name : </strong></label></br>
				</td>
				<td >
					<input name="name" type="text"  size="25"/>
				</td>
				<td style="padding-left:10px;">
					<label><strong style="float: left;"><span class="blue">*</span> Customer Mail : </strong></label>
				</td>
				<td>
					<input  name="email" type="text"  size="25"></input>
				</td>
			</tr>
			<tr style="height:50px;">
				<td>
					<label><strong style="float: left;"><span class="blue">*</span> Contact Number : </strong></label>
				</td>
				<td >
					<input name="phone" type="text" size="25" ></input>
				</td>
				
				<td style="padding-left:10px;">
					<label><strong style="float: left;"><span class="blue">*</span> Order Amount : </strong></label>
				</td>
				<td>
					<input name="amount" type="text"  size="25"></input>
				</td>
				
			</tr>
			<tr style="height:50px;">
				<td style="padding-left:10px;">
						<label><strong style="float: left;"><span class="blue">*</span> Address : </strong></label><br />
				</td>
				<td>
					<textarea style="line-height:20px; !important" id="addr" name="addr"  rows="50" cols="40"></textarea>
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td style="padding-left:20px; padding-top:10px;">
					<input type="submit" class="buttonSubmit" value="Place Order" ></input>
				</td>
			</tr>
			
			</table>
	       

</form>

