    <!-- Start HTML form -->
	<form name="form" method="post" id="third" class="niceform" action="/Telecom_Store/RetailerServlet?action=PLACEORDER" >
		<table style="margin-top:20px; ">
			<tr style="height:50px;">
				<td>
					<label style="margin-right:0px;"><strong style="float: left;"><span class="blue">*</span> Retailer Name : </strong></label></br>
				</td>
				<td >
					<input name="name" type="text"  size="25"/>
				</td>
				<td style="padding-left:10px;">
					<label><strong style="float: left;"><span class="blue">*</span> Email ID : </strong></label>
				</td>
				<td>
					<input  name="email" type="text"  size="25"></input>
				</td>
			</tr>
			<tr style="height:50px;">
				<td>
					<label><strong style="float: left;"><span class="blue">*</span> Contact Number : </strong></label>
				</td>
				<td >
					<input name="phone" type="text" size="25" ></input>
				</td>
				
				<td style="padding-left:10px;">
					<label><strong style="float: left;"><span class="blue">*</span> Licence Number : </strong></label>
				</td>
				<td>
					<input name="licence" type="text"  size="25"></input>
				</td>
				
			</tr>
			<tr style="height:50px;">
				<td>
					<label><strong style="float: left;"><span class="blue">*</span> Store Location : </strong></label>
				</td>
				<td >
					<input name="loc" type="text" size="25" ></input>
				</td>
				<td style="padding-left:10px;">
						<label><strong style="float: left;"><span class="blue">*</span> Address : </strong></label><br />
				</td>
				<td>
					<textarea style="line-height:20px; !important" id="addr" name="addr"  rows="50" cols="40"></textarea>
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

