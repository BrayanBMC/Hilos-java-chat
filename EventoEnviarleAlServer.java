package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoEnviarleAlServer implements ActionListener{
    
    public void actionPerformed(ActionEvent e) {
        try{
            String mensa = MiCliente.texto.getText();
            MiCliente.objEscucharServer.enviar(mensa);
        }
        catch(Exception e1){
        }
    }
    
}
