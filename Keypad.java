// Keypad.java
// Representa o teclado do ATM 

import java.util.Scanner; //o programa utiliza Scanner para obter a entrada de usuario

public class Keypad {
    private Scanner input; // lê os dados na linha de comando 

    // o construtor sem argumento inicializa a classe Scanner
    public Keypad() {
        input = new Scanner(System.in);
    } // fim do construtor Keypad sem argumentos

    // retorna um valor inteiro inserido pelo usúario
    public int getInput() {
        return input.nextInt(); // supomos que usúario insira um inteiro
    } // fim do método getInput
} // fim da clase keypad
