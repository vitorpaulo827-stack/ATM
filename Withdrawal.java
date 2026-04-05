// Withdrawal.java
// Representa uma transação de saque no ATM

public class Withdrawal extends Transaction {
   // constante que corresponde a opção cancelar no menu
   private final static int CANCELED = 6;

   private int amount;                         // quantia a sacar
   private Keypad keypad;                      // referência ao teclado numérico
   private CashDispenser cashDispenser;        // referência ao dispensador de cédulas

   // Construtor de Withdrawal
   public Withdrawal(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, CashDispenser atmCashDispenser) {
      // inicializa as variáveis da superclasse
      super(userAccountNumber, atmScreen, atmBankDatabase);

      // inicializa as referências ao teclado numérico e ao dispensador de cédulas
      keypad = atmKeypad;
      cashDispenser = atmCashDispenser;
   } // fim do construtor de Withdrawal

   // realiza a transação
   @Override
   public void execute() {
      boolean cashDispensed = false; // cédulas ainda não foram entregues
      double availableBalance;       // quantia disponível para saque

      // obtém as referências ao banco de dados e tela do banco
      BankDatabase bankDatabase = getBankDatabase();
      Screen screen = getScreen();

      // faz um loop até as cédulas serem entregues ou o usuário cancelar
      do {
         // obtém a quantia de um saque escolhida pelo usuário