import java.util.*;

public class Exercicio07 {

    public static int menu(Scanner scannerNum, int menuOpt){

       System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
       System.out.println("1. Cadastrar novo produto");
       System.out.println("2. Editar dados de um produto");
       System.out.println("3. Gerenciar Estoque");
       System.out.println("4. Gerar relatorio");
       System.out.println("5. sair");
       System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

       menuOpt = scannerNum.nextInt();
       return menuOpt;
    }

    public static void cadastrar(Scanner scannerNum, Scanner scannerString, ArrayList<Exercicio07Class> produtos){

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Digite o nome do novo produto");
        String nome = scannerString.nextLine();
        System.out.println("Digite o preco por unidade do novo produto");
        Float preco = scannerNum.nextFloat();
        System.out.println("Digite o estoque atual do produto");
        int estoque = scannerNum.nextInt();

        int codigo = produtos.size() + 1;

        Exercicio07Class produtoNovo = new Exercicio07Class(nome, preco, estoque, codigo);
        produtos.add(produtoNovo);
        System.out.println("Produto registrado com sucesso!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


    }

    public static void editarProduto(Scanner scannerNum, Scanner scannerString, ArrayList<Exercicio07Class> produtos){

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Digite o codigo do produto a ser editado");
        int cod = scannerNum.nextInt();

        if((cod > produtos.size())||(cod <= 0)){
            System.out.println("codigo invalido");
        }

        for(int i = 0; i < produtos.size(); i++){

            if(produtos.get(i).getCodigoProduto() == cod){

                System.out.println("Produto encontrado: " + produtos.get(i).getNomeProduto() + " | Codigo: " + produtos.get(i).getCodigoProduto());

                while(true){

                    System.out.println("1 - alterar nome");
                    System.out.println("2 - alterar preco");
                    System.out.println("3 - voltar");
                    int opt = scannerNum.nextInt();

                    if(opt == 1){
                        System.out.println("Digite o novo nome do produto:");
                        String nome = scannerString.nextLine();
                        produtos.get(i).setNomeProduto(nome);
                        System.out.println("Nome de produto alterado com sucesso");
                    }else if(opt == 2){
                        System.out.println("Digite o novo preco do produto:");
                        Float preco = scannerNum.nextFloat();
                        produtos.get(i).setPrecoProduto(preco);
                        System.out.println("Preco de produto alterado com sucesso");
                    }else if(opt == 3){
                        break;
                    }else{
                        System.out.println("Opcao invalida");
                    }

                }

            }

        }

        
    }

    public static void gerenciarEstoque(Scanner scannerNum, Scanner scannerString, ArrayList<Exercicio07Class> produtos){

        for(int i = 0; i < produtos.size(); i++){

            System.out.println("=======================================");
            System.out.println("| Codigo: " + produtos.get(i).getCodigoProduto());
            System.out.println("| Nome: " + produtos.get(i).getNomeProduto());
            System.out.println("| Estoque: " + produtos.get(i).getEstoqueProduto());
            System.out.println("| Preco: " + produtos.get(i).getProdutoPreco());
            System.out.println("=======================================");

        }

        System.out.println("Digite o codigo do produto para alterar seu estoque:");
        int cod = scannerNum.nextInt();

        for(int i = 0; i < produtos.size(); i++){
            if(produtos.get(i).getCodigoProduto() == cod){
                System.out.println("~~~~~~~~~~~~~~~~~");
                System.out.println("1 - adicionar estoque");
                System.out.println("2 - deduzir estoque");
                System.out.println("3 - sair");
                int opt = scannerNum.nextInt();

                if(opt == 1){
                    System.out.println("Digite o quanto a adicionar ao estoque");
                    int estoque = scannerNum.nextInt();
                    if(estoque<0){
                        System.out.println("Invalido");
                    }else{
                        estoque += produtos.get(i).getEstoqueProduto();
                        produtos.get(i).setEstoqueProduto(estoque);
                        System.out.println("Estoque adicionado com sucesso!");
                    }
                    
                }else if(opt == 2){
                    System.out.println("Digite quanto a deduzir do estoque");
                    int estoque = scannerNum.nextInt();
                    if((estoque<0)||(estoque>produtos.get(i).getEstoqueProduto())){
                        System.out.println("invalido - input nao pode ser superior ao estoque existente, e/ou o input nao pode ser 0");
                    }else{
                        int estoqueD = produtos.get(i).getEstoqueProduto();
                        estoque =  estoqueD - estoque;
                        produtos.get(i).setEstoqueProduto(estoque);
                        System.out.println("estoque deduzido com sucesso");
                    }
                }
            }
        }
    }

    public static void relatorio(Scanner scannerNum, Scanner scannerString, ArrayList<Exercicio07Class> produtos){

        for(int i = 0; i < produtos.size(); i++){

        System.out.println("=======================================");

        if(produtos.get(i).getEstoqueProduto() <= 0){
            System.out.println("| ATENCAO: FALTA DE ESTOQUE");
        }else{
            System.out.println("| OK ");
        }
        System.out.println("| Codigo: " + produtos.get(i).getCodigoProduto());
        System.out.println("| Nome: " + produtos.get(i).getNomeProduto());
        System.out.println("| Estoque: " + produtos.get(i).getEstoqueProduto());

        if(produtos.get(i).getProdutoPreco() <= 0){
            System.out.println("ATENCAO: ERRO NO PRECO DE PRODUTO!!");
        }else{
            System.out.println("| Preco: " + produtos.get(i).getProdutoPreco());
        }

        Float dinheiro = produtos.get(i).getProdutoPreco() * produtos.get(i).getEstoqueProduto();
        System.out.println("| Valor Bruto do produto: " + dinheiro);
        System.out.println("=======================================");

        }
    }
    
    public static void main(String[] args) {
        
        int menuOpt = 0;

        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);

        ArrayList<Exercicio07Class> produtos = new ArrayList<>();

        while (true){

            menuOpt = menu(scannerNum, menuOpt);

            if(menuOpt == 1){
                cadastrar(scannerNum, scannerString, produtos);
            }else if(menuOpt == 2){
                editarProduto(scannerNum, scannerString, produtos);
            }else if(menuOpt == 3){
                gerenciarEstoque(scannerNum, scannerString, produtos);
            }else if(menuOpt == 4){
                relatorio(scannerNum, scannerString, produtos);
            }



        }

    }




}
