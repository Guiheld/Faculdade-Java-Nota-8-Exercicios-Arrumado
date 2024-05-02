import java.util.Scanner;

public class Exercicio01 {
    

    public static void main(String[] args) {
        
        Float X1, Y1, result = null;
        char Operador;
        String input;

        Scanner scannerString = new Scanner(System.in);

        System.out.println("Digite uma operacao matematica:");
        input = scannerString.nextLine();

        String[] splitInput = input.split("\\s+");
        X1 = Float.parseFloat(splitInput[0]);
        Y1 = Float.parseFloat(splitInput[2]);
        Operador = splitInput[1].charAt(0);


        Exercicio01Class math = new Exercicio01Class(X1, Y1, Operador, result);




        scannerString.close();

    }
}
