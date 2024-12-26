package org.example.models;

public class DescuentoMembresiaPlatino implements DescuentoStrategy{

    @Override
    public double aplicarDescuento(double amount) {
        return amount * 0.80;
    }
}
