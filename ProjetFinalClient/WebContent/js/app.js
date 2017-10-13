var app=angular.module("myApp",[]);

app.controller("authentificationResponsable", function($scope, $http){
	$scope.responsable={};
	$scope.authentifier=function(){
		$http.post("http://localhost:8080/projetfinalserveur/getResponsable", $scope.responsable)
		.then(function(response){
			$scope.responsable=response.data;
			})
	}
});


app.controller("listEnfant",function($scope, $http){
	$http.get("http://localhost:8080/projetfinalserveur/listEnfant")
    .then(function(response) {
        $scope.enfants = response.data;
       
    })
    .catch (function(reason){
    	alert("Erreur de récupération des données");
    	console.log(reason);	
    })
});

app.controller("createEnfant", function($scope, $http) {
	$scope.enfant={};
	$scope.ajouter=function(){
		$http.post("http://localhost:8080/projetfinalserveur/saveEnfant", $scope.enfant)
		.then(function(value){
			$scope.enfant=response.data;
		})
		.catch(function(reason){
			alert("Erreur générée lors de l'ajout enfant");
			console.log(reason);
		})
	}
});
app.controller("updateEnfant", function($scope, $http) {
	$scope.enfant.monResponsable=$scope.responsable;
	$scope.attribuerResponsabler=function(){
		$http.post("http://localhost:8080/projetfinalserveur/updateEnfant", $scope.enfant)
		.then(function(){
		})
		.catch(function(reason){
			alert("Erreur générée lors de l'ajout enfant");
			console.log(reason);
		})
	}
});


//app.controller("attribuer", function($scope, $http) {
//	$scope.attribuerResponsable=function(){
//		$http.post("http://localhost:8080/projetfinalserveur/linkEnfantResponsable", $scope.idEnfant, $scope.idUser)
//		.then(function(){
//			alert("Attribution ok");
//		})
//		.catch(function(reason){
//			alert("Erreur générée lors de l'attribution d'un responsable à l'enfant");
//			console.log(reason);
//		})
//	}
//});

//listEnfantResponsable