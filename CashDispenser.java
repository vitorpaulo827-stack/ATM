// CashDispenser.java
// Representa o dispensador de cédulas do ATM

class CashDispenser {

    // número inicial padrão de cédulas no dispensador
    private static final int INITIAL_COUNT = 500;

    // número de cédulas de US$20 restantes
    private int count;

    // construtor sem argumentos
    public CashDispenser() {
        count = INITIAL_COUNT;
    }

    // simula a entrega de uma quantia específica
    public void dispenseCash(int amount) {
        int billsRequired = amount / 20; // número de cédulas necessárias
        count -= billsRequired; // atualiza a quantidade de cédulas
    }

    // verifica se há dinheiro suficiente
    public boolean isSufficientCashAvailable(int amount) {
        int billsRequired = amount / 20;
        return count >= billsRequired;
    }

    // método para mostrar quantas cédulas restam
    public int getCount() {
        return count;
    }
}