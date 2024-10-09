package br.com.fiap.contatoOficial.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_TIPO_CONTATO")
public class TipoContatos {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TB_TIPO_SEQ"
    )
    @SequenceGenerator(
            name = "TB_TIPO_SEQ",
            sequenceName = "TB_TIPO_SEQ",
            allocationSize = 1
    )
    private Long id;
    private String tipo;
    @OneToMany(mappedBy = "tipoContatos")
    private List<Contatos> contatos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Contatos> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contatos> contatos) {
        this.contatos = contatos;
    }

//    @Override
//    public String toString() {
//        return "TipoContatos{" +
//                "id=" + id +
//                ", tipo='" + tipo + '\'' +
//                ", contatos=" + contatos +
//                '}';
//    }
}
