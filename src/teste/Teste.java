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
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Convidado, tarlison
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws BadElementException, IOException {
        
       // ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Document documento = new Document(PageSize.A4, 20, 20, 50, 25);
        try {

            try {

                PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream("Bo_Epidemiologico.pdf"));
                HeaderFooterPageEvent event = new HeaderFooterPageEvent();
                writer.setPageEvent(event);
                documento.open(); 
                event.escreveNumBoletim(writer);
                event.escreveData(writer);
                Font font1 = new Font(Font.FontFamily.UNDEFINED, 12, Font.BOLD);
                Font font2 = new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD);
                Font font3 = new Font(Font.FontFamily.UNDEFINED, 11, Font.BOLD);
                
                
                PdfPTable tbHeader = new PdfPTable(3);
                PdfPCell _cell = new PdfPCell(new Paragraph("Cabeçalho"));
                _cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                tbHeader.addCell(_cell);
               
                documento.add(tbHeader);
               
                Paragraph paragraph = new Paragraph("\n \n \n BOLETIM EPIDEMIOLÓGICO SOBRE A DOENÇA \n"+ "PELO CORONAVÍRUS 2019 (COVID-19)", font1);
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
                documento.add(tabela);
                
                Paragraph espaco = new Paragraph("\n \n");
                documento.add(espaco);
               
                
                /*table 2 starts here*/
                
                PdfPTable table2 = new PdfPTable(7);
                table2.setWidthPercentage(90);
                table2.setWidths(new float[] { 3, 1, 1, 1, 1, 1, 1 });
                PdfPCell _cellF, _cellM, _cellFe, _cellT;
                
                _cellF = new PdfPCell(new Phrase("FAIXA\u00a0ETÁRIA\u00a0", font3));
                _cellF.setRowspan(2);
                _cellF.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
                _cellF.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                table2.addCell(_cellF);
          
                
                _cellM = new PdfPCell(new Phrase("MASCULINO", font3));
                _cellM.setColspan(2);
                _cellM.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
                _cellM.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                table2.addCell(_cellM);
                
                _cellFe = new PdfPCell(new Phrase("FEMININO", font3));
                _cellFe.setColspan(2);
                _cellFe.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
                _cellFe.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                table2.addCell(_cellFe);
                
                _cellT = new PdfPCell(new Phrase("TOTAL", font3));
                _cellT.setColspan(2);
                _cellT.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
                _cellT.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

                table2.addCell(_cellT);
                
                String[] nAndPercent = {"nº", "%", "nº", "%", "Nº", "%"};
                for (String iterator : nAndPercent){
                    PdfPCell _cellNandPercent = new PdfPCell(new Phrase(iterator, font2));
                    _cellNandPercent.setBorder(Rectangle.TOP | Rectangle.BOTTOM); //  esse
                    _cellNandPercent.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);// mais essa difere dos 2
                    table2.addCell(_cellNandPercent);
                }
                
                ///////////////////texto
                PdfPCell _cellAux1 = new PdfPCell(new Phrase("Menor que 1 ano", font2));
                _cellAux1.setBorder(PdfPCell.NO_BORDER);
                _cellAux1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT); //Difere dos 2
                table2.addCell(_cellAux1);
                //////////////////
                 
                String[] tableValues1 = {"34", "1,7", "28", "1,3", "62", "1,5"};
                for (String iterator : tableValues1){
                    PdfPCell _cellNandPercent = new PdfPCell(new Phrase(iterator, font2));
                    _cellNandPercent.setBorder(PdfPCell.NO_BORDER); //Difere aqui dos 2
                    _cellNandPercent.setHorizontalAlignment(PdfPCell.ALIGN_CENTER); //
                    table2.addCell(_cellNandPercent);
                }
                
                ///////////////////texto
                PdfPCell _cellAux2 = new PdfPCell(new Phrase("1 a 9 anos", font2));
                _cellAux2.setBorder(PdfPCell.NO_BORDER);
                _cellAux2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);  //Difere dos 2
                table2.addCell(_cellAux2);
                //////////////////
                    
                String[] tableValues2 = {"67", "3,4", "67", "3,1", "134", "3,2"};
                for (String iterator : tableValues2){
                    PdfPCell _cellNandPercent = new PdfPCell(new Phrase(iterator, font2));
                    _cellNandPercent.setBorder(PdfPCell.NO_BORDER); // Difere aqui dos 2
                    _cellNandPercent.setHorizontalAlignment(PdfPCell.ALIGN_CENTER); //
                    table2.addCell(_cellNandPercent);
                }


                documento.add(table2);
                
                
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
