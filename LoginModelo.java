import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LoginModelo {

    private String Usuario;
    private String Contrasena;

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public boolean BuscarUsuario() {
        String record = null;
        FileReader in = null;
        boolean existe = false;
        try {
            in = new FileReader("src/Registro/Usuarios.txt");
            BufferedReader br = new BufferedReader(in);
            while ((record = br.readLine()) != null) {
                String[] word = record.split(", ");
                if (word[1].equals(this.Usuario.toString()) && AES.decrypt(word[2]).toString().equals(this.Contrasena.toString())) {
                    
                    existe = true;
                }
            }
            if (!existe) {
                existe = false;
            }
        } catch (IOException err) {
        } catch (Exception ex) {
        }

        return existe;
    }

}
