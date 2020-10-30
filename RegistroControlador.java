import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class RegistroControlador implements ActionListener {

    private RegistroVista view;
    private RegistroModelo model;

    public RegistroControlador(RegistroVista view, RegistroModelo model) {
        this.view = view;
        this.model = model;
        this.view.Guardar.addActionListener(this);

    }

    public void iniciar() {
        view.setVisible(true);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimen = view.getSize();
        view.setLocation(
                (pantalla.width - dimen.width) / 2,
                (pantalla.height - dimen.height) / 2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.setRegNombre(view.Nombre.getText());
        model.setRegUsuario(view.RegUs.getText());
        model.setRegPassword1(view.RegPass.getText());  
        model.setRegPassword2(view.RegPass2.getText());
        if(model.Existe()==false && model.Escritor()==true){
            view.dispose();
            LoginModelo mod = new LoginModelo();
            LoginVista view = new LoginVista();
            LoginControlador crt = new LoginControlador(view, mod);
            crt.iniciar();
        }else if(model.Existe()==true){
            JOptionPane.showMessageDialog(null, "El Nombre de Usuario ya se encuentra Registrado", "Nombre de Usuario Invalido",2);
        }

    }
}
