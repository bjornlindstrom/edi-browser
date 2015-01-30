'use strict';

var appController = angular.module('appController', []);

appController.controller('headerCtrl', ['$scope', '$location',
                                            function($scope, $location) { 
    $scope.isActive = function (viewLocation) { 
        return viewLocation === $location.path();
    };
}]);