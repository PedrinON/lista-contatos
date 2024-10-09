package br.com.fiap.contatoOficial;

import br.com.fiap.contatoOficial.dao.Conexao;
import br.com.fiap.contatoOficial.dao.ContatosDao;
import br.com.fiap.contatoOficial.dao.TipoContatosDao;
import br.com.fiap.contatoOficial.model.Contatos;
import br.com.fiap.contatoOficial.model.TipoContatos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Criando o EntityManegers
        EntityManager em = Conexao.getEntityManager();

//        cadastrar(em);
//        atualizar(em);
//        excluir(em);
//        consultarContatoPorId(em);
//        listarTodosContatos(em);
//        listarContatosPorEmail(em);
        buscarTipoContatoPorId(em);
    }

    private static void buscarTipoContatoPorId(EntityManager em) {
        TipoContatosDao tipoContatosDao = new TipoContatosDao(em);
        TipoContatos tipoContatosBuscado = new TipoContatos();
        tipoContatosBuscado.setId(2L);

        TipoContatos tipoContatosEncontrado = new TipoContatos();

        tipoContatosEncontrado = tipoContatosDao.buscarTipoContatoPorId(tipoContatosBuscado);

        System.out.println(tipoContatosEncontrado.getTipo());
        System.out.println(tipoContatosEncontrado.getContatos());
    }

    public static void cadastrar(EntityManager em){
        //Setando um tipo de contato
        TipoContatos tipoContatos = new TipoContatos();
        tipoContatos.setId(3L);
//        tipoContatos.setTipo("Amigo");

        TipoContatosDao tipoContatosDao = new TipoContatosDao(em);
        em.getTransaction().begin();
//        tipoContatosDao.salvar(tipoContatos);

        // Setando um contato e usando o tipo de contato criado
        Contatos contato = new Contatos();
        contato.setNome("Raí");
        contato.setEmail("rai@gmail.com");
        contato.setDataNascimento(LocalDate.of(2004,6,18));
        //usando o tipo de contato setado na linha 32
        contato.setTipoContatos(tipoContatos);

        // Instância ContatoDao
        ContatosDao contatosDao = new ContatosDao(em);

        contatosDao.salvar(contato);
        em.getTransaction().commit();
    }

    public static void atualizar(EntityManager em){
        Contatos contato = new Contatos();
        contato.setId(3L);
        contato.setNome("Matheus Oliveira");
        contato.setEmail("matheusoli@gmail.com");
        contato.setDataNascimento(LocalDate.of(1998,7,22));

        // Instância DAO
        ContatosDao contatosDao = new ContatosDao(em);

        em.getTransaction().begin();
        contatosDao.atualzar(contato);
        em.getTransaction().commit();
    }

    public static void excluir(EntityManager em){
        Contatos contato = new Contatos();
        contato.setId(2L);

        // Instância DAO
        ContatosDao contatosDao = new ContatosDao(em);

        em.getTransaction().begin();
        contatosDao.excluir(contato);
        em.getTransaction().commit();
    }

    public static void consultarContatoPorId(EntityManager em){

        // Instância DAO
        ContatosDao contatosDao = new ContatosDao(em);

        em.getTransaction().begin();
        contatosDao.consultarContatoPorId(4L);
        em.getTransaction().commit();
    }

    public static void listarTodosContatos(EntityManager em){

        // Instância DAO
        ContatosDao contatosDao = new ContatosDao(em);

        List<Contatos> lista = contatosDao.listarTodosContatos();

        for (Contatos contatos : lista){

            System.out.println("--__________________________________________________--");
            System.out.println(contatos.toString());
        }
    }

    public static void listarContatosPorEmail(EntityManager em){

        // Instância DAO
        ContatosDao contatosDao = new ContatosDao(em);

        List<Contatos> lista = contatosDao.listarContatosPorEmail("matheusoli@gmail.com");

        for (Contatos contatos : lista){

            System.out.println("--__________________________________________________--");
            System.out.println(contatos.toString());
        }
    }
}
