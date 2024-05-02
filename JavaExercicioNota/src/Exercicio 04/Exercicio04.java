import java.util.*;


public class Exercicio04 {

        static int menu(Scanner scannerNum,int menuOpt){

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. cadastrar jogador");
        System.out.println("2. listar cadastros");
        System.out.println("3. editar cadastros");
        System.out.println("4.  sair");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        return menuOpt = scannerNum.nextInt();

    }

    static void cadastrar(Scanner scannerNum, Scanner scannerString, ArrayList<Exercicio04Class> jogadores){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Digite o nome do jogador");
        String nome = scannerString.nextLine();

        System.out.println("Digite o nivel do jogador");
        int nivel = scannerNum.nextInt();

        System.out.println("Digite a pontuacao do jogador");
        Float ponto = scannerNum.nextFloat();

        Exercicio04Class jogador = new Exercicio04Class(nome, ponto, nivel);
        jogadores.add(jogador);

        System.out.println("jogador cadastrado com sucesso!!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    static void listar(ArrayList<Exercicio04Class> jogadores){

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for(int i = 0; i < jogadores.size(); i++){

            System.out.println("Nome: " + jogadores.get(i).getNomeJogador() + " | Nivel: " + jogadores.get(i).getNivelJogador() + " | Pontos: " + jogadores.get(i).getPontoJogador());

        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    static void editar(Scanner scannerNum, Scanner scannerString, ArrayList<Exercicio04Class> jogadores){

        System.out.println("Digite o nome do usuario para edita-lo");
        String nomeProcurar = scannerString.nextLine();


        for(int i = 0; i < jogadores.size(); i++){

            if(jogadores.get(i).getNomeJogador().equals(nomeProcurar)){

                System.out.println("Digite o novo nome de usuario: ");
                String newName = scannerString.nextLine();
                System.out.println("Digite o novo nivel do jogador");
                int newNivel = scannerNum.nextInt();
                System.out.println("Digite a nova pontuacao:");
                Float newPonto = scannerNum.nextFloat();

                jogadores.get(i).setNomeJogador(newName);
                jogadores.get(i).setNivelJogador(newNivel);
                jogadores.get(i).setPontoJogador(newPonto);

                System.out.println("Editado com sucesso!");

                System.out.println("Nome: " + jogadores.get(i).getNomeJogador() + " | Nivel: " + jogadores.get(i).getNivelJogador() + " | Pontos: " + jogadores.get(i).getPontoJogador());


            }
            
        }

    }

    public static void main(String[] args) {
        
        int menuOpt = 0;

        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);

        ArrayList<Exercicio04Class> jogadores = new ArrayList<Exercicio04Class>();


        while(true){

            menuOpt = menu(scannerNum, menuOpt);

            if(menuOpt==1){
                cadastrar(scannerNum, scannerString, jogadores);
            }else if(menuOpt==2){
                listar(jogadores);
            }else if(menuOpt==3){
                editar(scannerNum, scannerString, jogadores);
            }else if(menuOpt==4){
                break;
            }

        }


    }


    
}
