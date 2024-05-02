import java.util.*;

public class Exercicio06 {

    public static int menu(Scanner scannerNum, int menuOpt){

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. cadastrar novo contato");
        System.out.println("2. procurar contato na agenda");
        System.out.println("3. listar todos os contatos");
        System.out.println("4. sair");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return menuOpt = scannerNum.nextInt();
    }
    

    public static void cadastrar(Scanner scannerNum, Scanner scannerString, Exercicio06ClassAgenda contatosArray){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Digite o nome do novo contato");
        String nome = scannerString.nextLine();
        System.out.println("Digite o numero de telefone do novo contato");
        long telefone = scannerNum.nextLong();

        Exercicio06ClassContato contato = new Exercicio06ClassContato(nome, telefone);
        
        contatosArray.adicionarContatos(contato);
        System.out.println("Contato adicionado com sucesso!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    public static void procurarContato(Scanner scannerString, Exercicio06ClassAgenda contatosArray ){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Digite o nome do usuario para procura-lo");
        String nome = scannerString.nextLine();
        ArrayList<Exercicio06ClassContato> contatosAchados = contatosArray.procurarContato(nome);
        System.out.println("Contatos achados:");
        for(int i = 0; i < contatosAchados.size(); i++){
            System.out.println("Nome: " + contatosAchados.get(i).nomeContato + " | Telefone: " + contatosAchados.get(i).telefoneContato);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }
    
    public static void main(String[] args) {
        
        int menuOpt = 0;

        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);

        Exercicio06ClassAgenda contatosArray = new Exercicio06ClassAgenda();

        while(true){

            menuOpt = menu(scannerNum, menuOpt);

            if(menuOpt == 1){
                cadastrar(scannerNum, scannerString, contatosArray);
            }else if(menuOpt ==2){
                procurarContato(scannerString, contatosArray);
            }else if(menuOpt ==3){
                contatosArray.listarContatos();
            }else{
                break;
            }


        }

        /*este foi mais complicado do que deveria kkkkkk */

    }



}
