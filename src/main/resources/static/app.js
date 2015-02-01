'use strict';

var ediApp = angular.module('ediApp', ['ui.bootstrap',
                                       'ngRoute', 
                                       'appController', 
                                       'partnerController', 
                                       'partnerService',
                                       'errorController']);

ediApp.config(['$routeProvider',
                    function($routeProvider) {
                      $routeProvider.
                        when('/partner', {
                          templateUrl: 'components/partner/partners-list.html',
                          controller: 'partnerCtrl'
                        }).
                        when('/partner/:partnerId', {
                          templateUrl: 'components/partner/partner-detail.html',
                          controller: 'partnerDetailCtrl'
                        }).
                        when('/error', {
                            templateUrl: 'components/error/error-list.html',
                            controller: 'errorCtrl'
                          }).
                        otherwise({
                          redirectTo: '/partner'
                        });
                    }]);
