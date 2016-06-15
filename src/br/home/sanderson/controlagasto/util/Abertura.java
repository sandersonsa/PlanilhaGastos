package br.home.sanderson.controlagasto.util;

import br.home.sanderson.controlagasto.conexao.JPAFactory;
import br.home.sanderson.controlagasto.controle.Controle;
import br.home.sanderson.controlagasto.view.TelaPrincipal;
import java.awt.Component;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author Sanderson
 */
public class Abertura extends SwingWorker<Void, Integer> {

    private Component tela;
    private JProgressBar barraProgresso;

    private Abertura() {
    }

    public Abertura(Component tela, JProgressBar barraProgresso) {
        this.tela = tela;
        this.barraProgresso = barraProgresso;
    }

    @Override
    protected Void doInBackground() throws InterruptedException {
        barraProgresso.setStringPainted(true);
        barraProgresso.setString("Carregando Dados...");
        JPAFactory.construirEntityManagerFactory();
        JPAFactory.pegarEntityManager();
        Thread.sleep(500);
        barraProgresso.setString("Dados carregados com sucesso.");
        Thread.sleep(500);
        barraProgresso.setString("Abrindo Aplicação...");
        Thread.sleep(500);
        tela.setVisible(false);
        new Controle().chamarTelaPrincipal();
        return null;
    }
}