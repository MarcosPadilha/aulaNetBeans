package visao;
/**
 * Teclado
 * 
 * Classe estatica para leitura de teclado que mantem um Singleton do objeto scanner
 * e que nao tem problemas de leituras sendo "puladas" como a usabilidade normal da
 * classe Scanner.
 * @version 0.1
 * @author  Eduardo Reus Souza
 * @uses    java.util.Scanner
 */

import java.util.Scanner;
public class Teclado {
    /**
     * Instancia da classe LScan, usado para manter o singleton
     * @type    Lscan
     * @access  Private
     */
    private static Teclado inst;
    
    /**
     * Instancia da classe Scanner usada para as leituras
     * @type    Scanner
     * @access  Private
     */
    private Scanner scan;
    
    /**
     * Construtor da classe LScan, inicializa o Scanner interno para efetuar as leituras
     * @access Private
     */
    private Teclado(){
        this.scan = new Scanner(System.in);
    }
    
    /**
     * Metodo usado para adquirir o Singleton da classe LScan dentro dos metodos
     * @access  Private
     */
    private synchronized static Teclado getInstance(){
        if( inst == null )
            inst = new Teclado();
        return inst;
    }
    
    /**
     * Getter para o Scanner da instancia
     * @access  Public
     * @return  Scanner
     */
    public Scanner getScanner(){
        return this.scan;
    }
    
    /**
     * Le um byte e limpa o buffer para evitar erros de leitura subsequentes
     * @access  Public
     * @return  Byte
     */
    public static byte lerByte(){
        byte var = Teclado.getInstance().getScanner().nextByte();
        Teclado.getInstance().getScanner().nextLine();
        return var;
    }
    
    /**
     * Le um inteiro e limpa o buffer para evitar erros de leitura subsequente
     * @access  Public
     * @return  int
     */
    public static int lerInt(){
        int var = Teclado.getInstance().getScanner().nextInt();
        Teclado.getInstance().getScanner().nextLine();
        return var;
    }
    
    /**
     * Le um Double e limpa o buffer para evitar erros de leitura subsequente
     * @access  Public
     * @return  double
     */
    public static double lerDouble(){
        double var = Teclado.getInstance().getScanner().nextDouble();
        Teclado.getInstance().getScanner().nextLine();
        return var;
    }
    
    /**
     * Le uma string
     * @access  Public
     * @return  String
     */
    public static String lerString(){
        return Teclado.getInstance().getScanner().nextLine();
    }
}