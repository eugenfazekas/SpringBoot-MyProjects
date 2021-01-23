const packages = JSON.parse(document.getElementById("packages_json").innerHTML);
var main_div = document.getElementById("article_main_container");

function articles(packages) {
	
	for(let package in packages ) {
		
		let item = packages[package];
		
			let article = document.createElement("article");
			let header = document.createElement("header");
			let section = document.createElement("section");
			let footer = document.createElement("footer");
			article.setAttribute("id", "article_index");
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
articles(packages); 