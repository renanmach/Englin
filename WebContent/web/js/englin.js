var flag=0;

function nextWord() {
	ajaxRequest(getContextPath()+"/RememberItActionServlet","type="+flag);
}

function ajaxRequest(url,parameters) {
	var xhttp = null;
	var tag1 = "text-input1";
	var tag2 = "text-input2";
	
	try {
		xhttp = new XMLHttpRequest();
	}
	
	catch (e) {
		xhttp = ActiveXObject("Microsoft.XMLHTTP");
	}
	
	if(xhttp == null) {
		alert("Ajax is not supported by your browser!");
		return;
	}
	
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			if(flag==0) {
				document.getElementById(tag1).innerHTML = xhttp.responseText;
				document.getElementById(tag2).innerHTML = "";
				flag=1;
			}
			
			else {
				document.getElementById(tag2).innerHTML = xhttp.responseText;
				flag=0;
			}
		}
	};
	xhttp.open("POST", url+"?"+parameters, true);
	xhttp.send();
}

function getContextPath() {
	   return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}