// Deposit.java
// Representa uma transação de depósito no ATM

public class Deposit extends Transaction {
    private double amount;                // quantia a depositar
    private Keypad keypad;                // referência ao teclado númerico
    private DepositSlot depositSlot;      // referência à abertura para depósito
    private final static int CANCELED = 0;// constante para a opção de cancelamento

    // Construtor de Deposit
    public Deposit(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, DepositSlot atmDepositSlot) {
        // inicializa variáveis da superclasse
        super(userAccountNumber, atmScreen, atmBankDatabase);

        // inicializa as referências a teclado a abertura para depósito
        keypad = atmKeypad;
        depositSlot = atmDepositSlot;
    } // fim do construtor de Deposit

    // realiza a transação
    @Override
    public void execute() {
        BankDatabase bankDatabase = getBankDatabase(); // obtém a referência
        Screen screen = getScreen();                   // obtém a referência
        amount = promptForDepositAmount();             // obtém a quantia de depósito do usuário

        // verifica se usuário inseriu uma quantia de depósito ou cancelou
        if (amount != CANCELED) {
            // solicitao envelope de depósito contendo a quantia especificada
            screen.displayMessage("\nPlease insert a deposit envelope containing");
            screen.displayDollarAmount(amount);
            screen.displayMessageLine(".");

            // recebe o envelope
            boolean envelopeReceived = depositSlot.isEnvelopeReceived();
            // verifica sse envelope de depósito foi recebido
            if (envelopeReceived) {
                screen.displayMessageLine("\nYour envelope has been received. \nNote: The money just deposited will not be avaliable until we verify the amount of any enclosed cash and your checks clear.");

            // credita na conta para refletir o deposito
            bankDatabase.credit(getAccountNumber(), amount);
            } // fim do if
            else { // envelope de depósito não foi recebido
                screen.displayMessageLine("\nYou did not insert an envelope, so the ATM has canceled your transaction.");
            } //fim do else
        } // fim do if
        else // o usuário cancelou em vez de inserir uma quantia
        {
            screen.displayMessageLine("\nCancelling transaction...");
        } // fim do else
    } // fim do método execute

    // solicita que o usuário insira uma quantia de depósito em centavos
    private double promptForDepositAmount() {
        Screen screen = getScreen(); // obtém a referência à tela
        // exibe a solicitação
        screen.displayMessage("\nPlease enter a deposit amount in CENTS (or 0 to cancel): ");
        int input = keypad.getInput(); //recebe a entrada da quantia do depósito
        // verifica se o usuário cancelou ou inseriu uma quantidade válida
        if (input == CANCELED)
            return CANCELED;
        else
            return (double) input / 100; //retorna a quantia em dólares

    } // fim do método promptForDepositAmount
} // fim da classe Deposit