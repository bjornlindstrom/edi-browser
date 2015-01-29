var partnerController = angular.module('partnerController', []);

partnerController.controller(
		'homeCtrl', function($scope, $http) {
			  $http.get('/resource/').success(function(data) {
			    $scope.greeting = data;
			  })
			}
);

partnerController.controller('partnerCtrl', ['$scope', '$http',
  function ($scope, $http) {
    $http.get('/partners').success(function(data) {
      $scope.partners = data;
    });

//    $scope.orderProp = 'age';
  }]);

partnerController.controller('partnerDetailCtrl', ['$scope', '$http', '$routeParams',
  function($scope, $http, $routeParams) {
		
	$http.get('/partners/'+$routeParams.partnerId).success(function(data) {
	      $scope.partner = data;
	      $scope.backup = angular.copy(data);
	      $scope.partnerId = $routeParams.partnerId;
	});

	    $scope.saveJob = function (idx) {
	        // set the partner id to the job.
	    	$scope.partner.partnerJobs[idx].partner = {id:$scope.partner.id};
	        $http.post('/partners/savejob', $scope.partner.partnerJobs[idx])
	        .success(function(){
	        	console.log('success');
	        });
	        
	        
	    };

	    $scope.reset = function (idx) {
	    	$scope.partner.partnerJobs[idx] = $scope.backup.partnerJobs[idx];
	    };
	
}]);

partnerController.controller('headerCtrl', ['$scope', '$location',
                                            function($scope, $location) { 
    $scope.isActive = function (viewLocation) { 
        return viewLocation === $location.path();
    };
}]);