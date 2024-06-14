package infenet.edu.com.example.TP3.DR1.service;

import infenet.edu.com.example.TP3.DR1.model.Fornecedor;
import infenet.edu.com.example.TP3.DR1.model.Produto;
import infenet.edu.com.example.TP3.DR1.repository.FornecedorRepository;
import infenet.edu.com.example.TP3.DR1.repository.ProdutoRepository;
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

class ProdutoServiceTest {
    @InjectMocks
    private ProdutoService produtoService;
    @Mock
    private ProdutoRepository produtoRepository;
    @Mock
    private FornecedorRepository fornecedorRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Save Produto")
    void save() {
        Produto produto = new Produto(1L, "Processador", "Descricao Produto 1", 50.0);
        when(produtoRepository.save(any(Produto.class))).thenReturn(produto);
        Produto savedProduto = produtoService.save(produto);
        assertNotNull(savedProduto);
        assertEquals(produto, savedProduto);
    }

    @Test
    @DisplayName("Get All Produto")
    void getAll() {
        when(produtoRepository.findAll()).thenReturn(List.of(new Produto(), new Produto()));
        Collection<Produto> produtos = produtoService.getAll();
        assertEquals(2, produtos.size());
    }

    @Test
    @DisplayName("Get By Id Produto")
    void getById() {
        Produto produto = new Produto(1L, "Processador", "Descricao Produto 1", 50.0);
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));
        Produto foundProduto = produtoService.getById(1L);
        assertNotNull(foundProduto);
        assertEquals(1L, foundProduto.getId());
    }

    @Test
    @DisplayName("Update Produto")
    void update() {
        Produto produto = new Produto(1L, "Processador", "Descricao Produto 1", 50.0);
        when(produtoRepository.existsById(1L)).thenReturn(true);
        when(produtoRepository.save(any(Produto.class))).thenReturn(produto);
        Produto updatedProduto = produtoService.update(1L, produto);
        assertNotNull(updatedProduto);
    }

    @Test
    @DisplayName("Remove Produto")
    void remove() {
        doNothing().when(produtoRepository).deleteById(1L);
        produtoService.remove(1L);
        verify(produtoRepository, times(1)).deleteById(1L);
    }
}