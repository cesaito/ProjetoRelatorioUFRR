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
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Convidado
 */
public class HeaderFooterPageEvent extends PdfPageEventHelper {

    @Override
    public void onStartPage(PdfWriter writer, Document documento) {
        Image cabecalho;
        try {
            cabecalho = Image.getInstance("C:\\Users\\Convidado\\Documents\\NetBeansProjects\\Teste\\Imagens\\Cabecalho.png");
            cabecalho.setAlignment(Element.ALIGN_CENTER);
            cabecalho.scaleAbsolute(560, 100);
            cabecalho.setAbsolutePosition(20, 730);
            writer.getDirectContent().addImage(cabecalho, true);
//documento.add(cabecalho);
        } catch (BadElementException ex) {
            Logger.getLogger(HeaderFooterPageEvent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HeaderFooterPageEvent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(HeaderFooterPageEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onEndPage(PdfWriter writer, Document documento) {
        Image rodape;
        try {
            rodape = Image.getInstance("C:\\Users\\Convidado\\Documents\\NetBeansProjects\\Teste\\Imagens\\Rodape.png");
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

}
