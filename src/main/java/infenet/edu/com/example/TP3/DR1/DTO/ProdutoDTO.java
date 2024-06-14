package infenet.edu.com.example.TP3.DR1.DTO;

import infenet.edu.com.example.TP3.DR1.DTO.FornecedorDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public class ProdutoDTO {
    @NotBlank
    private String descricao;
    @NotBlank
    private String tipo;
    @NotNull
    private Double valor;



    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
