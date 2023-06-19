/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pry1_ci;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java_cup.runtime.Symbol;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import pry1_ci.GeneradorCodigo.*;

/**
 *
 * @author asmal
 */
public class PRY1_CI {
    static String nombreArchivo = "";
    static File archivoSeleccionado;
    static String raiz;
    static int banderaErrores = 0;
    
    /**
     * Funcion principal
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, Exception {
        presentarLogo();
        seleccionarArchivo();
    }
    
    /**
     * Funcion para presentar el logo del compilador
     * @throws InterruptedException 
     */
    private static void presentarLogo() throws InterruptedException {
        JFrame frame = new JFrame("Logo Window");
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(447, 294);
        frame.setLocationRelativeTo(null);
        
        ImageIcon logoIcon = new ImageIcon("src/pry1_ci/logo.png");
        JLabel logoLabel = new JLabel(logoIcon);

        // Agrega el JLabel al contenido de la ventana
        frame.getContentPane().add(logoLabel, BorderLayout.CENTER);

        // Muestra la ventana
        frame.setVisible(true);
        Thread.sleep(2000);
        frame.dispose();
    }
    
    /**
     * Funcion para seleccionar el archivo que se desea compilar
     * @throws Exception 
     */
    private static void seleccionarArchivo() throws Exception {
        raiz = System.getProperty("user.dir");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona el archivo que deseas compilar");
        File direccionInicial = new File(raiz);
        fileChooser.setCurrentDirectory(direccionInicial);
        
        // Filtra los tipos de archivos permitidos
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        fileChooser.setFileFilter(filter);

        // Abre el explorador de archivos y espera a que el usuario seleccione un archivo
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            archivoSeleccionado = fileChooser.getSelectedFile();
            nombreArchivo = archivoSeleccionado.getName();
            Menu();
        }
    }
    
    /**
     * 
     * @throws IOException
     * @throws Exception 
     */
    private static void Menu() throws IOException, Exception {
        Limpiar();
        System.out.println("\nIniciando analisis lexico...");
        Thread.sleep(1500);
        probarLexer();
        System.out.println("\nIniciando analisis sintactico y semantico...");
        Thread.sleep(1500);
        probarParser();
        generarCodigo();
    }
        
    /**
    * Metodo para eliminar los archivos existentes de analisis pasados
    * @throws java.io.IOException
    */
    private static void Limpiar() throws IOException, Exception {
        String rutaLexer, rutaParser;
        
        rutaLexer = raiz+"\\src\\pry1_ci\\lexer.jflex";
        rutaParser = raiz+"\\src\\pry1_ci\\Parser.cup";
        
        Files.deleteIfExists(Paths.get(raiz+"\\src/pry1_ci\\sym.java"));
        Files.deleteIfExists(Paths.get(raiz+"\\src/pry1_ci\\Parser.java"));
        Files.deleteIfExists(Paths.get(raiz+"\\src/pry1_ci\\LexerAS.java"));
        Files.deleteIfExists(Paths.get(raiz+"\\src/pry1_ci\\analisisLexico.txt"));
        
        Generar(rutaLexer, rutaParser);
        
        Files.move(Paths.get(raiz+"\\sym.java"), Paths.get(raiz+"\\src\\pry1_ci\\sym.java"));
        Files.move(Paths.get(raiz+"\\parser.java"), Paths.get(raiz+"\\src\\pry1_ci\\parser.java"));
    }
    
    /**
    * Metodo para generar el Lexer y Parser
    * @throws java.io.IOException
    */
    private static void Generar(String r1, String r2) throws IOException {
        File archivo;
        archivo = new File(r1);
        JFlex.Main.generate(archivo);
        String[] opciones = {r2};
         try 
        {
            java_cup.Main.main(opciones);
        } 
        catch (Exception ex)
        {
            System.out.print(ex);
        }
         
    }
    
    /**
     * Metodo para realizar el analisis lexico del codigo del archivo escogido
     * @throws java.io.IOException
    */
    private static void probarLexer() throws FileNotFoundException, IOException {
        String rutaEJ1 = archivoSeleccionado.getAbsolutePath();
        Reader reader = new BufferedReader(new FileReader (rutaEJ1));
        reader.read();
        LexerAS lexer = new LexerAS(reader);
        int i = 0;
        
        Symbol token;
        String rutaAnalisis = "src/pry1_ci/analisisLexico.txt";
        
        File analisis = new File(rutaAnalisis);
        
        analisis.createNewFile();
        FileWriter escribir = new FileWriter(analisis);
        BufferedWriter buffer = new BufferedWriter(escribir);
        System.out.println("\n#-------------------------- ANALISIS LEXICO --------------------------#");
        while(true) {
            token = lexer.next_token();
            if(token.sym !=0) {
                String msg = "[Tabla de lexer] Linea: "+lexer.getYYLine()+" Columna: "+lexer.getYYColumn()+" Tokem: "+token.sym+ ", Valor: "+lexer.yytext()+ " ("+sym.terminalNames[token.sym]+")\n";
                
                buffer.write(msg);
                
                if(!"".equals(lexer.getMsgErr())) {
                    buffer.write(lexer.getMsgErr()+"\n");
                    banderaErrores = 1;
                }
                
                lexer.SetMsgErr();
            }
          
            else {
                String msg = "Cantidad de lexemas encontrados: "+i;
                buffer.write(msg);
                buffer.close();
                System.out.println(msg);
                if (banderaErrores == 0) {
                    System.out.println("Sin errores lexicos");
                }
                System.out.println("#-------------------------- FIN ANALISIS LEXICO --------------------------#\n");
                
                System.out.println("Para obtener mas detalles del analisis revisar el archivo analisisSintactico.txt en la direccion");
                System.out.println(raiz+"src/pry1_ci/analisisLexico.txt");
                return;
            }
            i++;
        }
        
    }
    
    /**
     * Metodo para realizar analisis semantico
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception 
     */
    private static void probarParser() throws FileNotFoundException, IOException, Exception {
        String rutaEJ1 = archivoSeleccionado.getAbsolutePath();
        Reader reader = new BufferedReader(new FileReader (rutaEJ1));
        reader.read();
        LexerAS lexer = new LexerAS(new FileReader (rutaEJ1));
        try {
            raiz = System.getProperty("user.dir");
            Files.deleteIfExists(Paths.get(raiz+"\\src/pry1_ci\\codigoIntermedio.txt"));
            String rutaCodigo = "src/pry1_ci/codigoIntermedio.txt";
            File codigo = new File(rutaCodigo);
            codigo.createNewFile();
            System.out.println("\n#-------------------------- ANALISIS SINTACTICO Y SEMANTICO --------------------------#");
            parser p = new parser(lexer);
            Object result = p.parse();
            
            if (p.getBanderaErrores() == 1) {
                banderaErrores = 1;
            }
            
       
        
        }catch (Exception e) {
            System.err.println("Error al intentar realizar analisis: " + e);
            System.err.println("El archivo no se puede compilar");
            banderaErrores = 1;
        }
        System.out.println("#-------------------------- FIN ANALISIS SINTACTICO Y SEMANTICO --------------------------#\n");
           
    }
    
    /**
     * 
     * @throws IOException 
     */
    private static void generarCodigo() throws IOException, InterruptedException {
        Thread.sleep(1000);
        if (banderaErrores == 0) {
            System.out.println("#-------------------------- GENERANDO CODIGO ENSAMBLADOR MIPS --------------------------#");
            Thread.sleep(1500);
            String rutaCI = "src/pry1_ci/codigoIntermedio.txt";
            int lastIndex = nombreArchivo.lastIndexOf(".");
            String nombreFinal = nombreArchivo.substring(0, lastIndex) + ".asm";
            Files.deleteIfExists(Paths.get(raiz+"\\src/pry1_ci\\"+nombreFinal));
            GeneradorCodigo.generarBloques(rutaCI,nombreFinal);
        }
        else {
            System.err.println("El proceso de compilacion ha presentado errores, el archivo no se puede compilar!!");
        }
        
    }
    
}
