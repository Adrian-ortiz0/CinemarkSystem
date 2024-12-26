package org.example.models;

public class DescuentoMembresiaGold implements DescuentoStrategy{

    @Override
    public double aplicarDescuento(double amount) {
        return amount * 0.90;
    }
    
}
