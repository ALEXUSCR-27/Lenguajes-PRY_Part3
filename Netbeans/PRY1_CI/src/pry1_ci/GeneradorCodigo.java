/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pry1_ci;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author asmal
 */
public class GeneradorCodigo {
    static String nombreArchivoFinal = "";
    public GeneradorCodigo() {}
    
    /**
     * 
     * @param nombreRuta
     * @param nombreArchivo
     * @throws IOException 
     */
    public static void generarBloques(String nombreRuta, String nombreArchivo) throws IOException {
        nombreArchivoFinal = nombreArchivo;
        HashMap<String, ArrayList<String>> listaBloques = new HashMap<String, ArrayList<String>>();
        BufferedReader lector = new BufferedReader(new FileReader(nombreRuta));
        String funcionInicial = "";
        String finFuncionIni = "";
        String linea;
        int bandera = 1;
        ArrayList datosFuncion = new ArrayList<String>();
        while((linea = lector.readLine())!=null) {
            //System.out.println(funcionInicial);
            if (bandera == 1) {
                funcionInicial = linea.split(":")[0];
                finFuncionIni = funcionInicial+"_end";
                bandera = 0;
            }
            if (linea.equals(finFuncionIni)) {
                datosFuncion.add(linea);
                listaBloques.put(funcionInicial, datosFuncion);
                datosFuncion = new ArrayList<String>();
                bandera = 1;
            }
            else {
                datosFuncion.add(linea);
            }
        }
        //System.out.println(listaBloques);
        escribirBloques(listaBloques);
        
        
    }
    
    /**
     * 
     * @param listaBloques
     * @throws IOException 
     */
    public static void escribirBloques(HashMap<String, ArrayList<String>> listaBloques) throws IOException {
        File archivoMips = new File("src/pry1_ci/"+nombreArchivoFinal);
        archivoMips.createNewFile();
        FileWriter escritor = new FileWriter(archivoMips, true);
        String data = "\n.data\n";
        escritor.write(".text\n");
        ArrayList<String> variables = new ArrayList<String>();
        ArrayList<String> parametros = new ArrayList<String>();
        for (String i:listaBloques.keySet()) {
            escritor.write(i+":\n");
            ArrayList<String> listaDatosF = listaBloques.get(i);
            for (String j:listaDatosF) {
                String[] tokens =j.split(" ");
                if (j.startsWith("data")) {
                    String variable = j.split(" ")[1];
                    if (!variables.contains(variable)) {
                        variables.add(variable);
                        data+=variable+": .word 0\n";
                    }
                }
                if (tokens.length == 3) {
                    if (!tokens[0].startsWith("t")) {
                        if (tokens[2].startsWith("t")) {
                            escritor.write("move $t0, $"+tokens[2]+"\n");
                            escritor.write("sw $t0, "+tokens[0]+"\n");
                        }
                        else {
                            escritor.write("li $t0, "+tokens[2]+"\n");
                            escritor.write("sw $t0, "+tokens[0]+"\n");
                        }
                    }
                    else {
                        escritor.write("lw $"+tokens[0]+", "+tokens[2]+"\n");
                    }
                    
                }
                
               
                if (tokens.length>4) { //expresiones
                    String etiquetaT = tokens[0];
                    String operando1 = tokens[2];
                    String op = tokens[3];
                    String operando2 = tokens[4];
                        
                    if (op.equals("+")) {
                        escritor.write("addu $"+etiquetaT+", $"+operando1+", $"+operando2+"\n");
                        /*if (operando1.startsWith("t")) {
                            String op1 = buscarValor(operando1, i, listaBloques);
                        }
                        if (operando2.startsWith("t")) {
                            String op1 = buscarValor(operando2, i, listaBloques);
                        }*/
                            //escritor.write("li "+operando1+", ");
                    }
                    
                    if (op.equals("-")) {
                        escritor.write("subu $"+etiquetaT+", $"+operando1+", $"+operando2+"\n");
                    }
                        
                        
                        System.out.println(op);
                }
                
                if (tokens.length == 2) {
                    if (tokens[0].equals("print")) {
                        escritor.write("\n# IMPRESION DE DATO\n");
                        escritor.write("li $v0, 1\n");
                        escritor.write("lw $a0, "+tokens[1]+"\n");
                        escritor.write("syscall\n\n");
                        escritor.write("li $a0, 10\n");
                        escritor.write("li $v0, 11\n");
                        escritor.write("syscall\n\n");
                    }
                    if (tokens[0].equals("return")) {
                        escritor.write("li $v0, 10\n");
                        escritor.write("syscall\n\n");
                    }
                    if (tokens[0].equals("param")) {
                        parametros.add(tokens[1]);
                    }
                }
                
                if (tokens.length == 4) {
                    String funcion = tokens[3].split(",")[0];
                    escritor.write("jal "+funcion+"\n");
                }
                
                
                
                
                
                //System.out.println(j);
            }
            escritor.write(".end "+i+"\n");
            //System.out.println(i);
        }
        escritor.write(data);
        escritor.close();
    }
    
    /**
     * 
     * @param nombreTemp
     * @param nombreFuncion
     * @param lista
     * @return 
     */
    public static String buscarValor(String nombreTemp, String nombreFuncion, HashMap<String, ArrayList<String>> lista) {
        for (String i:lista.get(nombreFuncion)) {
            if (i.startsWith("t")) {
                String[] tokens = i.split(" ");
                if (tokens[0].equals(nombreTemp)) {
                    return tokens[2];
                }
            }
        }
        return "";
    }
    
    
    
}
