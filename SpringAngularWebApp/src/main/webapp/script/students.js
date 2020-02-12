var app=angular.module("myApp",[]);
app.controller("MyController",function($scope,$location){
    $scope.getAllCustomers=function(){
        var config={
            method:"GET",
            url:'http://localhost:8080/'
            };
var httpRequest=$http(config);
httpRequest.then(
    function successCallback(response){
        console.log(response.data);
        })
}
});