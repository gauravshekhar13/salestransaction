(function() {
  var app = angular.module('crudApp', ['ui.router','ngStorage']);
  
  app.run(function($rootScope, $location, $state, LoginService) {
    $rootScope.$on('$stateChangeStart', 
      function(event, toState, toParams, fromState, fromParams){ 
          console.log('Changed state to: ' + toState + toParams);
      });
    
      if(!LoginService.isAuthenticated()) {
        $state.transitionTo('login');
      }
  });
  
  app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/home');
    
    $stateProvider
      .state('login', {
        url : '/login',
        templateUrl : 'login',
        controller : 'LoginController'
      })
      .state('home1', {
        url : '/',
        templateUrl : 'home.html',
        controller:'HomeController',
        
      })
      .state('list', {
    	  url : '/',
          templateUrl : 'partials/list',
    	  controller:'UserController',
          controllerAs:'ctrl',
          resolve: {
              users: function ($q, UserService) {
                  console.log('Load all users');
                  var deferred = $q.defer();
                  UserService.loadAllUsers().then(deferred.resolve, deferred.resolve);
                  return deferred.promise;
              }
          }

        });
  }]);

  app.controller('LoginController', function($scope, $rootScope, $stateParams, $state, LoginService) {
    $rootScope.title = "SalesCalculator";
    
    $scope.formSubmit = function() {
      if(LoginService.login($scope.username, $scope.password)) {
        $scope.error = '';
        $scope.username = '';
        $scope.password = '';
        $state.transitionTo('home1');
        
      } else {
        $scope.error = "Incorrect username/password !";
      }   
    };
    
  });
  
  
  
  
  
  app.controller('HomeController', function($scope, $rootScope, $stateParams, $state, LoginService) {
	  console.log('HomeController call');
	  if(true) {
		  console.log('state is list'); 
	  }
	  
  });
  
  
  app.factory('LoginService', function() {
    var admin = 'admin';
    var pass = 'pass';
    var isAuthenticated = false;
    
    return {
      login : function(username, password) {
        isAuthenticated = username === admin && password === pass;
        return isAuthenticated;
      },
      isAuthenticated : function() {
        return isAuthenticated;
      }
    };
    
  });
  
})();