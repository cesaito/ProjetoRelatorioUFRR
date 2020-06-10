/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Convidado
 */
public class LerXML {
    private final static String pathTabela1XML = ".\\XML\\tab1.xml"; 
    private final static String pathTabela2XML = ".\\XML\\tab2.xml"; 
    private final static String pathTabela3XML = ".\\XML\\tab3.xml"; 
    private final static String pathTabela4XML = ".\\XML\\tab4.xml"; 
  

    public static ArrayList ParseXML(Document _doc){
    
        ArrayList _listaTotalTabela = new ArrayList();
        NodeList _listaDados = _doc.getElementsByTagName("row");
        int _tamanhoLista = _listaDados.getLength();

        for (int i = 0; i < _tamanhoLista; i++) {
            Node _municipio = _listaDados.item(i);

            if (_municipio.getNodeType() == Node.ELEMENT_NODE) {

                Element _elementoDados = (Element) _municipio;
                NodeList _listaDeFilhosDados = _elementoDados.getChildNodes();

                int _tamanhoListaFilhos = _listaDeFilhosDados.getLength();
                for (int j = 0; j < _tamanhoListaFilhos; j++) {

                    Node _nofilho = _listaDeFilhosDados.item(j);
                    if (_nofilho.getNodeType() == Node.ELEMENT_NODE) {
                        Element _elementoFilho = (Element) _nofilho;
                       _listaTotalTabela.add(_elementoFilho.getTextContent());
                    }
                }
            }
        }
    return _listaTotalTabela;
    
    }
    public static ArrayList Tabela1() throws ParserConfigurationException, SAXException, IOException {

        
        //Lendo arquivo XML
        DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder _builder = _factory.newDocumentBuilder();
        Document _doc = _builder.parse(pathTabela1XML);
        return ParseXML(_doc);
    }

    public static ArrayList Tabela2() throws ParserConfigurationException, SAXException, IOException {
        
        //Lendo arquivo XML
        DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder _builder = _factory.newDocumentBuilder();
        Document _doc = _builder.parse(pathTabela2XML);
        return ParseXML(_doc);
    }
    
    public static ArrayList Tabela4() throws ParserConfigurationException, SAXException, IOException {
       
        //Lendo arquivo XML
        DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder _builder = _factory.newDocumentBuilder();
        Document _doc = _builder.parse(pathTabela4XML);
        return ParseXML(_doc);
    }


}
