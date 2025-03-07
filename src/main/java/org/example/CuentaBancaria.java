package org.example;

public class CuentaBancaria {
    private String titular;
    private double saldo;
    private String numeroCuenta;


    public CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }


    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso. Ahora el saldo es: " + String.format("%.2f", saldo));
        } else {
            System.out.println("Monto no válido para depositar, vuelve a intentarlo.");
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro exitoso. Ahora cuentas con un saldo de: " + String.format("%.2f", saldo));
        } else {
            System.out.println("Fondos insuficientes o monto no válido, intentalo nuevamente.");
        }
    }

    public void mostrarInformacion() {
        System.out.println("Titular: " + titular);
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Saldo: " + String.format("%.2f", saldo));
        /* String.format en Java se utiliza para crear cadenas formateadas.
        String.format("%.2f", saldo) muestra el saldo con dos decimales, asegurando claridad y evitando la notación científica.
        Es útil para presentar datos de manera clara y consistente.
         */
    }
}
