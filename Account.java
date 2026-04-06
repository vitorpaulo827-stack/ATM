// Account.java
// Representa uma conta bancária

public class Account {
    private int accountNumber;      // número da conta
    private int pin;                // PIN para autenticação
    private double avaliableBalance;// fundos dispníveis para saque
    private double totalBalance;    // fundos disponíveis + depósitos pendentes

    // O construtor Account inicializa os atributos
    public Account(int theAccountNumber, int thePIN, double theAvaliableBalance, double theTotalBalance) {
        accountNumber = theAccountNumber;
        pin = thePIN;
        avaliableBalance = theAvaliableBalance;
        totalBalance = theTotalBalance ;
    } // fim do contrutor Account

    // determina se um PIN especificado pelo usuário correspondem ao PIN em Account
    public boolean validatePIN(int userPIN) {
        if (userPIN == pin)
            return true;
        else
            return false;
    } // fim do método validatePIN
    
    // retorna saldo disponível
    public double getAvaliableBalance() {
        return avaliableBalance;
    } // fim de getAvaliableBalance

    // retorna saldo total
    public double getTotalBalance() {
        return totalBalance;
    } // fim do método getTotalBalance

    // credita uma quantia à conta
    public void credit(double amount) {
        totalBalance += amount; // adiciona saldo total
    } // fim do método credit

    // debita uma quantia da conta
    public void debit(double amount) {
        avaliableBalance -= amount; // dubtrai do saldo disponível
        totalBalance -= amount;     // subtrai do saldo total
    } // fim do método debit

    // retorna o número da conta
    public int getAccountNumber() {
        return accountNumber;
    } // fim do método getAccountNumber
} // fim da classe Account