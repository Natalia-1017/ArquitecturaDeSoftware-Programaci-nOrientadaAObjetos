package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<CuentaBancaria> cuentasLista = new ArrayList<>();


        CuentaBancaria cuenta1 = new CuentaBancaria("Luna Fernández", "156", 1000);
        CuentaBancaria cuenta2 = new CuentaBancaria("Heyder Suba", "215", 2000);

        cuentasLista.add(cuenta1);
        cuentasLista.add(cuenta2);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Ver cuentas");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            int opcion = entrada.nextInt();
            entrada.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("Titular:");
                    String nombreTitular = entrada.nextLine();

                    System.out.println("Número de cuenta:");
                    String numCuenta = entrada.nextLine();

                    System.out.println("Saldo inicial:");
                    double saldoInicial = entrada.nextDouble();

                    CuentaBancaria nuevaCuenta = new CuentaBancaria(nombreTitular, numCuenta, saldoInicial);
                    cuentasLista.add(nuevaCuenta);
                    System.out.println("Cuenta creada.");
                    break;

                case 2:
                    System.out.println("Número de cuenta:");
                    String cuentaDeposito = entrada.nextLine();

                    CuentaBancaria cuentaDep = buscarCuenta(cuentasLista, cuentaDeposito);
                    if (cuentaDep != null) {
                        System.out.println("Monto a depositar:");
                        double montoDepositar = entrada.nextDouble();
                        cuentaDep.depositar(montoDepositar);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("Número de cuenta:");
                    String cuentaRetiro = entrada.nextLine();

                    CuentaBancaria cuentaRet = buscarCuenta(cuentasLista, cuentaRetiro);
                    if (cuentaRet != null) {
                        System.out.println("Monto a retirar:");
                        double montoRetirar = entrada.nextDouble();
                        cuentaRet.retirar(montoRetirar);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;

                case 4:
                    for (CuentaBancaria cuenta : cuentasLista) {
                        cuenta.mostrarInformacion();
                    }
                    break;

                case 5:
                    System.out.println("Hasta luego.");
                    entrada.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static CuentaBancaria buscarCuenta(List<CuentaBancaria> cuentasLista, String numCuenta) {
        for (CuentaBancaria cuenta : cuentasLista) {
            if (cuenta.getNumeroCuenta().equals(numCuenta)) {
                return cuenta;
            }
        }
        return null;
    }
}
