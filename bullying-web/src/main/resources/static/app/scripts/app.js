(function() {
  'use strict';

  angular
    .module('Bullying', [
      'ngResource',
      'ui.bootstrap',
      'ui-notification',
      'ui.router'
    ])


  .config(function($stateProvider, $urlRouterProvider,
    NotificationProvider, $httpProvider) {

    NotificationProvider.setOptions({
      delay: 8000,
      startTop: 60,
      startRight: 20,
      verticalSpacing: 50,
      horizontalSpacing: 50,
      positionX: 'right',
      positionY: 'top',
      replaceMessage: true
    });

    $urlRouterProvider.otherwise("/index");

    $stateProvider
    .state('index', {
        url: "/index",
        templateUrl: "scripts/modules/index.html"
      });
  });
})();
