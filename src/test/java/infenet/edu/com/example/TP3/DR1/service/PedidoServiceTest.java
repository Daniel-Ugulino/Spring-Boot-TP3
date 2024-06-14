package infenet.edu.com.example.TP3.DR1.service;

import infenet.edu.com.example.TP3.DR1.model.*;
import infenet.edu.com.example.TP3.DR1.repository.*;
import infenet.edu.com.example.TP3.DR1.model.*;
import infenet.edu.com.example.TP3.DR1.repository.PedidoRepository;
import infenet.edu.com.example.TP3.DR1.repository.*;
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
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

class PedidoServiceTest {

    @InjectMocks
    private PedidoService pedidoService;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @Mock
    private FornecedorRepository fornecedorRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Save Pedido")
    void save() {
        Produto produto = new Produto(1L, "Processador", "Descricao Produto 1", 50.0);
        Cliente cliente = new Cliente(1L, "Leo", "12345678900", "Rio de Janeiro", "cliente1@example.com", "+5521982032323");
        Funcionario funcionario = new Funcionario(1L, "Jose", "12345678900", 2500);
        Pedido pedido = new Pedido(1L, "Pedido Processador", 50.0, List.of(produto), cliente, funcionario);

        when(produtoRepository.saveAll(anyList())).thenReturn(List.of(produto));
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        when(funcionarioRepository.save(any(Funcionario.class))).thenReturn(funcionario);
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);

        Pedido savedPedido = pedidoService.save(pedido);
        assertNotNull(savedPedido);
        assertEquals(pedido, savedPedido);
        assertNotNull(savedPedido.getCliente());
        assertNotNull(savedPedido.getFuncionario());
    }

    @Test
    @DisplayName("Get All Pedidos")
    void getAll() {
        when(pedidoRepository.findAll()).thenReturn(List.of(new Pedido(), new Pedido()));
        Collection<Pedido> pedidos = pedidoService.getAll();
        assertEquals(2, pedidos.size());
    }

    @Test
    @DisplayName("Get By Id Pedido")
    void getById() {
        Pedido pedido = new Pedido(1L, "Pedido Processador", 100.0, null, null, null);
        when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));
        Pedido foundPedido = pedidoService.getById(1L);
        assertNotNull(foundPedido);
        assertEquals(pedido, foundPedido);
    }

    @Test
    @DisplayName("Update Pedido")
    void update() {
        Produto produto = new Produto(1L, "Processador", "Descricao Produto 1", 50.0);
        Cliente cliente = new Cliente(1L, "Leo", "12345678900", "Rio de Janeiro", "cliente1@example.com", "+5521982032323");
        Funcionario funcionario = new Funcionario(1L, "Jose", "12345678900", 2500);
        Pedido pedido = new Pedido(1L, "Pedido Processador Atualizado", 100.0, List.of(produto), cliente, funcionario);

        when(pedidoRepository.existsById(1L)).thenReturn(true);
        when(produtoRepository.saveAll(anyList())).thenReturn(List.of(produto));
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        when(funcionarioRepository.save(any(Funcionario.class))).thenReturn(funcionario);
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);

        Pedido updatedPedido;
        updatedPedido = pedidoService.update(1L, pedido);
        assertNotNull(updatedPedido);
        assertEquals(1, updatedPedido.getProdutos().size());
        assertNotNull(updatedPedido.getCliente());
        assertNotNull(updatedPedido.getFuncionario());
    }

    @Test
    @DisplayName("Remove Pedido")
    void remove() {
        doNothing().when(pedidoRepository).deleteById(1L);
        pedidoService.remove(1L);
        verify(pedidoRepository, times(1)).deleteById(1L);
    }
}