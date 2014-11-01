<%
		String name_updateRetailer = (String) session.getAttribute("name");
		if(name_updateRetailer.equalsIgnoreCase("Admin")){
	%>

  <a data-toggle="modal" href="#myModal4">Search to  Update </a>

  <!-- Modal -->
  <div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
  			 style="visibility:visible;" data-backdrop="static">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title">Search to Update </h4>
        </div>
        <div class="modal-body">
         <%@include file="searchRetailer_2.jsp" %>
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
  