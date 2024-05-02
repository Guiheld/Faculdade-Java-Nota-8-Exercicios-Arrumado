

public class Exercicio01Class{

    Float x, y;
    char operator;
    Float result;

    Exercicio01Class(Float X1, Float Y1, char Operador, Float result){

        x = X1;
        y = Y1;
        operator = Operador;

        if(operator == '+'){ 
            result = x + y; 
            System.out.println(result);
        }else if (operator == '/'){
            if(operator == '0'){
                System.out.println("Divisao por zero nao e permetida");
            }else{
                result = x / y;
                System.out.println(result);
            }
        }else if (operator == '-'){
            result = x - y;
            System.out.println(result);
        }else if (operator == '*'){
            result = x * y;
            System.out.println(result);
        }

    }


}