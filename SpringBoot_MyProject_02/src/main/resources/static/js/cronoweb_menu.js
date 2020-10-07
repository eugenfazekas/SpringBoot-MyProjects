var o = window.location.pathname;
var slice = o.slice(0, 14);


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