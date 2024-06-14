package infenet.edu.com.example.TP3.DR1.DTO;

import jakarta.validation.constraints.NotBlank;

public class ClienteDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String endereco;
    @NotBlank
    private String email;
    @NotBlank
    private String contato;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
}
