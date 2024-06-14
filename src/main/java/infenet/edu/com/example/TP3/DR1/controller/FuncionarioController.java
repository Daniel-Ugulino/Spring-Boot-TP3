package infenet.edu.com.example.TP3.DR1.controller;

import infenet.edu.com.example.TP3.DR1.DTO.FuncionarioDTO;
import infenet.edu.com.example.TP3.DR1.model.Funcionario;
import infenet.edu.com.example.TP3.DR1.model.Pedido;
import infenet.edu.com.example.TP3.DR1.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcService;

    @GetMapping("/list")
    public ResponseEntity<Object> list(){
        Collection<Funcionario> funcionarios;

        try {
            funcionarios = funcService.getAll();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao listar funcionarios");
        }

        return ResponseEntity.status(HttpStatus.OK).body(funcionarios);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> byId(@PathVariable Long id){
        Funcionario funcionario;
        try {
            funcionario = funcService.getById(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao obter funcionarios");
        }

        return ResponseEntity.status(HttpStatus.OK).body(funcionario);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody @Valid FuncionarioDTO funcionarioDTO){
        try {
            Funcionario funcionarioModel = new Funcionario();
            BeanUtils.copyProperties(funcionarioDTO,funcionarioModel);
            funcService.save(funcionarioModel);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar Funcionario");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@RequestBody @Valid FuncionarioDTO funcionarioDTO, @PathVariable Long id){
        try {
            Funcionario funcionarioModel = new Funcionario();
            BeanUtils.copyProperties(funcionarioDTO,funcionarioModel);
            funcService.update(id,funcionarioModel);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar funcionario");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> remove(@PathVariable Long id){

        try {
            funcService.remove(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar teclado");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Funcionario Deletado");
    }
}
