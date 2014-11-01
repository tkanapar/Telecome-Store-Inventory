<html lang="en">
<head>

<meta charset="utf-8">
<title>jQuery.getJSON demo</title>
<style>
img {
	height: 100px;
	float: left;
}
</style>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>
	<div id='tweet-list'></div>
	<script>
 
		window.onload = init;

		function init() {
			// the code to be called when the dom has loaded
			
		jQuery.support.cors = true;
		var firstParturl = "http://developer.api.cnet.com/rest/v1.0/techProductSearch?viewType=json&partKey=np5dzg5em3j2zy9jhrnm24mp&partTag=np5dzg5em3j2zy9jhrnm24mp&query=";
		var query =encodeURIComponent($('#item').text());
		var secondPartUrl = "&criteria=minOffers%3D1%7ChasGoodBad%3Dtrue&iod=goodBad&start=0&limit=1";
		var mainUrl = firstParturl+query+secondPartUrl; 
		//var mainUrl = "http://developer.api.cnet.com/rest/v1.0/techProductSearch?viewType=json&partKey=np5dzg5em3j2zy9jhrnm24mp&partTag=np5dzg5em3j2zy9jhrnm24mp&query=nexus%205&criteria=minOffers%3D1%7ChasGoodBad%3Dtrue&iod=goodBad&start=0&limit=1";
		//console.log(url);
		console.log(mainUrl);
		var jqxhr = $.ajax({
			url : mainUrl,
			dataType : 'jsonp'
		})

		.fail(
				function(data, textStatus, error) {
					alert("getJSON failed, status: " + textStatus + ", error: "
							+ error);
				})

		.always(function(jqxhr) {
			//alert(JSON.stringify(jqxhr));
			console.log(jqxhr.CNETResponse.TechProducts.TechProduct.BottomLine);
			$('#bottomLine').append(jqxhr.CNETResponse.TechProducts.TechProduct.BottomLine.$);
			$('#EditorsTake').append(jqxhr.CNETResponse.TechProducts.TechProduct.EditorsTake.$);
			$('#bad').append(jqxhr.CNETResponse.TechProducts.TechProduct.Bad.$);
			$('#good').append(jqxhr.CNETResponse.TechProducts.TechProduct.Good.$);
			$('#EditorsRating').append(jqxhr.CNETResponse.TechProducts.TechProduct.EditorsRating.$);
			$('#EditorsStarRating').append(jqxhr.CNETResponse.TechProducts.TechProduct.EditorsStarRating.$);
			

		 	var imgSrc = jqxhr.CNETResponse.TechProducts.TechProduct.ImageURL[1].$;
		 	//console.log(jqxhr.CNETResponse.TechProducts.TechProduct.ImageURL[1].$);
		 	var imgInfo = '<img src='+imgSrc+'>';
		 	$('#image').append(imgInfo);
			console.log(jqxhr.id);

		});
			console.log();
		}
	</script>
	
	<div class="cform" style="min-height:550px; border:1px solid #99ebff; padding-left:40px;">
	<h1 style="padding-top:20px; font-size: 25px; " align="center" >::: Reviews of Product :::</h1>
		<span id="image" title="image" style="width:150px"></img>
		<strong  style="float:left; width:120px; font-size: 13px;"> Editors Take : </strong>	
		<span id="item" style="font-size: 13px;"><%=request.getParameter("prod_name")%></span></br></br>
		<strong  style="float:left; width:120px; font-size: 13px; " > Editors Take : </strong>	
		<span id="EditorsTake" title="Editors Take" style="font-size: 13px;"></span></br></br>
		<strong  style="float:left; width:120px; font-size: 13px; "> Bottom Line : </strong>	
		<span id="bottomLine" title="Bottom Line" style="font-size: 13px;"></span></br></br>
		<strong  style="float:left; width:120px; font-size: 13px; "> Good Reviews : </strong>	
		<span id="good" title="good" style="font-size: 13px;"></span></br></br>
		<strong  style="float:left; width:120px; font-size: 13px;  "> Bad Reviews : </strong>	
		<span id="bad" title="bad" style="font-size: 13px;"></span></br></br>
		<strong  style="float:left; width:120px; font-size: 13px;  "> Editors Rating : </strong>	
		<span id="EditorsRating" title="Editors Rating" style="font-size: 13px;"></span></br></br>
		<strong  style="float:left; width:120px; font-size: 13px;  "> Star Rating : </strong>	
		<span id="EditorsStarRating" title="Editors Star Rating" style="font-size: 13px;"></span></br></br></br></br>
	</div>

</body>
</html>