// ATM.java
// Representa um caixa eletrônico

public class ATM {
    // constantes que correspondem as principais opções de menu
    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;

    private boolean userAuthenticated; // se usuário foi autenticado
    private int currentAccountNumber; // número atual da conta de usuário
    private Screen screen;            // tela do ATM
    private Keypad keypad;            // teclado do ATM
    private CashDispenser cashDispenser; // dispensador de cédulas do ATM
    private DepositSlot depositSlot;  // abertura para depósito do ATM
    private BankDatabase bankDatabase;// banco de dados com as informações sobre as contas

    // contrutor sem argumento de ATM inicializa as variáveis de instância
    public ATM() {
        userAuthenticated = false;           // úsuario não foi autenticado para iniciar
        currentAccountNumber = 0;           // nenhum número atual de conta para inciar
        screen = new Screen();              // cria a tela
        keypad = new Keypad();              // cria o teclado
        cashDispenser = new CashDispenser();// cria o dispensador de cédulas
        depositSlot = new DepositSlot();    // abertura para depósito
        bankDatabase = new BankDatabase();  // cria o banco de dados com informãções sobre as contas
    } // fim do contrutor ATM sem argumentos

    // inicia o ATM
    public void run() {
        // dá as boas-vindas e autentica o usuário; realiza trasações
        while (true) {
            // faz um loop enquanto o usuário ainda não está autenticado
            while (!userAuthenticated) {
                screen.displayMessageLine("\nWelcome!");
                authenticatedUser(); // autentica o usuário
            } // fim do while

            performTransactions();      // o usuário agora está autenticado
            userAuthenticated = false; // reinicializa antes da próxima sessão do ATM
            currentAccountNumber = 0;  // reinicializa antes da próxima sessão do ATM
            screen.displayMessageLine("\nThank you! Goodbye!");
        } // fim do while
    } // fim do método run

    // tenta autenticar o usuário contra o banco de dados
    private void authenticatedUser() {
        screen.displayMessage("\nPlease enter your account number: ");
        int accountNumber = keypad.getInput(); // insere o número de conta
        screen.displayMessage("\nEnter your PIN: "); //solicita o PIN
        int pin = keypad.getInput(); // insere o PIN

        // configura userAuthenticated  como valor booleano retornado pelo banco de dados
        userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);

        // verifica se a autenticação foi bem-sucedida
        if (userAuthenticated) {
            currentAccountNumber = accountNumber; // salva a conta do usuário
        } // fim do if
        else {
            screen.displayMessageLine("Invalid account number or PIN. Please try again.");
        } // fim do else
    } // fim do método authenticUser

    // exibe o menu principal e realiza transações
    private void performTransactions() {
        // variável local para armazenar a transação atualmente processada
        Transaction currentTransaction = null;
        boolean userExited = false; // usuário optou por não sair
        // faz um loop enquanto o usuário não escolher a opção para sair do sistema
        while (!userExited) {
            // mostra o menu principal e obtém a seleção de usuário
            int mainMenuSelection = displayMainMenu();
            // decide como prosseguir com base na seleção de menu feita pelo usuário
            switch (mainMenuSelection){
                // o usuário optou por realizar um entre três tipos de transações
                case BALANCE_INQUIRY:
                case WITHDRAWAL:
                case DEPOSIT:
                    // inicializa como o novo objeto do tipo escolhido
                    currentTransaction = createTransaction(mainMenuSelection);
                    currentTransaction.execute(); // executa a transação
                    break;
                case EXIT:  // usuário optou por terminar a sessão
                screen.displayMessageLine("\nExiting the system...");
                userExited = true;  //essa sessão de ATM deve terminar
                    break;
                default:    // usuário não inseriu um inteiro de 1 a 4
                screen.displayMessageLine("\nYou did not enter a valid selection. Try again.");
                    break;
            } // dim do switch
        } // fim do while
    } // fim do método performTransaction

    // exibe o menu principal e retorna uma seleção de entrada
    private int displayMainMenu() {
        screen.displayMessageLine("\nMain menu:");
        screen.displayMessageLine("1 - View my balance");
        screen.displayMessageLine("2 - Withdraw cash");
        screen.displayMessageLine("3 - Deposit founds");
        screen.displayMessageLine("4 - Exit\n");
        screen.displayMessage("Enter a choice: ");
        return keypad.getInput(); //retorna a seleção do usuário
    } // fim do método displayMainMenu

    // retorna o objeto da subclasse de Transaction especificada
    private Transaction createTransaction(int type) {
        Transaction temp = null; // variável Transaction temporária
        // determina qual o tipo de Transaction criar
        switch (type) {
            case BALANCE_INQUIRY: // cria uma nova transação BalanceInquiry
            temp = new BalanceInquiry(currentAccountNumber, screen, bankDatabase);
            break;
            case WITHDRAWAL: // cria uma nova transação withdrawal
            temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);
            break;
            case DEPOSIT: // cria uma nova transação Deposit
            temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);
            break;
        } // fim do switch
        return temp; // retorna o objeto recém-criado
    } // fim do método createTransaction
} // fim da classe ATM