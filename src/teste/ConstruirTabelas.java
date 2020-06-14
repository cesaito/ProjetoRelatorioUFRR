/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author tarli
 */
public class ConstruirTabelas {

    static ArrayList<Municipios> _listaTabela1 = new ArrayList();
    static ArrayList<Tabela2> _listaTabela2 = new ArrayList();
    static ArrayList<Tabela4> _listaTabela4 = new ArrayList();

    public static void gravaCelulaTab1(String info, PdfPTable tabela1, Font fontTabelaMeio) {
        if (info.equals("NULL")) {
            PdfPCell _cellAuxTable1 = new PdfPCell(new Phrase("0", fontTabelaMeio));
            _cellAuxTable1.setBorder(PdfPCell.NO_BORDER);
            _cellAuxTable1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            _cellAuxTable1.setPaddingBottom((float) 2.4);
            tabela1.addCell(_cellAuxTable1);
        } else {
            PdfPCell _cellAuxTable1 = new PdfPCell(new Phrase(info, fontTabelaMeio));
            _cellAuxTable1.setBorder(PdfPCell.NO_BORDER);
            _cellAuxTable1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            _cellAuxTable1.setPaddingBottom((float) 2.4);
            tabela1.addCell(_cellAuxTable1);
        }

    }

    public static void gravaCelulaTab2(String info, PdfPTable tabela2, Font fontTabelaMeio) {

        PdfPCell _cellAuxTable2 = new PdfPCell(new Phrase(info, fontTabelaMeio));
        _cellAuxTable2.setBorder(PdfPCell.NO_BORDER);
        if (info.matches("[-+]?[0-9]*\\.?[0-9]+")) {
            _cellAuxTable2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        } else {
            _cellAuxTable2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        }
        tabela2.addCell(_cellAuxTable2);
    }

    public static void construirTabela1(Document documento, Font font2, Font font3, Font fontTabelaMeio) throws ParserConfigurationException, SAXException, IOException, DocumentException, Exception {
        PdfPTable tabela1 = new PdfPTable(5);
        tabela1.setWidthPercentage(92);
        PdfPCell _cellTabela1;
        //_listaTabela1 = 
        _listaTabela1 = LerXML.Tabela1();
        String info = null;
        int auxUltimaLinha = 0;
        String[] cabecalhosTabela1 = {"MUNICIPIOS", "NOTIFICADOS", "CONFIRMADOS", "RECUPERADOS", "DESCARTADOS"};
        //Caso cabecalhos da tabela
        for (String iterator : cabecalhosTabela1) {
            _cellTabela1 = new PdfPCell(new Phrase(iterator, font3));
            _cellTabela1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
            _cellTabela1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            _cellTabela1.setPaddingTop((float) 0.4);
            _cellTabela1.setPaddingBottom((float) 1.5);
            tabela1.addCell(_cellTabela1);
        }
        //Caso do Meio da tabela

        for (int i = 0; i < _listaTabela1.size() -1 ; i++) {
            gravaCelulaTab1(_listaTabela1.get(i).getMunicipios(), tabela1, fontTabelaMeio);
            gravaCelulaTab1(_listaTabela1.get(i).getNotificados(), tabela1, fontTabelaMeio);
            gravaCelulaTab1(_listaTabela1.get(i).getConfirmados(), tabela1, fontTabelaMeio);
            gravaCelulaTab1(_listaTabela1.get(i).getRecuperados(), tabela1, fontTabelaMeio);
            gravaCelulaTab1(_listaTabela1.get(i).getDescartados(), tabela1, fontTabelaMeio);
        }

        auxUltimaLinha = _listaTabela1.size() - 1;
        //Caso da Ultima Linha
        String[] _ultimalinha = {_listaTabela1.get(auxUltimaLinha).getMunicipios(), _listaTabela1.get(auxUltimaLinha).getNotificados(), _listaTabela1.get(auxUltimaLinha).getConfirmados(), _listaTabela1.get(auxUltimaLinha).getRecuperados(), _listaTabela1.get(auxUltimaLinha).getDescartados()};

        PdfPCell _cellAuxTable2;
        for (String iterator : _ultimalinha) {
            _cellAuxTable2 = new PdfPCell(new Phrase(iterator, font2));
            _cellAuxTable2.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
            _cellAuxTable2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            _cellAuxTable2.setPaddingBottom((float) 2.4);
            tabela1.addCell(_cellAuxTable2);
        }
        documento.add(tabela1);
    }

    public static void ordenaTabela2(int i, PdfPTable table2, Font fontTabelaMeio) {

        gravaCelulaTab2(_listaTabela2.get(i).getFaixaEtaria(), table2, fontTabelaMeio);
        gravaCelulaTab2(_listaTabela2.get(i).getTotalMasculino(), table2, fontTabelaMeio);
        gravaCelulaTab2(_listaTabela2.get(i).getPorcentagemMasculino(), table2, fontTabelaMeio);
        gravaCelulaTab2(_listaTabela2.get(i).getTotalFeminino(), table2, fontTabelaMeio);
        gravaCelulaTab2(_listaTabela2.get(i).getPorcentagemFeminino(), table2, fontTabelaMeio);
        gravaCelulaTab2(_listaTabela2.get(i).getTotalMasculinoFeminino(), table2, fontTabelaMeio);
        gravaCelulaTab2(_listaTabela2.get(i).getPorcentagemMasculinoFeminino(), table2, fontTabelaMeio);
    }

    public static void construirTabela2(Document documento, Font font2, Font font3, Font fontTabelaMeio) throws DocumentException, ParserConfigurationException, SAXException, Exception {

        int auxUltimaLinha = 0;
        PdfPTable table2 = new PdfPTable(7);
        table2.setWidthPercentage(90);
        table2.setWidths(new float[]{3, 1, 1, 1, 1, 1, 1});
        PdfPCell _cellC;
        String[] cabecalhosTabela2 = {"FAIXA ETÁRIA", "MASCULINO", "FEMININO", "TOTAL"};

        //caso do cabecalho
        for (String iterator : cabecalhosTabela2) {
            _cellC = new PdfPCell(new Phrase(iterator, font3));
            if (iterator.equals("FAIXA ETÁRIA")) {
                _cellC.setRowspan(2);
                _cellC.setPaddingTop(8);
            } else {
                _cellC.setColspan(2);
            }
            _cellC.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
            _cellC.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            table2.addCell(_cellC);
        }
        //caso da 2 linha
        String[] nAndPercent = {"nº", "%", "nº", "%", "Nº", "%"};
        for (String iterator : nAndPercent) {
            PdfPCell _cellNandPercent = new PdfPCell(new Phrase(iterator, font2));
            _cellNandPercent.setBorder(Rectangle.TOP | Rectangle.BOTTOM); //  esse
            _cellNandPercent.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);// mais essa difere dos 2
            table2.addCell(_cellNandPercent);
        }

        _listaTabela2 = LerXML.Tabela2();
        //caso do meio da tabela
        ordenaTabela2(7, table2, fontTabelaMeio);
        ordenaTabela2(1, table2, fontTabelaMeio);
        ordenaTabela2(0, table2, fontTabelaMeio);
        ordenaTabela2(2, table2, fontTabelaMeio);
        ordenaTabela2(3, table2, fontTabelaMeio);
        ordenaTabela2(4, table2, fontTabelaMeio);
        ordenaTabela2(5, table2, fontTabelaMeio);
        ordenaTabela2(6, table2, fontTabelaMeio);


        /*
        for (int i = 0; i < _listaTabela2.size(); i++) {

            if (_listaTabela2.get(i).equals("NULL")) {
                PdfPCell _cellAuxTable2 = new PdfPCell(new Phrase("0", fontTabelaMeio));
                _cellAuxTable2.setBorder(PdfPCell.NO_BORDER);
                _cellAuxTable2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                _cellAuxTable2.setPaddingBottom((float) 2.4);
                table2.addCell(_cellAuxTable2);
            } else if (_listaTabela2.get(i).equals("Total")) {
                auxUltimaLinha = i;
                break;
            } else if (((String) _listaTabela2.get(i)).matches("[-+]?[0-9]*\\.?[0-9]+")) {
                PdfPCell _cellAuxTable2 = new PdfPCell(new Phrase((String) _listaTabela2.get(i), fontTabelaMeio));
                _cellAuxTable2.setBorder(PdfPCell.NO_BORDER);
                _cellAuxTable2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                table2.addCell(_cellAuxTable2);
            } else {
                PdfPCell _cellAuxTable2 = new PdfPCell(new Phrase((String) _listaTabela2.get(i), fontTabelaMeio));
                _cellAuxTable2.setBorder(PdfPCell.NO_BORDER);
                _cellAuxTable2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                table2.addCell(_cellAuxTable2);
            }
        }
        //caso da ultima linha
        for (int i = auxUltimaLinha; i < _listaTabela2.size(); i++) {
            PdfPCell _cellAuxTable2 = new PdfPCell(new Phrase((String) _listaTabela2.get(i), font2));
            _cellAuxTable2.setBorder(Rectangle.TOP | Rectangle.BOTTOM);

            if (((String) _listaTabela2.get(i)).equals("Total")) {
                _cellAuxTable2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            } else {
                _cellAuxTable2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            }
            table2.addCell(_cellAuxTable2);
        }
         */
        documento.add(table2);
    }

    public static void gravaCelulaTab4(String info, PdfPTable tabela4, Font tipoFonte) {
        if (info.matches("[-+]?[0-9]*\\.?[0-9]+")) {
            PdfPCell _cellAuxTable4 = new PdfPCell(new Phrase(info, tipoFonte));
            _cellAuxTable4.setBorder(PdfPCell.NO_BORDER);
            _cellAuxTable4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            tabela4.addCell(_cellAuxTable4);
        } else if (info.equals("Sexo") | info.equals("Faixa etária")) {
            PdfPCell _cellAuxTable4 = new PdfPCell(new Phrase(info, tipoFonte));
            _cellAuxTable4.setBorder(PdfPCell.NO_BORDER);
            _cellAuxTable4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tabela4.addCell(_cellAuxTable4);
        } else if (info.equals("NULL")) {
            PdfPCell _cellAuxTable4 = new PdfPCell(new Phrase("", tipoFonte));
            _cellAuxTable4.setBorder(PdfPCell.NO_BORDER);
            _cellAuxTable4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tabela4.addCell(_cellAuxTable4);
        } else {
            PdfPCell _cellAuxTable4 = new PdfPCell(new Phrase(info, tipoFonte));
            _cellAuxTable4.setBorder(PdfPCell.NO_BORDER);
            _cellAuxTable4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tabela4.addCell(_cellAuxTable4);

        }

    }

    public static void ordenaTabela4(int i, PdfPTable table4, Font tipoFonte) {
        if (_listaTabela4.get(i).equals("0") || _listaTabela4.get(i).equals("3")) {
            gravaCelulaTab4(_listaTabela4.get(i).getVariavel(), table4, tipoFonte);
            gravaCelulaTab4("", table4, tipoFonte);
            gravaCelulaTab4("", table4, tipoFonte);
        } else {
            gravaCelulaTab4(_listaTabela4.get(i).getVariavel(), table4, tipoFonte);
            gravaCelulaTab4(_listaTabela4.get(i).getNumero(), table4, tipoFonte);
            gravaCelulaTab4(_listaTabela4.get(i).getPorcentagem(), table4, tipoFonte);

        }
    }

    public static void construirTabela4(Document documento, Font font3, Font fontTabelaMeio, PdfWriter writer) throws ParserConfigurationException, SAXException, IOException, DocumentException, Exception {

        PdfPTable tabela4 = new PdfPTable(3);
        tabela4.setWidthPercentage(45);
        PdfPCell _cellC;
        String[] cabecalho = {"Variável", "nº", "%"};

        //caso do cabecalho
        for (String iterator : cabecalho) {
            _cellC = new PdfPCell(new Phrase(iterator, font3));
            _cellC.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
            _cellC.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            tabela4.addCell(_cellC);
        }
        _listaTabela4 = LerXML.Tabela4();

        ordenaTabela4(0, tabela4, font3);
        ordenaTabela4(2, tabela4, fontTabelaMeio);
        ordenaTabela4(1, tabela4, fontTabelaMeio);
        ordenaTabela4(3, tabela4, font3);
        ordenaTabela4(12, tabela4, fontTabelaMeio);
        ordenaTabela4(5, tabela4, fontTabelaMeio);
        ordenaTabela4(4, tabela4, fontTabelaMeio);
        ordenaTabela4(6, tabela4, fontTabelaMeio);
        ordenaTabela4(7, tabela4, fontTabelaMeio);
        ordenaTabela4(9, tabela4, fontTabelaMeio);
        ordenaTabela4(9, tabela4, fontTabelaMeio);
        ordenaTabela4(10, tabela4, fontTabelaMeio);
        ordenaTabela4(11, tabela4, fontTabelaMeio);
        /*
        //caso meio da tabela
        for (int i = 0; i < _listaTabela4.size(); i++) {
            if (_listaTabela4.get(i).equals("NULL")) {
                PdfPCell _cellAuxTable4 = new PdfPCell(new Phrase("", font3));
                _cellAuxTable4.setBorder(PdfPCell.NO_BORDER);
                tabela4.addCell(_cellAuxTable4);
            } else if (((String) _listaTabela4.get(i)).equals("Sexo") | ((String) _listaTabela4.get(i)).equals("Faixa etária")) {
                PdfPCell _cellAuxTable4 = new PdfPCell(new Phrase((String) _listaTabela4.get(i), font3));
                _cellAuxTable4.setBorder(PdfPCell.NO_BORDER);
                _cellAuxTable4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                tabela4.addCell(_cellAuxTable4);
            } else if (((String) _listaTabela4.get(i)).matches("[-+]?[0-9]*\\.?[0-9]+")) {
                PdfPCell _cellAuxTable4 = new PdfPCell(new Phrase((String) _listaTabela4.get(i), fontTabelaMeio));
                _cellAuxTable4.setBorder(PdfPCell.NO_BORDER);
                _cellAuxTable4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                tabela4.addCell(_cellAuxTable4);
            } else {
                PdfPCell _cellAuxTable4 = new PdfPCell(new Phrase((String) _listaTabela4.get(i), fontTabelaMeio));
                _cellAuxTable4.setBorder(PdfPCell.NO_BORDER);
                _cellAuxTable4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                tabela4.addCell(_cellAuxTable4);
            }
        }
         */
        documento.add(tabela4);
    }

}
