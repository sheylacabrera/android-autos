package com.example.santi.autos.controladores;

import com.example.santi.autos.entidades.Products;

import java.util.List;

public interface AdministradorVentas {
    //void crear(Products obj) throws Exception;

    //void modificar(Products obj) throws Exception;

    //void eliminar(Products obj) throws Exception;

    List<Products> listarDatos() throws Exception;
    int[] listarImagen() throws Exception;
}
