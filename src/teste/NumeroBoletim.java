/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

/**
 *
 * @author tarlison
 */
public class NumeroBoletim{
    
    //
    public static void gravarArquivo(String novoNum, String nomeArq) throws IOException {
      FileWriter arq = new FileWriter(nomeArq);
      PrintWriter gravarArq = new PrintWriter(arq);
      System.out.println("aqui gravar "+novoNum);
      gravarArq.printf(novoNum);
      arq.close();
    }
    
    //
    public static String lerArquivo(String nomeArq) throws FileNotFoundException, IOException {
      FileReader arq = new FileReader(nomeArq);
      BufferedReader lerArq = new BufferedReader(arq);
      String linha = lerArq.readLine();
      System.out.println(linha);
      return linha;
    }
    
}
