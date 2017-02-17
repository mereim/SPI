angular.module('app').controller('FormationCtrl', [
			'$scope',
			'$http',
			function($scope, $http) {

				$http.get("http://localhost:8090/formation").then(
						function(response) {

							$scope.formations = response.data;

						});

			} ]);

angular.module('app').controller('AfficherFormationCtrl', [ '$scope', '$http',
			'$routeParams', function($scope, $http, $routeParams) {
				var lien = "http://localhost:8090/formation/" + $routeParams.code;
				$http.get(lien).then(function(response) {
					$scope.formation = response.data;
					
					switch($scope.formation.diplome) {
					case 'L':
						$scope.formation.diplome = "Licence";
						break;
					case 'M':
						$scope.formation.diplome = "Master";
						break;
					case 'D':
						$scope.formation.diplome = "Doctorat";
						break;
				}
					
					
					
					
					
				});
			} ]);
	
angular.module('app').controller('SupprimerFormationCtrl',['$scope','$http','$routeParams',function($scope, $http, $routeParams){
		var lien = "http://localhost:8090/formation/" + $routeParams.code;
		$http.delete(lien);
	}]);
	
angular.module('app').controller('AjouterFormationCtrl',['$scope','$http','$location',function($scope,$http,$location){
		
		$scope.formation={
				codeFormation : "",
  				nomFormation : "",
  				diplome : "",
  				estUnDoubleDiplome : false,
  				nombreDAnnee : "",
  				debutAccreditation : "",
  				finAccreditation : ""
		}
		$scope.ajouterFormation = function(){
			console.log($scope.formation);
  			$scope.formation["Content-Type"] = "application/json";
  			var clientUrl = '/formation';
  			var request = $http({
  				method: "POST",
  				url: clientUrl,
  				data: $scope.formation
  			});
  			request.success(
  				function(response) {
  					$location.path('/formation');
  				}
  			);
  		}
		
	}]);

angular.module('app').controller('ModifierFormationCtrl',['$scope','$http','$routeParams','$location',function($scope,$http, $routeParams, $location){
	
	var lien = "http://localhost:8090/formation/" + $routeParams.code;
	
	$http.get(lien).then(function(response) {
		$scope.formation = response.data;
		
	});
	$scope.modifierFormation = function(){
		
		$scope.formation["Content-Type"] = "application/json";
		var clientUrl='/formation/'+ $routeParams.code;
		var request = $http({
			method : "PUT",
			url : clientUrl,
			data : $scope.formation
		});
		request.success(
  				function(response) {
  					$location.path('/formation');
  				}
  			);
	}
	
	
	
}]);














