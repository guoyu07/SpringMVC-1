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
	<div id="app">
		<template>
		    <el-table :data="tableData" width="500px" border v-loading="isLoadingData">
		      <el-table-column prop="userName" label="用户名" width="180">
		      </el-table-column>
		      <el-table-column prop="userType" label="用户类型" width="180">
		      </el-table-column>
		      <el-table-column prop="password" label="密码">
		      </el-table-column>
		      <el-table-column prop="description" label="描述">
		      </el-table-column>
		    </el-table>
		  </template>
		  <el-pagination
		  		id="page"
      			@size-change="handleSizeChange"
      			@current-change="handleCurrentChange"
      			:current-page="currentPage"
      			:page-sizes="[5, 10, 20, 50, 100]"
      			:page-size="pageSize"
      			layout="total, sizes, prev, pager, next, jumper"
      			:total="itemCount"
      			style="float:right;">
    	</el-pagination>
	</div>
  </body>
</html>

	<script type="text/javascript">
//		jQuery.ajaxSetup({cache:false});//ajax不缓存
//	//	jQuery(function($){
//	//		var xmlobj= $.ajax({url: '../UserControl/test',async:false});
//	//		
//	//		$("#divTest").html(xmlobj.responseText);
//	//	});
//		
//		var vm = new Vue({
//			el:"#divTest",
//			data:{
//				userList:{
//					
//				}
//			},
//			
//			//methods:{
//				created:function(){				
//				var _self = this;
//				$.ajax({
//	                url:"../UserControl/test",
//	                dataType:'json',
//	                success:function(result){
//	                	_self.userList = result;                  
//	                },
//	                error:function(){
//	                    alert("请求失败");
//	                }
//	            });				
//			}
//		  //}
//		});
    
var vm = new Vue({
	el: '#app',
	data:{
		tableData: [],
		itemCount: 0,
		pageSize: 10,
		currentPage: 1,
		isLoadingData:false
	},
	methods:{
		loadData:function(currentPageIndex, pageSize)
		{
			_self = this;
			this.isLoadingData = true;
			$.ajax({
			    url:"../UserControl/test?pageIndex=" + currentPageIndex+ "&pageSize=" + pageSize,
			    dataType:'json',
			    success:function(result){
			    	_self.tableData = result.itemList;
			    	_self.itemCount = result.totalItemCount;
			    	_self.isLoadingData = false;
			    },
			    error:function(){
			    	_self.isLoadingData = false;
			        alert("请求失败");
			    }
			});				
		},
		handleCurrentChange: function(val)
		{
			this.currentPage = val;
			vm.loadData(val, this.pageSize);
		},
		handleSizeChange: function(val)
		{
			this.pageSize = val;
			vm.loadData(this.currentPage, val);
		},
	}
});

 vm.loadData(vm.currentPage, vm.pageSize);
</script>