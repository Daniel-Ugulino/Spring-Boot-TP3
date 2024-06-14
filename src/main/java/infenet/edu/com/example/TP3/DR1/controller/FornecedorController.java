package infenet.edu.com.example.TP3.DR1.controller;

import infenet.edu.com.example.TP3.DR1.DTO.FornecedorDTO;
import infenet.edu.com.example.TP3.DR1.model.Fornecedor;
import infenet.edu.com.example.TP3.DR1.model.Funcionario;
import infenet.edu.com.example.TP3.DR1.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/list")
    public ResponseEntity<Object> list(){
        Collection<Fornecedor> fornecedores;

        try {
            fornecedores = fornecedorService.getAll();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao listar fornecedores");
        }

        return ResponseEntity.status(HttpStatus.OK).body(fornecedores);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> byId(@PathVariable Long id){
        Fornecedor fornecedor;
        try {
            fornecedor = fornecedorService.getById(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao obter fornecedor");
        }

        return ResponseEntity.status(HttpStatus.OK).body(fornecedor);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody @Valid FornecedorDTO fornecedorDTO){
        try {
            Fornecedor fornecedorModel = new Fornecedor();
            BeanUtils.copyProperties(fornecedorDTO,fornecedorModel);
            fornecedorService.save(fornecedorModel);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar fornecedor");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@RequestBody @Valid FornecedorDTO fornecedorDTO, @PathVariable Long id){
        try {
            Fornecedor fornecedorModel = new Fornecedor();
            BeanUtils.copyProperties(fornecedorDTO,fornecedorModel);
            fornecedorService.update(id,fornecedorModel);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar fornecedor");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> remove(@PathVariable Long id){

        try {
            fornecedorService.remove(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar fornecedor");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("fornecedor Deletado");
    }
}
