package br.com.fiap.contatoOficial.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "TB_CONTATOS")
public class Contatos {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TB_CONTATOS_SEQ"
    )
    @SequenceGenerator(
            name = "TB_CONTATOS_SEQ",
            sequenceName = "TB_CONTATO_SEQ",
            allocationSize = 1
    )
    private Long id;
    private String nome;
    private String email;
    @Column(name = "data_nasci")
    private LocalDate dataNascimento;
    @ManyToOne
    @JoinColumn(name = "tipoContatos_id")
    private TipoContatos tipoContatos;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public TipoContatos getTipoContatos() {
        return tipoContatos;
    }

    public void setTipoContatos(TipoContatos tipoContatos) {
        this.tipoContatos = tipoContatos;
    }

    @Override
    public String toString() {
        return "Contatos{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", tipoContatos=" + tipoContatos +
                '}';
    }
}