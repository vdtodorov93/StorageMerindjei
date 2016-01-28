function VendorsController($scope, $http, services) {
	getVendors();

	$scope.submit = function() {
		var vendorName = $scope.vendorName;
		var vendorAddress = $scope.vendorAddress;
		var vendorPhone = $scope.vendorPhone;
		var vendorBankAcc = $scope.vendorBankAcc;
		var vendorObj = {
			"name" : vendorName,
			"address" : vendorAddress,
			"phoneNumber" : vendorPhone,
			"bankAccount" : vendorBankAcc
		}

		$http.post('/api/vendors', vendorObj).success(function(data) {
			clearFields()
			getVendors();
		}).error(function(err) {
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

	function clearFields() {
		$scope.vendorName = '';
		$scope.vendorAddress = '';
		$scope.vendorPhone = '';
		$scope.vendorBankAcc = '';
	}
}