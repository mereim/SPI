(function() {
	'use strict';
	var app = angular.module(
			'app',
			[ 'ngRoute', 'ngAnimate', 'ui.bootstrap', 'easypiechart',
					'mgo-angular-wizard', 'textAngular', 'ui.tree',
					'ngTagsInput']).config(
			[ '$routeProvider', function($routeProvider,$urlRouterProvider) {
				$routeProvider
				.when('/formations',{
					templateUrl : 'views/ListeFormations.html',
					controller : 'FormationCtrl',
					controllerAs : 'ListeFormations'
				})
				.when('/AfficherFormation/:code',{
					templateUrl : 'views/AfficherFormation.html',
					controller : 'AfficherFormationCtrl'
				})
				.when('/SupprimerFormation/:code',{
					templateUrl : 'views/SupprimerFormation.html',
					controller : 'SupprimerFormationCtrl'
				})
				.when('/AjouterFormation',{
					templateUrl : 'views/AjouterFormation.html',
					controller : 'AjouterFormationCtrl'
				})
				.when('/modifierFormation/:code',{
					templateUrl : 'views/modifierFormation.html',
					controller : 'ModifierFormationCtrl'
				})
				.otherwise({
					redirectTo : '/'
				});
				
			} ]
    );

}).call(this);
