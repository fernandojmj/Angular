package br.castgroup.teste;

import br.castgroup.teste.model.Pessoa;
import br.castgroup.teste.service.PessoaService;
import br.castgroup.teste.util.Util;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TesteApplicationTests {
    
    @Autowired
    PessoaService service;
    
    @Before
    public void setUp(){
        Util util = new Util();
    }

	@Test
	public void contextLoads() {
	}
        
        /**
         * Teste do método  max diference 
         */
        @Test
	public void testeMaxDiference() {
            
             Integer[] a = {2, 3, 10, 2, 4, 8, 1};
            Assert.assertEquals(8,Util.maxDifference(a));
            
             Integer[] b =  {7, 9, 5, 6, 3, 2};
            Assert.assertEquals(2,Util.maxDifference(b));
            
	}
        
        
        /**
         * Teste do método savar pessoa.
         */
        @Test
        public void testeSavePessoa(){
            Pessoa p = new Pessoa();
            p.setName("Fernando");
            p.setNeighborhood("bb");
            p.setNumber("123");
            p.setPhone("8199767654");
            p.setState("PE");
            p.setStreet("RUA ABC");
            
            p = service.salvar(p);
            
            Assert.assertNotNull(p.getId());
        }
        
        @Test
        public void testeRemoverPessoa(){
           
            
            List<Pessoa> pessoas = service.buscarPessoas();
            
            for (Pessoa pessoa : pessoas) {
                
            service.remove(pessoa.getId());
            break;
            }
            
            Assert.assertNotEquals(pessoas.size(), service.buscarPessoas().equals(this));
        }

}

