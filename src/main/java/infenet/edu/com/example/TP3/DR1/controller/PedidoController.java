package infenet.edu.com.example.TP3.DR1.controller;

import infenet.edu.com.example.TP3.DR1.DTO.PedidoDTO;
import infenet.edu.com.example.TP3.DR1.model.Pedido;
import infenet.edu.com.example.TP3.DR1.model.Produto;
import infenet.edu.com.example.TP3.DR1.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/list")
    public ResponseEntity<Object> list(){
        Collection<Pedido> pedidos;

        try {
            pedidos = pedidoService.getAll();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao listar Pedidos");
        }

        return ResponseEntity.status(HttpStatus.OK).body(pedidos);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> byId(@PathVariable Long id){
        Pedido pedido;
        try {
            pedido = pedidoService.getById(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao obter Pedido");
        }

        return ResponseEntity.status(HttpStatus.OK).body(pedido);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody @Valid PedidoDTO pedidoDTO){
        try {
            Pedido pedidoModel = new Pedido();
            BeanUtils.copyProperties(pedidoDTO,pedidoModel);
            pedidoService.save(pedidoModel);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar Pedido");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@RequestBody @Valid PedidoDTO pedidoDTO, @PathVariable Long id){
        try {
            Pedido pedidoModel = new Pedido();
            BeanUtils.copyProperties(pedidoDTO,pedidoModel);
            pedidoService.update(id,pedidoModel);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar Pedido");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> remove(@PathVariable Long id){

        try {
            pedidoService.remove(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar Pedido");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Pedido Deletado");
    }
}
