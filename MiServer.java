package servidor;
public class MiServer {
    public static AtenderClientes objAtenderClientes = null;
    public MiServer(){
        try{
            objAtenderClientes = new AtenderClientes();
            objAtenderClientes.start();
        }
        catch(Exception e){
        }
    }
    public static void main(String arg[]){
        MiServer p = new MiServer();        
    }    
}
