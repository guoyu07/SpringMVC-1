<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帐号登录</title>
<script language="javascript" type="text/javascript" src="${ctx}/components/icon-svg.vue"></script>
<script language="javascript" type="text/javascript" src="${ctx}/components/iconfont.js"></script>
</head>
<body>
  <el-form id="loginForm" :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-position="left" label-width="0px" class="demo-ruleForm login-container">
    <h3 class="title">系统登录</h3>
    <el-form-item prop="account">
      <span class="svg-container"><icon-svg icon-class="jiedianyoujian"></icon-svg></span>
      <el-input type="text" v-model="ruleForm2.account" auto-complete="off" placeholder="帐号"></el-input>
    </el-form-item>
    <el-form-item prop="checkPass">
      <span class="svg-container"><icon-svg icon-class="mima"></icon-svg></span>
      <el-input type="password" v-model="ruleForm2.checkPass" auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-checkbox v-model="checked" checked class="remember">记住密码</el-checkbox>
    <el-form-item style="width:100%;">
      <el-button type="primary" style="width:100%;" @click.native.prevent="handleSubmit2" :loading="logining">登录</el-button>
      <!--<el-button @click.native.prevent="handleReset2">重置</el-button>-->
    </el-form-item>
  </el-form>
</body>
</html>

<script type="text/javascript">  
 var vm = new Vue({
	el: '#loginForm',
 	data:{
        logining: false,
        ruleForm2: {
          account: '',
          checkPass: ''
        },
        rules2: {
          account: [
            { required: true, message: '请输入帐号', trigger: 'blur' },
            //{ validator: validaePass }
          ],
          checkPass: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            //{ validator: validaePass2 }
          ]
        },
        checked: true
      },
    methods: {
      handleReset2:function() {
        this.$refs.ruleForm2.resetFields();
      },
      handleSubmit2:function(ev) {
        var _this = this;
        this.$refs.ruleForm2.validate(function(valid){
          if (valid) {
            //_this.$router.replace('/table');
            this.logining = true;
            //NProgress.start();
            var loginParams = { username: this.ruleForm2.account, password: this.ruleForm2.checkPass };
            requestLogin(loginParams).then(function(data){
              this.logining = false;
              //NProgress.done();
              //let { msg, code, user } = data;
              if (code !== 200) {
                this.$message({
                  message: msg,
                  type: 'error'
                });
              } else {
                sessionStorage.setItem('user', JSON.stringify(user));
                this.$router.push({ path: '/table' });
              }
            });
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      }
    }
  })
 
 
</script>

<style lang="scss" scoped>
  .login-container 
  {
    /*box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);*/
    -webkit-border-radius: 5px;
    border-radius: 5px;
    -moz-border-radius: 5px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  
  .title 
  {
      margin: 0px auto 40px auto;
      text-align: center;
      color: #505458;
  }
  
  .remember
  {
      margin: 0px 0px 35px 0px;
  }
  
  .svg-container {
      padding: 6px 5px 6px 15px;
      color: #889aa4;
    }
    
    .login-container .el-input 
    {
		display: inline-block;
		height: 35px;
		width: 85%;
	}
    
  .svg-icon 
  {
	width: 1em;
	height: 1em;
	vertical-align: -.15em;
	fill: currentColor;
	overflow: hidden;
	}
	
    .svg-container {
      padding: 6px 5px 6px 15px;
      color: #889aa4;
    }
    
   .el-input__inner 
   {      
      border: 0px;
      -webkit-appearance: none;
      border-radius: 5px;
      padding: 12px 5px 12px 15px;
      height: 35px;
      width:307px;
    }
    
    .login-form {
      position: absolute;
      left: 0;
      right: 0;
      width: 350px;
      padding: 35px 35px 15px 35px;
      margin: 120px auto;
    }
    .el-form-item {
      border: 1px solid #bfcbd9;
      border-radius: 5px;
      color: #454545;
    }
</style>