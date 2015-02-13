(function() {
	'use strict';

	var ediApp = angular.module('ediApp', [ 'ui.bootstrap', 'ngRoute',
			'appDirectives', 'partnerController',
			'partnerService', 'errorController']);

	ediApp.config([ '$routeProvider', function($routeProvider) {
		$routeProvider.when('/partner', {
			templateUrl : 'components/partner/partners-list.html',
			controller : 'partnerCtrl',
			controllerAs: 'vm'
		}).when('/partner/add', {
			templateUrl : 'components/partner/partner-detail.html',
			controller : 'partnerDetailCtrl',
			controllerAs: 'vm'
		}).when('/partner/:partnerId', {
			templateUrl : 'components/partner/partner-detail.html',
			controller : 'partnerDetailCtrl',
			controllerAs: 'vm'
		}).when('/error', {
			templateUrl : 'components/error/error-list.html',
			controller : 'errorCtrl',
			controllerAs: 'vm'
		}).otherwise({
			redirectTo : '/partner'
		});
	} ])
	.config(['notificationServiceProvider', function(notificationServiceProvider) {

		notificationServiceProvider.setStack('top_left', 'stack-topleft', {
            dir1: 'down',
            dir2: 'right',
            push: 'top'
        }); 
		notificationServiceProvider.setDefaultStack('top_left');
		
		notificationServiceProvider.setDefaults({
            delay: 10000,
            buttons: {
                closer: true,
                sticker: false                
            }
        });

    }]);
}());