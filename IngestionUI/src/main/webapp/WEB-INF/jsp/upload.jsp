<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

	<h1>Ingestion - File upload</h1>

	<%--<form method="POST" action="/upload" enctype="multipart/form-data">
		<input type="file" name="file" /><br />
		<br /> <input type="submit" value="Submit" />
	</form>--%>
	
	<form class="md-form" action="/upload" enctype="multipart/form-data" method="POST">
    <div class="file-field">
        <div class="btn btn-primary btn-sm float-left">
            <span>Choose file</span>
            <input type="file" name="file">
        </div>
        <%--<div class="file-path-wrapper">
           <input class="file-path validate" type="text" placeholder="Upload your file">
        </div>--%>
    </div>
    <div class="row">
    	<input class="btn btn-outline-secondary" type="submit" value="Upload" />
    </div>
</form>

</body>
</html>
