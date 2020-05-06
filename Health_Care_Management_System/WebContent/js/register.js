/**
 * 
 */
function validate()
{ 
 var password = document.form.password.value;
 var conpassword= document.form.conpassword.value;
 
 if(password.length<6)
 { 
 alert("Password must be at least 6 characters long."); 
 return false; 
 } 
 else if (password!=conpassword)
 { 
 alert("Confirm Password should match with the Password"); 
 return false; 
 } 
 } 
function myFunction() {
	  alert("I am an alert box!");
	}

function clear()
{ 
	
	document.getElementById('myInput').value = '';
	 
	 
}