// Deposit.java
// Representa uma transação de depósito no ATM

public class Deposit extends Transaction {
   private double amount;              // quantia a depositar
   private Keypad keypad;              // referência ao teclado numérico
   private DepositSlot depositSlot;    // referência à abertura para depósito
   private final static int CANCELED = 0; // constante para a opção de cancelamento

   // Construtor de Deposit
   public Deposit(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, DepositSlot atmDepositSlot) {
      // inicializa as variáveis da superclasse
      super(userAccountNumber, atmScreen, atmBankDatabase);

      // inicializa as referências a teclado e abertura para depósito
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
         // solicita o envelope de depósito contendo a quantia especificada
         screen.displayMessage("\nPlease insert a deposit envelope containing");
         screen.displayDollarAmount(amount);
         screen.displayMessageLine(".");

         // recebe o envelope de depósito