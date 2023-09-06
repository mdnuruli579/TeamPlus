var app=angular.module('RecordofEmployee',[])
	app.factory('employeeService', function($http) {
    return {
		index:function(){
			return $http.get('/create')
		},
        getAllEmployees: function() {
            return $http.get('http://localhost:9496/employee/');
        },
        getEmployeeById: function(id) {
            return $http.get('/details/' + id);
        },
        createEmployee: function(employee) {
            return $http.post('/add', employee);
        },
        updateEmployee: function(id, employee) {
            return $http.put('/update/' + id, employee);
        },
        deleteEmployee: function(id) {
            return $http.delete('/delete/' + id);
        }
    };
});
