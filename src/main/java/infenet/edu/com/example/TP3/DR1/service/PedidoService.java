package infenet.edu.com.example.TP3.DR1.service;

import infenet.edu.com.example.TP3.DR1.model.Pedido;
import infenet.edu.com.example.TP3.DR1.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepo;

    public Pedido save(Pedido pedido) {
        return pedidoRepo.save(pedido);
    }

    public Collection<Pedido> getAll() {
        return pedidoRepo.findAll();
    }

    public Pedido getById(Long id) {
        return pedidoRepo.findById(id).get();
    }

    public Pedido update(Long id, Pedido pedido) {
        Pedido pedidoDB = pedidoRepo.findById(id).get();
        pedido.setId(pedidoDB.getId());
        pedidoRepo.save(pedido);
        return pedido;
    }

    public void remove(Long id) {
        Pedido pedido = pedidoRepo.findById(id).get();
        pedidoRepo.delete(pedido);
    }

}
