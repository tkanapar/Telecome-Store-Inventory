<%@ page import="java.util.*" %>
<%@ page import="com.telecom.datavo.OrderVO" %>
    <!-- Start HTML form -->
<div class="cform" style="min-height:176px; border:1px solid #99ebff;">
			<h1 style="padding-top:20px;">::: Order Details :::</h1>
			
	<%ArrayList<OrderVO> OrderList = new ArrayList<OrderVO>();
	OrderVO orderVO = new OrderVO();
	OrderList = (ArrayList)session.getAttribute("orderVOCustDetails");
	%>
	<table style="margin-top:20px; ">
			<tr style="height:50px;">
				<td>
					<label style="margin-right:0px;"><strong style="float: left;"><span class="blue">*</span> Customer Name : </strong></label></br>
				</td>
				<td >
					<input name="name" type="text"  size="25" value="<%=OrderList.get(0).getCustName()%>"></input>
				</td>
				<td style="padding-left:10px;">
					<label><strong style="float: left;"><span class="blue">*</span> Customer Mail : </strong></label>
				</td>
				<td>
					<input  name="email" type="text"  size="25" value="<%=OrderList.get(0).getCustMailId()%>"></input>
				</td>
				<td>
					<label><strong style="float: left;"><span class="blue">*</span> Contact Number : </strong></label>
				</td>
				<td >
					<input name="phone" type="text" size="25" value="<%=OrderList.get(0).getPhoneNumb()%>" ></input>
				</td>
			</tr>
		</table>	
		</div>
		<div class="cform" style="min-height:276px; border:1px solid #99ebff;">
			<h1 style="padding-top:20px;">::: Select Product to Raise Defect :::</h1>
			<div style="width:1000px;">
					<strong  style="float:left; width:160px; font-size: 13px;">Product Id : </strong>			
					<strong  style="float:left; width:160px; font-size: 13px;">Product Mod Id : </strong>			
					<strong  style="float:left; width:160px; font-size: 13px;">Product Name : </strong>
					<strong  style="float:left; width:160px; font-size: 13px;">Amount : </strong>
					<strong  style="float:left; width:160px; font-size: 13px;">Product Status : </strong>
			</div>
				</br></br></br></br>
<%	for(int i=0;i<OrderList.size();i++)
	{
		orderVO = new OrderVO();
		orderVO = (OrderVO)OrderList.get(i);
	%>
		<div style="width:1000px;">
			<div  style="width:20px; float:left;"><input name="cbox" id="<%=orderVO.getProdCode()%>" 
						class="cbox" value=<%=orderVO.getProdCode()%> type="checkbox" /></div>
			<div  style="width:160px; float:left;"><input name="prodId" type="text"  size="20" value="<%=orderVO.getProdCode()%>" ></div>
			<div  style="width:160px; float:left;"><input name="prodId" type="text"  size="20" value="<%=orderVO.getProdModId()%>" ></div>
			<div  style="width:160px; float:left;"><input  name="prodName" type="text"  size="20" value="<%=orderVO.getProdName()%>" ></div>
			<div  style="width:160px; float:left;"><input  name="amnt" type="text"  size="20" value="<%=orderVO.getOrderAmnt()%>" ></div>
			<div  style="width:160px; float:left;"><input  name="status" type="text"  size="20" value="<%=orderVO.getProdStatus()%>" ></div>
			<br></br><br></br>
		</div>
	<%} %>
	<input type="button" id="delete" value="Raise Defect" onClick="OrderSelectedDefectProductModels()" />
	</div>