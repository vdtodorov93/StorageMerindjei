app.factory('services', function($http, $q) {
	return {
		getMaterials : function() {
			var deffered = $q.defer();
			$http.get('/api/materials').success(function(data) {
				deffered.resolve(data);
			}).error(function(err) {
				console.log(err);
			})
			return deffered.promise;
		},
		getVendors : function() {
			var deffered = $q.defer();
			$http.get('/api/vendors').success(function(data) {
				deffered.resolve(data);
			}).error(function(err) {
				console.log(err);
			})
			return deffered.promise;
		},
		useMaterial: function(name, quantity) {
			var deffered = $q.defer();
			var reqBody = {
				"material" : name,
				"quantity" : quantity
			}
			
			$http.post('/api/materials/quantity/use', reqBody).success(function(data) {
				deffered.resolve(data);
			}).error(function(err) {
				console.log(err);
			})
			return deffered.promise;
		},
		getDeliveries: function() {
			var deffered = $q.defer();
			$http.get('/api/deliveries').success(function(data) {
				deffered.resolve(data);
			}).error(function(err) {
				console.log(err);
			})
			return deffered.promise;
		}
	}
})