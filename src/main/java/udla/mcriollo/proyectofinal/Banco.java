package udla.mcriollo.proyectofinal;
import java.util.ArrayList;

public class Banco {

    private ArrayList<CuentaBancaria> cuentas;

    public Banco() {
        cuentas = new ArrayList<>();
    }

    public void registrarCuenta(String numeroCuenta, Cliente cliente) {
        cuentas.add(new CuentaBancaria(numeroCuenta, cliente));
    }

    public void listarCuentas() {
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
        } else {
            for (CuentaBancaria cuenta : cuentas) {
                System.out.println(cuenta);
            }
        }
    }
}
