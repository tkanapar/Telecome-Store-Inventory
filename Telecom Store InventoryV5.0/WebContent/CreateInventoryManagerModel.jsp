<%
		String name_createIM = (String) session.getAttribute("name");
		if(name_createIM.equalsIgnoreCase("Admin")){
	%>
  <a data-toggle="modal" href="#myModal6">Create Inventory Manager</a>

  <!-- Modal -->
  <div class="modal fade" id="myModal6" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="visibility:visible;" data-backdrop="static">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title">Create Inventory Manager</h4>
        </div>
        <div class="modal-body" data-backdrop="static">
         <%@include file="createInventoryManager.jsp" %>
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