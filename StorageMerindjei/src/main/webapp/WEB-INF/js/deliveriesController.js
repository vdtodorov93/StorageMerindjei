app.controller('DeliveriesController', function DeliveriesController($scope, $http, services) {
	getMaterials();
	getVendors();
	getDeliveries();

	$scope.submit = function() {
		var deliveryObject = {};
		deliveryObject["vendor"] = $scope.selectedVendor.name;
		deliveryEntities = [];
		var container = $('#newdelivery');
	    var count = container.find('tr').length;
	    for(var i = 1; i < count; i++) {
	    	var material = $('#material' + i).val();
	    	var typematerial = $('#typematerial' + i).val();
	    	var color = $('#color' + i).val();
	    	var quantity = parseFloat($('#quantity' + i).val());
	    	var price = $('#price' + i).val();
	    	if(price == '' || quantity == '' || material == '') {
	    		continue;
	    	}
	    	var entityObj = {
	    		"material" : material,
	    		"type" : typematerial,
	    		"quantity" : quantity,
	    		"color" : color,
	    		"price" : price
	    	}
	    	deliveryEntities.push(entityObj);
	    }
		
	    deliveryObject["deliveryEntities"] = deliveryEntities;
	    if(deliveryEntities.length == 0) {
	    	return;
	    }
		
		$http.post('/api/deliveries', deliveryObject)
		.success(function(data) {
			getDeliveries();
		})
		.error(function(err) {
			console.log(err);
		})
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
	
	function getDeliveries() {
		services.getDeliveries()
		.then(function(response) {
			$scope.deliveries = response;
		}, function(err) {
			console.log(err);
		})
	}
})