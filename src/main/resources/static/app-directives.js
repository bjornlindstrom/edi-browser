'use strict';

angular.module('appDirectives', [])
.controller('alertCtrl', function ($rootScope) {
	$rootScope.alerts = [];
  
	$rootScope.addSuccess = function(msg){
		$rootScope.alerts.push({type: 'success', msg: msg});
  };
  $rootScope.addError = function(msg){
	  $rootScope.alerts.push({type: 'danger', msg: msg});
  };

  $rootScope.closeAlert = function(index) {
	  $rootScope.alerts.splice(index, 1);
  };
})
.directive('navMenu', function($location) {
  return {
	  restrict:'E',
	  templateUrl: '/components/nav-menu.html',
	  scope: false,
      link: function (scope, element) {
          
    	  function setActive() {
              var path = $location.path();
              if (path) {
                  angular.forEach(element.find('li'), function (li) {
                      var anchor = li.querySelector('a');
                      if (anchor.href.match('#' + path + '(?=\\?|$)')) {
                          angular.element(li).addClass('active');
                      } else {
                          angular.element(li).removeClass('active');
                      }
                  });
              }
          }

          setActive();

          scope.$on('$locationChangeSuccess', setActive);
      }
  };   
});