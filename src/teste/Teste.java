/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;


import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Convidado
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws BadElementException, IOException {
    
        Document documento = new Document();
        try {

            try {

                PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream("PrimeiroPDF.pdf"));
                documento.open();
                Font f1 = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
                Font f2 = new Font(Font.FontFamily.TIMES_ROMAN, 14);

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                dataset.setValue(121, "Alto Alegre", "");
                dataset.setValue(57, "Amajarí", "");
                dataset.setValue(4647, "Boa Vista", "");
                dataset.setValue(150, "Bonfim", "");
                dataset.setValue(238, "Cantá", "");
                dataset.setValue(27, "Caracaraí", "");
                dataset.setValue(165, "Caroebe", "");
                dataset.setValue(25, "Iracema", "");
                dataset.setValue(179, "Mucajaí", "");
                dataset.setValue(18, "Normandia", "");
                dataset.setValue(190, "Pacaraima", "");
                dataset.setValue(199, "Rorainopolis", "");
                dataset.setValue(78, "São Luiz", "");

                DefaultCategoryDataset datasetLinha = new DefaultCategoryDataset();
               // datasetLinha.setValue(4388, "Notificados", "27/05");
               // datasetLinha.setValue(4729, "Notificados", "28/05");
               // datasetLinha.setValue(4809, "Notificados", "29/05");
               // datasetLinha.setValue(5129, "Notificados", "30/05");
                datasetLinha.setValue(5351, "Notificados", "31/05");
                datasetLinha.setValue(5621, "Notificados", "01/06");
                datasetLinha.setValue(5904, "Notificados", "02/06");
                datasetLinha.setValue(6267, "Notificados", "03/06");
                datasetLinha.setValue(7732, "Notificados", "04/06");
                datasetLinha.setValue(8640, "Notificados", "05/06");
                
                datasetLinha.setValue(3474, "Confirmados", "31/05");
                datasetLinha.setValue(3692, "Confirmados", "01/06");
                datasetLinha.setValue(3850, "Confirmados", "02/06");
                datasetLinha.setValue(4143, "Confirmados", "03/06");
                datasetLinha.setValue(4831, "Confirmados", "04/06");
                datasetLinha.setValue(5238, "Confirmados", "05/06");

                
                
                JFreeChart graficoLinha = ChartFactory.createLineChart("", "1", "Roraima", datasetLinha, PlotOrientation.VERTICAL, true, false, false);
                JFreeChart graficoBarra = ChartFactory.createBarChart3D("", "Municipio", "Notificados", dataset, PlotOrientation.VERTICAL, true, false, false);

                try {
                    ChartUtilities.saveChartAsJPEG(new File("C:\\Users\\Convidado\\Documents\\NetBeansProjects\\Teste\\Imagens\\chart.jpg"), graficoBarra, 500, 300);
                    ChartUtilities.saveChartAsJPEG(new File("C:\\Users\\Convidado\\Documents\\NetBeansProjects\\Teste\\Imagens\\chart1.jpg"), graficoLinha, 500, 300);
                } catch (Exception e) {
                    System.out.println("Problem occurred creating chart.");
                }

                //PdfPageEventHelper teste = new PdfPageEventHelper();
                PdfPTable tbHeader = new PdfPTable(3);
                PdfPCell _cell = new PdfPCell(new Paragraph("Cabeçalho"));
                _cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                tbHeader.addCell(_cell);
                // tbHeader.writeSelectedRows(0, 0 , documento.leftMargin(),writer.getPageSize().getTop(documento.topMargin()) ,writer.getDirectContent());
                //tbHeader.wri
                documento.add(tbHeader);
                try {
                    Image cabecalho = Image.getInstance("C:\\Users\\Convidado\\Documents\\NetBeansProjects\\Teste\\Imagens\\Cabecalho.png");
                    cabecalho.setAlignment(Element.ALIGN_TOP);
                    cabecalho.scaleAbsolute(540, 100);
                    documento.add(cabecalho);
                } catch (BadElementException ex) {
                    Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
                }

                Paragraph paragraph = new Paragraph("\n \n \n BOLETIM EPIDEMIOLÓGICO SOBRE A DOENÇA \n" + "PELO CORONAVÍRUS 2019 (COVID-19)", f1);
                paragraph.setAlignment(Element.ALIGN_CENTER);

                documento.add(paragraph);

                Paragraph teste = new Paragraph("\n \n \n O estado de Roraima, até o dia 02 de junho de 2020, notificou 6.267 casos para COVID19, de acordo com os critérios de definição de caso recomendados pelo Ministério da Saúde"
                        + "(MS). Destes, 4.143 foram confirmados segundo município de residência e 2.128 foram"
                        + " descartados (Tabela 1)."
                        + "\n Conforme observado na Tabela 1, foram recuperados 29,7% (n= 1.227) do total de"
                        + "pessoas que confirmaram para a doença pela COVID-19. Os dados referentes aos casos"
                        + "recuperados dependem do envio das informações pelos municípios, pois estes acompanham,"
                        + "através da Estratégia Saúde da Família – ESF, a evolução do quadro clínico destes."
                        + "\n \n Tabela 1. Total de casos notificados do Coronavírus 2019 (COVID-19), segundo município de\n"
                        + "residência. Roraima – RR, 2020.\n\n");
                teste.setAlignment(Element.ALIGN_JUSTIFIED);
                documento.add(teste);

                PdfPTable tabela = new PdfPTable(5);
                tabela.addCell("Municipios");
                tabela.addCell("Notificados");
                tabela.addCell("Confirmados");
                tabela.addCell("Recuperados");
                tabela.addCell("Descartados");
                tabela.addCell("Alto Alegre");
                tabela.addCell("121");
                tabela.addCell("78");
                tabela.addCell("25");
                tabela.addCell("43");
                tabela.addCell("Amajarí");
                tabela.addCell("57");
                tabela.addCell("38");
                tabela.addCell("1");
                tabela.addCell("19");
                tabela.addCell("Boa Vista");
                tabela.addCell("4.647");
                tabela.addCell("3.133");
                tabela.addCell("1.002");
                tabela.addCell("1.514");
                tabela.addCell("Bonfim");
                tabela.addCell("150");
                tabela.addCell("84");
                tabela.addCell("23");
                tabela.addCell("66");
                tabela.addCell("Cantá");
                tabela.addCell("238");
                tabela.addCell("170");
                tabela.addCell("7");
                tabela.addCell("68");
                tabela.addCell("Caracaraí");
                tabela.addCell("27");
                tabela.addCell("23");
                tabela.addCell("0");
                tabela.addCell("4");
                tabela.addCell("Coroebe");
                tabela.addCell("165");
                tabela.addCell("67");
                tabela.addCell("29");
                tabela.addCell("98");
                tabela.addCell("Iracema");
                tabela.addCell("25");
                tabela.addCell("13");
                tabela.addCell("0");
                tabela.addCell("12");
                tabela.addCell("Mucajaí");
                tabela.addCell("179");
                tabela.addCell("112");
                tabela.addCell("13");
                tabela.addCell("67");
                tabela.addCell("");
                tabela.addCell("");
                tabela.addCell("");
                tabela.addCell("");
                tabela.addCell("");
                tabela.addCell("");
                tabela.addCell("");
                tabela.addCell("");
                tabela.addCell("");
                tabela.addCell("");
                tabela.addCell("");
                tabela.addCell("");
                tabela.addCell("");
                tabela.addCell("");

                documento.add(tabela);
                Paragraph espaco = new Paragraph("\n \n \n \n \n \n");
                documento.add(espaco);
                Image rodape = Image.getInstance("C:\\Users\\Convidado\\Documents\\NetBeansProjects\\Teste\\Imagens\\Rodape.png");
                rodape.setAlignment(Element.ALIGN_TOP);
                rodape.scaleAbsolute(540, 35);
                documento.add(rodape);

                /*
                documento.add(new Paragraph("\n SITUAÇÃO EPIDEMIOLÓGICA NO ESTADO",f1));
                documento.add(new Paragraph("\n \n O estado de Roraima, até o dia 02 de junho de 2020, notificou 6.267 casos para COVID19,",f2));
                documento.add(new Paragraph("de acordo com os critérios de definição de caso recomendados pelo Ministério da Saúde",f2));
                documento.add(new Paragraph("(MS). Destes, 4.143 foram confirmados segundo município de residência e 2.128 foram",f2));
                documento.add(new Paragraph("descartados (Tabela 1).",f2));
                documento.add(new Paragraph("Conforme observado na Tabela 1, foram recuperados 29,7% (n= 1.227) do total de",f2));
                documento.add(new Paragraph("pessoas que confirmaram para a doença pela COVID-19. Os dados referentes aos casos",f2));
                documento.add(new Paragraph("recuperados dependem do envio das informações pelos municípios, pois estes acompanham,\n",f2));
                documento.add(new Paragraph("através da Estratégia Saúde da Família – ESF, a evolução do quadro clínico destes.",f2));
                documento.add(new Paragraph("Tabela 1. Total de casos notificados do Coronavírus 2019 (COVID-19), segundo município de",f2));
                documento.add(new Paragraph("residência. Roraima – RR, 2020.",f2));
                 */
                Image cabecalho = Image.getInstance("C:\\Users\\Convidado\\Documents\\NetBeansProjects\\Teste\\Imagens\\Cabecalho.png");
                cabecalho.setAlignment(Element.ALIGN_TOP);
                cabecalho.scaleAbsolute(540, 100);
                documento.add(cabecalho);

                documento.add(espaco);
                Image img_graficoBarra = Image.getInstance("C:\\Users\\Convidado\\Documents\\NetBeansProjects\\Teste\\Imagens\\chart.jpg");
                img_graficoBarra.setAlignment(Element.ALIGN_CENTER);
                img_graficoBarra.scaleAbsolute(500, 400);
                documento.add(img_graficoBarra);
                documento.add(espaco);
                documento.add(rodape);
                
                documento.add(espaco);
                documento.add(cabecalho);
                
                documento.add(espaco);
                Image img_graficoLinha = Image.getInstance("C:\\Users\\Convidado\\Documents\\NetBeansProjects\\Teste\\Imagens\\chart1.jpg");
                img_graficoLinha.setAlignment(Element.ALIGN_CENTER);
                img_graficoLinha.scaleAbsolute(500, 400);
                documento.add(img_graficoLinha);
                
                documento.add(espaco);
                documento.add(rodape);
                documento.close();
                writer.close();

            } catch (DocumentException ex) {
                Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
