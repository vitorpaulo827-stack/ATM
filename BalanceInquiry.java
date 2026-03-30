// BlanceInquiry.java
// Representa uma transação de consulta de saldos no ATM

public class BalanceInquiry extends Trasaction {

    // Construtor de BalanceInquiry
    public BalanceInquiry(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
        super(userAccountNumber, atmScreen, atmBankDatabase):
    } // fim do construtor de BalanceInquiry
    
    @Override
    public void execute() {
        // obtém as referências ao banco de dados e tela do banco
        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();

        // obétem o saldo disponivel da conta encolvida