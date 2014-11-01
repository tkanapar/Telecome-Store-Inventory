<script type="text/javascript" src="ViewretailersAjax.js">
</script>

<ul class="modmenu" style="width:65%;float:left">

		<li>
			<a style="border-top-left-radius: 8px;" onclick="sendRequest('GET','createRetailer.jsp')" href="#">
				<i style="float: left;" class=" icon-home icon-3x"></i>&nbsp;Home
			</a>
		</li>
	<%
		String name_ddm = (String) session.getAttribute("name");
		if(name_ddm.equalsIgnoreCase("InventoryManager")){
	%>
		<li>
		<a href="#">Manage Product Models</a>
			<ul>
				<li><%@include file="CreateProductModelmodal.jsp" %></li>
				<li><a href="#" onclick="sendRequest2('GET','/Telecom_Store/IMServlet?action=VIEWPRODUCTMODELS')">
						 				View &amp; Multiple Delete</a></li>
				<li><%@include file="SearchProductModelToDeletemodal.jsp" %></li>
				<li><%@include file="updateProductModelModal.jsp" %></li>
			</ul>
		</li>
		<li>
		<!--<a href="#">Manage Rewards</a>
			<ul>
				<li><a href="#">Create Rewards</a></li>
				<li><a href="#">Allocate Rewatds</a></li>
				<li><a href="#">View &amp; Multiple Delete</a></li>
				<li><a href="#">Search to Update</a></li>
			</ul>
		</li>
		<li>
		<a href="#">Threshold</a>
			<ul>
				<li><a href="#" onclick="sendRequest2('GET','asd.jsp')"></a></li>
			</ul>
		</li>-->
	<%
		}else if(name_ddm.equalsIgnoreCase("Admin")){
	%>
		<li>
		<a href="#">Map Products</a>
			<ul>
				<li><a href="#" onclick="sendRequest2('GET','/Telecom_Store/AdminServlet?action=VIEWPRODUCTMODELSBYADMIN')">
						 				Available Product Models</a></li>
				<li><%@include file="SearchRetailerToMap.jsp" %></li>
				<li><%@include file="SearchRetailerToDeleteMap.jsp" %></li>
			</ul>
		</li>
		<li>
				<a href="#">Manage Retailer</a>
					<ul>
						<li><%@include file="CreateRetailermodal.jsp" %></li>
						 <li><a href="#" onclick="sendRequest2('GET','/Telecom_Store/AdminServlet?action=VIEWRETAILER')">
						 				View &amp; Multiple Delete</a></li>
						<li><%@include file="SearchRetailerToDeletemodal.jsp" %></li>
						<li><%@include file="updateRetailerModal.jsp" %></li>
					</ul>
		</li>
		<li><a href="#" >Inventory Manager</a>
					<ul>
						<li><%@include file="CreateInventoryManagerModel.jsp" %></li>
						 <li><a href="#" onclick="sendRequest2('GET','/Telecom_Store/AdminServlet?action=VIEWIM')">
						 				View / Update / Delete</a></li>
					</ul>
		</li>
	<%
		}else if(name_ddm.equalsIgnoreCase("Retailer")){
			%>
			<li>
			<a href="#">Order Management</a>
				<ul>
					<li><a href="#" onclick="sendRequest2('GET','/Telecom_Store/RetailerServlet?action=GETPRODUCTS')">
						 				Place Order</a></li>
					<li><%@include file="SearchOrderToUpdate.jsp" %></li>
					<li><%@include file="SearchOrderToUpdateCust.jsp" %></li>
				</ul>
			</li>
			<li>
					<a href="#">Defect Tracking</a>
						<ul>
							<li><%@include file="SearchOrderRaiseDefect.jsp" %></li>
						</ul>
			</li>
			<li>
					<a href="#">Reviews And Ratings</a>
						<ul>
							<li><%@include file="SearchProductToGetReviewsModal.jsp" %></li>
						</ul>
			</li>
			
		<%
			}
		%>
	
</ul>
