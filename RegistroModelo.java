import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class RegistroModelo {

    private String RegNombre;
    private String RegUsuario;
    private String RegPassword1;
    private String RegPassword2;

    public String getRegNombre() {
        return RegNombre;
    }

    public void setRegNombre(String RegNombre) {
        this.RegNombre = RegNombre;
    }

    public String getRegUsuario() {
        return RegUsuario;
    }

    public void setRegUsuario(String RegUsuario) {
        this.RegUsuario = RegUsuario;
    }

    public String getRegPassword1() {
        return RegPassword1;
    }

    public void setRegPassword1(String RegPassword1) {
        this.RegPassword1 = RegPassword1;
    }

    public String getRegPassword2() {
        return RegPassword2;
    }

    public void setRegPassword2(String RegPassword2) {
        this.RegPassword2 = RegPassword2;
    }

     public Boolean Existe(){
        boolean existe=false;
        String record = null;
        FileReader in = null;
        try {
            in = new FileReader("src/Registro/Usuarios.txt");
            BufferedReader br = new BufferedReader(in);
            while ((record = br.readLine()) != null) {
                String[] word = record.split(", ");
                if (word[1].equals(this.RegUsuario.toString())) {
                    
                    
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

    public Boolean Escritor() {
        boolean escrito = false;
        if (this.RegNombre.toString().equals("") || this.RegUsuario.toString().equals("") || this.RegPassword1.toString().equals("")
                || this.RegPassword2.toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Uno o más Campos están vacíos.", "Campos Faltantes", 2);
            escrito = false;
        } else if (!this.RegPassword1.toString().equals(this.RegPassword2.toString())) {
            JOptionPane.showMessageDialog(null, "Las Contraseñas no Coinciden", "Contraseñas no Coinciden", 2);
            escrito = false;
        } else {
            File libreta = new File("src/Registro/Usuarios.txt");
            try {
                FileWriter pluma = new FileWriter(libreta, true);
                pluma.write("\n");
                pluma.write(this.RegNombre.toString());
                pluma.write(", ");
                pluma.write(this.RegUsuario.toString());
                pluma.write(", ");
                pluma.write(AES.encrypt(this.RegPassword1.toString()));
                pluma.close();
            } catch (IOException Err) {
            } catch (Exception ex) {
            }
            System.out.println("Guardado");
            JOptionPane.showMessageDialog(null, "Usuario Registrado Exitosamente", "Éxito", 1);
            escrito = true;
            
        }
        return escrito;
    }
}
