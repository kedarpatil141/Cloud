<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
var source= new EventSource('http://localhost:4444/stream');
source.addEventListener=function(source){
	console.error(source);
}
	

	/* var ws;
	 ws = new WebSocket('ws://localhost:4444/name');
	 ws.onmessage = function(data){
	 //showGreeting(data.data);
	 alert(data.data);
	 }
	 */

	/* 
	 if(typeof(EventSource) !== "undefined") {
	 var source = new EventSource("/ingestionNotification");
	 source.onmessage = function(event) {
	 document.getElementById("sseDiv").innerHTML += event.data + " - ";
	 };
	 }  
	 */

	var source = new EventSource("/name");
	source.onmessage = function(event) {
		console.info(event);
	};
</script>

</head>
<body>
	<h1>Upload Status</h1>

	Status: ${message}
	<div id="sseDiv"></div>
</body>
</html>