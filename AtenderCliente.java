package servidor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class AtenderCliente extends Thread{
    public AtenderCliente sig = null;
    public Socket s = null;
    public InputStream entrada = null;
    public DataInputStream entra = null;
    public OutputStream salida = null;
    public DataOutputStream sale = null;
    
    public AtenderCliente(Socket refS){
        try{
            s = refS;
            entrada = s.getInputStream();
            entra = new DataInputStream(entrada);
            salida = s.getOutputStream();
            sale = new DataOutputStream(salida);
        }
        catch(Exception e){
        }
    }
    
    public void mostrar(){
        try{
            System.out.println(s.toString());
        }
        catch(Exception e){
        }
    }
    
    public void run(){
        try{
            while(true){
                String leido = entra.readUTF();
                AtenderClientes.objListaClientes.enviar(leido);
                System.out.println("El cliente dijo "+leido);
            }
        }
        catch(Exception e){
        }
    }
    
    public void enviar(String mensaje){
        try{
            sale.writeUTF(mensaje);
        }
        catch(Exception e){
        }
    }
    
}