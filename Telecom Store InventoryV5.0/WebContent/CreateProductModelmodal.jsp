 <%
		String name_createRetailer = (String) session.getAttribute("name");
		if(name_createRetailer.equalsIgnoreCase("InventoryManager")){
	%>
  <a data-toggle="modal" href="#myModal15">Create Product Model</a>

  <!-- Modal -->
  <div class="modal fade" id="myModal15" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="visibility:visible;" data-backdrop="static">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title">Create Product Model</h4>
        </div>
        <div class="modal-body" data-backdrop="static">
         <%@include file="createProductModel.jsp" %>
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