package br.com.fiap.contatoOficial.dao;

import br.com.fiap.contatoOficial.model.Contatos;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ContatosDao {

    private EntityManager em;

    public ContatosDao(EntityManager em){
        this.em = em;
    }

    public void salvar(Contatos contatos){
        em.persist(contatos);
    }

    public void atualzar(Contatos contatos){
        em.merge(contatos);
    }

    public void excluir(Contatos contatos){
        Contatos contatoExcluir = em.find(Contatos.class, contatos.getId());
        em.remove(contatoExcluir);
    }

    public void consultarContatoPorId(Long id){
        Contatos contatosConsulta = em.find(Contatos.class, id);

        if (contatosConsulta == null){
            System.out.println("Contato não encontrado");
        } else {
            System.out.println("-----------------------------------------------------");
            System.out.println(contatosConsulta.toString());
            System.out.println("-----------------------------------------------------");
        }

    }

    public List<Contatos> listarTodosContatos(){
        String lista = "SELECT c FROM Contatos c ORDER BY nome ASC";
        return em.createQuery(lista).getResultList();
    }

    public List<Contatos> listarContatosPorEmail(String email){
        String lista = "SELECT c FROM Contatos c WHERE email = :email";
        return em.createQuery(lista, Contatos.class)
                .setParameter("email", email)
                .getResultList();
    }
}
