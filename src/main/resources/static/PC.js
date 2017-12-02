var app = angular.module('pc', []);

app.controller('PcController', function($scope, $http, $location) {	  
	

function changeMarkerPosition(marker, lat , lng) {
		var latlng = new google.maps.LatLng(lat, lng);
		marker.setPosition(latlng);
	}
	  
      $scope.initMap = function () {
		  alert("init");
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 3,
          center: {lat: 0, lng: -180},
          mapTypeId: 'terrain'
        });
		
		// Init path from source
		var latitude= 31.772, longitude = 30.214;
		var flightPlanCoordinates = [];
		var i = 0 ;
		var flightPath = new google.maps.Polyline({
			  path: flightPlanCoordinates,
			  geodesic: true,
			  strokeColor: '#FF0000',
			  strokeOpacity: 1.0,
			  strokeWeight: 2
			});
		flightPlanCoordinates.push({lat: latitude , lng: longitude}) ;
		  var marker = new google.maps.Marker({
			position: {lat: latitude , lng: longitude},
			map: map,
			title: 'Hello World!'
		  });
		flightPath.setMap(map);

		while (latitude >= -90 && longitude <=180)
		{
					
			// get existing path
			var path = flightPath.getPath();
			// add new point
			path.push(new google.maps.LatLng(latitude, longitude));
			// Update Path
			flightPath.setPath(path);
			
			changeMarkerPosition(marker , latitude , longitude) ;
			function getPosition() {
			    var url = "/getCurrentLocation";
			    $http.get(url, config).then(function (Location) {
			    	$scope.position = Location.data;
			    	$scope.lat = $scope.position.lat;
			    	$scope.lon = $scope.position.lon;
			    	 
			         }, function (sendLocation) {
			             $scope.boolean = "Fail!";
			             
			         });
			}
			
			
			latitude = $scope.lat ;
			longitude= $scope.lon;
			

		}
	  }
	    
});