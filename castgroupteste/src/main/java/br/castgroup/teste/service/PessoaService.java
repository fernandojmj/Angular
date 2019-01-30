/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.castgroup.teste.service;

import br.castgroup.teste.model.Pessoa;
import br.castgroup.teste.repository.PessoaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando.j.junior
 *
 * Classe responsavel pela regra de negocio referente a entidaed Pessoa.
 */
@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    /**
     * Método responsavel po acessar a classe repositorio e buscar pessoas
     *
     * @return lista de pessoas
     */
    public List<Pessoa> buscarPessoas() {
        return pessoaRepository.findAll();
    }

    /**
     * Método responsavel po acessar a classe repositorio e buscar uma pessoa
     * escolhida
     *
     * @return lista de pessoas
     */
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    /**
     * Método responsavel por acessar a classe repositorio e remover uma pessoa
     *
     * @param id
     */
    public void remove(Integer id) {
        pessoaRepository.deleteById(id);
    }

    /**
     * Método responsavel por acessar o classe repositorio e retornar uma pessoa
     * pesquisada.
     *
     * @param id
     * @return
     */
    public Optional<Pessoa> buscarId(Integer id) {
        return pessoaRepository.findById(id);
    }

}
