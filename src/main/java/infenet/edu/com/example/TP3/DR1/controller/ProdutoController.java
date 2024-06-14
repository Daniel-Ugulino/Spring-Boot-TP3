package infenet.edu.com.example.TP3.DR1.controller;

import infenet.edu.com.example.TP3.DR1.DTO.ProdutoDTO;
import infenet.edu.com.example.TP3.DR1.model.Cliente;
import infenet.edu.com.example.TP3.DR1.model.Produto;
import infenet.edu.com.example.TP3.DR1.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/list")
    public ResponseEntity<Object> list(){
        Collection<Produto> produtos;

        try {
            produtos = produtoService.getAll();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao listar Produtos");
        }

        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> byId(@PathVariable Long id){
        Produto produto;
        try {
            produto = produtoService.getById(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao obter Produto");
        }

        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody @Valid ProdutoDTO produtoDTO){
        try {
            Produto produtoModel = new Produto();
            BeanUtils.copyProperties(produtoDTO,produtoModel);
            produtoService.save(produtoModel);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar Produto");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@RequestBody @Valid ProdutoDTO produtoDTO, @PathVariable Long id){
        try {
            Produto produtoModel = new Produto();
            BeanUtils.copyProperties(produtoDTO,produtoModel);
            produtoService.update(id,produtoModel);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar Produto");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> remove(@PathVariable Long id){

        try {
            produtoService.remove(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar Produto");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Produto Deletado");
    }
}
