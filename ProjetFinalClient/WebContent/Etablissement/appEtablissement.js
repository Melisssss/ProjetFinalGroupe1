// Déclaration du module Angular
var app = angular.module("appEtablissement", ["ngRoute"]);

// Barre de navigation
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "./vues/accueilEtablissement.html",
    })
    .when("/demandeFiches", {
        templateUrl : "./vues/demandeFiches.html",
        controller : "demandeFichesCtrl",
    })
     .when("/connexionEtablissement", {
        templateUrl : "./vues/connexionEtablissement.html",
        controller : "connectionCtrl",
     })
     .when("/inscriptionEtablissement", {
        templateUrl : "./vues/inscriptionEtablissement.html",
        controller : "inscriptionCtrl"
    });
});

app.controller("accueilEtablissementCtrl", function ($scope) {
    $scope.msg = "Bonjour";
});
app.controller("demandeFichesCtrl", function ($scope) {
    $scope.msg = "Bonjour";
});
app.controller("connectionCtrl", function ($scope) {
    $scope.msg = "Bonjour ";
});
app.controller("inscriptionCtrl", function ($scope) {
    $scope.msg = "I love ins";
});

app.controller('registerEstablishment',function($scope,$http){

	$scope.registerSchool=function(){
	$http.post("http://localhost:8080/projetfinalserveur/saveEcole",$scope.etablissement).then(function(value){
		$scope.etablissement = value.data;
		
	}).catch(function(reason){
		alert("erreur d'ajout etablissement");
		console.log(reason);
	})
	$http.post("http://localhost:8080/projetfinalserveur/createConnexionEtablissement",$scope.connexion).then(function(value){
		$scope.connexion = value.data;
		
	}).catch(function(reason){
		alert("erreur d'ajout connexion");
		console.log(reason);
	})
	};
	
	$scope.registerClub=function(){
		$http.post("http://localhost:8080/projetfinalserveur/saveClub",$scope.etablissement).then(function(value){
			$scope.etablissement = value.data;
			
		}).catch(function(reason){
			alert("erreur d'ajout etablissement");
			console.log(reason);
		})
		$http.post("http://localhost:8080/projetfinalserveur/createConnexionEtablissement",$scope.connexion).then(function(value){
			$scope.connexion = value.data;
			
		}).catch(function(reason){
			alert("erreur d'ajout connexion");
			console.log(reason);
		})
		};
		
	$scope.registerCentreLosirs=function(){
		$http.post("http://localhost:8080/projetfinalserveur/saveCentreLoisirs",$scope.etablissement).then(function(value){
			$scope.etablissement = value.data;
			
		}).catch(function(reason){
			alert("erreur d'ajout etablissement");
			console.log(reason);
		})
		$http.post("http://localhost:8080/projetfinalserveur/createConnexionEtablissement",$scope.connexion).then(function(value){
			$scope.connexion = value.data;
			
		}).catch(function(reason){
			alert("erreur d'ajout connexion");
			console.log(reason);
		})
		};
		
	$scope.register=function(id1,id2){
		$http.get("http://localhost:8080/projetfinalserveur/linkConnexionEtablissement",{params:  {idEtablissement : id1, idConnexion : id2}}).then(function(value){
			
		}).catch(function(reason){
			alert("erreur d'attribution");
			console.log(reason);
		})
		$scope.etablissement={};
		$scope.connexion={};
	};
	
});	
	

app.controller('connection',function($scope,$http,$rootScope){

	$scope.seConnecter=function(){
	$http.post("http://localhost:8080/projetfinalserveur/connexionEtablissement",$scope.connexion).then(function(value){
		$rootScope.rootEtablissement = value.data;
		$scope.connexion={};
	}).catch(function(reason){
		alert("Login et/ou mot de passe incorrect");
		console.log(reason);
		$scope.connexion={};
	})
	
	};
});	

//Deconnexion
app.controller('deconnection',function($scope,$rootScope){

	$scope.seDeconnecter=function(){
		$rootScope.rootResponsable = {};
		alert("Vous êtes déconnecté");
};	
})

app.controller('findAllFicheEtablissement',function($scope,$http,$rootScope){
	
	
	$scope.findAllFicheEtablissement = function(id){
		$http.get("http://localhost:8080/projetfinalserveur/findAllFichePrincipaleEtablissement",{params:  {idEtablissement : id}}).then(function(value){
			$scope.mesFichesPrincipales = value.data;
			
		}).catch(function(reason){
			alert("erreur chargement");
			$scope.mesFichesPrincipales = {};
			console.log(reason);
		})
		
		$http.get("http://localhost:8080/projetfinalserveur/findAllFicheMedicalEtablissement",{params:  {idEtablissement : id}}).then(function(value){
			$scope.mesFichesMedicales = value.data;
			
		}).catch(function(reason){
			alert("erreur chargement");
			$scope.mesFichesMedicales = {};
			console.log(reason);
		})
		
		$http.get("http://localhost:8080/projetfinalserveur/findAllFicheVaccinEtablissement",{params:  {idEtablissement : id}}).then(function(value){
			$scope.mesFichesVaccins = value.data;
			
		}).catch(function(reason){
			alert("erreur chargement");
			$scope.mesFichesVaccins = {};
			console.log(reason);
		})
		$http.get("http://localhost:8080/projetfinalserveur/findAllFicheImageEtablissement",{params:  {idEtablissement : id}}).then(function(value){
				$scope.mesFichesImages = value.data;
		}).catch(function(reason){
				alert("erreur chargement");
				$scope.mesFichesImages = {};
				console.log(reason);
			})
			
		
	};
	
	
	$scope.findAllFichePrincipaleEtablissement = function(id){
	$http.get("http://localhost:8080/projetfinalserveur/findAllFichePrincipaleEtablissement",{params:  {idEtablissement : id}}).then(function(value){
		$scope.mesFichesPrincipales = value.data;
		
	}).catch(function(reason){
		alert("erreur chargement");
		$scope.mesFichesPrincipales = {};
		console.log(reason);
	})
	};
	
	$scope.findAllFicheMedicalEtablissement = function(id){
		$http.get("http://localhost:8080/projetfinalserveur/findAllFicheMedicalEtablissement",{params:  {idEtablissement : id}}).then(function(value){
			$scope.mesFichesMedicales = value.data;
			
		}).catch(function(reason){
			alert("erreur chargement");
			$scope.mesFichesMedicales = {};
			console.log(reason);
		})
		};
		$scope.findAllFicheVaccinEtablissement = function(id){
			$http.get("http://localhost:8080/projetfinalserveur/findAllFicheVaccinEtablissement",{params:  {idEtablissement : id}}).then(function(value){
				$scope.mesFichesVaccins = value.data;
				
			}).catch(function(reason){
				alert("erreur chargement");
				$scope.mesFichesVaccins = {};
				console.log(reason);
			})
			};
			$scope.findAllFicheImageEtablissement = function(id){
				$http.get("http://localhost:8080/projetfinalserveur/findAllFicheImageEtablissement",{params:  {idEtablissement : id}}).then(function(value){
					$scope.mesFichesImages = value.data;
					
				}).catch(function(reason){
					alert("erreur chargement");
					$scope.mesFichesImages = {};
					console.log(reason);
				})
				};
			
	
	$scope.dissocier = function(id1,id2){
    	$http.get("http://localhost:8080/projetfinalserveur/unLinkFicheEtablissement",{params:  {idFiche : id1, idEtablissement : id2}})
    	.then(function(response){
    		$scope.findAllFicheEtablissement(id2)
    	})
    	.catch(function(reason) {
			alert("Echec dissociation");
			console.log(reason);
		})
    }
	
});
	
	
app.controller('findAllFiche',function($scope,$http,$rootScope){
	$scope.findAllFiche = function(){
		$http.get("http://localhost:8080/projetfinalserveur/findAllFiche").then(function(value){
			$scope.fiches= value.data;
			
		}).catch(function(reason){
			alert("erreur chargement");
			$scope.fiches = {};
			console.log(reason);
		})
		};
		$scope.demande = function(id1,id2,id3){
	    	$http.get("http://localhost:8080/projetfinalserveur/demande",{params:  {idEtablissement : id1, idFiche : id2, idEnfant : id3}})
	    	.then(function(response){
	    		
	    	})
	    	.catch(function(reason) {
				alert("Echec association");
				console.log(reason);
			})
	    }
		
	
});


