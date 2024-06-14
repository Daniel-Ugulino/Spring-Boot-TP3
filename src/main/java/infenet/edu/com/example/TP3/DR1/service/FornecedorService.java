package infenet.edu.com.example.TP3.DR1.service;

import infenet.edu.com.example.TP3.DR1.model.Fornecedor;
import infenet.edu.com.example.TP3.DR1.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepo;

    public Fornecedor save(Fornecedor fornecedor) {
        return fornecedorRepo.save(fornecedor);
    }

    public Collection<Fornecedor> getAll() {
        return fornecedorRepo.findAll();
    }

    public Fornecedor getById(Long id) {
        return fornecedorRepo.findById(id).get();
    }

    public Fornecedor update(Long id, Fornecedor fornecedor) {
        Fornecedor fornecedorDB = fornecedorRepo.findById(id).get();
        fornecedor.setId(fornecedorDB.getId());
        fornecedorRepo.save(fornecedor);
        return fornecedor;
    }

    public void remove(Long id) {
        Fornecedor fornecedor = fornecedorRepo.findById(id).get();
        fornecedorRepo.delete(fornecedor);
    }


}
