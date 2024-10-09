package br.com.fiap.contatoOficial.dao;

import br.com.fiap.contatoOficial.model.TipoContatos;
import jakarta.persistence.EntityManager;

public class TipoContatosDao {

    private EntityManager em;

    public TipoContatosDao(EntityManager em){
        this.em = em;
    }

    public void salvar(TipoContatos tipoContatos){
        em.persist(tipoContatos);
    }

    public TipoContatos buscarTipoContatoPorId(TipoContatos tipoContatos){
        return em.find(TipoContatos.class, tipoContatos.getId());
    }
}
