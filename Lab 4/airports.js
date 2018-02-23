var baseURI = "http://localhost:8080/waslab04";


function showAirports () {
   var country = document.getElementById("countryName").value;

   // Replace the two lines below with your implementation
   //var mock_text = "You should show a list of clickable airports of " + country;
   //document.getElementById("left").innerHTML = mock_text;

   var uri = baseURI+"/airport_names.php";
   var req = new XMLHttpRequest();
   req.open("GET", uri+"?country="+country, true);
   req.onreadystatechange = function () {
   		if (req.readyState == 4 && req.status == 200) {
   			var airports_list = req.responseText;
   			var airports = JSON.parse(airports_list);
   			var html = "";
   			document.getElementById("left").innerHTML = html;
   			for (i = 0; i < airports.length; i++) {
   				var name = airports[i].name;
   				var code = airports[i].code;
   				html += "<p><a href='#' onClick = showAirportInfo('"+code+"')>"+name+" ("+code+")</a></p>";
   			}
   			document.getElementById("left").innerHTML = html;
   			document.getElementById("right").innerHTML = "<-- Select an airport from the left menu";
   		}
   		else {
   			document.getElementById("left").innerHTML = "<p>Error "+req.readyState+"</p>";
   		}
   };
   req.send(null);
};


function showAirportInfo (code) {
	var uri = baseURI+"/airport_info.php";
	var req = new XMLHttpRequest();
    req.open("GET", uri+"?code="+code, true);
    req.onreadystatechange = function () {
   		if (req.readyState == 4 && req.status == 200) {
   			var info = JSON.parse(req.responseText);
   			var html = "";
   			html += "<h2>Airport of " + info.CityOrAirportName + " (" + info.AirportCode + ")</h2>";
   			html += "<ul><li>Runway Length: <b>" + info.RunwayLengthFeet + "</b> feet</li>";
   			html += "<li>Runway Elevation: <b>" + info.RunwayElevationFeet + "</b> feet</li>";
   			html += "<li>Coordinates: <b>" + info.LatitudeDegree + "&deg" + info.LatitudeMinute + "'" + info.LatitudeSecond + "\" " + info.LatitudeNpeerS + ", ";
   			html += info.LongitudeDegree + "&deg" + info.LongitudeMinute + "'" + info.LongitudeSeconds + "\" " + info.LongitudeEperW + "</b></li></ul>";
   			document.getElementById("right").innerHTML = html;
   		}
    };
    req.send(null);
}

window.onload = showAirports();
