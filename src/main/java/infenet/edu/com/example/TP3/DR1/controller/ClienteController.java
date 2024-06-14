package infenet.edu.com.example.TP3.DR1.controller;

import infenet.edu.com.example.TP3.DR1.DTO.ClienteDTO;
import infenet.edu.com.example.TP3.DR1.model.Cliente;
import infenet.edu.com.example.TP3.DR1.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/list")
    public ResponseEntity<Object> list(){
        Collection<Cliente> clientes;

        try {
            clientes = clienteService.getAll();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao listar Clientes");
        }

        return ResponseEntity.status(HttpStatus.OK).body(clientes);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> byId(@PathVariable Long id){
        Cliente cliente;
        try {
            cliente = clienteService.getById(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao obter Cliente");
        }

        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody @Valid ClienteDTO clienteDTO){
        try {
            Cliente clienteModel = new Cliente();
            BeanUtils.copyProperties(clienteDTO,clienteModel);
            clienteService.save(clienteModel);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar Cliente");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@RequestBody @Valid ClienteDTO clienteDTO, @PathVariable Long id){
        try {
            Cliente clienteModel = new Cliente();
            BeanUtils.copyProperties(clienteDTO,clienteModel);
            clienteService.update(id,clienteModel);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar Cliente");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> remove(@PathVariable Long id){

        try {
            clienteService.remove(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar Cliente");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente Deletado");
    }
}
