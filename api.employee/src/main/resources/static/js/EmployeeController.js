var app=angular.module('myApp', []);
      app.controller('EmployeeController',function ($scope, $http) {
        $scope.employee = {};

        $scope.employeeRecord = function () {
          $http.post('/add', $scope.employee)
            .then(function (response) {
              alert('Employee data saved successfully',response);
            })
            .catch(function (error) {
              console.error('Error saving employee data', error);
              
            });
        };
      });