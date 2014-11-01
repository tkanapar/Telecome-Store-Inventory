<%
		String name_searchDelMap1 = (String) session.getAttribute("name");
		if(name_searchDelMap1.equalsIgnoreCase("Admin")){
	%>
  <a data-toggle="modal" href="#myModa31">Search to Delete Map</a>

  <!-- Modal -->
  <div class="modal fade" id="myModa31" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
  			 style="visibility:visible;" data-backdrop="static">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title">Search to Delete Map</h4>
        </div>
        <div class="modal-body">
         <%@include file="searchRetailer_1_DeleteMap.jsp" %>
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
  