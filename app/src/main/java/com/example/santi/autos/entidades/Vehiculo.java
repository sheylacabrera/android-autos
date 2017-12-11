package com.example.santi.autos.entidades;


import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Vehiculo {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int codigo = 0;
    private String placa;
    private String marca;
    private String color;
    private Date fecha;
    private boolean estado;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca, String color, Date fecha, boolean estado) {
        this.codigo = count.incrementAndGet();
        this.placa = placa;
        this.marca = marca;
        this.color = color;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehiculo vehiculo = (Vehiculo) o;

        return codigo == vehiculo.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "codigo=" + codigo +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", fecha=" + fecha +
                ", estado=" + estado +
                '}';
    }
}
