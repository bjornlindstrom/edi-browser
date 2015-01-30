'use strict';

var errorController = angular.module('errorController', []);

errorController.controller('errorCtrl', ['$scope', '$http',
  function ($scope, $http) {
    $http.get('/edierror').success(function(data) {
      $scope.errors = data;
    });
  }]);


