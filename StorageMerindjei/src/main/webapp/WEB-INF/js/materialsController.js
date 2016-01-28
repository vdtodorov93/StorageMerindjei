app.controller('MaterialsController', function MaterialsController($scope, $http, services) {
	getMaterials();

	$scope.submit = function() {
		var materialName = $scope.materialName;
		$http.post('/api/materials', {"name" : materialName})
		.success(function(data) {
			getMaterials();
			clearFields();
		})
		.error(function(err) {
			console.log(err);
		})
	}
	
	function clearFields() {
		$scope.materialName = "";
	}
	
	function getMaterials() {
		services.getMaterials()
		.then(function(response) {
			$scope.materials = response;
		}, function(err) {
			console.log(err);
		})
	}
	
	$scope.useMaterial = function(materialName) {
		//I know this sucks, but I lost more than an hour -.-
		var quantity = parseFloat($('#use' + materialName).val());
		services.useMaterial(materialName, quantity)
		.then(function(response) {
			getMaterials();
		}, function(err) {
			console.log(err);
		})
	}
})