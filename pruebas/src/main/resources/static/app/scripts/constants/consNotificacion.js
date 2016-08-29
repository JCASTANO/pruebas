(function() {
  'use strict';

  function messageUtil($http, Notification) {
    /* jshint validthis: true */
    var vm = this;

    vm.constants = {};

    $http.get("scripts/constants.json")
      .success(function(data) {
        vm.constants = data;
      })
      .error(function(data) {
        vm.constants = data;
      });

    vm.warning = function(mensaje) {
      Notification.warning({
        title: vm.constants.generales.advertencia,
        message: mensaje
      });
    };

    vm.success = function(mensaje) {
      Notification.success({
        title: vm.constants.generales.exitoso,
        message: mensaje
      });
    };

    vm.error = function(mensaje) {
      Notification.error({
        title: vm.constants.generales.error,
        message: mensaje
      });
    };

    return vm;
  }

  angular.module('Pruebas')
    .service('messageUtil', messageUtil);
})();
