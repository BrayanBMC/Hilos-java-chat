package servidor;
import java.net.ServerSocket;
import java.net.Socket;
public class AtenderClientes extends Thread{
    public static ServerSocket ss = null;
    public static ListaClientes objListaClientes = null;
    public AtenderClientes(){
        try{
            ss = new ServerSocket(69);
            objListaClientes = new ListaClientes();
        }
        catch(Exception e){
        }
    }
    public void run(){
        try{            
            while(true){
                Socket s_cliente = ss.accept();
                AtenderCliente ac = new AtenderCliente(s_cliente);
                ac.start();
                objListaClientes.agregar(ac);
                objListaClientes.mostrar();
            }            
        }
        catch(Exception e){
        }
    }    
}
