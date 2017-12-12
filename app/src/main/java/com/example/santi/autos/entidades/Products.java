package com.example.santi.autos.entidades;


import java.util.concurrent.atomic.AtomicInteger;

public class Products {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int criticoRate = 0;
    private double customerRate;
    private String nombre;

    public Products(String nombre, int critRate, double customerRate) {
        criticoRate = critRate;
        this.nombre = nombre;
        this.customerRate = customerRate;
    }

    public static AtomicInteger getCount() {
        return count;
    }

    public int getCriticoRate() {
        return criticoRate;
    }

    public void setCriticoRate(int criticoRate) {
        this.criticoRate = criticoRate;
    }

    public double getCustomerRate() {
        return customerRate;
    }

    public void setCustomerRate(float customerRate) {
        this.customerRate = customerRate;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        return count == products.count;
    }

    @Override
    public int hashCode() {
        return count.intValue();
    }

    @Override
    public String toString() {
        return "Products{" +
                "nombre=" + nombre +
                ", criticoRate='" + criticoRate + '\'' +
                ", customerRate='" + customerRate + '\'' +
                '}';
    }
}
