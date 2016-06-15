package br.home.sanderson.controlagasto.componente;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author AJFILHO
 */
public abstract class ModelJTableGeneric<T extends Object> extends AbstractTableModel {

    private static final Integer COLLUMN_COUNT = 2;
    protected List<T> lista;
    protected Class<T> classe;

    public ModelJTableGeneric() {
        this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public ModelJTableGeneric(Collection<T> lista) {
        this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.lista = new ArrayList<T>(lista);
    }

    public Class<T> getClasse() {
        return classe;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return COLLUMN_COUNT;
    }

    public T getObjetoTable(int row) {
        return lista.get(row);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public List<T> getLista(){
        return lista;
    }
}
