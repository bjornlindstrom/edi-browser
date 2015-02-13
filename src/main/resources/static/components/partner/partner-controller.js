'use strict';

var partnerController = angular.module('partnerController', ['partnerService', 'jlareau.pnotify']);

partnerController.controller('partnerCtrl', ['$scope', '$http', 'notificationService', 
  function ($scope, $http, notificationService) {
    
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
		$http.get('/partner?page='+($scope.currentPage > 0 ? $scope.currentPage-1 : 0)+'&sort=id,asc&size='+$scope.itemsPerPage)
		.success(function(data) {
			$scope.data = data;		      
			$scope.initPage(data);	
		});
	};
	
	$scope.selectPage(0);    	
	
  }]);

partnerController.controller('partnerDetailCtrl', ['$scope', '$http', '$routeParams', 'partnerService', 'notificationService', 
  function($scope, $http, $routeParams, partnerService, notificationService) {
	var vm = this;
	
	if ($routeParams.partnerId) {
		$http.get('/partner/'+$routeParams.partnerId)
		.success(function(data) {
		      $scope.partner = data;
		      $scope.partnerId = $routeParams.partnerId;
		      for (var i = 0; i < data.partnerJobs.length; i++) {
		    	  for (var j = 0; j < data.partnerJobs[i].processes.length; j++) {
		    		  vm.loadProcessorIds(data.partnerJobs[i].processes[j].processName.id);
		    	  }
		      }
		})
		.error(function(data){
			notificationService.error("Could not get the partner: " + (data ? data.message : ''));
		});
	}
	
	$scope.savePartner = function(event){
		partnerService.toggleButton(event.target);
		
		var saveSuccess = function(){
			notificationService.success("Saved partner successfully.");
	        partnerService.toggleButton(event.target);
	    };
	    var saveError = function(data){
        	notificationService.error("Save partner failed: " + (data ? data.message : ''));
        	partnerService.toggleButton(event.target);	        
	    };
		
		if ($scope.partner.id){
			$http.put('/partner', $scope.partner)
	        .success(saveSuccess)
	        .error(saveError);
		} else {
			$http.post('/partner', $scope.partner)
	        .success(saveSuccess)
	        .error(saveError);
		}		
	};
	
	$scope.saveJob = function (idx) {
	    // set the partner id to the job.
	  	$scope.partner.partnerJobs[idx].partner = {id:$scope.partner.id};
	    
	  	$http.post('/partnerjob', $scope.partner.partnerJobs[idx])
	    .success(function(){
	       	notificationService.success("Saved job successfully.");
	    })
	    .error(function(data){
	    	notificationService.error("Save job failed: " + (data ? data.message : ''));
	    });
	};
	
	$scope.addPartnerJob = function(){
		if(!$scope.partner.partnerJobs) {
			$scope.partner.partnerJobs = [];
		}
		$scope.partner.partnerJobs.push({});
	}

	 $scope.addProcess = function(job){
		 if(!job.processes) {
			 job.processes = [];			 
		 } 
		 job.processes.push({});			
	 };
	 
	 $scope.removeProcess = function(job, idx){
		 job.processes.splice(idx, 1);
	 };
	 
	 vm.loadProcessorIds = function(processNameId){
		 if (!vm.processorIds) {
			 vm.processorIds = [];
		 }
		 if (!vm.processorIds[processNameId]) {
			 $http.get('/processorids/'+processNameId).success(function(data){
				 vm.processorIds[processNameId] = data;
			 });
		 }
	 };
	 
	 $http.get('/processnames').success(function(data){
		 vm.processNames = data;
	 });
}])
.directive('partnerJob', function(){
	
	return {
		restrict:'E',
		templateUrl: '/components/partner/partner-job.html',
		scope: true,	      
	};
});

