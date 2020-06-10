/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Convidado, tarlison
 */
public class HeaderFooterPageEvent extends PdfPageEventHelper {
    
    private Date date = new Date();
    private final Font fontHeader = new Font(Font.FontFamily.UNDEFINED, 10,  Font.NORMAL, BaseColor.BLUE);
    private final String pathNumBo = "C:\\Users\\tarli\\OneDrive\\Documents\\1_bo_scripts\\ProjetoRelatorioUFRR-master\\src\\teste\\n_boletim.txt"; 
    private final String pathImage = "C:\\Users\\tarli\\OneDrive\\Documents\\1_bo_scripts\\ProjetoRelatorioUFRR-master\\Imagens\\Cabecalho.png";
    @Override
    public void onStartPage(PdfWriter writer, Document documento) {
        Image cabecalho;
        
        try {
            cabecalho = Image.getInstance(pathImage);
            cabecalho.setAlignment(Element.ALIGN_CENTER);
            cabecalho.scaleAbsolute(550, 90);
            cabecalho.setAbsolutePosition(20, 730);
            writer.getDirectContent().addImage(cabecalho, true);

        } catch (BadElementException ex) {
            Logger.getLogger(HeaderFooterPageEvent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | DocumentException ex) {
            Logger.getLogger(HeaderFooterPageEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void onEndPage(PdfWriter writer, Document documento) {
        Image rodape;
        try {
            rodape = Image.getInstance("C:\\Users\\tarli\\OneDrive\\Documents\\1_bo_scripts\\ProjetoRelatorioUFRR-master\\Imagens\\Rodape.png");
            rodape.setAlignment(Element.ALIGN_CENTER);
            rodape.scaleAbsolute(560, 35);
            rodape.setAbsolutePosition(25, 10);
            writer.getDirectContent().addImage(rodape, true);
//documento.add(cabecalho);
        } catch (BadElementException ex) {
            Logger.getLogger(HeaderFooterPageEvent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HeaderFooterPageEvent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(HeaderFooterPageEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escreveData(PdfWriter writer){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        String today = formatter.format(this.date);
                
        Phrase phrase2 = new Phrase("ATUALIZADO EM: "+today, fontHeader);
        PdfContentByte canvas2 = writer.getDirectContent();
        ColumnText.showTextAligned(canvas2, Element.ALIGN_CENTER, phrase2, 495, 740, 0);        
    }
    public void escreveNumBoletim(PdfWriter writer) throws IOException{
        String numBoletim = NumeroBoletim.lerArquivo(pathNumBo);
        Phrase phrase1 = new Phrase("BOLETIM EPIDEMIOLÓGICO Nº"+numBoletim, fontHeader);
        PdfContentByte canvas1 = writer.getDirectContent();
        ColumnText.showTextAligned(canvas1, Element.ALIGN_CENTER, phrase1, 300, 740, 0);
        int numBo = Integer.parseInt(numBoletim); //num do boletim
        numBo += 1; //att num do boletim
        numBoletim = String.valueOf(numBo);
        System.out.println("aqui "+numBoletim);
        NumeroBoletim.gravarArquivo(numBoletim,pathNumBo);
    }
}

