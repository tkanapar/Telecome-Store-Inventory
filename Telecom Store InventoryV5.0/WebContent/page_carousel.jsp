<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>page carousel</title>
<script type="text/javascript" src="javascript/jquery.min.js"></script>
<script type="text/javascript" src="javascript/coursal.js"></script>
<script type="text/javascript" src="javascript/jquery.barousel.min.js"></script>
<script type="text/javascript" src="javascript/jquery.thslide.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/barousel_demo.css"/>
<link rel="stylesheet" type="text/css" href="css/reset.css"/>
</head>
<body>
<div id="barousel_thslide" class="barousel">
                <div class="barousel_image">
                    <!-- image 1 -->
                    <img src="images/barousel_horses_1.jpg" alt="" class="" style="display: none;">
                    <!-- image 2 -->
                    <img src="images/barousel_horses_2.jpg" alt="" class="" style="display: none;">
                    <!-- image 3 -->
                    <img src="images/barousel_horses_3.jpg" alt="" class="current" style="display: inline;">
                    <!-- image 4 -->
                    <img src="images/barousel_horses_4.jpg" alt="" class="" style="display: none;">
                    <!-- image 5 -->
                    <img src="images/barousel_carousel_1.jpg" alt="" class="" style="display: none;">
                    <!-- image 6 -->
                    <img src="images/barousel_carousel_2.jpg" alt="" class="" style="display: none;">
                    <!-- image 7 -->
                    <img src="images/barousel_carousel_3.jpg" alt="">
                    <!-- image 8 -->
                    <img src="images/barousel_carousel_4.jpg" alt="">
                </div>
                <div class="barousel_content" style="height: 136px; display: block;">
                    <!-- content 1 -->
                    <div class="default" style="display: none;">
                        <p class="header">Horses 1</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
                        <p><a href="#">Link 1</a></p>
                    </div>
                    <!-- content 2 -->
                    <div style="display: none;">
                        <p class="header">Horses 2</p>
                        <p>Nam eros eros, tempor ac hendrerit a, placerat vitae augue. </p>
                        <p><a href="#">Link 2</a></p>
                    </div>
                    <!-- content 3 -->
                    <div style="display: block;">
                        <p class="header">Horses 3</p>
                        <p>Ut euismod suscipit elit, id pulvinar dui viverra ac. Fusce interdum leo sit amet turpis pretium fringilla. </p>
                        <p><a href="#">Link 3</a></p>
                    </div>
                    <!-- content 4 -->
                    <div style="display: none;">
                        <p class="header">Horses 4</p>
                        <p>Vivamus pharetra tristique mi, vitae blandit enim fringilla eget. Fusce consectetur lorem nec tortor varius elementum vel ac urna. Vitae blandit enim fringilla eget.</p>
                        <p><a href="#">Link 4</a></p>
                    </div>
                    <!-- content 5 -->
                    <div style="display: none;">
                        <p class="header">Carousel 1</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
                        <p><a href="#">Link 5</a></p>
                    </div>
                    <!-- content 6 -->
                    <div style="display: none;">
                        <p class="header">Carousel 2</p>
                        <p>Nam eros eros, tempor ac hendrerit a, placerat vitae augue. </p>
                        <p><a href="#">Link 6</a></p>
                    </div>
                    <!-- content 7 -->
                    <div style="display: none;">
                        <p class="header">Carousel 3</p>
                        <p>Ut euismod suscipit elit, id pulvinar dui viverra ac. Fusce interdum leo sit amet turpis pretium fringilla.</p>
                        <p><a href="#">Link 7</a></p>
                    </div>
                    <!-- content 8 -->
                    <div style="display: none;">
                        <p class="header">Carousel 4</p>
                        <p>Vivamus pharetra tristique mi, vitae blandit enim fringilla eget. Fusce consectetur lorem nec tortor varius elementum vel ac urna. Vitae blandit enim fringilla eget.</p>
                        <p><a href="#">Link 8</a></p>
                    </div>
                </div>
                <div id="thslide_barousel_nav" class="thslide">
                    <div class="thslide_nav_previous">
                        <a href="#">&nbsp;</a>
                    </div>
                    <div class="thslide_list">
                        <ul style="margin-left: 0px;">
                            <li><a href="#" class=""><img src="images/th_barousel_horses_1.jpg" alt=""><span></span></a></li>                        
                            <li><a href="#" class=""><img src="images/th_barousel_horses_2.jpg" alt=""><span></span></a></li>
                            <li><a href="#" class="current"><img src="images/th_barousel_horses_3.jpg" alt=""><span></span></a></li>
                            <li><a href="#" class=""><img src="images/th_barousel_horses_4.jpg" alt=""><span></span></a></li>
                            <li><a href="#" class=""><img src="images/th_barousel_carousel_1.jpg" alt=""><span></span></a></li>                        
                            <li><a href="#" class=""><img src="images/th_barousel_carousel_2.jpg" alt=""><span></span></a></li>
                            <li><a href="#"><img src="images/th_barousel_carousel_3.jpg" alt=""><span></span></a></li>
                            <li><a href="#"><img src="images/th_barousel_carousel_4.jpg" alt=""><span></span></a></li>
                       </ul>
                    </div>
                    <div class="thslide_nav_next">
                        <a href="#">&nbsp;</a>
                    </div>
                </div>
            </div>
</body>
<script type="text/javascript">
$('#barousel_thslide').barousel({
    navWrapper: '#thslide_barousel_nav .thslide_list',
    manualCarousel: 1,
    navType: 3
});

$('#thslide_barousel_nav').thslide({
    itemOffset: 93
});
</script>
</html>