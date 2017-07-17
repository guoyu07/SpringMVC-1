<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>spring3</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
  </head>
  <body>
		<div id="divTest">
			<template v-for="user in userList">
			<ul>
			  <li v-for="(value, key) in user" v-show="key != 'userId' && user.userType != '管理员'">
			  	{{key}} ：{{value}}
			  </li>
			</ul>
			</template>
		</div>
  </body>
</html>

	<script type="text/javascript">
		jQuery.ajaxSetup({cache:false});//ajax不缓存
	//	jQuery(function($){
	//		var xmlobj= $.ajax({url: '../UserControl/test',async:false});
	//		
	//		$("#divTest").html(xmlobj.responseText);
	//	});
		
		var vm = new Vue({
			el:"#divTest",
			data:{
				userList:{
					
				}
			},
			
			//methods:{
				created:function(){				
				var _self = this;
				$.ajax({
	                url:"../UserControl/test",
	                dataType:'json',
	                success:function(result){
	                	_self.userList = result;                  
	                },
	                error:function(){
	                    alert("请求失败");
	                }
	            });				
			}
		  //}
		});
		
	</script>