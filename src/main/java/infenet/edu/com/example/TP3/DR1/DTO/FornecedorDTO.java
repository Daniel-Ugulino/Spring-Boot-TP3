package infenet.edu.com.example.TP3.DR1.DTO;

import jakarta.validation.constraints.NotBlank;

public class FornecedorDTO {
    @NotBlank
    private String nomeFantasia;
    @NotBlank
    private String cnpj;
    @NotBlank
    private String email;
    @NotBlank
    private String contato;

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
