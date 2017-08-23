require.config({
		baseUrl: "./js/",
        paths: {
          "es6-promise": 'es6-promise'
        },
        shim:{   
            "es6-promise":{  
                "exports":"_"  
            }  
        }  
      });