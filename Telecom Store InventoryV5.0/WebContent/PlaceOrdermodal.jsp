<%
		String name_createRetailer = (String) session.getAttribute("name");
		if(name_createRetailer.equalsIgnoreCase("Retailer")){
	%>
  <a data-toggle="modal" href="#myModal">Place Order</a>

  <!-- Modal -->
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="visibility:visible;" data-backdrop="static">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title">Place Order</h4>
        </div>
        <div class="modal-body" data-backdrop="static">
         <%@include file="PlaceOrder.jsp" %>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div><!-- /.modal -->
<%
		}
%>