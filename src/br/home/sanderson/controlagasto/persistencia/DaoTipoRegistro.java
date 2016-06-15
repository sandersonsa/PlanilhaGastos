/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.home.sanderson.controlagasto.persistencia;

import br.home.sanderson.controlagasto.conexao.JPAFactory;
import br.home.sanderson.controlagasto.modelo.TipoRegistro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Mangabit
 */
public class DaoTipoRegistro extends GenericService<TipoRegistro, Integer> {

    public List<TipoRegistro> listarTipoRegistro() {
        EntityManager em = JPAFactory.pegarEntityManager();
        resultadoLista = new ArrayList<TipoRegistro>();
        query = em.createNamedQuery("TipoRegistro.findAll");
        resultadoLista = (List<TipoRegistro>) query.getResultList();
        em.close();
        return resultadoLista;
    }

}
