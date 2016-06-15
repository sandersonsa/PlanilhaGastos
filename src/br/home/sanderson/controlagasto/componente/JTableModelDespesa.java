package br.home.sanderson.controlagasto.componente;

import br.home.sanderson.controlagasto.modelo.Despesa;
import br.home.sanderson.controlagasto.util.Utils;
import java.util.Collection;

/**
 *
 * @author Mangabit
 */
public class JTableModelDespesa extends ModelJTableGeneric<Despesa> {

    private static final Integer TIPO_REGISTRO = 0;
    private static final Integer DESCRICAO = 1;
    private static final Integer VENCIMENTO = 2;
    private static final Integer VALOR = 3;
    private static final Integer PAGAMENTO = 4;

    public JTableModelDespesa(Collection<Despesa> despesas) {
        super(despesas);
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        StringBuilder nome = new StringBuilder("");
        if (column == TIPO_REGISTRO) {
            nome.append("Tipo");
        } else if (column == DESCRICAO) {
            nome.append("Descrição");
        } else if (column == VENCIMENTO) {
            nome.append("Vencimento");
        } else if(column == VALOR){
            nome.append("Valor (R$)");
        } else if(column == PAGAMENTO){
            nome.append("Pago");
        }
        return nome.toString();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Despesa despesa = this.getObjetoTable(rowIndex);
        Object objeto = null;
        if (columnIndex == TIPO_REGISTRO) {
            objeto = despesa.getTipoRegistro().getTipo();
        } else if (columnIndex == DESCRICAO) {
            objeto = despesa.getDescricao();
        } else if (columnIndex == VENCIMENTO) {
            objeto = Utils.getDataString(despesa.getVencimento());
        } else if (columnIndex == VALOR) {
            objeto = Utils.verificarValor(despesa.getValor().toString().replace(".", ","));
        } else if (columnIndex == PAGAMENTO) {
            objeto = despesa.isPago() ? "SIM" : "NÃO";
        }
        return objeto;
    }

}