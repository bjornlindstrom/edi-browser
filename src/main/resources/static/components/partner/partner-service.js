'use strict';

var partnerService = angular.module('partnerService', []);

partnerService.factory('partnerService', [function(){
	
	return {
		toggleButton: function(btn){	
			if (btn.hasAttribute('disabled')) {
				btn.removeAttribute('disabled');
			}
			else {
				btn.setAttribute('disabled', 'disabled');
			}
		}
	}
	
}]);