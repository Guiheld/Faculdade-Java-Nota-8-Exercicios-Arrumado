public class Exercicio03Class {

    private int numeroConta;
    private Float saldo;
    private String nomeConta;

    public int accountLinel;

    Exercicio03Class(int accountNum, Float balanceNum, String username){

        numeroConta = accountNum;
        saldo = balanceNum;
        nomeConta = username;


    }


    public void setNomeConta(String username){
        this.nomeConta = username;
    }

    public String getNomeConta(){
        return nomeConta;
    }

    public int getNumeroConta(){
        return numeroConta;
    }

    public Float getSaldo(){
        return saldo;
    }
    
    public void addSaldo(Float balanceNum){
        this.saldo += balanceNum;
    }

    public void subSaldo(Float balanceNum){
        this.saldo -= balanceNum;
    }
    
}
