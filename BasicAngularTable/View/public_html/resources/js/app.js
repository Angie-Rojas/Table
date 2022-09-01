var app = angular.module("app", []);
var temp1;

app.controller("controlador", function($scope){
      //$scope.apellido = "Silva";
      var lista = this;
      lista.dataSource = [];
      lista.demo = "Nada";
      lista.dataSource = [
            {aplicacion: 1, nombreparametro: 'Hydrogen', descripcion: 1.0079, symbol: 'H'},
            {aplicacion: 2, nombreparametro: 'Helium', descripcion: 4.0026, symbol: 'He'},
            {aplicacion: 3, nombreparametro: 'Lithium', descripcion: 6.941, symbol: 'Li'},
            {aplicacion: 4, nombreparametro: 'Beryllium', descripcion: 9.0122, symbol: 'Be'},
            {aplicacion: 5, nombreparametro: 'Boron', descripcion: 10.811, symbol: 'B'},
            {aplicacion: 6, nombreparametro: 'Carbon', descripcion: 12.0107, symbol: 'C'},
            {aplicacion: 7, nombreparametro: 'Nitrogen', descripcion: 14.0067, symbol: 'N'},
            {aplicacion: 8, nombreparametro: 'Oxygen', descripcion: 15.9994, symbol: 'O'},
            {aplicacion: 9, nombreparametro: 'Fluorine', descripcion: 18.9984, symbol: 'F'},
            {aplicacion: 10, nombreparametro: 'Neon', descripcion: 20.1797, symbol: 'Ne'}
      ];
      lista.cosultarDatos = function(){
      /*
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                  if (this.readyState == 4 && this.status == 200) {
                        //document.getElementById("demo").value = this.responseText;
                        lista.demo = this.responseText;
                        lista.dataSource = this.response.json;
                        temp1 = this.responseText;
                  }
            };
            xhttp.open("POST", "consume", true);
            xhttp.send(); //*/
            
            var xhr = new XMLHttpRequest();
            xhr.open('GET', "consume", true);
            xhr.responseType = 'json';
            xhr.onload = function() {
                  var status = xhr.status;
                  if (status === 200) {
                        lista.dataSource = xhr.response;//callback(null, xhr.response);
                        $scope.$apply();
                  } else {
                        temp1 = "fallo";//callback(status, xhr.response);
                  }
            };
            xhr.send();
      }
});
