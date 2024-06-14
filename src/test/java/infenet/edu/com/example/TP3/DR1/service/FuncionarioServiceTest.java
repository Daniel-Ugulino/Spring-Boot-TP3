package infenet.edu.com.example.TP3.DR1.service;

import infenet.edu.com.example.TP3.DR1.model.Funcionario;
import infenet.edu.com.example.TP3.DR1.repository.FuncionarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FuncionarioServiceTest {

    @InjectMocks
    private FuncionarioService funcionarioService;

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Save Funcionario")
    void save() {
        Funcionario funcionario = new Funcionario(1L, "Jose", "12345678900", 2500);
        when(funcionarioRepository.save(any(Funcionario.class))).thenReturn(funcionario);
        Funcionario savedFuncionario = funcionarioService.save(funcionario);
        assertNotNull(savedFuncionario);
    }

    @Test
    @DisplayName("Get All Funcionario")
    void getAll() {
    }

    @Test
    @DisplayName("Get By Id Funcionario")
    void getById() {
        Funcionario funcionario = new Funcionario(1L, "Jose", "12345678900", 2500);
        funcionario.setId(1L);
        when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(funcionario));
        Funcionario foundFuncionario = funcionarioService.getById(1L);
        assertNotNull(foundFuncionario);
        assertEquals(1L, foundFuncionario.getId());
    }

    @Test
    @DisplayName("Update Funcionario")
    void update() {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1L);
        when(funcionarioRepository.existsById(1L)).thenReturn(true);
        when(funcionarioRepository.save(any(Funcionario.class))).thenReturn(funcionario);
        Funcionario updatedFuncionario = funcionarioService.update(1L, funcionario);
        assertNotNull(updatedFuncionario);
    }

    @Test
    @DisplayName("Remove Funcionario")
    void remove() {
        doNothing().when(funcionarioRepository).deleteById(1L);
        funcionarioService.remove(1L);
        verify(funcionarioRepository, times(1)).deleteById(1L);
    }
}