/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.home.sanderson.controlagasto.persistencia;

import br.home.sanderson.controlagasto.conexao.JPAFactory;
import br.home.sanderson.controlagasto.modelo.Receita;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Mangabit
 */
public class DaoReceita extends GenericService<Receita, Integer> {
    private EntityTransaction transacao;

    public List<Receita> listarTodosReceita() {
        EntityManager em = JPAFactory.pegarEntityManager();
        resultadoLista = new ArrayList<Receita>();
        query = em.createNamedQuery("Receita.findAll");
        resultadoLista = (List<Receita>) query.getResultList();
        em.close();
        return resultadoLista;
    }

    public List<Receita> listarReceitasPorReferencia(Integer ref) {
        EntityManager em = JPAFactory.pegarEntityManager();
        resultadoLista = new ArrayList<Receita>();
        query = em.createNamedQuery("Receita.findByReferencia");
        query.setParameter("referencia", ref);
        resultadoLista = (List<Receita>) query.getResultList();
        em.close();
        return resultadoLista;
    }

    public void salvarReceita(Receita r) {
        EntityManager em = JPAFactory.pegarEntityManager();
        try {
            transacao = em.getTransaction();
            transacao.begin();
            super.atualizar(r);
            JPAFactory.commitTransacao(transacao);
            em.close();
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao salvar o Receita", e);
        }
    }

    public void deletarReceita(Receita r) {
        EntityManager em = JPAFactory.pegarEntityManager();
        try {
            transacao = em.getTransaction();
            transacao.begin();
            super.deletar(r);
            JPAFactory.commitTransacao(transacao);
            em.close();
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao salvar o Receita", e);
        }
    }

}
