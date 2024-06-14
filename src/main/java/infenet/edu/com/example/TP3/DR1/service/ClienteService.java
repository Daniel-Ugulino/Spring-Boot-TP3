package infenet.edu.com.example.TP3.DR1.service;

import infenet.edu.com.example.TP3.DR1.model.Cliente;
import infenet.edu.com.example.TP3.DR1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class ClienteService {
    @Autowired
    private ClienteRepository ClienteRepo;

    public Cliente save(Cliente cliente) {
        return ClienteRepo.save(cliente);
    }

    public Collection<Cliente> getAll() {
        return ClienteRepo.findAll();
    }

    public Cliente getById(Long id) {
        return ClienteRepo.findById(id).get();
    }

    public Cliente update(Long id, Cliente cliente) {
        Cliente clienteDB = ClienteRepo.findById(id).get();
        cliente.setId(clienteDB.getId());
        ClienteRepo.save(cliente);
        return cliente;
    }

    public void remove(Long id) {
        Cliente cliente = ClienteRepo.findById(id).get();
        ClienteRepo.delete(cliente);
    }

}
