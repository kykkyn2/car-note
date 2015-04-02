<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
	<button id="kakao">시작해볼까?</button>
	
	
	<script>
		$("#kakao").click(function(){
			$.ajax({
				url  : '/kakao.htm',
				success	: function(data){
					console.log(data);
				}
			});
		});
	</script>
</body>
</html>
