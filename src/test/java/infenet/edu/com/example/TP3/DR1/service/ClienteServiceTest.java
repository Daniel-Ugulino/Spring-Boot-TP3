package infenet.edu.com.example.TP3.DR1.service;

import infenet.edu.com.example.TP3.DR1.model.Cliente;
import infenet.edu.com.example.TP3.DR1.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Save Cliente")
    void save() {
        Cliente cliente = new Cliente(1L, "Leo", "12345678900", "Rio de Janeiro", "cliente1@example.com", "+5521982032323");
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        Cliente savedCliente = clienteService.save(cliente);
        assertNotNull(savedCliente);
        assertEquals(cliente, savedCliente);
    }

    @Test
    @DisplayName("Get All Cliente")
    void getAll() {
        when(clienteRepository.findAll()).thenReturn(List.of(new Cliente(), new Cliente()));
        Collection<Cliente> clientes = clienteService.getAll();
        assertEquals(2, clientes.size());
    }

    @Test
    @DisplayName("Get By Id Cliente")
    void getById() {
        Cliente cliente = new Cliente(1L, "Leo", "12345678900", "Rio de Janeiro", "cliente1@example.com", "+5521982032323");
        cliente.setId(1L);
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        Cliente foundCliente = clienteService.getById(1L);
        assertNotNull(foundCliente);
        assertEquals(1L, foundCliente.getId());
    }

    @Test
    @DisplayName("Update Cliente")
    void update() {
        Cliente cliente = new Cliente(1L, "Leo", "12345678900", "Rio de Janeiro", "cliente1@example.com", "+5521982032323");
        cliente.setId(1L);
        when(clienteRepository.existsById(1L)).thenReturn(true);
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        Cliente updatedCliente = clienteService.update(1L, cliente);
        assertNotNull(updatedCliente);
    }

    @Test
    @DisplayName("Remove Cliente")
    void remove() {
        doNothing().when(clienteRepository).deleteById(1L);
        clienteService.remove(1L);
        verify(clienteRepository, times(1)).deleteById(1L);
    }
}