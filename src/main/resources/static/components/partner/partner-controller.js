'use strict';

var partnerController = angular.module('partnerController', ['partnerService']);

partnerController.controller('partnerCtrl', ['$scope', '$http',
  function ($scope, $http) {
    
	$scope.itemsPerPage = 10;

	$scope.initPage = function(data){
		if(data){
			$scope.totalItems = $scope.data.totalElements;
			// backend paging is 0 based.
			$scope.currentPage = $scope.data.number+1;
			$scope.numPages = $scope.data.totalPages;
		}
	}
	
	$scope.selectPage = function() {		
		$http.get('/partner?page='+($scope.currentPage > 0 ? $scope.currentPage-1 : 0)+'&sort=id,asc&size='+$scope.itemsPerPage).success(function(data) {
		      $scope.data = data;		      
			  $scope.initPage(data);	
		    });
	};
	
	$scope.selectPage(0);
    
  }]);

partnerController.controller('partnerDetailCtrl', ['$scope', '$http', '$routeParams', 'partnerService',
  function($scope, $http, $routeParams, partnerService) {
		
	$http.get('/partner/'+$routeParams.partnerId)
	.success(function(data) {
	      $scope.partner = data;
	      $scope.backup = angular.copy(data);
	      $scope.partnerId = $routeParams.partnerId;
	})
	.error(function(data){
		console.log(data);
	});
	
	$scope.savePartner = function(event){
		partnerService.toggleButton(event.target);
		$http.post('/partner', $scope.partner)
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
	        $http.post('/partnerjob', $scope.partner.partnerJobs[idx])
	        .success(function(){
	        	console.log('success');
	        });
	    };

	    $scope.reset = function (idx) {
	    	$scope.partner.partnerJobs[idx] = angular.copy($scope.backup.partnerJobs[idx]);
	    };
	    
}])
.directive('partnerJob', function(){
	
	return {
		  restrict:'E',
		  templateUrl: '/components/partner/partner-job.html',
		  scope: true,	      
	};
});

