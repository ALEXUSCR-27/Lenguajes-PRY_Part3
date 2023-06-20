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
        String condicion = "";
        boolean salto = false;
        int punteroLista = 0;
        ArrayList<String> variables = new ArrayList<>();
        ArrayList<String> parametros = new ArrayList<>();
        HashMap<String, String> tablaRegistros = new HashMap<String, String>();
        int t = 1;
        for (String i:listaBloques.keySet()) {
            //escritor.write(i+":\n");
            
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
                if (tokens[0].endsWith(":")) {
                    escritor.write(tokens[0]+"\n");
                    if (salto) {
                        escritor.write("addi $sp, $sp, -4\n");
                        escritor.write("sw $ra, 0($sp)\n");
                        salto = false;
                    }
                }
                
                if (tokens.length == 3) {
                    String valor = buscarValor(tokens[2], i, listaBloques);
                    if (!tokens[0].startsWith("t")) { // primer valor es una variable
                        if (tokens[2].startsWith("t")) { // segundo valor es temporal
                            if (valor.equals("call")) { // valor de temporal es el res de una funcion
                                escritor.write("move $t0, $s0\n");
                            }
                            //escritor.write("move $t0, $"+tokens[2]+"\n");
                            escritor.write("sw $t0, "+tokens[0]+"\n");
                        }
                        else {
                            escritor.write("li $t0, "+tokens[2]+"\n"); //t0 = literal
                            escritor.write("sw $t0, "+tokens[0]+"\n"); //t0 -> num
                        }
                    }
                    else { //primer valor es un temporal

                       if (t>7) {
                           t=1;
                       }
                        String registro = "$t"+t;
                        tablaRegistros.put(tokens[0], registro);
                      
                        if (!esEntero(tokens[2])) {
                            escritor.write("lw "+registro+", "+tokens[2]+"\n");
                        }
                        else {
                            escritor.write("li "+registro+", "+tokens[2]+"\n");
                        }
                        
                        t++;
                    }
                    
                }
                
               
                if (tokens.length>4) { //expresiones
                    String etiquetaT = tokens[0];
                    String operando1 = tokens[2];
                    String op = tokens[3];
                    String operando2 = tokens[4];
                    String registro1  = "";
                    String registro2  = "";
                    if (operando1.startsWith("t")) {
                        registro1 = tablaRegistros.get(operando1);
                    }
                    else {
                        registro1 = operando1;
                    }
                    if (operando2.startsWith("t")) {
                        registro2 = tablaRegistros.get(operando2);
                    }
                    else {
                        registro2 = operando2;
                    }
                    if (op.equals("+")) {
                        escritor.write("addu $t0, "+registro1+", "+registro2+"\n");
                        escritor.write("move $s0, $t0\n");
                    }
                    
                    if (op.equals("-")) {
                        escritor.write("subu $t0, "+registro1+", "+registro2+"\n");
                        escritor.write("move $s0, $t0\n");
                    }
                    
                    if (op.equals("*")) {
                        escritor.write("mul $t0, "+registro1+", "+registro2+"\n");
                        escritor.write("move $s0, $t0\n");
                    }
                    
                    if (op.equals("/")) {
                        escritor.write("div "+registro1+", "+registro2+"\n");
                        escritor.write("mflo $t0\n");
                        escritor.write("move $s0, $t0\n");
                        
                    }
                    
                    if (op.equals(">")) {
                        condicion = "bgt "+registro1+", "+registro2;
                    }
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
                        
                        if (tokens[1].startsWith("t")) {
                            parametros.add(tokens[1]);
                            String registro = tablaRegistros.get(parametros.get(punteroLista));
                            if (registro != null) {
                                escritor.write("move $s0, "+registro+"\n");
                            }
                        }
                        else {
                            
                            escritor.write("sw $s0, "+tokens[1]+"\n");
                            punteroLista++;
                        }
                    }
                    if (tokens[0].equals("goto")) {
                        escritor.write("j "+tokens[1]+"\n");
                    }
                }
                
                if (tokens.length == 4) {
                    if (tokens[2].equals("call")) {
                        String funcion = tokens[3].split(",")[0];
                        //escritor.write("li $s0, 0\n");
                        escritor.write("jal "+funcion+"\n");
                        salto = true;
                    }
                    if (tokens[0].equals("if")) {
                        condicion+=","+tokens[3]+"\n";
                        escritor.write(condicion);
                    }
                }
                if (tokens[0].equals("main_end")) {
                    escritor.write("li $v0, 10\n");
                    escritor.write("syscall\n");
                }
             
            }
            
            escritor.write(".end "+i+"\n");
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
    
    public static boolean esEntero(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}
