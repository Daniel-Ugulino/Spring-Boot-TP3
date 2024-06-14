package infenet.edu.com.example.TP3.DR1.service;

import infenet.edu.com.example.TP3.DR1.model.Produto;
import infenet.edu.com.example.TP3.DR1.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepo;

    public Produto save(Produto produto) {
        return produtoRepo.save(produto);
    }

    public Collection<Produto> getAll() {
        return produtoRepo.findAll();
    }

    public Produto getById(Long id) {
        return produtoRepo.findById(id).get();
    }

    public Produto update(Long id, Produto produto) {
        Produto produtoDB = produtoRepo.findById(id).get();
        produto.setId(produtoDB.getId());
        produtoRepo.save(produto);
        return produto;
    }

    public void remove(Long id) {
        Produto produto = produtoRepo.findById(id).get();
        produtoRepo.delete(produto);
    }

}
