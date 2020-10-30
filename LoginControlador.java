import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class LoginControlador implements ActionListener {

    private LoginVista view;
    private LoginModelo model;

    public LoginControlador(LoginVista view, LoginModelo model) {
        this.view = view;
        this.model = model;

        this.view.Entrar.addActionListener(this);

    }

    public void iniciar() {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimen = view.getSize();
        view.setLocation(
                (pantalla.width - dimen.width) / 2,
                (pantalla.height - dimen.height) / 2);
        view.setVisible(true);
    }

    public void cerrar() {
        view.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.setUsuario(view.User.getText());
        model.setContrasena(view.Password.getText());
        if (model.BuscarUsuario() == false) {
            JOptionPane.showMessageDialog(null, "El Usuario o Contraseña son Incorrectos", "Acceso Denegado",1);
            view.dispose();
        }else if(model.BuscarUsuario()==true){
            view.dispose();
            String record = null;
            FileReader in = null;
        try {
            in = new FileReader("src/Registro/Usuarios.txt");
            BufferedReader br = new BufferedReader(in);
            while ((record = br.readLine()) != null) {
                String[] word = record.split(", ");
                if (word[1].equals(view.User.getText().toString()) && AES.decrypt(word[2]).toString().equals(view.Password.getText().toString())) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + word[0], "Bienvenido",JOptionPane.PLAIN_MESSAGE);
                }
            }
        } catch (IOException err) {
        } catch (Exception ex) {
        }
            

        }

    }

}
