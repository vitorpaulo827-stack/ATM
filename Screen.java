// Screen.java
// Representa a tela do ATM

public class Screen {
    // exibe uma mensagem sem retorno de carro
    public void displayMessage(String message) {
        System.out.print(message);
    } // fim do método displayMessageline

    // exibe uma mensagem com um retorno de carro
    public void displayMessageLine(String message) {
        System.out.println(message);
    } //fim do método displayMessageLine
    
    // exibe um valor em dólares
    public void displayDollarAmount(double amount) {
    System.out.printf("$%,.2f", amount);
    } // fim do método displayDolarAmount
} // fim da classe Screen