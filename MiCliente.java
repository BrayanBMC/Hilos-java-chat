package cliente;

import java.net.Socket;
import java.awt.FlowLayout;  
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel; 
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MiCliente {

    public static EscucharServer objEscucharServer = null;
    public static Socket miSocket = null;
    public static JTextArea ta = null;
    public static JTextField texto = null;
    public static EventoEnviarleAlServer objEventoEnviarleAlServer = null;

    public MiCliente() {
        try {
            miSocket = new Socket("localhost", 69);
            objEscucharServer = new EscucharServer(miSocket);
            objEscucharServer.start();
            JFrame frame = new JFrame("JFrame Example");
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            texto = new JTextField("escriba su mensaje aqui");
            ta = new JTextArea(10,10);
            JButton button = new JButton();
            button.setText("Button");
            panel.add(ta);
            panel.add(texto);
            panel.add(button);
            frame.add(panel);
            frame.setSize(200, 300);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            objEventoEnviarleAlServer = new EventoEnviarleAlServer();
            button.addActionListener(objEventoEnviarleAlServer);
        } catch (Exception e) {
        }
    }

    public static void main(String arg[]) {
        MiCliente p = new MiCliente();
    }
}
