/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.home.sanderson.controlagasto.componente;

import br.home.sanderson.controlagasto.modelo.Receita;
import br.home.sanderson.controlagasto.util.Utils;
import java.util.Collection;

/**
 *
 * @author Mangabit
 */
public class JTableModelReceita extends ModelJTableGeneric<Receita> {
    private static final Integer ORIGEM = 0;
    private static final Integer VALOR = 1;
    private static final Integer REFERENCIA = 2;

     public JTableModelReceita(Collection<Receita> receitas) {
        super(receitas);
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        StringBuilder nome = new StringBuilder("");
        if (column == ORIGEM) {
            nome.append("Fonte");
        } else if (column == VALOR) {
            nome.append("Valor (R$)");
        } else if (column == REFERENCIA) {
            nome.append("Referência");
        }
        return nome.toString();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Receita receita = this.getObjetoTable(rowIndex);
        Object objeto = null;
        if (columnIndex == ORIGEM) {
            objeto = receita.getOrigem();
        } else if (columnIndex == VALOR) {
            objeto = receita.getValor();
        } else if (columnIndex == REFERENCIA) {
            objeto = Utils.formatarReferencia(receita.getReferencia());
        }
        return objeto;
    }

}
