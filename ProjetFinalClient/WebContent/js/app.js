var app=angular.module("myApp",[]);


app.controller("createResponsable", function($scope,$http){
	$scope.createresponsable={};
	$scope.createResponsable = function(){
		$http.post("http://localhost:8080/projetfinalserveur/saveResponsable", $scope.createresponsable)
		.then(function(value){
			$scope.createresponsable=value.data;
			location.reload();
		})
		.catch(function(reason){
			alert("Erreur générée lors de l'ajout d'un responsable");
			console.log(reason);
		})
	}
})

//app.controller("authentificationResponsable", function($scope, $http){
//	$scope.responsable={};
//	$scope.authentifier=function(){
//		$http.post("http://localhost:8080/projetfinalserveur/getResponsable", $scope.responsable)
//		.then(function(response){
//			$scope.responsable=response.data;
//			})
//	}
//});


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
	$scope.enfantTest={};
	$scope.ajouter=function(){
		$http.post("http://localhost:8080/projetfinalserveur/saveEnfant", $scope.enfantTest)
		.then(function(value){
			$scope.enfantTest=value;
		})
		.catch(function(reason){
			alert("Erreur générée lors de l'ajout enfant");
			console.log(reason);
		})
	}
});

app.controller("attribuer", function($scope, $http) {
	$scope.enfant={};
	$scope.representant={};
	$scope.authentifier=function(){
		$http.post("http://localhost:8080/projetfinalserveur/getResponsable", $scope.responsable)
		.then(function(response){
			$scope.responsable=response.data;
			})
	};
	$scope.attribuerResponsable=function(){
		$http.post("http://localhost:8080/projetfinalserveur/attribuerResponsable",$scope.enfant)
		.then(function(){
		})
		.catch(function(reason){
			alert("Erreur générée lors de l'attribution enfant");
			console.log(reason);
		})
	}
});
app.controller("updateEnfant", function($scope, $http) {
		$scope.enfant={};
		$scope.ajouter=function(){
			$http.post("http://localhost:8080/projetfinalserveur/updateEnfant", $scope.enfant)
			.then(function(){
			})
			.catch(function(reason){
				alert("Erreur générée lors de la modification enfant");
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

app.controller("connexionCtrl" ,function($scope,$http){

	$scope.demandeconnexion = function(){
		$http.post("URL/CO",$scope.connexion)
		var verificationConnexion = $get("URL/CO")
		if ( connexion.login == verificationConnexion.loign
				&& connexion.mdp == verificationConnexion.mdp){}
			then(function(response) {
		        $scope.responsable = response.data;
		    })
		    .catch(function(reason){
		    	alert("Erreur de connexion, le mot de passe ou le login sont invalide");
		    	console.log(reason);
		});
	}
})


/*CREATION DES FICHES, modif, suppression*/
app.controller("createFicheP", function($scope,$http){
	$scope.ficheP = {};
	$scope.createFicheP = function(){
		$http.post("http://localhost:8080/projetfinalserveur/saveFichePrincipale", $scope.ficheP)
		.then(function(value){
			$scope.enfant=value.data;
			location.reload();
		})
		.catch(function(reason){
			alert("Erreur générée lors de l'ajout d'un responsable");
			console.log(reason);
		})
	}
})
app.controller("infoEnfant", function($scope,$http){
	$http.get("http://localhost:8080/projetfinalserveur/saveEnfant")
	$http.get("http://localhost:8080/projetfinalserveur/saveMere")
	$http.get("http://localhost:8080/projetfinalserveur/savePere")
	.then(function(response) {
        $scope.enfant = response.data;
        $scope.mere = response.data;
        $scope.pere = response.data;
    })
    .catch(function(reason){
    	alert("echec recuperation informations enfant");
    	console.log(reason);
    });
})


app.controller("createFicheV", function($scope,$http){
	$scope.ficheV = {};
	$scope.createFicheV = function(){
		$http.post("http://localhost:8080/projetfinalserveur/saveFicheVaccin", $scope.ficheV)
		.then(function(value){
			$scope.enfant=value.data;
			location.reload();
		})
		.catch(function(reason){
			alert("Erreur générée lors de l'ajout d'un responsable");
			console.log(reason);
		})
	}
})
app.controller("createFicheM", function($scope,$http){
	$scope.ficheM = {};
	$scope.createFicheM = function(){
		$http.post("http://localhost:8080/projetfinalserveur/saveFicheMedical", $scope.ficheM)
		.then(function(value){
			$scope.enfant=value.data;
		})
		.catch(function(reason){
			alert("Erreur générée lors de l'ajout d'un responsable");
			console.log(reason);
		})
	}
})
app.controller("createFicheI", function($scope,$http){
	$scope.ficheI = {};
	$scope.createFicheI = function(){
		$http.post("http://localhost:8080/projetfinalserveur/saveFicheImage", $scope.ficheI)
		.then(function(value){
			$scope.enfant=value.data;
			location.reload();
		})
		.catch(function(reason){
			alert("Erreur générée lors de l'ajout d'un responsable");
			console.log(reason);
		})
	}
})