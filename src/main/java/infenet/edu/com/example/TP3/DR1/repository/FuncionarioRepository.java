package infenet.edu.com.example.TP3.DR1.repository;

import infenet.edu.com.example.TP3.DR1.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {}