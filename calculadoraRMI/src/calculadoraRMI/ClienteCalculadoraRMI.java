import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteCalculadoraRMI {

    private ClienteCalculadoraRMI() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];

        try {
            Registry registry = LocateRegistry.getRegistry(host);
            CalculadoraRMI stub = (CalculadoraRMI) registry.lookup("CalculadoraRMI");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite o primeiro número:");
            double num1 = scanner.nextDouble();

            System.out.println("Digite o segundo número:");
            double num2 = scanner.nextDouble();

            double resultadoSoma = stub.soma(num1, num2);
            System.out.println("Resultado da soma: " + resultadoSoma);

            double resultadoSubtracao = stub.subtracao(num1, num2);
            System.out.println("Resultado da subtração: " + resultadoSubtracao);

            double resultadoMultiplicacao = stub.mult(num1, num2);
            System.out.println("Resultado da multiplicação: " + resultadoMultiplicacao);

            double resultadoDivisao = stub.divisao(num1, num2);
            if(Double.isNaN(resultadoDivisao)) {
                System.out.println("Divisão por zero não é permitida.");
            } else {
                System.out.println("Resultado da divisão: " + resultadoDivisao);
            }

        } catch (Exception e) {
            System.err.println("Exceção no Cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
