var appSelecao = angular.module("appSelecao", []);


appSelecao.controller("controllerPessoa", function ($scope, $http) {

    $scope.pessoas = [];

    $scope.pessoa;
    $scope.mensagem = '';
    $scope.mensagemErro;
    $scope.pessoaDetalhe;
    $scope.exbibeMensagemSucesso = 'none';
    $scope.exbibeMensagemErro = 'none';
    $scope.pessoaPesquisada = "";
    $scope.host = '';
    $scope.path = '';

    $scope.pesquisarPessoa = function (nome) {


        for (var i = 0; i < $scope.pessoas.length; i++) {
            var nomeLista = $scope.pessoas[i].name;
            if (nomeLista.includes(nome)) {
                $scope.pessoa = $scope.pessoas[i];
                break;
            }
        }

    }


//Função responsavel por buscar uma pessoas cadastradas 
    $scope.carregarPessoas = function () {
        var path = window.location.pathname;

        if (path.includes('service')) {
            $scope.path = 'service';
            $scope.host ='http://18.210.88.250:8080'
        } else {
            $scope.path = '';
            $scope.host =window.location.host;
        }

        $http({
            method: 'GET', url: $scope.host + '/' + $scope.path + '/pessoas'})
                .then(function (response) {

                    $scope.pessoas = response.data;

                }, function (response) {

                });

    }
//Função responsavel por buscar uma pessoa pelo ID
    $scope.buscarPessoa = function (id) {
        var host = window.location.host;
        var path = window.location.pathname;

        $http({
            method: 'GET', url: $scope.host + '/' + $scope.path + '/pessoa/' + id, data: '',
            headers: {
                'Content-Type': 'application/json'
            }})
                .then(function (response) {

                    $scope.pessoaDetalhe = response.data;

                }, function (response) {

                    $scope.mensagemErro = response.data;
                    $scope.mensagem = ''
                    $scope.exbibeMensagemSucesso = 'none';
                    $scope.exbibeMensagemErro = 'block';

                });

    }

    $scope.carregarPessoas();

//Função responsavel por cadastrar ima nova pessoa na lista
    $scope.cadastrarPessoa = function (pessoa) {

        var host = window.location.host;
        var path = window.location.pathname;

        $http({
            method: 'POST', url: $scope.host + '/' + $scope.path + '/pessoa/save', data: pessoa})
                .then(function (response) {

                    $scope.pessoas.push(response.data)
                    $scope.mensagem = 'Pessoa com ID: ' + response.data.id + ' Cadastrada com sucesso'
                    $scope.exbibeMensagemSucesso = 'block';
                    $scope.exbibeMensagemErro = 'none';

                    mensagemErro = '';
                }, function (response) {
                    $scope.mensagemErro = "Ocorreu um erro ao tentar Cadastrar Pessoa";
                    $scope.mensagem = ''
                    $scope.exbibeMensagemSucesso = 'none';
                    $scope.exbibeMensagemErro = 'block';
                });

    }
//Funçao responsavel por remover pessoa da lista
    $scope.excliurPessoa = function (pessoa) {


        var host = window.location.host;
        var path = window.location.pathname;

        if (path.includes('service')) {
            path = 'service';
        } else {
            path = '';
        }
        $http({
            method: 'DELETE', url: $scope.host + '/' + $scope.path + '/pessoa/remove/' + pessoa.id, data: '',
            headers: {
                'Content-Type': 'application/json'
            }})
                .then(function (response) {

                    $scope.carregarPessoas();
                    $scope.mensagem = 'Pessoa removida com sucesso'
                    mensagemErro = '';
                    $scope.exbibeMensagemSucesso = 'block';
                    $scope.exbibeMensagemErro = 'none';
                }, function (response) {
                    $scope.mensagemErro = 'Ocorreu um erro tentar Remover: ' + pessoa.name;
                    $scope.mensagem = ''
                    $scope.exbibeMensagemSucesso = 'none';
                    $scope.exbibeMensagemErro = 'block';
                });

    }


});
