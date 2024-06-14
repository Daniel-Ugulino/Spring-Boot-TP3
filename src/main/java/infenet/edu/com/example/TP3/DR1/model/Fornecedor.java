package infenet.edu.com.example.TP3.DR1.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeFantasia;
    private String cnpj;
    private String email;
    private String contato;
    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant updatedDate;

    public Fornecedor(Long id, String nomeFantasia, String cnpj, String email, String contato) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.email = email;
        this.contato = contato;
        this.createdDate = Instant.now();
        this.updatedDate = Instant.now();
    }

    public Fornecedor() {
    }

    public Long getId() {
        return id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
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
