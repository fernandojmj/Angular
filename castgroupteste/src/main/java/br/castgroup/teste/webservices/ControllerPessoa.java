/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.castgroup.teste.webservices;

import br.castgroup.teste.model.Pessoa;
import br.castgroup.teste.service.PessoaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fernando.j.junior
 *
 * Classe controller para disponibilizar webServices referente ao objeto pessoa.
 */
@RestController
public class ControllerPessoa {

    @Autowired
    PessoaService service;

    /**
     * Serviço responsvel por retornar todas as pessoas cadastradas
     *
     * @return lista de pessoas
     */
    @RequestMapping(method = RequestMethod.GET, value = "/pessoas")
    public ResponseEntity<List<Pessoa>> buscarPessoas() {
        System.out.println("br.castgroup.teste.webservices.ControllerPessoa.buscarPessoas()");
        return new ResponseEntity<List<Pessoa>>(service.buscarPessoas(), HttpStatus.OK);
    }

    /**
     * Serviço responsavel por savar ou alterar uma pessoa na base de dados
     *
     * @param pessoa
     * @return pessoa
     */
    @RequestMapping(method = RequestMethod.POST, value = "/pessoa/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa) {
        return new ResponseEntity<Pessoa>(service.salvar(pessoa), HttpStatus.OK);
    }

    /**
     * Serviço responsavel por remover uma pessoa na base de dados
     *
     * @param id
     * @return status
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/pessoa/remove/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> buscarPessoas(@PathVariable int id) {
        service.remove(id);
        return new ResponseEntity<Pessoa>(HttpStatus.OK);
    }

    /**
     * Serviço responsavel por retornar um objeto pessoa
     *
     * @param id
     * @return pessoa
     */
//    @RequestMapping(method = RequestMethod.GET, value = "/pessoa/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Optional<Pessoa>> buscarPessoaId(@PathVariable int id) {
//        return new ResponseEntity<Optional<Pessoa>>(service.buscarId(id), HttpStatus.OK);
//    }
     @RequestMapping(method = RequestMethod.GET, value = "/pessoa/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> buscarPessoaId(@PathVariable int id) {
        return new ResponseEntity<Pessoa>(service.buscarId(id), HttpStatus.OK);
    }

}
