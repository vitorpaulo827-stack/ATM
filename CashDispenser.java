//CashDispenser.java
//Representa o dispensador de cádulas do ATM

public class CashDispenser {
    
    // o numero inicial padão de cédulas no dispensador de cédulas
    private final static int INITIAL_COUNT = 500;
    private int count; // número de cédulas de USS 20 remanescente

    // contrutor sem argumentos CashDispenser inicializa a count para o padrão
    public CashDispenser() {
        count = INITIAL_COUNT; //configura atributo count como o padrão
    } //fim do contrutor CashDispenser

    // simula a entrega da quantia especificada de cédulas
    public void dispenserCash(int amount){
        int billsRequired = amount / 20; //número de cédulas de USS 20 requerido
        count -= billsRequired;     // atualiza a contagem das cédulas
    } // fim do método dispenserCash

    // indica se o dispensador de cédulas pode entregar a quantia desejada
    public boolean isSufficientCashAvaliable(int amount) {
        int billsRequired = amount / 20; // número de cédulas de USS 20 requerido
        return count >= billsRequired;   // se há ou não cédulas suficientes disponíveis
    }// fim do método isSufficientCashAvaliable
     
} // fim da classe CashDispenser