Application.$controller("wwwwwwwwPageController", ["$scope", function ($scope) {
    "use strict";

	/* perform any action on widgets within this block */
    $scope.onPageReady = function () {
		/*
		 * widgets can be accessed through '$scope.Widgets' property here
		 * e.g. to get value of text widget named 'username' use following script
		 * '$scope.Widgets.username.datavalue'
		 */
    };

}]);


Application.$controller("grid1Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);
