import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorCalculadoraRMI implements CalculadoraRMI {

    @Override
    public double soma(double n1, double n2) {
        return n1 + n2;
    }

    @Override
    public double subtracao(double n1, double n2) {
        return n1 - n2;
    }

    @Override
    public double mult(double n1, double n2) {
        return n1 * n2;
    }

    @Override
    public double divisao(double n1, double n2) {
        if (n2 == 0) {
            System.out.println("Divisão por zero não é permitida.");
            return Double.NaN; 
        } else {
            return n1 / n2;
        }
    }

    public static void main(String[] args) {
        try {
            ServidorCalculadoraRMI obj = new ServidorCalculadoraRMI();
            CalculadoraRMI stub = (CalculadoraRMI) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("CalculadoraRMI", stub); 

            System.out.println("Servidor da Calculadora RMI está pronto e aguardando...");

        } catch (Exception e) {
            System.err.println("Exceção no Servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
