app.controller('DeliveriesController', function DeliveriesController($scope, $http, services) {
	getMaterials();
	getVendors();

	$scope.submit = function() {
//		var materialName = $scope.materialName;
//		$http.post('/api/materials', {"name" : materialName})
//		.success(function(data) {
//			getMaterials();
//		})
//		.error(function(err) {
//			console.log(err);
//		})
	}
	
	function getMaterials() {
		services.getMaterials()
		.then(function(response) {
			$scope.materials = response;
		}, function(err) {
			console.log(err);
		})
	}
	
	function getVendors() {
		services.getVendors()
		.then(function(response) {
			$scope.vendors = response;
		}, function(err) {
			console.log(err);
		})
	}
})