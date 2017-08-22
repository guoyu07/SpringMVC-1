requirejs.config({
		baseUrl: "js",
        paths: {
          axios: 'axios.min'
        },
        shim: {
      　　　　　　'axiosconfig': {
      　　　　　　　　deps: ['axios', 'qs'],
      　　　　　　　　exports: 'axiosconfig'
      　　　　　　}
      　　　　}		
      });

alert('here');