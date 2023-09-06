angular.module('App').controller('Employee', function($scope, employeeService) {
    $scope.employees = [];

    $scope.getAllEmployees = function() {
        employeeService.getAllEmployees().then(function(response) {
            $scope.employees = response.data;
        });
    };

    $scope.getEmployeeById = function(id) {
        employeeService.getEmployeeById(id).then(function(response) {
            $scope.employee = response.data;
        });
    };

    $scope.createEmployee = function() {
        employeeService.createEmployee($scope.employee).then(function(response) {
            $scope.employee = response.data;
            $scope.getAllEmployees();
            });
    };
});
       