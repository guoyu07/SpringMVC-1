//alert('here1');
//var axios = require('axios')
var qs = require('qs');

// import * as _ from 'tool'
axios.defaults.timeout = 5000;                        //响应时间
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';           //配置请求头
axios.defaults.baseURL = 'http://localhost:8080';   //配置接口地址
//POST传参序列化(添加请求拦截器)
axios.interceptors.request.use(function(config){
	//在发送请求之前做某件事
    if(config.method === 'get'){
    	config.data = qs.stringify(config.data);
    }
    return config;
},function(error){
     // _.toast("错误的传参", 'fail');
	console.log(error);
    return Promise.reject(error);
});

//返回状态判断(添加响应拦截器)
axios.interceptors.response.use(function(res){
	//对响应数据做些事
//    if(!res.data.success){
//        // _.toast(res.data.msg);
//        return Promise.reject(res);
//    }
    return res;
}, function(error){
    // _.toast("网络异常", 'fail');
	console.log(error);
    return Promise.reject(error);
});

////返回一个Promise(发送post请求)
//function fetch(url, params) {
//    return new Promise((resolve, reject) => {
//        axios.post(url, params)
//            .then(response => {
//            	alert(response.data);
//                resolve(response.data);
//            }, err => {
//               reject(err);
//            })
//            .catch((error) => {
//               reject(error)
//            })
//    })
//}