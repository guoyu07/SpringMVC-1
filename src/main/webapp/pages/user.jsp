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
		      <el-table-column prop="loginName" label="登录帐户" width="180">
		      </el-table-column>
		      <el-table-column prop="name" label="用户姓名" width="180">
		      </el-table-column>
		      <el-table-column prop="email" label="email">
		      </el-table-column>
		      <el-table-column prop="officePhone" label="办公室电话">
		      </el-table-column>
		      <el-table-column prop="mobilePhone" label="移动电话">
		      </el-table-column>
		      <el-table-column prop="dataState" label="帐户状态">
		      </el-table-column>
		      <el-table-column prop="createTime" label="创建时间"
		      :formatter="dateFormate">
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
//			$.ajax({
//			    url:"../UserControl/test?pageIndex=" + currentPageIndex+ "&pageSize=" + pageSize,
//			    dataType:'json',
//			    success:function(result){
//			    	_self.tableData = result.itemList;
//			    	_self.itemCount = result.totalItemCount;
//			    	_self.isLoadingData = false;
//			    },
//			    error:function(){
//			    	_self.isLoadingData = false;
//			        alert("请求失败");
//			    }
//			});


			axios.post("/SpringMVC/AccountControl/test", {pageIndex: currentPageIndex, pageSize: pageSize})
				  .then(function (response) {
				    _self.tableData = response.data.itemList;
				    _self.itemCount = response.data.totalItemCount;
				    _self.isLoadingData = false;
				    console.info(response);
				  })
				  .catch(function (error) {
					 _self.isLoadingData = false;
				    console.error(error);
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
		 //时间格式化
        dateFormate:function(row, column) {
	           var date = row[column.property];
		      if (date == undefined) {
		         return "";
		      }
		      return moment(date).format("YYYY-MM-DD");
        }
	}
});

 vm.loadData(vm.currentPage, vm.pageSize);
</script>
