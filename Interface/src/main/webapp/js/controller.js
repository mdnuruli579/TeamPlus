
var baseurl='http://localhost:9496/employee';
var app=angular.module('MyApp',['ngRoute']);
app.config(function($routeProvider){
	$routeProvider.when('/',{
		templateUrl: 'views/home.html',
		controller: 'Employee'
	})
	.when('/add',{
		templateUrl: 'views/add.html',
        controller: 'AddEmployee'
	})
	.when('/details/:id',{
		templateUrl: 'views/details.html',
        controller: 'DetailsEmployee'
	})
	.when('/update/:id',{
		templateUrl: 'views/update.html',
        controller: 'UpdateEmployee'
	});
});

app.controller('Employee',function($scope,employeeService){
	$scope.employees = [];
    $scope.getAllEmployees = function() {
       	 employeeService.getAllEmployees().then(function(response) {
            $scope.employees = response.data;
            
        }).catch(function(error) {
          console.log('Error fetching employee records:', error);
          }); 
    };
    $scope.deleteEmployee=function(id){
		var index=this.$index;
		employeeService.deleteEmployee(id).then(function(){
			alert('Data Deleted Sucessfully');	
		});
		$scope.employees.splice(index,1);
	};
	$scope.getAllEmployees();
});
app.controller('AddEmployee',function($scope,employeeService,$window){
	$scope.employees={};
	$scope.createEmployee=function(){
		employeeService.createEmployee($scope.employees).then(function(response){
			$scope.employees=response.data.records;
			console.log(employees);
			alert('Data Saved Sucessfully');
			$window.location.href = '/';
		});
	};
});

app.controller('DetailsEmployee',function($scope,$routeParams,employeeService){
		$scope.details={};
		$scope.id = $routeParams.id;
		$scope.employeeDetails = function() {
			employeeService.getEmployeeById($scope.id).then(function(response) {
			$scope.details=response.data;
			//console.log($scope.details);
        })
        .catch(function(error) {
          console.log('Data Not fetching:', error);
        });
  	 };
  	 $scope.employeeDetails();
});

app.controller('UpdateEmployee',function($scope,$routeParams,employeeService){
	$scope.val=$routeParams.id;
	$scope.update={};
	$scope.allDetails=function(){
		employeeService.getEmployeeById($scope.val).then(function(response) {
			$scope.update=response.data;
			console.log($scope.update);
        })
        .catch(function(error) {
          console.log('Data Not fetching:', error);
        });
	};
	$scope.allDetails();
	$scope.updateEmployee=function(){
		employeeService.updateEmployee($scope.val,$scope.update).then(function(response){
			$scope.update=response.data;
			console.log($scope.update);
		});
	};
});


app.service('employeeService', function($http) {
    return {
        getAllEmployees: function() {
            return $http.get(baseurl+'/');
        },
        getEmployeeById: function(id) {
            return $http.get(baseurl+'/details/' + id);
        },
        createEmployee: function(obj) {
            return $http.post(baseurl+'/add',obj);
        },
        updateEmployee: function(id, employee) {
            return $http.put(baseurl+'/update/' + id, employee);
        },
        deleteEmployee: function(id) {
            return $http.delete(baseurl+'/delete/' + id);
        }
    };
});