import java.util.*;

public class Exercicio3 {

    static int menu(int menuOpt, Scanner scannerNum){

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Abrir uma conta bancaria");
        System.out.println("2. consultar saldo de cliente");
        System.out.println("3. realizar deposito em uma conta bancaria");
        System.out.println("4. gerar pagamento");
        System.out.println("5. sair");

        menuOpt = scannerNum.nextInt();
        return menuOpt;

    }

    static void cadastrar(ArrayList<Exercicio03Class> accounts, Scanner scannerNum, Scanner scannerString){

        int accountNum = accounts.size() + 1;
        Float balanceNum = 0f;

        System.out.println("Digite o nome do usuario:");
        String username = scannerString.nextLine();

        Exercicio03Class user = new Exercicio03Class(accountNum, balanceNum, username);

        accounts.add(user);

        System.out.println("Usuario cadastrado com sucesso: Numero de conta " + accountNum + " | Nome de usuario: " + username);

    }

    static int consultarSaldoCliente(ArrayList<Exercicio03Class> accounts, Scanner scannerNum, Scanner scannerString, int accountLine){

        System.out.println("Digite 1 - para procurar pelo nome de usuario | 2 - para procurar por numero de conta");
        int opt = scannerNum.nextInt();

        if(opt == 1){

            System.out.println("Digite o nome do usuario: ");
            String inputName = scannerString.nextLine();

            for(int i = 0; i < accounts.size(); i++){
                if(inputName.equals(accounts.get(i).getNomeConta())){
                    accountLine = i;
                }
            }



        }else if(opt == 2){
            System.out.println("Digite o numero de conta do usuario: ");
            float inputNum = scannerNum.nextFloat();

            for(int i = 0; i < accounts.size(); i++){
                if(inputNum == accounts.get(i).getNumeroConta()){
                    accountLine = i;
                }
            }
        }else{
            System.out.println("opcao invalida");
        }

        System.out.println("Usuario encontrado: Nome: " + accounts.get(accountLine).getNomeConta() + " | Numero de conta: "  + accounts.get(accountLine).getNumeroConta() + " | Saldo: " + accounts.get(accountLine).getSaldo());
        return accountLine;


        
    }

    static void addSaldo(ArrayList<Exercicio03Class> accounts, Scanner scannerNum, Scanner scannerString, int accountLine){

        accountLine = consultarSaldoCliente(accounts, scannerNum, scannerString, accountLine);

        System.out.println("Digite o valor a depositar na conta do cliente " + accounts.get(accountLine).getNomeConta() + ".");
        Float valorDeposito = scannerNum.nextFloat();
        accounts.get(accountLine).addSaldo(valorDeposito);
        
        System.out.println("valor adicionado com sucesso, saldo atual do cliente: " + accounts.get(accountLine).getSaldo());

    }

    static void Sofrimento_e_dor(ArrayList<Exercicio03Class> accounts, Scanner scannerNum, Scanner scannerString, int accountLine){

        accountLine = consultarSaldoCliente(accounts, scannerNum, scannerString, accountLine);

        System.out.println("Digite o valor do boleto a pagar na conta do cliente " + accounts.get(accountLine).getNomeConta() + ".");
        Float valorBoleto = scannerNum.nextFloat();
        accounts.get(accountLine).subSaldo(valorBoleto);
        
        System.out.println("boleto pago com sucesso, saldo atual do cliente: " + accounts.get(accountLine).getSaldo());
    }


    public static void main(String[] args) {

        int menuOpt = 0, accountLine = 0;

        ArrayList<Exercicio03Class> accounts = new ArrayList<Exercicio03Class>();

        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);

        while(true){

            menuOpt = menu(menuOpt, scannerNum);

            if(menuOpt == 1){
                cadastrar(accounts, scannerNum, scannerString);
            }else if(menuOpt == 2){
                consultarSaldoCliente(accounts, scannerNum, scannerString, accountLine);
            }else if(menuOpt == 3){
                addSaldo(accounts, scannerNum, scannerString, accountLine);
            }else if(menuOpt ==4){
                Sofrimento_e_dor(accounts, scannerNum, scannerString, accountLine);
            }else if(menuOpt == 5){
                break;
            }

        }

    }
    
}
