async function sendEmail() {

	var uname = document.getElementById('uname').value
	var email = document.getElementById('email').value
	var comment = document.getElementById('comment').value
	var check = document.getElementById('message_check').checked
	var crono_message = 'Message senders name: '+ uname + ",<br/><br/>"+ "Message: " +comment+",<br/><br/>Message senders email: " + email;
	
	if(uname != '' && email != '' && comment != '' && check.toString() === 'true') {
		const emailsend = await	Email.send({
				SecureToken:"b5a7b82d-4e1b-4711-b1cc-710fed3db574",
			    To : 'skybolt83@gmail.com',
			    From : "cronoweb.ro@gmail.com",
			    Subject : uname ,
			    Body : crono_message
			}).then(
				 message => { location.replace("https://www.cronoweb.ro"); console.log('message sent') }
			);
		};
	};

