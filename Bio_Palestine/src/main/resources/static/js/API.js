const settings = {
	"async": true,
	"crossDomain": true,
	"url": "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/ingredients/9266/information?amount=100&unit=gram",
	"method": "GET",
	"headers": {
		"X-RapidAPI-Host": "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com",
		"X-RapidAPI-Key": "2d30ee76bfmsh7600e5a3557f3a4p1712fejsn1b766e6330dd"
	}
};

$.ajax(settings).done(function (response) {
	console.log(response);
});