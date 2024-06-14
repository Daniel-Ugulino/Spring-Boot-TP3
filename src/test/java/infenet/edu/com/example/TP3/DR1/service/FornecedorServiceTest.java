package infenet.edu.com.example.TP3.DR1.service;

import infenet.edu.com.example.TP3.DR1.model.Fornecedor;
import infenet.edu.com.example.TP3.DR1.repository.FornecedorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FornecedorServiceTest {

    @InjectMocks
    private FornecedorService fornecedorService;

    @Mock
    private FornecedorRepository fornecedorRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Save Fornecedor")
    void save() {
        Fornecedor fornecedor = new Fornecedor(1L, "Fornecedor 1", "Descricao Fornecedor 1", "fornecedor1@example.com", "123456789");
        when(fornecedorRepository.save(any(Fornecedor.class))).thenReturn(fornecedor);
        Fornecedor savedFornecedor = fornecedorService.save(fornecedor);
        assertNotNull(savedFornecedor);
        assertEquals("Fornecedor 1", savedFornecedor.getNomeFantasia());
    }

    @Test
    @DisplayName("Get All Fornecedor")
    void getAll() {
        when(fornecedorRepository.findAll()).thenReturn(List.of(new Fornecedor(), new Fornecedor()));
        Collection<Fornecedor> fornecedores = fornecedorService.getAll();
        assertEquals(2, fornecedores.size());
    }

    @Test
    @DisplayName("Get By Id Fornecedor")
    void getById() {
        Fornecedor fornecedor = new Fornecedor(1L, "Fornecedor 1", "Descricao Fornecedor 1", "fornecedor1@example.com", "123456789");
        when(fornecedorRepository.findById(1L)).thenReturn(Optional.of(fornecedor));
        Fornecedor foundFornecedor = fornecedorService.getById(1L);
        assertNotNull(foundFornecedor);
        assertEquals(1L, foundFornecedor.getId());
    }

    @Test
    @DisplayName("Update Fornecedor")
    void update() {
        Fornecedor fornecedor = new Fornecedor(1L, "Fornecedor 1", "Descricao Fornecedor 1", "fornecedor1@example.com", "123456789");
        when(fornecedorRepository.existsById(1L)).thenReturn(true);
        when(fornecedorRepository.save(any(Fornecedor.class))).thenReturn(fornecedor);
        Fornecedor updatedFornecedor = fornecedorService.update(1L, fornecedor);
        assertNotNull(updatedFornecedor);
    }

    @Test
    @DisplayName("Remove Fornecedor")
    void remove() {
        doNothing().when(fornecedorRepository).deleteById(1L);
        fornecedorService.remove(1L);
        verify(fornecedorRepository, times(1)).deleteById(1L);
    }
}