import java.util.*;

public class Exercicio08 {

    public static int menu(int menuOpt, Scanner scannerNum){

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Pedir uma pizza");
        System.out.println("2. Consultar um pedido");
        System.out.println("3. relatorio");
        System.out.println("4. sair");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        return menuOpt = scannerNum.nextInt();

    } 

    public static void pizzaOrder(Scanner scannerNum, Scanner scannerSring, ArrayList<Exercicio08ClassPizza> pizzas){

        Float preco = 0f;
        String nome;

        while(true){

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("~~~~~~~~~ REALIZAR PEDIDO ~~~~~~~~~~~");
            System.out.println("Digite o seu nome: ...");
            nome = scannerSring.nextLine();

            if(nome.equals(null)){
                System.out.println("ERRO: por favor digite o seu nome!");
            }else{
                break;
            }

        }

        


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~ ESCOLHA UM SABOR ~~~~~~~~~~");
        System.out.println("1. Pepperoni     | 2. Frango Catupiry");
        System.out.println("3. Portuguesa    | 4. Calabresa");
        System.out.println("5. Personalizado | 0. Voltar");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int pizzaOpt = scannerNum.nextInt();

        //converter nomeInt -> nomeString
        String sabor;
        if(pizzaOpt == 1){
            sabor = "Pepperoni";
        }else if(pizzaOpt == 2){
            sabor = "Frango Catupiry";
        }else if(pizzaOpt == 3){
            sabor = "Portuguesa";
        }else if(pizzaOpt == 4){
            sabor = "Calabresa";
        }else if (pizzaOpt == 5){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Digite o nome do sabor e os detalhes do pedido nas observacoes \n(ATENCAO: a pizza personalizada tem o valor maior):");
            sabor = scannerSring.nextLine();
        }else{
            return;
        }

        //preco por sabor
        if(pizzaOpt != 5){
            preco += 30.0f;
        }else if(pizzaOpt == 5){
            preco += 40.50f;
        }else{
            return;
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~ ESCOLHA O TAMANHO ~~~~~~~~~~");
        System.out.println("1. Fatia         | 2. Pequena");
        System.out.println("3. Grande        | 4. Extra Grande");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int tamanho = scannerNum.nextInt();

        if(tamanho != 1){
            preco += tamanho * 10.26f;
        }else if((tamanho == 1)&&(pizzaOpt != 5)){
            preco = 14.38f;
        }else if((tamanho == 1) && (pizzaOpt == 5)){
            preco = 19.99f;
        }else{
            System.out.println("Opcao invalida");
            return;
        }

        int quantidade = 0;

        while(true){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Digite quantas pizzas, ou clique [enter] para uma unidade");
            quantidade = scannerNum.nextInt();

            if((quantidade < 0)){
                System.out.println("valor invalido");
            }else if(quantidade == 0){
                quantidade = 1;
            }else{
                break;
            }
        }

        String endereco;

        while(true){

            System.out.println("Digite o endereco de entrega: ...");
            endereco = scannerSring.nextLine();

            if(endereco.equals(null)){
                System.out.println("Input invalido| digite um endereco!");
            }else{
                break;
            }

        }

        System.out.println("Digite alguma observacao: \nCaso nao tenha clique [enter]");
        String obs = scannerSring.nextLine();

        boolean status = true;

        Exercicio08ClassPizza pizza = new Exercicio08ClassPizza(sabor, endereco, obs, tamanho, preco, status, nome, quantidade);
        pizzas.add(pizza);

    }

    public static void consultarPedido(Scanner scannerNum, Scanner scannerSring, ArrayList<Exercicio08ClassPizza> pizzas){



        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~ CONSULTAR PEDIDO ~~~~~~~");
        System.out.println("Digite o seu nome: ...");
        String nomeClient = scannerSring.nextLine();

        int line = 0;

        for(int i = 0; i < pizzas.size(); i++){

            if(pizzas.get(i).nomePizza.equals(nomeClient)){

                line = i;

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("~~~~~~~~~~ SEU PEDIDO ~~~~~~~~~~");
                System.out.println("Nome: " + pizzas.get(i).nomePizza);
                System.out.println("Sabor: " + pizzas.get(i).saborPizza);

                String tamanhoString;
                if(pizzas.get(i).tamanhoPizza == 1){ //Eu sei que isso eh um pessimo jeito de fazer isso, desculpe
                    tamanhoString = "Fatia";
                }else if(pizzas.get(i).tamanhoPizza == 2){
                    tamanhoString = "Pequena";
                }else if(pizzas.get(i).tamanhoPizza == 3){
                    tamanhoString = "Media";
                }else if(pizzas.get(i).tamanhoPizza == 4){
                    tamanhoString = "Grande";
                }else{
                    tamanhoString = "Extra Grande";
                }

                System.out.println("Tamanho: " + tamanhoString);
                System.out.println("Quantidade: " + pizzas.get(i).quantidadePizza+"x");
                System.out.println("Endereco: " + pizzas.get(i).enderecoPizza);
                System.out.println("Observacoes: " + pizzas.get(i).obsPizza);
                System.out.println("Preco: R$" + pizzas.get(i).precoPizza);
                if(pizzas.get(i).statusPizza == true){
                    System.out.println("Status: Sendo preparada!");
                }else{
                    System.out.println("Status: cancelada");
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


            }

        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~ OPCOES ~~~~~~~~~~~~");
        System.out.println("1. Cancelar");
        System.out.println("2. voltar");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int opt1 = scannerNum.nextInt();

        if(opt1 == 1){

            pizzas.get(line).statusPizza = false;

        }else if(opt1 == 2){
            return;
        }

    }

    public static void relatorio(Scanner scannerNum, ArrayList<Exercicio08ClassPizza> pizzas){

        int pedidosRealizados = 0;
        Float precoTotal = 0f;

        for(int i = 0; i < pizzas.size(); i++){

            if(pizzas.get(i).statusPizza == true){
                pedidosRealizados++;
                precoTotal += pizzas.get(i).precoPizza;
            }
            

        }

        int pedidosCancelados = pedidosRealizados - pizzas.size();
        Float precoMedio = precoTotal / pedidosRealizados;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~ Relatorio ~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Numero Total de Pedidos (realizados e cancelados): " + pizzas.size());
        System.out.println("Numero Total de Pedidos (realizados): " + pedidosRealizados);
        System.out.println("Numero Total de Pedidos (cancelados): " + pedidosCancelados);
        System.out.println("Preco medio de todos os pedidos (realizados): " + precoMedio);
        System.out.println("Total faturado: " + precoTotal);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Mostrar todos os pedidos registrados");
        System.out.println("2. Mostrar todos os pedidos feitos");
        System.out.println("3. Mostrar todos os pedidos cancelados");
        System.out.println("4. Voltar");
        int opt = scannerNum.nextInt();

        for(int i = 0; i < pizzas.size(); i++){

            if((opt == 1)||(opt == 2)&&(pizzas.get(i).statusPizza==true) || ((opt == 3)&&(pizzas.get(i).statusPizza==false))){

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("~~~~~~~~~~ SEU PEDIDO ~~~~~~~~~~");
                System.out.println("Nome: " + pizzas.get(i).nomePizza);
                System.out.println("Sabor: " + pizzas.get(i).saborPizza);

                String tamanhoString;
                if(pizzas.get(i).tamanhoPizza == 1){ //Eu sei que isso eh um pessimo jeito de fazer isso, desculpe
                    tamanhoString = "Fatia";
                }else if(pizzas.get(i).tamanhoPizza == 2){
                    tamanhoString = "Pequena";
                }else if(pizzas.get(i).tamanhoPizza == 3){
                    tamanhoString = "Media";
                }else if(pizzas.get(i).tamanhoPizza == 4){
                    tamanhoString = "Grande";
                }else{
                    tamanhoString = "Extra Grande";
                }

                System.out.println("Tamanho: " + tamanhoString);
                System.out.println("Quantidade: " + pizzas.get(i).quantidadePizza+"x");
                System.out.println("Endereco: " + pizzas.get(i).enderecoPizza);
                System.out.println("Observacoes: " + pizzas.get(i).obsPizza);
                System.out.println("Preco: R$" + pizzas.get(i).precoPizza);
                if(pizzas.get(i).statusPizza == true){
                    System.out.println("Status: Sendo preparada!");
                }else{
                    System.out.println("Status: cancelada");
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            }

        }
    }

    public static void main(String[] args) {
        
        int menuOpt = 0;

        ArrayList<Exercicio08ClassPizza> pizzas= new ArrayList<>();



        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerSring = new Scanner(System.in);

        while(true){

            menuOpt = menu(menuOpt, scannerNum);

            if(menuOpt == 1){
                pizzaOrder(scannerNum, scannerSring, pizzas);
            }else if(menuOpt == 2){
                consultarPedido(scannerNum, scannerSring, pizzas);
            }else if(menuOpt == 3){
                relatorio(scannerNum, pizzas);
            }else{
                break;
            }





        }

    }
    
}
