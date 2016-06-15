
package br.home.sanderson.controlagasto.persistencia;

import br.home.sanderson.controlagasto.conexao.JPAFactory;
import br.home.sanderson.controlagasto.modelo.Despesa;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Mangabit
 */
public class DaoDespesa extends GenericService<Despesa, Integer> {

    private EntityTransaction transacao;

    public List<Despesa> listarTodosDespesas() {
        EntityManager em = JPAFactory.pegarEntityManager();
        resultadoLista = new ArrayList<Despesa>();
        query = em.createNamedQuery("Despesa.findAll");
        resultadoLista = (List<Despesa>) query.getResultList();
        em.close();
        return resultadoLista;
    }
    
    public List<Despesa> listarDespesasPorReferencia(Integer ref) {
        EntityManager em = JPAFactory.pegarEntityManager();
        resultadoLista = new ArrayList<Despesa>();
        query = em.createNamedQuery("Despesa.findByReferencia");
        query.setParameter("referencia", ref);
        resultadoLista = (List<Despesa>) query.getResultList();
        em.close();
        return resultadoLista;
    }

    public void salvarDespesa(Despesa r) {
        EntityManager em = JPAFactory.pegarEntityManager();
        try {
            transacao = em.getTransaction();
            transacao.begin();
            super.atualizar(r);
            JPAFactory.commitTransacao(transacao);
            em.close();
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao salvar o Despesa", e);
        }
    }

    public void deletarDespesa(Despesa r) {
        EntityManager em = JPAFactory.pegarEntityManager();
        try {
            transacao = em.getTransaction();
            transacao.begin();
            super.deletar(r);
            JPAFactory.commitTransacao(transacao);
            em.close();
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao salvar o Despesa", e);
        }
    }
}
