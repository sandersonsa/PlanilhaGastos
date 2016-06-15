/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.home.sanderson.controlagasto.persistencia;

import static br.home.sanderson.controlagasto.conexao.JPAFactory.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author AJFILHO
 */
public abstract class GenericService<T extends Object, ID extends Serializable> {

    protected EntityManager entityManager;
    protected StringBuilder texto;
    protected Object classe;
    protected Query query;
    protected List<T> resultadoLista;
    protected Class<T> referencia;

    public GenericService() {
        entityManager = pegarEntityManager();
        this.referencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void salvar(T objeto) {
        try {
            entityManager.persist(objeto);
        } catch (EntityExistsException e) {
            rollbackTransacao(entityManager.getTransaction());
            throw new RuntimeException(e.getMessage(), e);
        } catch (PersistenceException pe) {
            rollbackTransacao(entityManager.getTransaction());
            throw new RuntimeException(pe.getMessage(), pe);
        }
    }

    public void atualizar(T objeto) {
        try {
            entityManager.merge(objeto);
        } catch (PersistenceException pe) {
            rollbackTransacao(entityManager.getTransaction());
            throw new RuntimeException(pe.getMessage(), pe);
        }
    }

    public void deletar(T objeto) {
        try {
            entityManager.remove(entityManager.merge(objeto));
        } catch (PersistenceException pe) {
            rollbackTransacao(entityManager.getTransaction());
            throw new RuntimeException(pe.getMessage(), pe);
        }
    }

    public T pegarPorID(ID id) {
        return pegarPorID(referencia, id);
    }

    public <O extends Object> O pegarPorID(Class<O> classe,
            Serializable id) {
        return (O) entityManager.find(classe, id);
    }

    public Class<T> getReferencia() {
        return referencia;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
