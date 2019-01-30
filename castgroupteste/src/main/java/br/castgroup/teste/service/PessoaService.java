/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.castgroup.teste.service;

import br.castgroup.teste.model.Pessoa;
//import br.castgroup.teste.repository.PessoaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando.j.junior
 *
 * Classe responsavel pela regra de negocio referente a entidaed Pessoa.
 */
@Service
public class PessoaService {

//    @Autowired
//    PessoaRepository pessoaRepository;

    List<Pessoa> pessoas = new ArrayList<Pessoa>();
    int idPessoaCont = 0;

    /**
     * Método responsavel po acessar a classe repositorio e buscar pessoas
     *
     * @return lista de pessoas
     */
    public List<Pessoa> buscarPessoas() {
        return pessoas; //pessoaRepository.findAll();
    }

    /**
     * Método responsavel po acessar a classe repositorio e buscar uma pessoa
     * escolhida
     *
     * @return lista de pessoas
     */
    public Pessoa salvar(Pessoa pessoa) {

        pessoa.setId(idPessoaCont);

        pessoas.add(pessoa);
        idPessoaCont++;

        return pessoa; //pessoaRepository.save(pessoa);
    }

    /**
     * Método responsavel por acessar a classe repositorio e remover uma pessoa
     *
     * @param id
     */
    public void remove(Integer id) {
        Pessoa pessoaRemover = new Pessoa();
        for (Pessoa pessoa : pessoas) {

            if (pessoa.getId() == id) {
                pessoaRemover = pessoa;
                break;

            }
        }

        pessoas.remove(pessoaRemover);

//        pessoaRepository.deleteById(id);
    }

    /**
     * Método responsavel por acessar o classe repositorio e retornar uma pessoa
     * pesquisada.
     *
     * @param id
     * @return
     */
    public Optional<Pessoa> buscarIdBase(Integer id) {

        return null;//pessoaRepository.findById(id);
    }

    public Pessoa buscarId(Integer id) {

        for (Pessoa pessoa : pessoas) {

            if (pessoa.getId() == id) {
                return pessoa;

            }
        }
        return null;
        //return pessoaRepository.findById(id);
    }

}
