var OUTPUT = document.createElement("INPUT");

function SET_OUTPUT_ATTRIBUTES(){
	OUTPUT.setAttribute("type", "file");
	OUTPUT.setAttribute("name", "fileOutput");
	OUTPUT.setAttribute("id", "fileOutput");
	OUTPUT.setAttribute("form", "form_upload");
	document.getElementById("form_upload").appendChild(OUTPUT);
}

var resize_image;

function resize(){
	//define the width to resize e.g 600px
	  var resize_width = 500;//without px

	  //get the image selected
	  var item = document.querySelector('#fileInput').files[0];

	  //create a FileReader
	  var reader = new FileReader();

	  //image turned to base64-encoded Data URI.
	  reader.readAsDataURL(item);
	  reader.name = item.name;//get the image's name
	  reader.size = item.size; //get the image's size
	  reader.onload = function(event) {
	    var img = new Image();//create a image
	    img.src = event.target.result;//result is base64-encoded Data URI
	    img.name = event.target.name;//set name (optional)
	    img.size = event.target.size;//set size (optional)
	    img.onload = function(el) {
	    	
	      if(el.target.width < resize_width){
		    	  resize_width = el.target.width;
		      }
	      
	      var elem = document.createElement('canvas');//create a canvas

	      //scale the image to 600 (width) and keep aspect ratio
	      var scaleFactor = resize_width / el.target.width;
	      	     
	      elem.width = resize_width;
	      elem.height = el.target.height * scaleFactor;

	      //draw in canvas
	      var ctx = elem.getContext('2d');
	      ctx.drawImage(el.target, 0, 0, elem.width, elem.height);

	      //get the base64-encoded Data URI from the resize image
	      var srcEncoded = ctx.canvas.toDataURL(el.target, 'image/png', 0);

	      //assign it to thumb src
	      document.querySelector('#image_test').src = srcEncoded;

	      /*Now you can send "srcEncoded" to the server and
	      convert it to a png o jpg. Also can send
	      "el.target.name" that is the file's name.*/
	      console.log('srcEncoded: ',srcEncoded)
	      resize_image = srcEncoded;

	    }
	  }
}

function b64toBlob(dataURI) {
	
	console.log('b64toBlob Input',dataURI);
	
    var byteString = atob(dataURI.split(',')[1]);
    var ab = new ArrayBuffer(byteString.length);
    var ia = new Uint8Array(ab);

    for (var i = 0; i < byteString.length; i++) {
        ia[i] = byteString.charCodeAt(i);
    }
    return new Blob([ab], { type: 'image/png' });
}

function append_data(inputBlob){
    
	SET_OUTPUT_ATTRIBUTES();
	console.log(OUTPUT);
	console.log('Append InputBlob',inputBlob);
	
	let file = new File([inputBlob], 'test.png');
	console.log('Appended file',file);

	let photo = document.getElementById("fileOutput").files[0];
	let formData = new FormData();

	formData.append("fileOutput", file, 'test');
	fetch('/uploadImage2', {method: "POST", body: formData});
	
}

function main_resize(){
		
	var blob = b64toBlob(resize_image);
	append_data(blob);

}

