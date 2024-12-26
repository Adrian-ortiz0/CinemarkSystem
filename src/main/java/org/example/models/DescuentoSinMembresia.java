
package org.example.models;

public class DescuentoSinMembresia implements DescuentoStrategy{

    @Override
    public double aplicarDescuento(double amount) {
        return amount;
    }
    
}
