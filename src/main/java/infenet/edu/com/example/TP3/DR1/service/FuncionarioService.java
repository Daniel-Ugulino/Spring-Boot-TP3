package infenet.edu.com.example.TP3.DR1.service;

import infenet.edu.com.example.TP3.DR1.model.Funcionario;
import infenet.edu.com.example.TP3.DR1.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepo;

    public Funcionario save(Funcionario f) {
        return funcionarioRepo.save(f);
    }

    public Collection<Funcionario> getAll() {
        return funcionarioRepo.findAll();
    }

    public Funcionario getById(Long id) {
        return funcionarioRepo.findById(id).get();
    }

    public Funcionario update(Long id, Funcionario funcionario) {
        Funcionario funcionarioDB = funcionarioRepo.findById(id).get();
        funcionario.setId(funcionarioDB.getId());
        funcionarioRepo.save(funcionario);
        return funcionario;
    }

    public void remove(Long id) {
        Funcionario funcionario = funcionarioRepo.findById(id).get();
        funcionarioRepo.delete(funcionario);
    }


}
