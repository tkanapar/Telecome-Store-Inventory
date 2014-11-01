<html>
	<head>
	<script src="js/jquery.js"></script>
	     <script type="text/javascript">
        function launchModal() {
            $("#myModal").html($("#modalTemplate").html()).modal();

        }

    </script>
	</head>

	<body>
		<a href="javascript:launchModal()" role="button" class="btn" >Launch demo modal</a>

    <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-    labelledby="myModalLabel" aria-hidden="true">

   </div> 

   <div id="modalTemplate" style="display:none">
      <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">Modal Header</h3>
  </div>
  <div class="modal-body">
    <div id="container" class="classIDThatContainstheContentsforModal">
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
  
  </div>

</div>	
	</body>

</html>