import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminControlador implements ActionListener {

    private AdminVista view;
    private AdminModelo model;

    public AdminControlador(AdminVista view, AdminModelo model) {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        model.setUsuario(view.User.getText());
        model.setContrasena(view.Password.getText());
        if (model.BuscarAdmin() == false) {
            JOptionPane.showMessageDialog(null, "No tiene Acceso a este apartado sin ser Administrador", "Acceso Denegado",1);
            
        }else if(model.BuscarAdmin()==true){
            view.dispose();
            RegistroModelo mod = new RegistroModelo();
            RegistroVista view = new RegistroVista();
            RegistroControlador crt = new RegistroControlador(view, mod);
            crt.iniciar();

        }

    }

}
