// Keypad.java
// representa o teclado do  ATM

import java.util.Scanner; //o programa uiliza scanner para obter a entrada de usuário

public class Keypad {
    private Scanner input; // lê os dados na linha de comando

    // o construtor sem argumentos inicializa a classe scanner 
    public Keypad() {
        input = new Scanner (System.in);
    } // fim do construtor keypad sem argumentos 

    // retorna um valor inteiro inserido pelo usuário
    public int getInput() {
        return input.nextInt(); // supomos que o usuário insira um inteiro
    } // fim do método getImput
} // fim da classe Keypad