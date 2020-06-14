/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.JDomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    private final static String pathTabela1XML = "https://roraimacontraocorona.rr.gov.br/winner/api/boletim/boletimtab1/10qwerty!@winner20";
    private final static String pathTabela2XML = "https://roraimacontraocorona.rr.gov.br/winner/api/boletim/boletimtab2/10qwerty!@winner20";
    private final static String pathTabela4XML = "https://roraimacontraocorona.rr.gov.br/winner/api/boletim/boletimtab3/10qwerty!@winner20";

    public static String getTagValue(String tag, Element element) {
        try {
            NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
            Node node = (Node) nodeList.item(0);
            return node.getNodeValue();
        }catch(Exception e) {
            return "NULL";
        }

    }

    public static ArrayList Tabela1() throws ParserConfigurationException, SAXException, IOException, Exception {
        ArrayList<Municipios> _municipios = new ArrayList<>();
        //Lendo arquivo XML
        DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder _builder = _factory.newDocumentBuilder();
        Document doc = _builder.parse(pathTabela1XML);

        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("totalCasoNotificadoDTO");
        List<Municipios> userList = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            userList.add(getMunicipios(nodeList.item(i)));
        }
        for (Municipios emp : userList) {
            _municipios.add(emp);
        }
        return _municipios;
    }

    public static Municipios getMunicipios(Node node) {

        Municipios user = new Municipios();
        if (node.getNodeType() == Node.ELEMENT_NODE) {

            Element element = (Element) node;

            user.setConfirmados(getTagValue("confirmados", element));
            user.setDescartados(getTagValue("descartados", element));
            user.setRecuperados(getTagValue("recuperados", element));
            user.setId(getTagValue("id", element));
            user.setMunicipios(getTagValue("municipios", element));
            user.setNotificados(getTagValue("notificados", element));
        }
        return user;
    }

    public static Tabela2 getTabela2(Node node) {
        Tabela2 user = new Tabela2();
        if (node.getNodeType() == Node.ELEMENT_NODE) {

            Element element = (Element) node;

            user.setFaixaEtaria(getTagValue("faixaEtariaIdade", element));
            user.setPorcentagemFeminino(getTagValue("porcentagemFem", element));
            user.setPorcentagemMasculino(getTagValue("porcentagemMas", element));
            user.setId(getTagValue("id", element));
            user.setPorcentagemMasculinoFeminino(getTagValue("porcentagemMasFem", element));
            user.setTotalFeminino(getTagValue("totalFem", element));
            user.setTotalMasculino(getTagValue("totalMas", element));
            user.setTotalMasculinoFeminino(getTagValue("totalMasFem", element));
        }
        return user;
    }

    public static ArrayList Tabela2() throws ParserConfigurationException, SAXException, IOException, Exception {
        ArrayList<Tabela2> _tab2 = new ArrayList<>();
        //Lendo arquivo XML
        DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder _builder = _factory.newDocumentBuilder();
        Document _doc = _builder.parse(pathTabela2XML);
        _doc.getDocumentElement().normalize();
        NodeList nodeList = _doc.getElementsByTagName("perfilEpidemiologicoDTO");
        List<Tabela2> userList = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            userList.add(getTabela2(nodeList.item(i)));
        }
        for (Tabela2 _aux : userList) {
            _tab2.add(_aux);
        }

        return _tab2;
    }

    public static ArrayList Tabela4() throws ParserConfigurationException, SAXException, IOException, Exception {
        ArrayList<Tabela4> _tab4 = new ArrayList<>();
        //Lendo arquivo XML
        DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder _builder = _factory.newDocumentBuilder();
        Document _doc = _builder.parse(pathTabela4XML);
        _doc.getDocumentElement().normalize();
        NodeList nodeList = _doc.getElementsByTagName("distribuicaoObitoDTO");
        List<Tabela4> userList = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            userList.add(getTabela4(nodeList.item(i)));
        }
        for (Tabela4 _aux : userList) {
            _tab4.add(_aux);
        }
       
        return _tab4;
    }

    public static Tabela4 getTabela4(Node node) {
        Tabela4 user = new Tabela4();
        if (node.getNodeType() == Node.ELEMENT_NODE) {

            Element element = (Element) node;

            user.setNumero(getTagValue4("numero", element));
            user.setVariavel(getTagValue4("variavel", element));
            user.setPorcentagem(getTagValue4("_porcentagem", element));
            user.setId(getTagValue4("id", element));

        }
        return user;
    }

    public static String getTagValue4(String tag, Element element) {
        try {
            NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
            Node node = (Node) nodeList.item(0);
            return node.getNodeValue();
        } catch (Exception e) {
            return "NULL";
        }
    }
}
