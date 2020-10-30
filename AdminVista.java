import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class AdminVista extends JFrame {

    public final JButton Entrar;
    public final JLabel ImagenLogin;
    public final JSeparator Linea1;
    public final JSeparator Linea2;
    public final JPasswordField Password;
    public final JLabel PasswordE;
    public final JLabel PasswordI;
    public final JTextField User;
    public final JLabel UserE;
    public final JLabel UserI;
    public final JPanel Panel;
    public final JButton Regresar;

    public AdminVista() {
        super("Inicia Sesión para Continuar");
        Panel = new JPanel();
        UserE = new JLabel("ADMINISTRADOR:");
        PasswordE = new JLabel("PASSWORD:");
        ImagenLogin = new JLabel();
        User = new JTextField();
        Linea2 = new JSeparator();
        Linea1 = new JSeparator();
        Password = new JPasswordField();
        UserI = new JLabel();
        PasswordI = new JLabel();
        Entrar = new JButton();
        Regresar = new JButton();

        setIconImage(new ImageIcon("src/images/icons8_User_96px_2.png").getImage());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new AbsoluteLayout());

        Panel.setBackground(new Color(255, 255, 255));
        Panel.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
        Panel.setForeground(new Color(255, 255, 255));
        Panel.setLayout(new AbsoluteLayout());

        Regresar.setIcon(new ImageIcon("src/image/icons8_Next_page_64px.png"));
        Regresar.setBorder(null);
        Regresar.setBorderPainted(false);
        Regresar.setContentAreaFilled(false);
        Regresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Regresar.setRolloverIcon(new ImageIcon("src/image/icons8_Next_page_64px_1.png"));
        Regresar.setRolloverSelectedIcon(new ImageIcon("src/image/icons8_Next_page_64px_1.png"));
        Regresar.setSelectedIcon(new ImageIcon("src/image/icons8_Next_page_64px_1.png"));
        Panel.add(Regresar, new AbsoluteConstraints(10, 10, -1, -1));

        UserE.setBackground(new Color(238, 112, 82));
        UserE.setFont(new Font("Century Gothic", 1, 18));
        UserE.setForeground(new Color(238, 112, 82));
        Panel.add(UserE, new AbsoluteConstraints(40, 210, -1, -1));

        PasswordE.setBackground(new Color(238, 112, 82));
        PasswordE.setFont(new Font("Century Gothic", 1, 18));
        PasswordE.setForeground(new Color(238, 112, 82));
        Panel.add(PasswordE, new AbsoluteConstraints(40, 310, -1, -1));

        ImagenLogin.setIcon(new ImageIcon("src/image/icons8_User_96px_2.png"));
        Panel.add(ImagenLogin, new AbsoluteConstraints(90, 100, -1, -1));

        User.setBackground(new Color(255, 255, 255));
        User.setFont(new Font("Dialog", 0, 14));
        User.setForeground(new Color(153, 153, 153));
        User.setBorder(null);
        Panel.add(User, new AbsoluteConstraints(50, 230, 190, 30));
        Panel.add(Linea2, new AbsoluteConstraints(50, 360, 200, 10));
        Panel.add(Linea1, new AbsoluteConstraints(50, 260, 200, 10));

        Password.setBackground(new Color(255, 255, 255));
        Password.setBorder(null);
        Panel.add(Password, new AbsoluteConstraints(50, 330, 190, 30));

        UserI.setIcon(new ImageIcon("src/image/icons8_customer_32px_1.png"));
        Panel.add(UserI, new AbsoluteConstraints(10, 230, -1, -1));

        PasswordI.setIcon(new ImageIcon("src/image/icons8_Key_32px.png"));
        Panel.add(PasswordI, new AbsoluteConstraints(10, 330, -1, -1));

        Entrar.setIcon(new ImageIcon("src/image/Enter_OFF.png"));
        Entrar.setBorder(null);
        Entrar.setBorderPainted(false);
        Entrar.setContentAreaFilled(false);
        Entrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Entrar.setRolloverIcon(new ImageIcon("src/image/Enter_ON.png"));
        Entrar.setRolloverSelectedIcon(new ImageIcon("src/image/Enter_ON.png"));
        Entrar.setSelectedIcon(new ImageIcon("src/image/Enter_ON.png"));
        Entrar.setSelected(true);
        Panel.add(Entrar, new AbsoluteConstraints(70, 400, -1, -1));

        getContentPane().add(Panel, new AbsoluteConstraints(0, 0, 290, 580));
        this.pack();

        Regresar.addActionListener(
                (e) -> {
                    this.dispose();
                    LoginModelo mod = new LoginModelo();
                    LoginVista view = new LoginVista();
                    LoginControlador crt = new LoginControlador(view, mod);
                    crt.iniciar();
                }
        );

    }

}
