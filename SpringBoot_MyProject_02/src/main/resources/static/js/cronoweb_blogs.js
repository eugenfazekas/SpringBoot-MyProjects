const blogs1 = JSON.parse(document.getElementById("blogs_array_input").innerHTML)

var blogId1 = 0;
var blogId2 = 0;

getBlogELements1(blogId1);
getBlogELements2(blogId1);

function nextBlog(){
	display();
	if(blogId1 <= blogs1.length - 3 ){
		blogId1 = blogId1 + 2;
		getBlogELements1(blogId1);

	}
	
	if(blogId2 <= blogs1.length - 4 ){
		blogId2 = blogId2 + 2;
		getBlogELements2(blogId2);

		}else {
			if(blogs1.length % 2 == 0){
			blogId2 = blogs1.length - 2 ;
			}else {
				blogId2 = blogs1.length - 1 ;
				displayNone();
			}
		}
}

function prevoiusBlog(){

	display();
	if(blogId1 >= 2  ){
		blogId1 = blogId1 - 2;
		getBlogELements1(blogId1);

	}
	
	if(blogId2 >= 2 ){
		blogId2 = blogId2 - 2;
		getBlogELements2(blogId2);

		}
}

function firstBlog(){
	display();
	getBlogELements1(0);
	getBlogELements2(0);
	blogId1 = 0;
	blogId2 = 0;
}

function secondBlog(){
	display();
	getBlogELements1(2);
	getBlogELements2(2);
	blogId1 = 2;
	blogId2 = 2;
}

function thirdBlog(){
	display();
	getBlogELements1(4);
	getBlogELements2(4);
	blogId1 = 4;
	blogId2 = 4;
}

function getBlogELements1(Id){
	
	var blogId = Id;
	
	document.getElementById("blogcimtartalom1").innerHTML = blogs1[blogId].title
	document.getElementById("bsection1").innerHTML = blogs1[blogId].blog
	document.getElementById("blogdatumtartalom1").innerHTML = blogs1[blogId].posted
	document.getElementById("delete1").value = blogs1[blogId].title
}

function getBlogELements2(Id){
	
	var blogId = Id;

	document.getElementById("blogcimtartalom2").innerHTML = blogs1[blogId+1].title
	document.getElementById("bsection2").innerHTML = blogs1[blogId+1].blog
	document.getElementById("blogdatumtartalom2").innerHTML = blogs1[blogId+1].posted
	document.getElementById("delete2").value = blogs1[blogId+1].title
}

function displayNone(){
	
	document.getElementById("article2").style.display = 'none'

}

function display(){
	
	document.getElementById("article2").style.display = 'block'

}

const blog_titles = [];
const blog_titles_toUpper = [];
const blog_title_array_index = [];

function createBlogTitles() {
	
	for (let item in blogs1) {

		blog_titles[item] = blogs1[item].title;
		blog_titles_toUpper[item] =blogs1[item].title.toUpperCase()
	}
}

function preSearch() {
    var  a = document.getElementById("main_search").value.toUpperCase()
	const result = blog_titles_toUpper.filter(word => word.startsWith(a));
	if(result.length == blog_titles_toUpper.length ) {result.length = 0}
	console.log(result);
	findIndexOfTitle(result); 
	loadPreSearchElements();

}

function findIndexOfTitle(array){
	blog_title_array_index.length = 0;
	for(i = 0; i < array.length + 1; i++){
		
		blog_title_array_index.push(blog_titles_toUpper.indexOf(array[i]));
		//alert(blog_titles_toUpper.indexOf(array[i]));
	}
	
}

var autocomplete1 = "autocomplete1";
var autocomplete2 = "autocomplete2";
var autocomplete3 = "autocomplete3";

function autoComleteHide(autocomlete){
		document.getElementById(autocomlete).innerHTML = ''
		document.getElementById(autocomlete).style.visibility="hidden";
}

function loadPreSearchElements() {

	
	if(blog_title_array_index[0] >= 0 && blog_title_array_index[0] < Number.MAX_SAFE_INTEGER ){
		
		document.getElementById("autocomplete1").innerHTML = blog_titles[blog_title_array_index[0]]
		document.getElementById("autocomplete1").style.visibility="visible";
	}else{
		 automcomlete1_hidden();
	}
	
	if(blog_title_array_index[1] >= 0 && blog_title_array_index[1] < Number.MAX_SAFE_INTEGER ){
		
		document.getElementById("autocomplete2").innerHTML = blog_titles[blog_title_array_index[1]]
		document.getElementById("autocomplete2").style.visibility="visible";
	}else{
		 automcomlete2_hidden();
		}
	
	if(blog_title_array_index[2] >= 0 && blog_title_array_index[2] < Number.MAX_SAFE_INTEGER ){
		
		document.getElementById("autocomplete3").innerHTML = blog_titles[blog_title_array_index[2]]
		document.getElementById("autocomplete3").style.visibility="visible";
	}else{
		 automcomlete3_hidden();
	}
}

function automcomlete1_hidden() {
	 autoComleteHide(autocomplete1);
}

function automcomlete2_hidden() {
	 autoComleteHide(autocomplete2);
}

function automcomlete3_hidden() {
	 autoComleteHide(autocomplete3);
}

function automcomleteAllHidden(){
		 automcomlete1_hidden()
		 automcomlete2_hidden()
		 automcomlete3_hidden()
}
function autoComplete1() {
		 document.getElementById("main_search").value = document.getElementById("autocomplete1").innerHTML
		 automcomleteAllHidden()
}

function autoComplete2() {
		 document.getElementById("main_search").value = document.getElementById("autocomplete2").innerHTML
		 automcomleteAllHidden()
}

function autoComplete3() {
		 document.getElementById("main_search").value = document.getElementById("autocomplete3").innerHTML
		 automcomleteAllHidden()
}

function submit_blog(){ 

		const result = blogs1.find( ({ title }) => title === document.getElementById("main_search").value );
		document.getElementById("blogcimtartalom1").innerHTML = result.title
		document.getElementById("bsection1").innerHTML = result.blog
		document.getElementById("blogdatumtartalom1").innerHTML = result.posted;
		displayNone();
}
//if(typeof(myVariable) != "undefined")
