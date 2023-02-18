package cliente;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EscucharServer extends Thread{
    public Socket s = null;
    public InputStream entrada = null;
    public DataInputStream entra = null;
    public OutputStream salida = null;
    public DataOutputStream sale = null;
    
    public EscucharServer(Socket refS){
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
    
    public void run(){
        try{
            while(true){
                String leido = entra.readUTF();
                System.out.println("El server dijo "+leido);
                String habia = MiCliente.ta.getText();
                MiCliente.ta.setText(habia+"\n"+leido);
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