/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;


import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import static java.time.Clock.fixed;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;



/**
 *
 * @author Convidado, tarlison
 */
public class Teste {

    /**
     * @param args the command line arguments
     * @throws com.itextpdf.text.BadElementException
     * @throws java.io.IOException
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     */
    public static void main(String[] args) throws BadElementException, IOException, ParserConfigurationException, SAXException, Exception {
        
         
        Document documento = new Document(PageSize.A4, 50, 50, 80, 80);
            try {

                PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream("Bo_Epidemiologico.pdf")); //inicializa o arquivo com o writer
                
                HeaderFooterPageEvent event = new HeaderFooterPageEvent(); //adiciona as imagens de cabeçalho
                
                writer.setPageEvent(event); //
                documento.open(); 
                event.escreveNumBoletim(writer); //escreve o numero do boletim no cabeçalho
                event.escreveData(writer); //escreve a data do boletim no cabeçalho
                
                Font font1 = new Font(Font.FontFamily.UNDEFINED, 12, Font.BOLD);
                Font font2 = new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD);
                Font font3 = new Font(Font.FontFamily.UNDEFINED, 11, Font.BOLD);
                Font font4 = new Font(Font.FontFamily.UNDEFINED, 11);
                Font link = new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD);
                Font fontTabelaMeio = new Font(Font.FontFamily.UNDEFINED, 10);
                link.setColor(BaseColor.BLUE);
                
               
                PdfPTable tbHeader = new PdfPTable(3);
                PdfPCell _cell = new PdfPCell(new Paragraph("Cabeçalho"));
                _cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                tbHeader.addCell(_cell);
               
                documento.add(tbHeader);
               
                Paragraph paragraph = new Paragraph("\n \nBOLETIM EPIDEMIOLÓGICO SOBRE A DOENÇA \n"+ "PELO CORONAVÍRUS 2019 (COVID-19)\n\n", font1);
                paragraph.setAlignment(Element.ALIGN_CENTER);
                documento.add(paragraph);
                
                Chunk c3 = new Chunk("SITUAÇÃO EPIDEMIOLÓGICA NO ESTADO", font1);
                c3.setBackground(new BaseColor(222,234,246), 15, 1, 281, 1);
                Paragraph title = new Paragraph(c3);
                title.setAlignment(Element.ALIGN_LEFT);
                documento.add(title);
                
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Calendar now = Calendar.getInstance();
                
                String today = formatter.format(date);
                
                //Primeiro Paragrafo
                Paragraph textoParte1 = new Paragraph(18,"\n       O estado de Roraima, até o dia "+today+", notificou 6.267 casos para COVID19, de acordo com os critérios de definição de caso recomendados pelo Ministério da Saúde"
                        + "(MS). Destes, 4.143 foram confirmados segundo município de residência e 2.128 foram"
                        + " descartados (Tabela 1)."
                        + "\n       Conforme observado na Tabela 1, foram recuperados 29,7% (n= 1.227) do total de"
                        + "pessoas que confirmaram para a doença pela COVID-19. Os dados referentes aos casos"
                        + "recuperados dependem do envio das informações pelos municípios, pois estes acompanham,"
                        + "através da Estratégia Saúde da Família – ESF, a evolução do quadro clínico destes.");
                documento.add(textoParte1);
                
                //Titulo tabela 1
                Chunk tituloTabela1_1 = new Chunk("\nTabela 1.", font2);
                Chunk tituloTabela1_2 = new Chunk(" Total de casos notificados do Coronavírus 2019 (COVID-19), segundo município de residência. Roraima – RR, 2020.\n\n", font4);
                Paragraph tituloTabela1 = new Paragraph();
                tituloTabela1.add(tituloTabela1_1);
                tituloTabela1.add(tituloTabela1_2);
                documento.add(tituloTabela1);
                
                
                textoParte1.setAlignment(Element.ALIGN_JUSTIFIED);

                //Tabela 1
                ConstruirTabelas.construirTabela1(documento, font2, font3, fontTabelaMeio); //Constroi a primeira tabela
                          
                //rodapé tabela1
                Chunk p1 = new Chunk("     Fonte: Gerenciador de Ambiente Laboratorial/GAL – LACEN/RR.\n"
                        + "     e-SUS Notifica/Ministério da Saúde. Disponível em:",fontTabelaMeio);
                Chunk p2 = new Chunk(" https://notifica.saude.gov.br/login/\n", link);
                Chunk p3 = new Chunk("     Dados atualizados em "+today+" às "+now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE) +" horas. Dados sujeitos à revisão.",fontTabelaMeio); 
                Paragraph rodapeTabela1e2 = new Paragraph();
                rodapeTabela1e2.add(new Chunk(p1));
                rodapeTabela1e2.add(new Chunk(p2));
                rodapeTabela1e2.add(new Chunk(p3));
                documento.add(rodapeTabela1e2);
                
                Paragraph espaco = new Paragraph("\n \n \n");
                documento.add(espaco);
                //Titulo tabela 2
                Chunk tituloTabela2_1 = new Chunk("\n       Tabela 2.", font2);
                Chunk tituloTabela2_2 = new Chunk(" Perfil epidemiológico dos casos confirmados de COVID-19. Roraima–RR, 2020.\n\n", font4);
                Paragraph tituloTabela2 = new Paragraph();
                tituloTabela2.add(tituloTabela2_1);
                tituloTabela2.add(tituloTabela2_2);
                documento.add(tituloTabela2);
                
                //Tabela 2
                ConstruirTabelas.construirTabela2(documento, font2, font3, fontTabelaMeio); //Constroi a segunda tabela
                
                //Rodape tabela 2
                documento.add(rodapeTabela1e2);
                
                
                //Titulo tabela 4
                Chunk tituloTabela4_1 = new Chunk("\n       Tabela 4.", font2);
                Chunk tituloTabela4_2 = new Chunk(" Perfil epidemiológico dos óbitos confirmados por COVID-19, segundo sexo e faixa etária. Roraima – RR, 2020.\n\n", font4);
                Paragraph tituloTabela4 = new Paragraph();
                tituloTabela4.add(tituloTabela4_1);
                tituloTabela4.add(tituloTabela4_2);
                documento.add(tituloTabela4);
                
                //Tabela 4
                ConstruirTabelas.construirTabela4(documento, font3, fontTabelaMeio, writer); //Constroi a quarta tabela

                documento.close();
                writer.close();
                
            } catch (DocumentException ex) {
                Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
