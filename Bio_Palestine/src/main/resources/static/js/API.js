   
   function api(){
    var productName=document.getElementById('productName');
    const settings = {
    				"async": true,
    				"crossDomain": true,
    				"url": "https://food-nutrition-information.p.rapidapi.com/foods/search?query="+productName,
    				"method": "GET",
    				"headers": {
    					"X-RapidAPI-Host": "food-nutrition-information.p.rapidapi.com",
    					"X-RapidAPI-Key": "67cbb8aa11mshfa39987e8db24fcp1f9323jsn984d9d5d4e7c"
    				}
    			};

    			$.ajax(settings).done(function (response) {
    				var result=response;
    				/*for(var i=0;i<result.foods.length;i++){*/
    					for(var j=0;j<result.foods[0].foodNutrients.length;j++){
    					console.log(result.foods[0].foodNutrients[5].nutrientName);
    					document.getElementById('fact').innerHTML=result.foods[0].foodNutrients[5].nutrientName;
    					}
    					/*for(var j=0;j<result.foods.foodNutrients;j++){
    				console.log(result.foods[i].foodNutrients[j].nutrientName);
    				}*/
    				
    				/*for(var i=0;i<result.foods.length;i++){
    					for(var j=0;j<result.foods[i].foodNutrients;j++){
    	    		/*console.log(result.foods[i].foodNutrients);
    	    		console.log(result.foods[i].foodNutrients[j].nutrientName);
    	    		document.getElementById('fact').innerHTML=result;
    				}
    				}*/
    			});



};

api(); 