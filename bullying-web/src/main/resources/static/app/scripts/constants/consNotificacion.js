(function() {
  'use strict';

  function messageUtil($http, Notification) {
    /* jshint validthis: true */
    var vm = this;

    vm.json = {};

    $http.get("scripts/labels.json")
      .success(function(data) {
        vm.json = data;
      })
      .error(function(data) {
        vm.json = data;
      });

    vm.warning = function(mensaje) {
      Notification.warning({
        title: "Advertencia",
        message: mensaje
      });
    };

    vm.success = function(mensaje) {
      Notification.success({
        title: "Exitoso",
        message: mensaje
      });
    };

    vm.error = function(mensaje) {
      Notification.error({
        title: "Error",
        message: mensaje
      });
    };

    return vm;
  }

  angular.module('Bullying')
    .service('messageUtil', messageUtil);
})();
