
public class Conta{
    int numero;
    double saldo;
    Cliente dono = new Cliente();
    String agencia;

    boolean deposito(double valor){
        if (valor > 0){
            this.saldo += valor;
            return true;
        }
        return false;
    }
    boolean saque(double valor){
        if (valor > 0 && valor <= this.saldo){
            this.saldo -= valor;
            return true;
        }
        return false;
    }
    boolean transferir(Conta destino, double valor){
        boolean saque = this.saque(valor);
        if (saque){
            boolean deposito = destino.deposito(valor);
            return deposito;
        }
        return false;
    }
    void imprimir(){
        System.out.printf("Dono : %s\nSaldo : %.2f\nNumero : %d\nAgencia : %s\n", this.dono.nome, this.saldo, this.numero, this.agencia);
    }
}