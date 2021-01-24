const nxInputPackages = JSON.parse(document.getElementById("packages_json").innerHTML);
const nxModelPackage = nxInputPackages[0];

const modelPackage = bestCopyEver(nxModelPackage);

function bestCopyEver(src) {
	  return Object.assign({}, src);
	}

let main_div = document.getElementById("service_article_main_container");

function nxFilter(json,inputElement){
	let filteredPackages = json.filter(item => {
		return inputElement.number_of_pages == item.number_of_pages  &&
		inputElement.number_of_page_elements == item.number_of_page_elements &&
		inputElement.database_type == item.database_type &&
		inputElement.site_search == item.site_search &&
		inputElement.multi_language == item.multi_language &&
		inputElement.animations == item.animations &&
		inputElement.user_authentication == item.user_authentication &&
		inputElement.newsletter_service == item.newsletter_service;	
	});
	return filteredPackages;	
}

allInOne();

function allInOne() {
	let a = nxFilter(nxInputPackages,modelPackage);
	articles(a); 
}

function setNumber_of_pages() {
	modelPackage.number_of_pages = document.getElementById("html_page").value;
   allInOne();
}

function setNumber_of_page_elements() {
	modelPackage.number_of_page_elements = document.getElementById("html_element").value;
	allInOne();
}

function setDatabase_type() {
	modelPackage.database_type = document.getElementById("service_db").value;
	allInOne();
}

function setSite_search() {
	modelPackage.site_search = document.getElementById("search").checked;
	allInOne();
}

function setMulti_language() {
	modelPackage.multi_language = document.getElementById("multilanguage").checked;
	allInOne();
}

function setAnimations() {
	modelPackage.animations = document.getElementById("animation").checked;
	allInOne();
}

function setUser_authentication() {
	modelPackage.user_authentication = document.getElementById("auth").checked;
	allInOne();
}

function setNewsletter_service() {
	modelPackage.newsletter_service = document.getElementById("newsletter").checked;
	allInOne();
}

function articles(arr) {
	
	removeArticles();
	
	for(let pack in arr ) {

			let item = arr[pack];
			let article = document.createElement("article");
			let header = document.createElement("header");
			let section = document.createElement("section");
			let footer = document.createElement("footer");
			article.setAttribute("id", "article_service");
			header.setAttribute("style", "margin:20px");
			footer.setAttribute("style", "margin:20px");
			
		for(let it in item){

				if(it == 'title'){
				let h3 = document.createElement("h3");
				h3.innerHTML = document.getElementById(item[it]).innerHTML;
				header.appendChild(h3);
			}

			if( item[it] != false && typeof(item[it]) == 'boolean' ) {
				let par = document.createElement("p");
				par.innerHTML = document.getElementById(it).innerHTML;
				section.appendChild(par);
			}
			
			if( it == 'number_of_pages' || it == 'number_of_page_elements') {
				let par = document.createElement("p");
				par.innerHTML = document.getElementById(it).innerHTML + ' ' + item[it];
				section.appendChild(par);
			}
			
			if( it == 'database_type') {
				let par = document.createElement("p");
				par.innerHTML = document.getElementById(item[it]).innerHTML;
				section.appendChild(par);
			}
			
			if( it == 'price' ) {
				let h4 = document.createElement("h4");
				h4.innerHTML = document.getElementById(it).innerHTML + ' ' + item[it]+ ' ' + '\u20AC';
				footer.appendChild(h4);
			}
			article.appendChild(header);
			article.appendChild(section);
			article.appendChild(footer);
			main_div.appendChild(article);
		}
	}
}


function removeArticles() {
	var list = document.getElementById("service_article_main_container");

	while (list.hasChildNodes()) {  
	  list.removeChild(list.firstChild);
	}
}


/*

function Scrolldown() {
     window.scroll(0,document.getElementById("height1").innerHTML); 
}

Scrolldown()
//window.onload = Scrolldown;

document.getElementById("html_page").value = document.getElementById("html_page1").innerHTML
document.getElementById("html_element").value = document.getElementById("html_element1").innerHTML
document.getElementById("service_db").value = document.getElementById("service_db1").innerHTML
document.getElementById("height").value = window.scrollY;

var search_box = document.getElementById("search");
var multilanguage_box = document.getElementById("multilanguage");
var animation_box = document.getElementById("animation");
var auth_box = document.getElementById("auth");
var newslterre_box = document.getElementById("newsletter");

var search_box1 = document.getElementById("search1").innerHTML;
var multilanguage_box1 = document.getElementById("multilanguage1").innerHTML;
var animation_box1 = document.getElementById("animation1").innerHTML;
var auth_box1 = document.getElementById("auth1").innerHTML;
var newslterre_box1 = document.getElementById("newsletter1").innerHTML;


function checkMaker(search,search1) {
	if(search1 != '' ) {
		search.checked = true;
	}else {
		search.checked = false;
	}
}

checkMaker(search_box,search_box1);
checkMaker(multilanguage_box,multilanguage_box1);
checkMaker(animation_box,animation_box1);
checkMaker(auth_box,auth_box1);
checkMaker(newslterre_box,newslterre_box1);


function height_measure() {
		var y = window.scrollY;
	   document.getElementById("height").value = y
}

*/
