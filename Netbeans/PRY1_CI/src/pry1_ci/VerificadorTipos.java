/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pry1_ci;

/**
 *
 * @author asmal
 * Clase para realizar analisis y verificaciones de tipos
 */
public class VerificadorTipos {
    public VerificadorTipos(){}
    
    /**
     * @param tipo
     * @param valor
     * @param valor2
     * @return Valor Booleano
     * Funcion para redirigir a alguna de las verificaciones
     */
    public boolean opciones(String tipo, String valor, Object valor2) {
        switch(tipo){
            case "int":
                if (verificarEntero(valor2)) return true;
                break;
            case "bool":
                if (verificarBooleano(valor2)) return true;
                break;
            case "float":
                if (verificarFloat(valor2)) return true;
                break;
            case "char":
                if (verificarChar(valor2)) return true;
                break;
            case "string":
                if (verificarString(valor2)) return true;
                break;
            default:
                break;
        }
        return false;
    }
    
    /**
     * @param valor
     * @return Valor Booleano
     * Funcion para verificar si una cadena de carateres puede ser entero
     */
    public boolean verificarEntero(Object valor) {
        try{
            return valor instanceof Integer;
        }
        catch(NumberFormatException e) {
            return false;
        }
        
    }
    
    /**
     * @param valor
     * @return Valor Booleano
     * Funcion para verificar si una cadena de carateres puede ser booleano
     */
    public boolean verificarBooleano(Object valor) {
        try{
            return valor instanceof Boolean; 
        }
        catch(NumberFormatException e) {
            return false;
        }
        
    }
    
    /**
     * @param valor
     * @return Valor Booleano
     * Funcion para verificar si un objeto es flotante
     */
    public boolean verificarFloat(Object valor) {
        return valor instanceof Float;
    }
    
    /**
     * @param valor
     * @return Valor Booleano
     * Funcion para verificar si un objeto puede ser char
     */
    public boolean verificarChar(Object valor) {
        return valor instanceof Character;
        
    }
    
    /**
     * @param valor
     * @return Valor Booleano
     * Funcion para verificar si un objeto puede ser String
     */
    public boolean verificarString(Object valor) {
        try{
            return valor instanceof String;
        }
        catch(Exception e) {
           return false;
        }
    }
    
}

