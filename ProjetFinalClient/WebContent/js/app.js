var app=angular.module("myApp",[]);
app.controller("listEnfant",function($scope, $http){
	$http.get("http://localhost:8080/projetfinalserveur")
    .then(function(response) {
        $scope.enfants = response.data;
       
    })
    .catch (function(reason){
    	alert("erreur de récupération des données");
    	console.log(reason);	
    })
});

app.controller("createEnfant", function($scope, $http) {
	$scope.enfant={};
	$scope.ajouter=function(){
		$http.post("http://localhost:8080/projetfinalserveur/saveEnfant", $scope.enfant)
		.then(function(value){
			$scope.enfant=value;
		})
		.catch(function(reason){
			alert("Erreur rencontrée lors de l'ajout enfant");
			console.log(reason);
		})
	}
});
