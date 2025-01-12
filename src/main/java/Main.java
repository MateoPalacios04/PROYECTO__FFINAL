import udla.mcriollo.proyectofinal.Banco;
import udla.mcriollo.proyectofinal.Cliente;
import udla.mcriollo.proyectofinal.CuentaBancaria;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/java_jdbc";
        String usr = "root";
        String ps = "Picachu2004//*";

        while (true) {
            System.out.println("\nSistema de Registro de Clientes del Banco Pichincha");
            System.out.println("1. Registrar Cliente y Cuenta");
            System.out.println("2. Listar Cuentas Registradas");
            System.out.println("3. Salir");

            int opcion = -1;

            //Ciclo "while" que permite la interacción entre usuario y el menu de opciones del registro

            while (true) {
                try {
                    System.out.print("Seleccione una opción: ");
                    opcion = Integer.parseInt(scanner.nextLine());
                    if (opcion < 1 || opcion > 3) {
                        throw new IllegalArgumentException(" La opción debe estar entre 1 y 3.");
                    }
                    break; // Solo se sale del bucle si la opción es válida
                } catch (NumberFormatException e) {
                    System.out.println("Error: Intente otra vez por favor.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: Intente otra vez por favor." + e.getMessage());
                }
            }
            // Se opta por el uso de un "Switch" en vez de una sentencia repetitíva "if", dado a las multiples opciones disponibles con las que cuenta el registro

            switch (opcion) {
                case 1:
                    String nombre = "";
                    while (true) {

                        //Se informa al programa que intente el registro del nombre del usuario

                        try {
                            System.out.print("Ingrese el nombre del cliente: ");
                            nombre = scanner.nextLine();

                            //El metodo "matches" compara la cadena de expresiones regulares

                            //La expresion regular o regex denominada:"[a-zA-Z\\s]+", se utiliza para formar un patron de busqueda

                            //Gracias al metodo "matches"  y la sentencia "if", el codigo verifica la validez de los datos ingresados

                            //Dependiendo del apartado del registro en el que se este, el regex cambiara de valores y limites


                            if (!nombre.matches("[a-zA-Z\\s]+")) {
                                throw new IllegalArgumentException("Error: Intente otra vez por favor.");
                            }
                            break; // Cuando la informacion el Nombre es válida

                            //Se captura el error y se manda el mensaje de poner carácteres en vez de números

                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    String cedula = "";
                    while (true) {
                        try {
                            System.out.print("Ingrese la cédula del cliente: ");
                            cedula = scanner.nextLine();
                            if (!cedula.matches("\\d+")) {
                                throw new IllegalArgumentException("Error: Intente otra vez por favor.");
                            }
                            break; // Cuando la información de la Cédula es válida
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    String direccion = "";
                    while (true) {
                        try {
                            System.out.print("Ingrese la dirección del cliente: ");
                            direccion = scanner.nextLine();
                            if (direccion.trim().isEmpty()) {
                                throw new IllegalArgumentException("Error: Intente otra vez por favor.");
                            }
                            break; // Cuando la información de la Dirección es válida
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    Cliente cliente = new Cliente(nombre, cedula, direccion);

                    String numeroCuenta = "";
                    while (true) {
                        try {
                            System.out.print("Ingrese el número de cuenta: ");
                            numeroCuenta = scanner.nextLine();
                            if (!numeroCuenta.matches("\\d+")){
                                throw new IllegalArgumentException("Error: Número de cuenta no instroducida");
                            }
                            break; // Cuando el Número de cuenta válido
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    CuentaBancaria nuevaCuenta = new CuentaBancaria(numeroCuenta, cliente);
                    banco.registrarCuenta(nuevaCuenta.getNumeroCuenta(), nuevaCuenta.getCliente());
                    System.out.println("Cuenta registrada.");
                    break;

                case 2:
                    banco.listarCuentas();
                    break;

                case 3:
                    System.out.println("Gracias por usar el sistema.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida, intente nuevamente.");
            }
        }
    }
}
