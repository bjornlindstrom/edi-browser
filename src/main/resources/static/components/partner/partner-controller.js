'use strict';

var partnerController = angular.module('partnerController', ['partnerService']);

partnerController.controller('partnerCtrl', ['$scope', '$http',
  function ($scope, $http) {
    $http.get('/partner').success(function(data) {
      $scope.partners = data;
    });
  }]);

partnerController.controller('partnerDetailCtrl', ['$scope', '$http', '$routeParams', 'partnerService',
  function($scope, $http, $routeParams, partnerService) {
		
	$http.get('/partner/'+$routeParams.partnerId).success(function(data) {
	      $scope.partner = data;
	      $scope.backup = angular.copy(data);
	      $scope.partnerId = $routeParams.partnerId;
	});
	
	$scope.savePartner = function(event){
		partnerService.toggleButton(event.target);
		$http.post('/partner/save', $scope.partner)
        .success(function(){
        	console.log('success save partner');
        	partnerService.toggleButton(event.target);
        })
        .error(function(){
        	console.log('error save partner');
        	partnerService.toggleButton(event.target);
        });
	};
	
	$scope.resetPartner = function(){
		$scope.partner = angular.copy($scope.backup);
	};

	    $scope.saveJob = function (idx) {
	        // set the partner id to the job.
	    	$scope.partner.partnerJobs[idx].partner = {id:$scope.partner.id};
	        $http.post('/partner/savejob', $scope.partner.partnerJobs[idx])
	        .success(function(){
	        	console.log('success');
	        });
	    };

	    $scope.reset = function (idx) {
	    	$scope.partner.partnerJobs[idx] = angular.copy($scope.backup.partnerJobs[idx]);
	    };
	
}]);

