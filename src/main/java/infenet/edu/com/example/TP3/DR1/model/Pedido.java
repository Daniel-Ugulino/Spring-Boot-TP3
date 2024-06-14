package infenet.edu.com.example.TP3.DR1.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant updatedDate;
    private Double valor_total;

    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Produto> produtos;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idFuncionario")
    private Funcionario funcionario;

    public Pedido() {
    }

    public Pedido(Long id, String descricao, Double valor_total, List<Produto> produtos, Cliente cliente, Funcionario funcionario) {
        this.id = id;
        this.descricao = descricao;
        this.valor_total = valor_total;
        this.produtos = produtos;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.createdDate = Instant.now();
        this.updatedDate = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }
}
