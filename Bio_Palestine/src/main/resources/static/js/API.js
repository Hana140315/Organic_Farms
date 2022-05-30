const settings = {
	"async": true,
	"crossDomain": true,
	"url": "https://food-nutrition-information.p.rapidapi.com/foods/search?query=cheese&pageSize=1&pageNumber=1&brandOwner=Kar%20Nut%20Products%20Company",
	"method": "GET",
	"headers": {
		"X-RapidAPI-Host": "food-nutrition-information.p.rapidapi.com",
		"X-RapidAPI-Key": "2d30ee76bfmsh7600e5a3557f3a4p1712fejsn1b766e6330dd"
	}
};

$.ajax(settings).done(function (response) {
	console.log(response);
});
