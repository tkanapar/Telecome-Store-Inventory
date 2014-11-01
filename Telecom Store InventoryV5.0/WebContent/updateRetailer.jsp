
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

    <!-- Start HTML form -->
	 	<form name="form" method="post" id="third" class="niceform" action="/Telecom_Store/AdminServlet?action=CREATERETAILER" >
		<table style="margin-top:20px; border:1px solid black;">
			<tr>
				
				<td>
					<label style="margin-right:0px;"><strong style="float: left;"><span class="blue">*</span> Retailer Name : </strong></label>
				</td>
				<td >
					<input name="name" type="text"  size="20"  minlength="2" required/>
				</td>
				<td style="padding-left:10px;">
					<label><strong style="float: left;"><span class="blue">*</span> Email ID : </strong></label>
				</td>
				<td>
					<input  name="email" type="email"  size="20"  minlength="2" required/>
				</td>
			</tr>
			<tr>
				<td>
					<label><strong style="float: left;"><span class="blue">*</span> Contact Number : </strong></label>
				</td>
				<td >
					<input name="phone" type="text" size="20"  minlength="2" required/>
				</td>
				
				<td style="padding-left:10px;">
					<label><strong style="float: left;"><span class="blue">*</span> Licence Number : </strong></label>
				</td>
				<td>
					<input name="licence" type="text"  size="20"  minlength="2" required/>
				</td>
				
			</tr>
			
			<tr>
				<td>
					<label><strong style="float: left;"><span class="blue">*</span> Store Location : </strong></label>
				</td>
				<td >
					<input name="loc" type="text" size="20" />
				</td>
				<td style="padding-left:10px;">
						<label><strong style="float: left;"><span class="blue">*</span> Address : </strong></label><br />
				</td>
				<td>
					<textarea id="addr" name="addr"  rows="10" cols="30"  minlength="2" required></textarea>
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td style="padding-left:20px; padding-top:10px;">
					<input type="submit" class="buttonSubmit" value="Update" />
				</td>
			</tr>
			
			</table>
	       



