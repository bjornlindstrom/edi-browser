'use strict';

var errorController = angular.module('errorController', []);

errorController.controller('errorCtrl', ['$scope', '$http',
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
		$http.get('/edierror?page='+($scope.currentPage-1)+'&sort=id,desc&size='+$scope.itemsPerPage).success(function(data) {
		      $scope.data = data;		      
			  $scope.initPage(data);	
		    });
	};
	
	$scope.selectPage(0);
	
  }]);


