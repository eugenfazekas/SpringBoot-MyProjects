var o = window.location.pathname;
var slice = o.slice(0, 14);

const width = window.innerWidth
|| document.documentElement.clientWidth
|| document.body.clientWidth;

var ele = document.getElementById("image_container_width");

var image_width = ele.clientWidth * 0.98;

function break_visibility(width){
	if(width <= 1000){
		document.getElementById("break").style.display = "block";
		console.log(width)
	}else{
		document.getElementById("break").style.display = "none";
	}
}

break_visibility(image_width);

document.getElementById('imageload1').width = image_width;
document.getElementById('imageload2').width = image_width;
document.getElementById('imageload3').width = image_width;

console.log(image_width);

if (o == '/menu/contact'){
	document.getElementById('contact').style.background="#007bff";
	document.getElementById('contact').style.color="#fff";
}

if (o == '/'){
	document.getElementById('home').style.background="#007bff";
	document.getElementById('home').style.color="#fff";
}

if (o == '/menu/services'){
	document.getElementById('service_nav_link').style.background="#007bff";
	document.getElementById('service_nav_link').style.color="#fff";
}

if (slice == '/menu/services'){
	document.getElementById('service_nav_link').style.background="#007bff";
	document.getElementById('service_nav_link').style.color="#fff";
}

if (o == '/menu/blog'){
	document.getElementById('service_nav_link').style.background="#007bff";
	document.getElementById('service_nav_link').style.color="#fff";
}