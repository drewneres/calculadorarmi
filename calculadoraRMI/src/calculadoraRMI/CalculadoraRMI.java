import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculadoraRMI extends Remote {
    double soma(double n1, double n2) throws RemoteException;
    double subtracao(double n1, double n2) throws RemoteException;
    double mult(double n1, double n2) throws RemoteException;
    double divisao(double n1, double n2) throws RemoteException;
}