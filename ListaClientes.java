package servidor;

public class ListaClientes {
    
    public AtenderCliente inicio = null;
    public AtenderCliente fin = null;
    
    public void agregar(AtenderCliente objAC){
        if(inicio==null){
            inicio  = objAC;
            fin  = objAC;
        }
        else{
            fin.sig = objAC;
            fin =  objAC;
        }        
    }
    
    public void mostrar(){
        try{
            AtenderCliente correr = null;
            correr = inicio;
            while(correr!=null){
                correr.mostrar();
                correr = correr.sig;
            }            
        }
        catch(Exception e){
        }
    }
    
    public void enviar(String mensaje){
        try{
            AtenderCliente correr = null;
            correr = inicio;
            while(correr!=null){
                correr.enviar(mensaje);
                correr = correr.sig;
            }            
        }
        catch(Exception e){
        }
    }    
    
}
