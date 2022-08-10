package com.example.jpah2demo;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nomeCliente", nullable = false)
    private String nomeCliente;

    @Column(name = "idade")
    private int idade;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Telefone> telefones = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List <Endereco> enderecos ;

    public Cliente() {
    }

    public Cliente(Long id, String nomeCliente, int idade, String email) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.idade = idade;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                '}';
    }
}
