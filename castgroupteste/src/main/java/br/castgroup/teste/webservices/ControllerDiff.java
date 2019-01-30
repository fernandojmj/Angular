/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.castgroup.teste.webservices;

import br.castgroup.teste.model.Pessoa;
import br.castgroup.teste.service.PessoaService;
import java.util.ArrayList;
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
public class ControllerDiff {

    private String esquerda;
    private String direita;

    /**
     * Serviço responsvel por receber base64 esqueda
     * @param id
     * @return 
     */
    @RequestMapping(method = RequestMethod.GET, value = "/v1/diff/{id}/left")
    public ResponseEntity<String> left(@PathVariable String id) {

        esquerda = id;
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    /**
     * Serviço responsvel por receber base64 esqueda
     * @param id
     * @return 
     */
    @RequestMapping(method = RequestMethod.GET, value = "/v1/diff/{id}/rigth")
    public ResponseEntity<String> rigth(@PathVariable String id) {

        direita = id;
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    /**
     * Serviço responsavel por exibir se os Base64 são iguais ou diferentes e caso diferentes informar em qual posição eles 
    são diferentes
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET, value = "/v1/diff")
    public ResponseEntity<String> diferenca() {

        if (direita.equals(esquerda)) {
            return new ResponseEntity<String>("true" ,HttpStatus.OK);
        }else if(direita.length()!= esquerda.length()){
             return new ResponseEntity<String>("size diff",HttpStatus.OK);
        }else{
            char[] arrayDireta = direita.toCharArray() ;
            char[] arrayEquerda = esquerda.toCharArray() ;
            List<Integer> posicoes = new ArrayList<Integer>();
            
            for (int i = 0; i < direita.length(); i++) {
                if(arrayDireta[i]!= arrayEquerda[i]){
                  posicoes.add(i);
                }
            }
             StringBuffer retorno = new StringBuffer();
             retorno.append("Posições do base64 difentes entre esquerda e direta: ");
            for (Integer pos : posicoes) {
                retorno.append(pos);
                retorno.append(" ");
            }
           return new ResponseEntity<String>(retorno.toString(),HttpStatus.OK);  
            
        }

    }

}
