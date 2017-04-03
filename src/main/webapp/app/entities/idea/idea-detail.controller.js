(function() {
    'use strict';

    angular
        .module('kpicsApp')
        .controller('IdeaDetailController', IdeaDetailController);

    IdeaDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Idea'];

    function IdeaDetailController($scope, $rootScope, $stateParams, previousState, entity, Idea) {
        var vm = this;

        vm.idea = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('kpicsApp:ideaUpdate', function(event, result) {
            vm.idea = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
