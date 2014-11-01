<script type = "text/javascript">


window.onload = function() 
{ 
	document.getElementById("m1").style.visibility ='hidden';
};

function dothis(){
		var boxes = $(".cbox");
        var button = document.getElementById('toggle');

        if(button.value == 'Select All'){
            for (var i in boxes){
            	boxes[i].checked = 'checked';
            }
            button.value = 'De - select'
        }else{
            for (var i in boxes){
            	boxes[i].checked = '';
            }
            button.value = 'Select All';
        }
    }

function deleteRecords(){
	var boxes = $(".cbox");
	var selectedBoxes = new Array();
	var j=0;
	for (var i in boxes){
    	if(boxes[i].checked){
        	selectedBoxes[j++] = boxes[i].id;
	     	}
		}
	
	$.ajax({url:"/Telecom_Store/AdminServlet?action=DELETEUSERS&selectedRet="+selectedBoxes,success:function(result){
		    $("#ajaxload").html("<p class=\"resultStyle\">Deleted Selected Retailors</p>");
		  }});
}

function deleteProductModels(){
	var boxes = $(".cbox");
	var selectedBoxes = new Array();
	var j=0;
	for (var i in boxes){
    	if(boxes[i].checked){
        	selectedBoxes[j++] = boxes[i].id;
	     	}
		}
	
	$.ajax({url:"/Telecom_Store/IMServlet?action=DELETEPRODUCTMODELS&selectedProdMod="+selectedBoxes,success:function(result){
		    $("#ajaxload").html("<p class=\"resultStyle\">Deleted Selected Product Models</p>");
		  }});
}
function mapProductModels(){
	var boxes = $(".cbox");
	var retailorId = $('#name').val();
	var selectedBoxes = new Array();
	var j=0;
	for (var i in boxes){
    	if(boxes[i].checked){
        	selectedBoxes[j++] = boxes[i].id;
	     	}
		}
	$.ajax({url:"/Telecom_Store/AdminServlet?action=MAPPRODUCTMODELS&ret_id="+retailorId+"&selectedProdMod="+selectedBoxes,success:function(result){
		    $("#ajaxload").html("<p class=\"resultStyle\">Mapped Selected Product Models</p>");
		  }});
}

function deleteMappedProductModels(){
	var boxes = $(".cbox");
	var retailorId = $('#name').val();
	var selectedBoxes = new Array();
	var j=0;
	for (var i in boxes){
    	if(!(boxes[i].checked)){
        	selectedBoxes[j++] = boxes[i].id;
	     	}
		}
	$.ajax({url:"/Telecom_Store/AdminServlet?action=DELETEMAPPRODUCTMODELSRET&ret_id="+retailorId+"&selectedProdMod="+selectedBoxes,success:function(result){
		    $("#ajaxload").html("<p class=\"resultStyle\">Deleted Selected Product Models</p>");
		  }});
}

function OrderSelectedDefectProductModels()
{
	var boxes = $(".cbox");
	var selectedBoxes = new Array();
	var j=0;
	for (var i in boxes){
    	if(boxes[i].checked){
        	selectedBoxes[j++] = boxes[i].id;
	     	}
		}
	$.ajax({url:"/Telecom_Store/RetailerServlet?action=PRODUCTSRAISEDASDEFECT&selectedProdids="+selectedBoxes,success:function(result){
	    $("#ajaxload").html("<p class=\"resultStyle\">Defect Raised Successfully</p>");
	  }});
}
function OrderSelectedProductModels(){
	var boxes = $(".cbox");
	var selectedBoxes = new Array();
	var quantity = new Array();
	var prod_id = new Array();
	var prod_name = new Array();
	var j=0;
	for (var i in boxes){
    	if(boxes[i].checked){
        		var quantityOfEach = document.getElementById("Q_"+boxes[i].id);
        		quantity[j] = quantityOfEach.value;
        		var prodMod = document.getElementById("mod_"+boxes[i].id);
        		prod_id[j] = prodMod.value;
        		var eachName = document.getElementById("name_"+boxes[i].id);
        		prod_name[j] = eachName.value;
           		j++;
	     	}
		}
	
	sendRequest2('GET','/Telecom_Store/RetailerServlet?action=SELECTPRODSTOORDER&quantity='+quantity+
			'&prod_id='+prod_id+'&prod_name='+prod_name);
}


function deleteIMRecords(){

	$.ajax({url:"/Telecom_Store/AdminServlet?action=DELETEIMUSER",success:function(result){
		    $("#ajaxload").html("<p class=\"resultStyle\">Deleted Inventory Manager</p>");
		  }});
}

function searchForDelete(){
	var retailorId = $('#name1').val();
	sendRequest2('GET','/Telecom_Store/AdminServlet?action=SEARCHRETAILRSTODELETE&ret_id='+retailorId);
}

function searchOrderToUpdate(){
	var orderId = $('#name2').val();
	$.ajax({url:"/Telecom_Store/RetailerServlet?action=SEARCHTOUPDATESTATUS&orderId="+orderId,success:function(result){
	    $("#ajaxload").html("<p class=\"resultStyle\">Updated successfully</p>");
	  }});
}
function searchOrderToRaiseDefect()
{
	var defectOrderId = $('#Defectname').val();
	sendRequest2('GET','/Telecom_Store/RetailerServlet?action=SEARCHORDERTORAISEDEFECT&defectOrderId='+defectOrderId);
}
function searchOrderToUpdateCust(){
	var orderId = $('#name3').val();
	sendRequest2('GET','/Telecom_Store/RetailerServlet?action=SEARCHORDERTOUPDATECUST&orderId='+orderId);
}
function searchForMap(){
	var retailorId = $('#name').val();
	sendRequest2('GET','/Telecom_Store/AdminServlet?action=SEARCHRETAILRSTOMAP&ret_id='+retailorId);
}
function searchForMapDelete(){
	var retailorId = $('#retname').val();
	sendRequest2('GET','/Telecom_Store/AdminServlet?action=SEARCHRETAILRSTODELETEMAP&ret_id='+retailorId);
}

function searchForUpdating(){
	var retailorId = $('#ret_id').val();
	sendRequest2('GET','/Telecom_Store/AdminServlet?action=SEARCHRETAILRSFORUPDATING&ret_id='+retailorId);
}

function searchProductModelForUpdating(){
	var prod_mod_id = $('#prod_mod_id').val();
	sendRequest2('GET','/Telecom_Store/IMServlet?action=SEARCHPRODUCTMODFORUPDATING&prod_mod_id='+prod_mod_id);
}

function searchProdModForDelete(){
	var prodmodId = $('#name').val();
	sendRequest2('GET','/Telecom_Store/IMServlet?action=SEARCHPRODMODTODELETE&prod_mod__id='+prodmodId);
}

function searchToGetReviews(){
	var prod_name = $('#prod_name').val();
	window.location = 'homePage.jsp?OPERATION=VIEWREVIEW&prod_name='+prod_name;
}
</script>

<ul id="topmenu" style="width: 40%; float: right; margin-top:20px;">
	<li><a href="#">About Us</a></li>
	<li><a onmouseover="mopen('m1')" onmouseout="mclosetime()" href="#">My Account</a>
				<ul id="m1" onmouseover="mcancelclosetime()" 
            onmouseout="mclosetime()">
					
					<li ><a href="#">Change Password</a></li>
				</ul>
	</li>
	
	<li>
		<a href="#">Contact Us</a>	
	</li>
	
	<li>
		<a href="#">Privacy Policy</a>	
	</li>
</ul>


<script type = "text/javascript">


var timeout	= 5;
var closetimer	= 0;
var ddmenuitem	= 0;

// open hidden layer
function mopen(id)
{	
	// cancel close timer
	mcancelclosetime();

	// close old layer
	if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';

	// get new layer and show it
	ddmenuitem = document.getElementById(id);
	ddmenuitem.style.visibility = 'visible';

}
// close showed layer
function mclose()
{
	if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';
}

// go close timer
function mclosetime()
{
	closetimer = window.setTimeout(mclose, timeout);
}

// cancel close timer
function mcancelclosetime()
{
	if(closetimer)
	{
		window.clearTimeout(closetimer);
		closetimer = null;
	}
}

// close layer when click-out
document.onclick = mclose; 
</script>
