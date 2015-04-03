<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	
</head>
	<a id="kakao-login-btn"></a>
    <script>
      	// 사용할 앱의 Javascript 키를 설정해 주세요.
      	Kakao.init('c4ff58307f47df809bef2d83dcf8f6ac');
      	Kakao.Auth.createLoginButton({
        	container: '#kakao-login-btn',
        	success: function(authObj) {
        		console.log(authObj);
          		$.ajax({
          			url : '/kakao.htm',
          			data : {
          				acc : authObj.access_token
          			},
          			success: function(data){
          				console.log(data);
          			}
          		})
        	},
        	fail: function(err) {
        		console.log(JSON.stringify(err));
        	}
      	});
    </script>
  </body>
</html>
