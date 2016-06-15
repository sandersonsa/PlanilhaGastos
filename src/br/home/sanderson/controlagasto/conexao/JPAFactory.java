package br.home.sanderson.controlagasto.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import org.h2.jdbc.JdbcSQLException;

/**
 *
 * @author AJFILHO
 */
public class JPAFactory {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static final String DRIVER_H2 = "org.h2.Driver";
    private static final String DATABASE_URL = "Base/base";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "asdfg";
    private static Connection connection = null;

    private JPAFactory() {
        super();
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName(DRIVER_H2);
            return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
//            return DriverManager.getConnection(DATABASE_URL.equals("") ? Utils.DATABASE_URL_LOCAL : Utils.DATABASE_URL, USERNAME, PASSWORD);
        } else {
            return connection;
        }
    }

    public static Connection getConnection(String url) throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName(DRIVER_H2);
            return DriverManager.getConnection(url + "/prefeitura;IFEXISTS=TRUE", USERNAME, PASSWORD);
        } else {
            return connection;
        }
    }

    public static void closeConnection(Connection conexao) {
        try {
            if(conexao != null && !conexao.isClosed())
                conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static EntityManagerFactory construirEntityManagerFactory() throws PersistenceException {
        if (getEntityManagerFactory() != null) {
            fecharEntityManagerFactory();
        }
        return configurarEntityManagerFactory();
    }

    public static EntityManagerFactory construirEntityManagerFactory(String persistenceUnitName, Map properties) throws PersistenceException, SQLException {
        //TODO Alteração na criação do EntityManager
        //        if (getEntityManagerFactory() != null) {
        //            fecharEntityManagerFactory();
        //        }
        return configurarEntityManagerFactory(persistenceUnitName, properties);
    }

    public static EntityManagerFactory construirEMFSeNecessario() {
        if (getEntityManagerFactory() != null) {
            return entityManagerFactory;
        }
        try {
            return configurarEntityManagerFactory();
        } catch (PersistenceException pe) {
            throw new RuntimeException(pe.getMessage(), pe);
        }
    }

    public static EntityManagerFactory configurarEntityManagerFactory() throws PersistenceException {
        entityManagerFactory = Persistence.createEntityManagerFactory("PlanilhaGastosPU");
        return entityManagerFactory;
    }

    public static EntityManagerFactory configurarEntityManagerFactory(String persistenceUnitName, Map properties) throws SQLException {
            try{
                getConnection();
                entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName, properties);
                return entityManagerFactory;
        }catch(JdbcSQLException e){
            throw new SQLException("Base de Dados não localizada, Corrija o endereço.");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
    }

    public static void fecharEntityManagerFactory() {
        if (getEntityManagerFactory() != null) {
            try {
                fecharEntityManager(entityManager);
                entityManager = null;
                getEntityManagerFactory().close();
                entityManagerFactory = null;
                closeConnection(connection);
            } catch (PersistenceException pe) {
                throw new RuntimeException(pe.getMessage(), pe);
            }
        }
    }

    public static EntityManager pegarEntityManager() throws PersistenceException, IllegalStateException {
        if (entityManager == null || !entityManager.isOpen()) {
            construirEMFSeNecessario();
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    public static EntityManager construirNovoEntityManager() throws PersistenceException {
        construirEMFSeNecessario();
        return entityManagerFactory.createEntityManager();
    }

    public static void fecharEntityManager(EntityManager entityManager) {
        if (entityManager != null) {
            try {
                entityManager.close();
            } catch (PersistenceException pe) {
                throw new RuntimeException(pe.getMessage(), pe);
            }
        }
    }

    public static void rollbackTransacao(EntityTransaction transacao) {
        try {
            if (transacao != null) {
                transacao.rollback();
            }
        } catch (TransactionRequiredException tre) {
            throw new RuntimeException(tre.getMessage(), tre);
        } catch (PersistenceException pe) {
            throw new RuntimeException(pe.getMessage(), pe);
        }
    }

    public static void commitTransacao(EntityTransaction transacao) {
        try {
            if (transacao.isActive() && !transacao.getRollbackOnly()) {
                transacao.commit();
            }
        } catch (IllegalStateException ie) {
            throw new RuntimeException(ie.getMessage(), ie);
        } catch (TransactionRequiredException tre) {
            throw new RuntimeException(tre.getMessage(), tre);
        } catch (RollbackException r) {
            throw new RuntimeException(r.getMessage(), r);
        } catch (PersistenceException pe) {
            throw new RuntimeException(pe.getMessage(), pe);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
