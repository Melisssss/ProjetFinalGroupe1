// Déclaration du module Angular
var app = angular.module("myApp", ["ngRoute"]);

// Barre de navigation
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "accueil.html",
    })
    .when("/administrateur", {
        templateUrl : "Administrateur/indexAdministrateur.html",
        controller : "administrateurCtrl",
    })
     .when("/etablissement", {
        templateUrl : "Etablissement/indexEtablissement.html",
        controller : "etablissementCtrl",
    })
     .when("/responsable", {
        templateUrl : "Responsable/indexResponsable.html",
        controller : "responsableCtrl",
     })
     .when("/connexion", {
        templateUrl : "connexion.html",
        controller : "connectionCtrl",
     })
     .when("/inscription", {
        templateUrl : "inscription.html",
        controller : "inscriptionCtrl"
    });
});

app.controller("administrateurCtrl", function ($scope) {
    $scope.msg = "Bonjour Admin";
});
app.controller("etablissementCtrl", function ($scope) {
    $scope.msg = "Bonjour Etablissement";
});
app.controller("responsableCtrl", function ($scope) {
    $scope.msg = "Bonjour Responsable";
});
app.controller("connectionCtrl", function ($scope) {
    $scope.msg = "I love con";
});
app.controller("inscriptionCtrl", function ($scope) {
    $scope.msg = "I love ins";
});

//Connexion
app.controller('testConnexion',function($scope,$http,$rootScope){
	$scope.log = function(){
	$http.post("http://localhost:8080/projetfinalserveur/findResponsable",$scope.connexion)
	.then(function(value) {
		$scope.responsable = value.data;
		$rootScope.responsable = value.data;
	}).
	catch(function(reason) {
		alert("Erreur lors de la connexion");
	});
	}
});

//CRUD enfants

/*creation Enfant*/
app.controller("createEnfant", function($scope, $http) {
	$scope.enfantTest={};
	$scope.creer=function(){
		$http.post("http://localhost:8080/projetfinalserveur/saveEnfant", $scope.enfantTest)
		.then(function(value){
			$scope.enfantTest=value;
		})
		.catch(function(reason){
			alert("Erreur générée lors de l'ajout d'enfant");
			console.log(reason);
		})
	}
});

/*listing et suppression Enfant*/
app.controller("listEnfant",function($scope, $http){
	$http.get("http://localhost:8080/projetfinalserveur/listEnfant")
    .then(function(response) {
        $scope.enfants = response.data;
    })
    .catch (function(reason){
    	alert("Erreur de récupération des données");
    	console.log(reason);	
    })
	/*suppression*/
	$scope.delete = function(id){
    	$http.get("http://localhost:8080/projetfinalserveur/deleteEnfant?idEnfant="+id)
    	.then(function(response){
    		$http.get("http://localhost:8080/projetfinalserveur/listEnfant")
    		.then(function(response){
    			$scope.enfants=response.data;
    		})
    		.catch(function(reason){
    			alert("Erreur de récupération des données");
    			console.log(reason);
    		})
    	})
    	.catch(function(reason) {
			alert("Echec d'abatage");
			console.log(reason);
		})
    }
})

/*modification Enfant*/
app.controller("updateEnfant", function($scope, $http) {
	$scope.enfant={};
	$scope.mettreaj=function(){
		$http.post("http://localhost:8080/projetfinalserveur/updateEnfant", $scope.enfant)
		.then(function(){
		})
		.catch(function(reason){
			alert("Erreur générée lors de la modification de l'enfant");
			console.log(reason);
		})
	}
});

//CRUD Responsable

/*creation Responsable*/
app.controller("createResponsable", function($scope, $http){
	$scope.saveResponsable = function(){
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

/*lister et suppression Responsable*/
app.controller("listResponsable",function($scope, $http){
	$http.get("http://localhost:8080/projetfinalserveur/listResponsable")
    .then(function(response) {
        $scope.responsables = response.data;
    })
    .catch (function(reason){
    	alert("Erreur de récupération des données");
    	console.log(reason);	
    })
	/*suppression*/
	$scope.delete = function(id){
    	$http.get("http://localhost:8080/projetfinalserveur/deleteResponsable?idResponsable="+id)
    	.then(function(response){
    		$http.get("http://localhost:8080/projetfinalserveur/listResponsable")
    		.then(function(response){
    			$scope.responsables=response.data;
    		})
    		.catch(function(reason){
    			alert("Erreur de récupération des données");
    			console.log(reason);
    		})
    	})
    	.catch(function(reason) {
			alert("Echec d'abatage");
			console.log(reason);
		})
    }
});
	
/*modification Responsable*/
app.controller("updateResponsable", function($scope, $http) {
	$scope.updateResp=function(){
		$http.post("http://localhost:8080/projetfinalserveur/updateResponsable", $scope.responsable)
		.then(function(value){
			$scope.responsable = value.data;
			location.reload();
		})
		.catch(function(reason){
			alert("Erreur générée lors de la modification responsable");
			console.log(reason);
		})
	}
});

/**************ESPACE FICHES*********************/
/*espace fiche vaccin*/
/*creation*/
app.controller("createFicheV", function($scope, $http) {
	$scope.createFicheV=function(){
		$http.post("http://localhost:8080/projetfinalserveur/saveFicheVaccin", $scope.ficheV)
		.then(function(value){
			$scope.ficheV=value.data;
			location.reload();
		})
		.catch(function(reason){
			alert("Erreur générée lors de l'ajout d'une fiche vaccin");
			console.log(reason);
		})
	}
})
/*listing et suppression*/
app.controller("listFicheVaccin",function($scope, $http){
	$http.get("http://localhost:8080/projetfinalserveur/listFicheVaccin")
    .then(function(response) {
        $scope.fichesV = response.data;
    })
    .catch (function(reason){
    	alert("Erreur de récupération des données");
    	console.log(reason);	
    })
	/*suppression*/
	$scope.delete = function(id){
    	$http.get("http://localhost:8080/projetfinalserveur/deleteFicheVaccin?idFicheVaccin="+id)
    	.then(function(response){
    		$http.get("http://localhost:8080/projetfinalserveur/listFicheVaccin")
    		.then(function(response){
    			$scope.fichesV=response.data;
    		})
    		.catch(function(reason){
    			alert("Erreur de récupération des données");
    			console.log(reason);
    		})
    	})
    	.catch(function(reason) {
			alert("Echec de suppression");
			console.log(reason);
		})
    }
})
/*modification*/
app.controller("updateFicheVaccin", function($scope, $http) {
	$scope.updateFicheV=function(){
		$http.post("http://localhost:8080/projetfinalserveur/updateFicheVaccin", $scope.ficheV)
		.then(function(value){
			$scope.ficheV = value.data;
			location.reload();
		})
		.catch(function(reason){
			alert("Erreur générée lors de la modification");
			console.log(reason);
		})
	}
})

/*fiche image*/
/*creation*/
app.controller("createFicheI", function($scope, $http) {
	$scope.createFicheI=function(){
		$http.post("http://localhost:8080/projetfinalserveur/saveFicheImage", $scope.ficheI)
		.then(function(value){
			$scope.ficheI=value.data;
			location.reload();
		})
		.catch(function(reason){
			alert("Erreur générée lors de l'ajout d'une fiche vaccin");
			console.log(reason);
		})
	}
})
/*listing et suppression*/
app.controller("listFicheImage",function($scope, $http){
	$http.get("http://localhost:8080/projetfinalserveur/listFicheImage")
    .then(function(response) {
        $scope.fichesI = response.data;
    })
    .catch (function(reason){
    	alert("Erreur de récupération des données");
    	console.log(reason);	
    })
	/*suppression*/
	$scope.delete = function(id){
    	$http.get("http://localhost:8080/projetfinalserveur/deleteFicheImage?idFicheImage="+id)
    	.then(function(response){
    		$http.get("http://localhost:8080/projetfinalserveur/listFicheImage")
    		.then(function(response){
    			$scope.fichesI=response.data;
    		})
    		.catch(function(reason){
    			alert("Erreur de récupération des données");
    			console.log(reason);
    		})
    	})
    	.catch(function(reason) {
			alert("Echec de suppression");
			console.log(reason);
		})
    }
})
/*modification*/
app.controller("updateFicheImage", function($scope, $http) {
	$scope.updateFicheI=function(){
		$http.post("http://localhost:8080/projetfinalserveur/updateFicheImage", $scope.ficheI)
		.then(function(value){
			$scope.ficheI = value.data;
			location.reload();
		})
		.catch(function(reason){
			alert("Erreur générée lors de la modification");
			console.log(reason);
		})
	}
})
/*fiche medical*/
/*creation*/
app.controller("createFicheM", function($scope, $http) {
	$scope.createFicheM=function(){
		$http.post("http://localhost:8080/projetfinalserveur/saveFicheMedical", $scope.ficheM)
		.then(function(value){
			$scope.ficheM=value.data;
			location.reload();
		})
		.catch(function(reason){
			alert("Erreur générée lors de l'ajout d'une fiche vaccin");
			console.log(reason);
		})
	}
})
/*listing et suppression*/
app.controller("listFicheMedical",function($scope, $http){
	$http.get("http://localhost:8080/projetfinalserveur/listFicheMedical")
    .then(function(response) {
        $scope.fichesM = response.data;
    })
    .catch (function(reason){
    	alert("Erreur de récupération des données");
    	console.log(reason);	
    })
	/*suppression*/
	$scope.delete = function(id){
    	$http.get("http://localhost:8080/projetfinalserveur/deleteFicheMedical?idFicheMedical="+id)
    	.then(function(response){
    		$http.get("http://localhost:8080/projetfinalserveur/listFicheMedical")
    		.then(function(response){
    			$scope.fichesM=response.data;
    		})
    		.catch(function(reason){
    			alert("Erreur de récupération des données");
    			console.log(reason);
    		})
    	})
    	.catch(function(reason) {
			alert("Echec de suppression");
			console.log(reason);
		})
    }
})
/*modification*/
app.controller("updateFicheMedical", function($scope, $http) {
	$scope.updateFicheM=function(){
		$http.post("http://localhost:8080/projetfinalserveur/updateFicheMedical", $scope.ficheM)
		.then(function(value){
			$scope.ficheM = value.data;
			location.reload();
		})
		.catch(function(reason){
			alert("Erreur générée lors de la modification");
			console.log(reason);
		})
	}
})

/*fiche principal*/
/*creation*/
app.controller("createFicheP", function($scope, $http) {
	$scope.createFicheP=function(){
		$http.post("http://localhost:8080/projetfinalserveur/saveFichePrincipale", $scope.ficheP)
		.then(function(value){
			$scope.ficheP=value.data;
			location.reload();
		})
		.catch(function(reason){
			alert("Erreur générée lors de l'ajout d'une fiche vaccin");
			console.log(reason);
		})
	}
})
/*listing et suppression*/
app.controller("listFichePrincipale",function($scope, $http){
	$http.get("http://localhost:8080/projetfinalserveur/listFichePrincipale")
    .then(function(response) {
        $scope.fichesP = response.data;
    })
    .catch (function(reason){
    	alert("Erreur de récupération des données");
    	console.log(reason);	
    })
	/*suppression*/
	$scope.delete = function(id){
    	$http.get("http://localhost:8080/projetfinalserveur/deleteFichePrincipale?idFichePrincipale="+id)
    	.then(function(response){
    		$http.get("http://localhost:8080/projetfinalserveur/listFichePrincipale")
    		.then(function(response){
    			$scope.fichesP=response.data;
    		})
    		.catch(function(reason){
    			alert("Erreur de récupération des données");
    			console.log(reason);
    		})
    	})
    	.catch(function(reason) {
			alert("Echec de suppression");
			console.log(reason);
		})
    }
})
/*modification*/
app.controller("updateFichePrincipale", function($scope, $http) {
	$scope.updateFicheP=function(){
		$http.post("http://localhost:8080/projetfinalserveur/updateFichePrincipale", $scope.ficheP)
		.then(function(value){
			$scope.ficheP = value.data;
			location.reload();
		})
		.catch(function(reason){
			alert("Erreur générée lors de la modification");
			console.log(reason);
		})
	}
})


