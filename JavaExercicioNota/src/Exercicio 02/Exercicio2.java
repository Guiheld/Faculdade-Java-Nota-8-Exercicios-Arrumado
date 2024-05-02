import java.util.Scanner;
import java.util.ArrayList;

public class Exercicio2 {

    static int menu(int menuOpt, Scanner scannerNum){

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. cadastrar um livro");
        System.out.println("2. listar livros");
        System.out.println("3. sair");

        menuOpt = scannerNum.nextInt();
        return menuOpt;

    }
 

    static void cadastrar(ArrayList<Exercicio2Class> books, Scanner scannerNum, Scanner scannerString){

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Digite o nome do livro:");
        String title = scannerString.nextLine();

        System.out.println("Digite o nome do author do livro:");
        String author = scannerString.nextLine();

        System.out.println("Digite o ano de publicacao:");
        int yearOfRealease = scannerNum.nextInt();

        Exercicio2Class livro = new Exercicio2Class(title, author, yearOfRealease);
        books.add(livro);

    }

    static void listar(ArrayList<Exercicio2Class> books){

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for(int i = 0; i < books.size(); i++){

            System.out.println("Titulo do livro: " + books.get(i).titulo + " | Nome do autor: " + books.get(i).autor + " | Ano de publicacao: " + books.get(i).anoDePublicacao);

        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    public static void main(String[] args) {
        
        int menuOpt=0;

        ArrayList<Exercicio2Class> books = new ArrayList<Exercicio2Class>();


        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);

        while(true){

            menuOpt = menu(menuOpt, scannerNum);

            if(menuOpt == 1){
                cadastrar(books, scannerNum, scannerString);
            }else if(menuOpt == 2){
                listar(books);
            }else if(menuOpt == 3){
                break;
            }

        }

        scannerNum.close();
        scannerString.close();
    }  

}
