var ediApp = angular.module('ediApp', ['ngRoute', 'partnerController']);

ediApp.config(['$routeProvider',
                    function($routeProvider) {
                      $routeProvider.
                        when('/partners', {
                          templateUrl: 'partials/partners-list.html',
                          controller: 'partnerCtrl'
                        }).
                        when('/partners/:partnerId', {
                          templateUrl: 'partials/partner-detail.html',
                          controller: 'partnerDetailCtrl'
                        }).
                        otherwise({
                          redirectTo: '/partners'
                        });
                    }]);
