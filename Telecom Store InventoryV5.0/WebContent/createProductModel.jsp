
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
	<form name="form" method="post" id="third" class="niceform" action="/Telecom_Store/IMServlet?action=CREATEPRODUCTMODEL" >
		<table style="margin-top:20px; ">
			<tr style="height:50px;">
				
				<td>
					<label style="margin-right:0px;"><strong style="float: left;"><span class="blue">*</span> Name : </strong></label></br>
				</td>
				<td >
					<input name="name" type="text"  size="25" minlength="2" required/>
				</td>
				<td style="padding-left:10px;">
					<label><strong style="float: left;"><span class="blue">*</span> Description : </strong></label>
				</td>
				<td>
					<input  name="desc" type="text"  size="25" minlength="2" required></input>
				</td>
			</tr>
			<tr style="height:50px;">
				<td>
					<label><strong style="float: left;"><span class="blue">*</span> Feature : </strong></label>
				</td>
				<td >
					<input name="feature" type="text" size="25" minlength="2" required></input>
				</td>
				
				<td style="padding-left:10px;">
					<label><strong style="float: left;"><span class="blue">*</span> Price : </strong></label>
				</td>
				<td>
					<input name="price" type="text"  size="25" minlength="2" required></input>
				</td>
				
			</tr>
			<tr style="height:50px;">
				<td>
					<label><strong style="float: left;"><span class="blue">*</span> Threshold : </strong></label>
				</td>
				<td >
					<input name="threshold" type="text" size="25" minlength="1" required></input>
				</td>
				<td style="padding-left:10px;">
						<label><strong style="float: left;"><span class="blue">*</span> Quantity : </strong></label><br />
				</td>
				<td>
					<input name="quantity" type="text" size="25" minlength="2" required></input>
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td style="padding-left:20px; padding-top:10px;">
					<input type="submit" class="buttonSubmit" value="Create" ></input>
				</td>
			</tr>
			
			</table>
	       

</form>

