/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.home.sanderson.controlagasto.controle;

import br.home.sanderson.controlagasto.modelo.Despesa;
import br.home.sanderson.controlagasto.util.Utils;
import br.home.sanderson.controlagasto.view.TelaPrincipal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Mangabit
 */
public class Controle {

    public void chamarTelaPrincipal() {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.setVisible(true);
    }

    public void relatorioGeral(List<Despesa> lista) {
        try {
            String path = "Relatório Geral.pdf";
            JasperExportManager.exportReportToPdfFile(imprimirRelatorioGeral(lista), path);
            Utils.abriPDF(path);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private JasperPrint imprimirRelatorioGeral(Collection registros) {
        JasperPrint jasperPrint = null;
        String jasperRps = "relatorioGeral.jasper";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("TIPO_RELATORIO", "Relatório Geral de Todas as Dispesas");
        try {
            JRBeanCollectionDataSource lista = new JRBeanCollectionDataSource(registros);
            jasperPrint = JasperFillManager.fillReport(jasperRps, params, lista);
        } catch (JRException ex) {
            throw new RuntimeException(ex);
        } catch (ExceptionInInitializerError ex) {
            throw new RuntimeException(ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return jasperPrint;
    }
}
