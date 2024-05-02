import java.util.*;

public class Exercicio05 {

    public static int menu(int menuOpt, Scanner scannerNum){

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Cadastrar um novo modelo de carro");
        System.out.println("2. Listar todos os carros cadastrados");
        System.out.println("3. Acelerar ou desacelerar o carro");
        System.out.println("4. Sair.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        menuOpt = scannerNum.nextInt();
        return menuOpt;
    }

    static void cadastrar(Scanner scannerNum, Scanner scannerString, ArrayList<Exercicio05Class> carros){

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Digite o modelo do carro: ");
        String modelo = scannerString.nextLine();
        System.out.println("Digite a placa do carro");
        String placa = scannerString.nextLine();
        System.out.println("Digite o ano do carro");
        int ano = scannerNum.nextInt();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Float velocidade = 0f;

        Exercicio05Class carroNovo = new Exercicio05Class(placa, modelo , ano, velocidade);
        carros.add(carroNovo);

    }

    static void listar(ArrayList<Exercicio05Class> carros){

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for(int i = 0; i < carros.size(); i++){

            System.out.println("Modelo: " + carros.get(i).getModeloCarro() + " | Placa: " + carros.get(i).getPlacaCarro() + " | Ano: " + carros.get(i).getAnoCarro() + " | Velocidade atual: " + carros.get(i).velocidadeCarro);

        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    static void mudarVelocidade(Scanner scannerNum, Scanner scannerString, ArrayList<Exercicio05Class> carros){

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Digite a placa do carro para alterar sua velocidade");
        String placa = scannerString.nextLine();

        for(int i = 0; i < carros.size(); i++){

            if(carros.get(i).getPlacaCarro().equals(placa)){

                System.out.println("1 - Acelerar | 2 - frear \n 0 - sair");
                float velo = 0f;

                while(true){

                    int opt = scannerNum.nextInt();
                    if(opt == 1){
                        velo += (velo + 10) /2;
                        carros.get(i).velocidadeCarro = velo;
                    }else if(opt ==2){
                        velo -= (velo - 0.5)/2;
                        carros.get(i).velocidadeCarro = velo;
                    }else{
                        break;
                    }
                    System.out.println(" O " + carros.get(i).getModeloCarro() + " esta fazendo " + carros.get(i).velocidadeCarro);
                    if((carros.get(i).velocidadeCarro < 240.0f)&&(carros.get(i).getAnoCarro()<2000)){
                        System.out.println("O " + carros.get(i).getModeloCarro() + " capotou feio!!!" );
                    }
                }

            }

        }


    }

    public static void main(String[] args) {

        int menuOpt = 0;

        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);

        ArrayList<Exercicio05Class>  carros = new ArrayList<Exercicio05Class>();

        while(true){

            menuOpt = menu(menuOpt, scannerNum);

            if(menuOpt == 1){
                cadastrar(scannerNum, scannerString, carros);
            }else if(menuOpt == 2){
                listar(carros);
            }else if(menuOpt==3){
                mudarVelocidade(scannerNum, scannerString, carros);
            }else{
                break;
            }

            

        }


    }
    
}
