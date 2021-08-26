package br.com.example.api;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
@ExtendWith(SpringExtension.class)
@Sql(value = "/load-database.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//usando pra me comunicar com a tabela
@TestPropertySource("classpath:application-test.properties")
@DisplayName("Tests for Cliente Repository")
@SpringBootTest
public class ClienteRepositoryTeste {


    @Autowired
    ClienteRepository clienteRepository;


    @Test
    @DisplayName("Test for List Client")
    public void list_Cliente() {
        ClienteRepository clienteRepository;
        int size = clienteRepository.findAll().size();
        assertEquals(1, size);
    }

    @Test
    public void save_Cliente() {
        Cliente cliente = new Cliente(1L, "teste", "teste", "teste");
        clienteRepository.save(cliente);
        int size = clienteRepository.findAll().size();
        assertEquals(1, size);

    }

    @Test
    @DisplayName("Test delete")
    public void delete_Id_Cliente() {
        clienteRepository.deleteById(1L);
        List<Cliente> listCliente = clienteRepository.findAll();
        assertEquals(0, listCliente.size());
    }

    @Test
    public void put_Cliente() {
        Cliente cliente = createCliente();
        cliente.getId();
        clienteRepository.findAll();
        Cliente byId = clienteRepository.getById(cliente.getId());
        assertEquals(1L, byId.getId());
    }

//    @Test
//    public void erro_Id_NotExist(){
//        assertThrows(ResourceNotFoundException.class, () -> clienteRepository.findById(0L));
//    }

    private Cliente createCliente() { //utilizado para os testes
        return Cliente.builder()
                .id(1L)
                .nome("Testando")
                .email("teste@teste.com")
                .cpf("000.000.000-05")
                .build();
    }


}
