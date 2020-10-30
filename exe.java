public class exe {

	public static void main(String[] args) {
        exe app = new exe();
        app.Acceso();
    }

    public Boolean Acceso() {
        boolean acceso = false;
        LoginModelo mod = new LoginModelo();
        LoginVista view = new LoginVista();

        LoginControlador crt = new LoginControlador(view, mod);
        crt.iniciar();
        if (mod.BuscarUsuario() == true) {
            acceso = true;
        } else {
            acceso = false;
        }
        return acceso;
    }
}
    