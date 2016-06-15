
package br.home.sanderson.controlagasto.util;

import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.*;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import org.h2.tools.Server;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public final class Utils {

    //Variáveis do Proxy
    public static String PROXY_USER = "";
    public static String PROXY_PASSWD = "";
    public static String PROXY_PORT = "";
    public static String PROXY_SERVER = "";
    public static boolean isProxy;
    
    public static final int IMPRIMIR_RPS = 0;
    public static final int TRANSMITIR_LOTE = 1;
    public static final int CONSULTAR_LOTE_RPS = 2;
    public static final int GERAR_LOTE_RPS = 3;
    public static final int CANCELAR_RPS_CONVERTIDO = 4;
    public static final int ERRO_CONT_OK = 0;
    public static final int TIPO_IDENT_CNPJ = 0;
    public static final int TIPO_IDENT_CPF = 1;
    public static final String BOTAO_IMPRIMIR_RPS = "Imprimir RPS";
    public static final String BOTAO_CONSULTAR_RPS = "Consultar RPS";
    public static final String BOTAO_NOVO_RPS = "Emissão de RPS";
    public static final String BOTAO_CONTRIBUINTE = "Selecionar Prestador";
    public static final String BOTAO_REFERENCIA = "Selecionar Referência";
    public static final String BOTAO_CONSULTAR_TRANSMISSAO = "Consultar Lote RPS";
    public static final String BOTAO_GERAR_RPS = "Gerar Lote RPS";
    public static final String BOTAO_CANCELAR_RPS = "Cancelar RPS Convertido";
    public static final String BOTAO_TRANSMITIR_RPS = "Transmitir Lote RPS";
    public static final String BOTAO_IMPRESSORA = "Impressora";
    public static final String BOTAO_BACKUP = "Backup";
    public static final String BOTAO_RESTORE = "Restore";
    public static final String BOTAO_MANUAL = "Sobre";
    public static final String BOTAO_AJUDA = "Manual de Ajuda";
    public static final String BOTAO_PORTAL_NFSd = "Portal NFSd";
    public static final String BOTAO_PORTAL_NFSE_NACIONAL = "Modelo Nacional - ABRASF";
    public static final String BOTAO_PORTAL_ALTAMIRA = "Prefeitura Altamira";
    public static String propsMensagem = System.getProperty("user.dir") + "\\src\\br\\home\\nfeAltamira\\properties\\Mensagens.properties";
    public static String propsPropriedades = "Propriedades.properties";
    public static final String DATABASE_URL_LOCAL = "jdbc:h2:tcp://localhost/" + System.getProperty("user.dir") + "/Base/prefeitura;IFEXISTS=TRUE";
    public static String DATABASE_URL = "";
    public static final String DATABASE_URL_REMOTA = "jdbc:h2:tcp://";
    public static final String DATABASE_URL_BACKUP = "jdbc:h2:tcp://localhost/";
    public static final String DATABASE_URL_REMOTA_PATH = "/C:/RPS/Base/prefeitura;IFEXISTS=TRUE";
    public static final String PRESTADOR_NAO_SELECIONADO = "Selecione um Prestador de Serviço";
    public static final String REFERENCIA_NAO_SELECIONADA = "Escolha uma Referência";
    static Server server = null;
    public static final String ERRO = "-1";
    //////////////////////////////////////////////////////////////
    public static final int ID_ALTAMIRA = 164;
    public static final int REGIME_IMUNE = 4;
    public static final int REGIME_ISENTO = 3;
    public static final int ID_TRIBUTACAO_FORA = 2;
    public static final int SIMPLES_NACIONAL = 7;
    public static final int MICRO_EMPREENDEDOR_INDIVIDUAL = 5;
    public static final int SUSPENSO_DECISAO_JUDICIAL = 7;
    public static final int SUSPENSO_PROCESSO_ADMINISTRATIVO = 7;

    /** Descrição da Operação Tela EmitirRps NOVO_RPS = 0 */
    public static final int NOVO_RPS = 0;
    /** Descrição da Operação Tela EmitirRps RPS_SUBSTITUTO = 1 */
    public static final int RPS_SUBSTITUTO = 1;

    /** Identifica documento com 11 digitos como CPF */
    public static final int IDENTIFICACAO_CPF = 11;
    /** Identifica documento com 14 digitos como CNPJ */
    public static final int IDENTIFICACAO_CNPJ = 14;
    /** Identifica documento com 9 digitos como IE */
    public static final int IDENTIFICACAO_IE = 9;

    public static final String TRIBUTAVEL_MUNICIPIO = "Tributável no Município";
    public static final String TRIBUTAVEL_FORA_MUNICIPIO = "Tributável fora do Município";
    public static final String REGIME_TRIB_JAMAIS = "J";
    public static final String REGIME_TRIB_NUNCA = "N";
    /** Se tomador estrangeiro tpTomador = N */
    public static final String TOMADOR_ESTRANGEIRO = "N";
    /** Se tomador pessoa fisica tpTomador = F */
    public static final String TOMADOR_PESSOA_FISICA = "F";
    /** Informa o tipo de recolhimento como ISS PRÓPRIO */
    public static final String RECOLHIMENTO_ISS_PROPRIO = "ISS Próprio";
    /** Informa o tipo de recolhimento como ISS RETIDO */
    public static final String RECOLHIMENTO_ISS_RETIDO = "ISS Retido";
    ///////////////////////////////////////////////////////////////
    /** Base DIEF **/
    public static final String BASE = File.separator + "Base" + File.separator + "prefeitura.h2.db";
    //URls
    public static final String URL_ALTAMIRA = "www.altamira.pa.cnm.org.br/";
    public static final String URL_PORTAL_NFSd = "nfsd.altamira.pa.gov.br/notadigital/";
    public static final String URL_PORTAL_ABRASF = "www.abrasf.org.br/p2038.aspx";
    //URls
    /** Backup (1) **/
    public static final Integer BACKUP = 1;
    /** Restore (2) **/
    public static final Integer RESTORE = 2;
    /** Valor Vazio "0" (Formato String) **/
    public static final String STRING_VAZIO = "0";
    //------------------------------------------------//
    /** Máscara para Valores. Formato: <b>',##0.00; (,##0.00)'</b> */
    public static final String PATTERN_VALORES = ",##0.00; (,##0.00)";
    public static final String PATTERN_VALORES_4 = ",##0.0000; (,##0.0000)";
    /** Aspas Duplas (String vazia)**/
    public static final String VAZIO = "";
    /** Valor Vazio "0,00" (Formato String) para Campos Monetários **/
    public static final String VALOR_VAZIO = "0,00";
    /** Máscara para Data. Formato: <b>'dd/MM/yyyy'</b> */
    public static final String PATTERN_DATA = "dd/MM/yyyy";
    /** Máscara para Data e Hora. Formato: <b>'dd-MM-yyyy HH:mm:ss'</b> */
    public static final String PATTERN_DATA_HORA = "dd-MM-yyyy HH:mm:ss";
    public static final String PATTERN_DATA_HORA_BACKUP = "ddMMyyyy_HHmm";
    /** Data de Validade do Kit 31/07/2011 */
    public static final String VALIDADE_KIT_DAE = "31/12/2011";
    public static final String ERRO_CONVERSAO_DATA = "Data inválida, informe uma data válida";
    public static final String PATH_DIRETORIO_IMAGEM_BARRAS = System.getProperty("user.dir") + File.separator + "Gerados" + File.separator;
    /** Caminho da imagem do código de barras - /CodeBar.png */
//    public static final String PATH_IMAGEM_BARRAS = System.getProperty("user.dir") + File.separator + "CodeBar.png";
    public static final String PATH_IMAGEM_BARRAS = System.getProperty("user.dir") + File.separator + "CodeBar";
//    private static InscricaoEstadualPA IE = new InscricaoEstadualPA();
    /** Camiho da base /BaseDAE*/
    public static final String URL_BASE_LOCAL = System.getProperty("user.dir") + File.separator + "Base";
    public static final String BACKUP_ERRO = "Erro ao Realizar Cópia de Segurança.\n";
    public static final String BACKUP_OK = "Cópia de Segurança Realizado com Sucesso.\nLocal: ";
    public static final String IMPORTACAO_ERRO = "Erro ao Realizar Importação de Dados. Visualize o Log de Erro para mais Detalhes\nLocal: ";
    public static final String IMPORTACAO_OK = "Importação de Dados Realizada com Sucesso";
    public static final String MESSAGE_LABEL_OK = "CONCLUIDO";
    public static final String MESSAGE_LABEL_ERRO = "ERRO";
    public static final String MESSAGE_LABEL_INFO = "INFORMAÇÃO";
    public static final String MESSAGE_LABEL_AVISO = "AVISO";
    public static final String ASPAS_DUPLAS = "";
    public static final int SIM = 1, NAO = 0;
    public static boolean conectado = false;
//    static DaoUtils utilsDao = new DaoUtils();

    /**
     * Método para Adicionar Enter para trocar Foco de Componentes de Texto.
     * @param jComponents
     * @author Augusto Rezende
     */
    public static void trocarFocoEnter(JComponent... jComponents) {
        for (JComponent jComponent : jComponents) {
            trocarFocoEnter(jComponent);
        }
    }

    /**
     * Método privado para Adicionar Enter para trocar Foco de Componentes de Texto.
     * @param jComponent
     * @author Augusto Rezende
     */
    private static void trocarFocoEnter(JComponent jComponent) {
        Set<AWTKeyStroke> keys = new HashSet<AWTKeyStroke>();
        keys.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_TAB, 0));
        keys.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        jComponent.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
    }

    /**
     * Seta a tecla TAB para trocar foco de JTextArea
     * @param area
     */
    public static void trocarFocoTextArea(JTextArea area) {
        Set<AWTKeyStroke> keys = new HashSet<AWTKeyStroke>();
        keys.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_TAB, 0));
        area.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
    }

    /**
     * Método para setar o tamanho das colunas das tabelas;
     * @author Augusto Rezende
     * @param table
     * @param valores
     */
    public static void setarTamanhoColuna(JTable table, Integer[] valores) {
        for (int i = 0; i < valores.length; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(valores[i]);
        }
    }

    /**
     * Preenche combo municipios
     * @param comboMunicipio
     */
    public static void inicarComboReferencia(JComboBox cmbReferencia) {
        cmbReferencia.removeAllItems();
        DateTime dt = getDtAtual();
        String ano = String.valueOf(dt.getYear());
        cmbReferencia.addItem("01/" + ano);
        cmbReferencia.addItem("02/" + ano);
        cmbReferencia.addItem("03/" + ano);
        cmbReferencia.addItem("04/" + ano);
        cmbReferencia.addItem("05/" + ano);
        cmbReferencia.addItem("06/" + ano);
        cmbReferencia.addItem("07/" + ano);
        cmbReferencia.addItem("08/" + ano);
        cmbReferencia.addItem("09/" + ano);
        cmbReferencia.addItem("10/" + ano);
        cmbReferencia.addItem("11/" + ano);
        cmbReferencia.addItem("12/" + ano);
    }

    public static Integer formatarReferencia(String referencia) {
        Integer ref = Integer.parseInt(referencia.substring(0, 2) + referencia.substring(3, referencia.length()));
        return ref;
    }

    public static String formatarReferencia(Integer ref){
        String refen = String.valueOf(ref);
        StringBuilder referencia = new StringBuilder();
        referencia.append(preencherZeros(2, refen.substring(0, refen.length() - 4)));
        referencia.append("/");
        referencia.append(refen.substring(refen.length() - 4 , refen.length()));
        return referencia.toString();
    }


  
    /**
     * Remove caracteres não numericos.
     * @param numeroFormatado numero com máscara
     * @return apenas numeros
     */
    public static String removeCaracteres(String numeroFormatado) {
        Pattern patternSemCaracteres = Pattern.compile("([0-9])");
//        Pattern patternSemCaracteres = Pattern.compile("\\s");
        if (numeroFormatado == null) {
            return "";
        }
        Matcher matcherNumero = patternSemCaracteres.matcher(numeroFormatado.trim());
        StringBuilder numeroSemFormatacao = new StringBuilder();
        while (matcherNumero.find()) {
            numeroSemFormatacao.append(matcherNumero.group());
        }
        return numeroSemFormatacao.toString();
    }

    /**
     * Remove caracteres não numericos.
     * @param numeroFormatado numero com máscara
     * @return apenas numeros
     */
    public static String removeNumeros(String str) {
        Pattern patternSemNumero = Pattern.compile("([a-zA-Z])");
        if (str == null) {
            return "";
        }
        Matcher matcherLetras = patternSemNumero.matcher(str.trim());
        StringBuilder numeroSemFormatacao = new StringBuilder();
        while (matcherLetras.find()) {
            numeroSemFormatacao.append(matcherLetras.group());
        }
        return numeroSemFormatacao.toString();
    }

    /**
     * Valida endereço de email.
     * @param email endereço de email
     * @return true ou false
     */
    public static boolean validaEmail(String email) {
        Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher m = p.matcher(email);
        if (!m.find()) {
            return false;
        }
        return true;
    }

    /**
     * Retorna String com a data, no formato dd/MM/yyyy
     * @param data DateTime que representa a data
     * @return String dd/MM/yyyy
     */
    public static String getDataString(DateTime data) {
        return data.toString(PATTERN_DATA);
    }

    /**
     * Retorna String com a data, no formato dd/MM/yyyy
     * @param data DateTime que representa a data
     * @return String dd/MM/yyyy
     */
    public static String getDataString(Date dt) {
        DateTime data = new DateTime(dt);
        return data.toString(PATTERN_DATA);
    }

    /**
     * Retorna String com a data atual - dd/MM/yyyy
     * @return data (String)
     */
    public static String getDataAtual() {
        DateTime data = getDtAtual();
        return data.toString(PATTERN_DATA);
    }

    /**
     * Retorna DateTime com a data Utual do sistema
     * @return DateTime
     */
    public static DateTime getDtAtual() {
        DateTime data = new DateTime();
        return data;
    }
    /**
     * Retorna DateTime com a data Utual do sistema
     * @return DateTime
     */
    public static Date dataAtual() {
        DateTime data = getDtAtual();
        return data.toDate();
    }

    /**
     * Retorna a data e hora atual do sistema
     * @return String "dd-MM-yyyy HH:mm:ss"
     */
    public static String getDataAtualHora() {
        DateTime data = getDtAtual();
        return data.toString(PATTERN_DATA_HORA);
    }

    /**
     * Retorna a data e hora atual do sistema
     * @return String "ddMMyyyy_HHmm"
     */
    public static String getDataAtualHoraBackup() {
        DateTime data = getDtAtual();
        return data.toString(PATTERN_DATA_HORA_BACKUP);
    }

    /**
     * Seta "" em JTextField e JTextArea
     * @param JTextField
     */
    public static void limparCamposTexto(Object... componentes) {
        if (componentes == null) {
            return;
        }
        for (Object componente : componentes) {
            if (componente instanceof JTextField || componente instanceof JFormattedTextField) {
                ((JTextField) componente).setText(Utils.VAZIO);
            }
        }
    }

    /**
     * Remove todos os elementos de um JComboBox
     * @param JComboBox
     */
    public static void limparCombox(Object... componentes) {
        if (componentes == null) {
            return;
        }
        for (Object componente : componentes) {
            if (componente instanceof JComboBox) {
                ((JComboBox) componente).removeAll();
                ((JComboBox) componente).setSelectedItem(Utils.VAZIO);
            }
        }
    }

    /**
     * Metodo que pega a Extensao do arquivo passado como parametro;
     * @param nome arquivo
     * @return extensão do arquivo
     */
    public static String pegarExtensaoArquivo(File arquivo) {
        String nomeArquivo = arquivo.getName();
        String extensao = nomeArquivo.substring(nomeArquivo.lastIndexOf("."), nomeArquivo.length());
        return extensao;
    }


    /**
     * Formata um JTextField, quando este perder seu foco, com o padrão monetário.<br/>
     * Caso o JTextField esteja vazio, o valor padrão - 0,00 - preencherá o campo.
     * @param texto O JTextField cuja valor contido deve ser formatado.
     */
    public static void setaCampoFormatoMonetario(JTextField texto) {
        try {
            NumberFormat valorFormatado = new DecimalFormat("#,##0.00");
            String txt = texto.getText().replace(texto.getText(), texto.getText().replaceAll("\\.", ""));
            if (txt.isEmpty()) {
                txt = "0.00";
            }
            String novoTxt = txt.replace(txt, txt.replaceAll("\\.", "."));
            double valor = Double.parseDouble(novoTxt);
            String valorSaida = String.valueOf(((DecimalFormat) valorFormatado).format(Math.abs(valor)));
            texto.setText(String.valueOf(valorSaida));
        } catch (NumberFormatException nfe) {
            texto.setText("0,00");
        }
    }

    /**
     * Método para validação de valores informados pelo JTextField.
     * @author Augusto Rezende
     * @param texto
     */
    public static void verificarValor(JTextField texto) {
        NumberFormat valorFormatado = new java.text.DecimalFormat("#,##0.00");
        valorFormatado.setMaximumIntegerDigits(20);
        valorFormatado.setMaximumFractionDigits(2);
        String txt = texto.getText().replace(texto.getText(), texto.getText().replaceAll("\\.", ""));
        String novoTxt = txt.replace(txt, txt.replaceAll("\\,", "."));
        if (!Utils.isNumeric(novoTxt)) {
        } else {
            texto.setText(VALOR_VAZIO);
            double valor = Double.parseDouble(novoTxt);
            String valorSaida = String.valueOf(((DecimalFormat) valorFormatado).format(getValorAbsoluto(valor)));
            texto.setText(String.valueOf(valorSaida));
        }
    }

    public static String verificarValor(String texto) {
        NumberFormat valorFormatado = new java.text.DecimalFormat("#,##0.00");
        valorFormatado.setMaximumIntegerDigits(20);
        valorFormatado.setMaximumFractionDigits(2);
        String txt = texto.replace(texto, texto.replaceAll("\\.", ""));
        String novoTxt = txt.replace(txt, txt.replaceAll("\\,", "."));
        if (!Utils.isNumeric(novoTxt)) {
            return VALOR_VAZIO;
        } else {
            texto = (VALOR_VAZIO);
            double valor = Double.parseDouble(novoTxt);
            String valorSaida = String.valueOf(((DecimalFormat) valorFormatado).format(getValorAbsoluto(valor)));
            return String.valueOf(valorSaida);
        }
    }

    public static void verificarValorAliquota(JTextField texto) {
        NumberFormat valorFormatado = new java.text.DecimalFormat("#,##0.00");
        valorFormatado.setMaximumIntegerDigits(3);
        valorFormatado.setMaximumFractionDigits(2);
        String txt = texto.getText().replace(texto.getText(), texto.getText().replaceAll("\\.", ""));
        txt = txt.replace("\\,", "");
        txt = txt.substring(0, 1).concat(",").concat(txt.substring(1, txt.length()));
        String novoTxt = txt.replace(txt, txt.replaceAll("\\,", "."));
        if (!Utils.isNumeric(novoTxt)) {
        } else {
            texto.setText(VALOR_VAZIO);
            double valor = Double.parseDouble(novoTxt);
            String valorSaida = String.valueOf(((DecimalFormat) valorFormatado).format(getValorAbsoluto(valor)));
            texto.setText(String.valueOf(valorSaida));
        }
//        NumberFormat valorFormatado = new java.text.DecimalFormat("#,##0.0000");
//        valorFormatado.setMaximumIntegerDigits(5);
//        valorFormatado.setMaximumFractionDigits(4);
//        String txt = texto.getText().replace(texto.getText(), texto.getText().replaceAll("\\.", ""));
//        String novoTxt = txt.replace(txt, txt.replaceAll("\\,", "."));
//        if (!Utils.isNumeric(novoTxt)) {
//        } else {
//            texto.setText(VALOR_VAZIO);
//            double valor = Double.parseDouble(novoTxt);
//            String valorSaida = String.valueOf(((DecimalFormat) valorFormatado).format(getValorAbsoluto(valor)));
//            texto.setText(String.valueOf(valorSaida));
//        }
    }

    public static String verificarValorAliquota(String texto) {
        NumberFormat valorFormatado = new java.text.DecimalFormat("#,##0.00");
        valorFormatado.setMaximumIntegerDigits(3);
        valorFormatado.setMaximumFractionDigits(4);
        String txt = texto.replace(texto, texto.replaceAll("\\.", ""));
        String novoTxt = txt.replace(txt, txt.replaceAll("\\,", "."));
        if (!Utils.isNumeric(novoTxt)) {
            return VALOR_VAZIO;
        } else {
            texto = (VALOR_VAZIO);
            double valor = Double.parseDouble(novoTxt);
            String valorSaida = String.valueOf(((DecimalFormat) valorFormatado).format(getValorAbsoluto(valor)));
            return String.valueOf(valorSaida);
        }
    }

    /** Método que retorna se um Valor é Numerico ou não (Double).
     * @author Augusto Rezende
     * @param s numero para testar
     * @return True ou False
     */
    public static boolean isNumeric(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException notNumeric) {
            return false;
        }
    }

    /**
     * Método para retornar o valor absoluto(Positivo).
     * @author Augusto Rezende
     * @param valor
     * @return double
     */
    public static double getValorAbsoluto(double valor) {
        return Math.abs(valor);
    }

    /**
     * Retorna um DateTime a partir de uma string
     * @param data String que representa a data. DD/MM/YYYY
     * @return DateTime
     */
    public static DateTime getDate(String data) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern(Utils.PATTERN_DATA);
        DateTime date = fmt.parseDateTime(data);
        return date;
    }

    public static Date getDataTxtField(String txt) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.parse(txt);
    }


    /**
     * Proibi a digitação de pontos em JtextField
     * @param evt
     * @param jTextField
     */
    public static void barrarPonto(KeyEvent evt, JTextField jTextField) {
        if (evt.getKeyCode() == KeyEvent.VK_PERIOD || evt.getKeyCode() == 0) {
            String auxiliar = jTextField.getText();
            JOptionPane.showMessageDialog(null, "Por Favor, não é permitido "
                    + "utilizar '.' (Ponto)", "Aviso", 1);
            jTextField.setText(auxiliar);
            evt.setKeyCode(-1);
        }
    }

    /**
     * Transforma o periodo informado em uma data.
     * @param String periodo
     * @return DateTime dtPeriodo
     */
    public static DateTime getDataReferencia(String periodo) {
        DateTime dtPeriodo = null;
        DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/yyyy");
        dtPeriodo = fmt.parseDateTime(periodo);
        return dtPeriodo;
    }

    public static void mensagemAlerta(String message) {
        JOptionPane.showMessageDialog(null, message, "Alerta", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void mensagemAviso(String message) {
        JOptionPane.showMessageDialog(null, message, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void mensagemErro(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Inicializa campos tipo monetário com '0,00'
     * @param campo
     */
    public static void iniciarCamposMonetarios(JTextField... campo) {
        for (JTextField jTextField : campo) {
            jTextField.setText("0,00");
        }
    }

    /**
     * Alinha conteúdo de uma coluna à direita
     * @return DefaultTableCellRenderer
     */
    public static DefaultTableCellRenderer setarAlinhamentoDireita() {
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        return direita;
    }

    /**
     * Alinha conteúdo de uma coluna à direita
     * @return DefaultTableCellRenderer
     */
    public static DefaultTableCellRenderer setarAlinhamentoCentro() {
        DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
        centro.setHorizontalAlignment(SwingConstants.CENTER);
        return centro;
    }

    /**
     * Alinha conteúdo de uma coluna à esquerda
     * @return DefaultTableCellRenderer
     */
    public static DefaultTableCellRenderer setarAlinhamentoEsquerda() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        return esquerda;
    }

    /**
     * Preenche uma string com tamanho definido com zeros à esqueda caso necessário
     * @param tamanho do campo
     * @param string
     * @return string preenchida
     */
    public static String preencherZeros(int zeros, String valor) {
        return String.format("%0" + zeros + "d", Long.parseLong(valor));
    }

    private static String preencherZerosIdentificacao(String valor) {
        if(valor.length() > 11 && valor.length() < 15 || valor.length() == 14){
            return String.format("%0" + 14 + "d", Long.parseLong(valor));
        }else if((valor.length() == 11 || valor.length() < 11) && valor.length() > 6){
            return String.format("%0" + 11 + "d", Long.parseLong(valor));
        }else{
            return valor;
        }
    }
    public static String formatarIdentificaoEnvio(String val) {
        String valor = Utils.removeCaracteres(val);
        if(valor.length() > 11 && valor.length() < 15 || valor.length() == 14){
            return String.format("%0" + 14 + "d", Long.parseLong(valor));
        }else if((valor.length() == 11 || valor.length() < 11) && valor.length() > 6){
            return String.format("%0" + 11 + "d", Long.parseLong(valor));
        }else{
            return valor;
        }
    }

    public static String preencherZeros(int zeros, int valor) {
        return String.format("%0" + zeros + "d", valor);
    }

    /** Formata Valores Double para JtextField ",##0.00; (,##0.00)"
     * @param valor valor Double;
     * @return String
     */
    public static String formatarValor(Double valor) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.applyPattern(PATTERN_VALORES);
        decimalFormat.setMaximumIntegerDigits(11);
        return decimalFormat.format(valor);
    }

    /** Retorna um valor formatado com 4 casas decimais e ',' */
    public static String formatarValor4(Double valor) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.applyPattern(PATTERN_VALORES_4);
        decimalFormat.setMaximumIntegerDigits(11);
        return decimalFormat.format(valor);
    }

    /**
     * Formata numero de CEP com a máscara ##.###-###
     * @param CEP numero de CEP
     * @return
     */
    public static String formatarCEP(String CEP) {
        StringBuilder CEPFormatado = new StringBuilder();
        CEPFormatado.append(CEP.substring(0, 2)).append(".");
        CEPFormatado.append(CEP.substring(2, 5)).append("-");
        CEPFormatado.append(CEP.substring(5, 8));
        return CEPFormatado.toString();
    }

    /**
     * Formata numero de CNPJ com máscara #.###.###/####-##
     * @param cnpj número do CNPJ
     * @return CNPJ com máscara.
     */
    private static String formataCNPJMascara(String cnpj) {
        StringBuilder cnpjFormatado = new StringBuilder();
        cnpjFormatado.append(cnpj.substring(0, 2)).append(".");
        cnpjFormatado.append(cnpj.substring(2, 5)).append(".");
        cnpjFormatado.append(cnpj.substring(5, 8)).append("/");
        cnpjFormatado.append(cnpj.substring(8, 12)).append("-");
        cnpjFormatado.append(cnpj.substring(12, 14));
        return cnpjFormatado.toString();
    }

    /**
     * Formata numero de CPF com a mascara ###.###.###-##
     * @param cpf numero do CPF
     * @return
     */
    private static String formataCPFMascara(String cpf) {
        StringBuilder cpfFormatado = new StringBuilder();
        cpfFormatado.append(cpf.substring(0, 3)).append(".");
        cpfFormatado.append(cpf.substring(3, 6)).append(".");
        cpfFormatado.append(cpf.substring(6, 9)).append("-");
        cpfFormatado.append(cpf.substring(9, 11));
        return cpfFormatado.toString();
    }

    /**
     * Formata número de identificação com máscara
     * @param identificacao Numero de identificação
     * @return numero de identificação formatado com máscara
     */
    public static String formatarIdentificacao(String identificacao) {
        if (identificacao.length() == IDENTIFICACAO_CPF || (identificacao.length() > 7 && identificacao.length() < 12)) {
            return formataCPFMascara(preencherZerosIdentificacao(identificacao));
        } else if (identificacao.length() == IDENTIFICACAO_CNPJ || (identificacao.length() > 11 && identificacao.length() < 15)) {
            return formataCNPJMascara(preencherZerosIdentificacao(identificacao));
        }
        return identificacao;
    }

    /** Formata o numero do RPS e do LoteRPS separando o ano de referência do numero sequencial */
    public static String formatarNumeroRpsLote(String numeroLote) {
        StringBuilder loteFormatado = new StringBuilder();
        loteFormatado.append(numeroLote.substring(0, 4));
        loteFormatado.append(".");
        loteFormatado.append(numeroLote.substring(4, numeroLote.length()));
        return loteFormatado.toString();
    }

    /**
     * Valida numero de identificação
     * @param identificacao numero de identificação, IE, CPF, CNPJ
     * @return true ou false
     */
//    public static boolean validaIdentificacao(String identificacao) {
//        if (identificacao.length() == 11) {
//            return validaCPF(identificacao);
//        } else if (identificacao.length() == 14) {
//            return validaCNPJ(identificacao);
//        } else if (identificacao.length() == 9) {
//            return IE.validate(identificacao);
//        } else {
//            return false;
//        }
//    }
    
    /**
     * Formata header de coluna de jtable
     * @param tabela
     * @return JTableHeader
     */
    public static JTableHeader formataCollumnHeader(JTable tabela) {
        Font fonte = new java.awt.Font("Tahoma", Font.BOLD, 11);
        JTableHeader header = tabela.getTableHeader();
        header.setFont(fonte);
        header.setAlignmentY(SwingConstants.CENTER);
        return header;
    }

    public static String removerFormatoMonetario(String valor) {
        StringBuilder valorFormatado = new StringBuilder();
        valorFormatado.append(valor.replace("R$", "").trim());
        return valorFormatado.toString();
    }

    /**
     * Verifica se valor informado é R$ 0,00
     * @param campo
     * @return
     */
    public static boolean checaValores(JTextField campo) {
        try {
            Double valor = Double.parseDouble(campo.getText().trim().replace(".", "").replace(",", "."));
            if (valor == 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Erro de Conversão: " + e.getMessage());
            return false;
        }
    }

    /**
     * Bloquea a edição de componentes não permitidos.
     * @param componente JTextField, JComboBox, JFormattedTextField, JCheckBox
     */
    public static void bloquearJComponentes(JComponent... componente) {
        if (componente == null) {
            return;
        }
        for (Object comp : componente) {
            if (comp instanceof JTextField || comp instanceof JFormattedTextField) {
                ((JTextField) comp).setEnabled(false);
                ((JTextField) comp).setBackground(Color.WHITE);
                ((JTextField) comp).setForeground(Color.BLACK);
            } else if (comp instanceof JComboBox) {
                ((JComboBox) comp).setEnabled(false);
            } else if (comp instanceof JCheckBox) {
                ((JCheckBox) comp).setEnabled(false);
            }
        }
    }

    public static int verificarCampoObrigatorio(JTextField... txts) {
        int erroCount = 0;
        for (JTextField txt : txts) {
            if (txt.getText().trim().isEmpty()) {
                txt.setBackground(Color.getHSBColor(246, 170, 170));
                erroCount++;
            } else {
                txt.setBackground(Color.WHITE);
            }
        }
        if (erroCount > 0) {
            JOptionPane.showMessageDialog(null, "Os campo Marcados em Vermelho são de preenchimento Obrigatório",
                    "Campos obrigatórios", JOptionPane.INFORMATION_MESSAGE);
        }
        return erroCount;
    }

    public static int verificarCamponNumericosObrigatorio(JTextField... txts) {
        int erroCount = 0;
        for (JTextField txt : txts) {
            try{
                Long.parseLong(Utils.removeCaracteres(txt.getText().trim()));
                txt.setBackground(Color.WHITE);
            }catch(NumberFormatException e){
                txt.setBackground(Color.getHSBColor(246, 170, 170));
                erroCount++;
            }
        }
        if (erroCount > 0) {
            JOptionPane.showMessageDialog(null, "Os campo Marcados em Vermelho são de preenchimento Obrigatório",
                    "Campos obrigatórios", JOptionPane.INFORMATION_MESSAGE);
        }
        return erroCount;
    }

    /**
     * Limpa e Bloquea campos de texto
     * @param componente JTextField
     */
    public static void limparBloquearCamposTexto(Component... componente) {
        if (componente == null) {
            return;
        }
        for (Object comp : componente) {
            if (comp instanceof JTextField || comp instanceof JFormattedTextField) {
                ((JTextField) comp).setEditable(false);
                ((JTextField) comp).setBackground(Color.WHITE);
                ((JTextField) comp).setForeground(Color.BLACK);
            }
        }
    }

    /**
     * Limpa e desbloquea um campo bloqueado por limparBloquearCampos()
     * @param componente
     */
    public static void limparDesbloquearCamposTexto(JComponent... componente) {
        if (componente == null) {
            return;
        }
        for (Object comp : componente) {
            if (comp instanceof JTextField || comp instanceof JFormattedTextField) {
                ((JTextField) comp).setEnabled(true);
                ((JTextField) comp).setEditable(true);
                ((JTextField) comp).setBackground(Color.WHITE);
                ((JTextField) comp).setForeground(Color.BLACK);
            }
        }
    }

    /**
     * Método para centralizar um componente na tela.
     * @author Augusto Rezende
     * @param componente (Component)
     */
    public static void centralizarComponente(Component componente) {
        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dw = componente.getSize();
        componente.setLocation((ds.width - dw.width) / 2, (ds.height - dw.height) / 2);
    }

    /**
     * Metodo para limpar as referencias existentes.
     * @param objetos
     * @author Augusto Rezende
     */
    public static void limparReferencias(Object... objetos) {
        if (objetos == null) {
            return;
        }
        for (Object objeto : objetos) {
            objeto = null;
        }
    }

    /**
     * Identifica o tipo de identificação
     * @param identificacao
     * @return
     */
    public static int tipoIdentificacao(String identificacao) {
        if (identificacao.length() == 14) {
//            return "CNPJ";
            return TIPO_IDENT_CNPJ;
        } else if (identificacao.length() == 9) {
//            return "Inscrição Estadual";
            return 2;
        } else if (identificacao.length() == 11) {
//            return "CPF";
            return TIPO_IDENT_CPF;
        }
        return 5;
    }

    /**
     * Realiza cópia de segurança da base de dados
     * @param origem Diretório a ser copiado
     * @param destino Local onde será realizada a cópia
     * @param overwrite Sobrescrever caso exista.
     * @throws IOException
     */
    public static void copiarTodosArquivos(File origem, File destino, boolean overwrite) throws IOException {
        if (!destino.exists()) {
            destino.mkdir();
        }
        if (!origem.isDirectory()) {
            throw new UnsupportedOperationException("Erro. Origem deve ser um diretório");
        }
        if (!destino.isDirectory()) {
            throw new UnsupportedOperationException("Erro. Destino deve ser um diretório");
        }
        File[] files = origem.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                copiarTodosArquivos(file, new File(destino + File.separator + file.getName()), overwrite);
            } else {
                copiarArquivo(file, new File(destino + File.separator + file.getName()), overwrite);
            }
        }
    }

    /**
     * Copia arquivos de um local para o outro
     * @param origem - Arquivo de origem
     * @param destino - Arquivo de destino
     * @param overwrite - Confirmação para sobrescrever os arquivos
     * @throws IOException
     */
    public static void copiarArquivo(File origem, File destino, boolean overwrite) throws IOException {
        if (destino.exists() && !overwrite) {
            return;
        }
        FileInputStream fisOrigem = new FileInputStream(origem);
        FileOutputStream fisDestino = new FileOutputStream(destino);
        FileChannel fcOrigem = fisOrigem.getChannel();
        FileChannel fcDestino = fisDestino.getChannel();
        fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);
        fisOrigem.close();
        fisDestino.close();
    }

    /**
     * Retorna caminho da pasta de backup
     * @param urlBackup
     * @return
     */
    public static String getCaminhoBackup(String urlBackup) {
        return urlBackup + File.separator + "BackupBaseDAE" + Utils.getDataAtualHora();
    }

    /**
     * Retorna o conteúdo de JTextfield
     * @param campo
     * @return String
     */
    public static String getConteudo(JTextField campo) {
        return campo.getText().trim();
    }

    /** Pega Valor Double de JtextField */
    public static Double getValorDouble(JTextField campo) {
        try {
            return Double.parseDouble(campo.getText().replace(".", "").replace(",", "."));
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * formata data no padrão yyyymmdd e faz parse para int
     * @param data
     * @return
     */
    public static int formataData(Date valor) {
        DateTime dt = new DateTime(valor);
        String data = dt.toString("dd/MM/yyyy");
        StringBuilder tmpData = new StringBuilder();
        tmpData.append(data.substring(6, 10));
        tmpData.append(data.substring(3, 5));
        tmpData.append(data.substring(0, 2));
        return Integer.parseInt(tmpData.toString());
    }

    /** Abre um arquivo PDF com o leitor padrão de arquivos pdf*/
    public static void abriPDF(String path) {
        File arquivoPDFCriado = new File(path);
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(arquivoPDFCriado);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Não Foi possivel Localizar o Arquivo", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "O Sistema não possui Leitor de PDF instalado.\né necessario um programa leitor de arquivo"
                    + "PDF para visualizar o manual", "Alerta", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    String getDescricaoQtde(int tpDescricao) {
        return "";
    }

    public static Double parseToDouble(String valor) throws ParseException {
        final NumberFormat valorFormatado = new java.text.DecimalFormat("#,##0.00");
        return valorFormatado.parse(valor).doubleValue();
    }

    /**
     * Metodo para transformar String em Double (4 casas depois da virgula).
     * @author Augusto Rezende
     * @param valor
     * @return Double
     */
    public static Double parseToDoubleQuatroCasasFracao(String valor) throws ParseException {
        final NumberFormat valorFormatado = new java.text.DecimalFormat("#,##0.0000");
        return valorFormatado.parse(valor).doubleValue();
    }

    /**
     * Metodo para barrar JTextFields vazios (Anexo IV);
     * @author Augusto Rezende
     * @param jTextField
     */
    public static void barrarTxtVazio(JTextField jTextField) {
        if (jTextField.getText().equals("")) {
            jTextField.setText(preencherZerosInteiros());
        }
    }

    /**
     * Metodo para preencher formularios com valores Zerados (0).
     * @author Augusto Rezende
     * @return String
     */
    public static String preencherZerosInteiros() {
        return STRING_VAZIO;
    }

    /**
     * Verifica se a data de cálculo é um dia útil
     * @param d Datatime data
     * @return boolean
     */
    public static boolean isDiaSemana(DateTime d) {
        if (d.getDayOfWeek() == 6) {
            return false;
        } else if (d.getDayOfWeek() == 7) {
            return false;
        }
        return true;
    }

    /** Marcar botão selecionado */
    public static void marcarBotao(JLabel lbl, String botao) {
        lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbl.setText("<html><u>" + botao + "</u></html>");
    }

    /** Marcar botão selecionado */
    public static void marcarBotaoTelaLogin(JLabel lbl, String botao) {
        lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbl.setForeground(new java.awt.Color(51, 51, 255));
        lbl.setText("<html><u>" + botao + "</u></html>");
    }

    /** Marcar botão */
    public static void desmarcarBotao(JLabel lbl, String botao) {
        lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        lbl.setText("<html>" + botao + "</html>");
    }

    public static void desmarcarBotaoTelaLogin(JLabel lbl, String botao) {
        lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        lbl.setForeground(new java.awt.Color(0, 0, 0));
        lbl.setText("<html>" + botao + "</html>");
    }

    public static void inicarCombo(JComboBox combo, String... list) {
        try {
            combo.removeAllItems();
            for (String string : list) {
                combo.addItem(string);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public static void iniciarH2Server() throws SQLException {
        // start the TCP Server
        server = Server.createTcpServer(new String[]{"-tcpAllowOthers"});
        server.start();
        // stop the TCP Server
        if (server.isRunning(true)) {
            System.out.println("Server OK");
        } else {
            System.out.println("Server Erro");
        }
    }

    public static void encerrarH2Server() {
        // stop the TCP Server
        if (server != null) {
            server.stop();
        }
    }

    //TODO: Conexão com a base de dados.
    public static Map getmap(String urlBase) {
        Map<String, String> config = new HashMap<String, String>();
        config.put("hibernate.jdbc.batch_size", "10");
        config.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        config.put("hibernate.connection.url", urlBase);
        config.put("hibernate.connection.user", "base");
        config.put("hibernate.connection.driver_class", "org.h2.Driver");
        config.put("hibernate.connection.password", "jaguatirica");
        config.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
        config.put("hibernate.transaction.TransactionTimeout", "4600");
        config.put("hibernate.connection.autocommit", "false");
        //<property name="transactionTimeout">300</property>
        return config;
    }

    public static boolean isConnected() {
        if(Utils.isProxy){
            System.getProperties().put("http.proxySet", "true");
            System.getProperties().put("http.proxyHost", Utils.PROXY_SERVER);
            System.getProperties().put("http.proxyPort", Utils.PROXY_PORT);
            System.getProperties().put("http.proxyUser", Utils.PROXY_USER);
            System.getProperties().put("http.proxyPassword", Utils.PROXY_PASSWD);
//            Controle.autenticarProxy(Utils.PROXY_USER, Utils.PROXY_PASSWD, Utils.PROXY_PORT, Utils.PROXY_SERVER);
        }
        try {
            int x = 0;
            java.net.URL mandarMail = new java.net.URL("http://www.google.com");
            java.net.URLConnection conn = mandarMail.openConnection();
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) conn;
//            httpConn.setConnectTimeout(500);
            x = httpConn.getResponseCode();
            if (x == 200) { // Código correto 200
                return true;
            } else {
                return false;
            }
        } catch (java.net.MalformedURLException urlmal) {
//            Controle.salvarLog("Utils.isConnected()", urlmal.getMessage());
            return false;
        } catch (java.io.IOException ioexcp) {
//            Controle.salvarLog("Utils.isConnected()", ioexcp.getMessage());
            return false;
        }
    }

    public static void abrirLink(String url) {
        Desktop desk = java.awt.Desktop.getDesktop();
        try {
            desk.browse(new java.net.URI("http://" + url));
        } catch (Exception e) {
//            Controle.salvarLog("Utils.abrilLink()", e.getMessage());
        }
    }

    public static void salvarLogFile(String texto) {
        String conteudo = texto;
        try {
            // o true significa q o arquivo será constante
            File f = new File("log.txt");
            FileWriter x = new FileWriter(f, true);
            conteudo += "\r"; // criando nova linha e recuo no arquivo
            x.write(conteudo); // armazena o texto no objeto x, que aponta para o arquivo
            x.close(); // cria o arquivo
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /** Retorna um BigDecimal a partir do valor inserido no txt field*/
    public static BigDecimal getTxtToValorBigDecimal(JTextField txt) {
        Double a = null;
        BigDecimal b = null;
        try {
            a = parseToDouble(txt.getText().trim());
        } catch (ParseException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        b = new BigDecimal(a).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return b;
    }

    /** Retorna um BigDecimal a partir do valor inserido no txt field*/
    public static BigDecimal getTxtToValorBigDecimalAliq(JTextField txt) throws ParseException {
        Double a = null;
        BigDecimal b = null;
        a = parseToDouble(txt.getText().trim());
        b = new BigDecimal(a).setScale(4, BigDecimal.ROUND_HALF_EVEN);
        return b;
    }

    /** Retorna um BigDecimal a partir do valor inserido no txt field*/
    public static BigDecimal getTxtToValorBigDecimalAliq(JComboBox txt) throws ParseException {
        Double a = null;
        BigDecimal b = null;
        a = parseToDouble(txt.getSelectedItem().toString().trim());
        b = new BigDecimal(a).setScale(4, BigDecimal.ROUND_HALF_EVEN);
        return b;
    }

    public static String getValorBigDecimalToTxt(BigDecimal value) {
        return value.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString();
    }
    /**
     * Metodo para mostrar a Hora em um JLabel, atualizando de segundo
     * em segundo por uma Thread.
     * @author Augusto Rezende
     * @param l (JLabel)
     */
    public static void atualizarTempo(JLabel l) {
        AtualizadorHorario ah = new AtualizadorHorario(l);
        ah.mostrarData(true);
        Thread thHora = ah;
        thHora.start();
    }
}//FIM DA CLASSE

