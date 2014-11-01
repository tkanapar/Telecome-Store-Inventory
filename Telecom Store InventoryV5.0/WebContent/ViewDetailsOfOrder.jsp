<%@ page import="java.util.*" %>
<%@ page import="com.telecom.datavo.ProductModelVO" %>
<%@ page import="com.telecom.datavo.OrderVO" %>
    <!-- Start HTML form -->
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
    
	<form name="form" method="post" id="third" class="niceform" action="/Telecom_Store/RetailerServlet?action=UPDATEORDERCUSTDETAILS" >
		<div class="cform" style="min-height:276px; border:1px solid #99ebff;">
			
	<%ArrayList<OrderVO> OrderList = new ArrayList<OrderVO>();
	OrderVO orderVO = new OrderVO();
	OrderList = (ArrayList)session.getAttribute("orderVODetails");
	%>
		
<h1 style="padding-top:20px;">::: Order Details :::</h1>

			<div style="width:1310px;">
					<strong  style="float:left; width:180px; font-size: 13px;">Product Id : </strong>			
					<strong  style="float:left; width:180px; font-size: 13px;">Product Mod Id : </strong>			
					<strong  style="float:left; width:180px; font-size: 13px;">Product Name : </strong>
					<strong  style="float:left; width:180px; font-size: 13px;">Amount : </strong>
					<strong  style="float:left; width:180px; font-size: 13px;">Product Status : </strong>
		</div>
				</br></br></br></br>
<%	for(int i=0;i<OrderList.size();i++)
	{
		orderVO = (OrderVO)OrderList.get(i);
	%>
		<div style="width:1310px;">
			<div  style="width:180px; float:left;"><input name="prodId" type="text"  size="20" value="<%=orderVO.getProdCode()%>"></div>
			<div  style="width:180px; float:left;"><input name="prodId" type="text"  size="20" value="<%=orderVO.getProdModId()%>"></div>
			<div  style="width:180px; float:left;"><input  name="prodName" type="text"  size="20" value="<%=orderVO.getProdName()%>"></div>
			<div  style="width:180px; float:left;"><input  name="amnt" type="text"  size="20" value="<%=orderVO.getOrderAmnt()%>" ></div>
			<div  style="width:180px; float:left;"><input  name="status" type="text"  size="20" value="<%=orderVO.getProdStatus()%>" ></div>
			<br></br><br></br>
		</div>
	<%} %>
		<table style="margin-top:20px; ">
			<tr style="height:50px;">
				
				<td>
					<label style="margin-right:0px;"><strong style="float: left;"><span class="blue">*</span> Customer Name : </strong></label></br>
				</td>
				<td >
					<input name="name" type="text"  size="25" value="<%=orderVO.getCustName()%>" minlength="2" required></input>
				</td>
				<td style="padding-left:10px;">
					<label><strong style="float: left;"><span class="blue">*</span> Customer Mail : </strong></label>
				</td>
				<td>
					<input  name="email" type="email"  size="25" value="<%=orderVO.getCustMailId()%>" minlength="2" required></input>
				</td>
			</tr>
			<tr style="height:50px;">
				<td>
					<label><strong style="float: left;"><span class="blue">*</span> Contact Number : </strong></label>
				</td>
				<td >
					<input name="phone" type="text" size="25" value="<%=orderVO.getPhoneNumb()%>" minlength="2" required></input>
				</td>
				
			</tr>
			<tr style="height:50px;">
				<td style="padding-left:10px;">
						<label><strong style="float: left;"><span class="blue">*</span> Address : </strong></label><br />
				</td>
				<td>
					<textarea style="line-height:20px; !important" id="addr" name="addr"  rows="50" cols="40" minlength="2" required><%=orderVO.getShippmentAddr() %>
					</textarea>
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td style="padding-left:20px; padding-top:10px;">
					<input type="submit" class="buttonSubmit" value="Update Order" ></input>
				</td>
			</tr>
			
			</table>
	       

</form>

