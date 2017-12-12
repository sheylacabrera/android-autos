package com.example.santi.autos.controladores;

import java.util.ArrayList;
import java.util.List;

import com.example.santi.autos.R;
import com.example.santi.autos.entidades.Products;

/**
 * Implementa el patron de diseño Singleton
 */
public class AdministradorVentasImpl implements AdministradorVentas {
    private List<Products> datos;
    // references to our images
    private int[] mThumbIds = {
            R.drawable.imagen1, R.drawable.imagen2,
            R.drawable.imagen3
    };
    private static AdministradorVentas administradorVentas;

    /**
     * Constructor provado para no permitir crear objetos de esta clase
     */
    private AdministradorVentasImpl() {
        datos = new ArrayList<Products>();
        datos.add(new Products("PRODUCTO 1", 5, 7));
        datos.add(new Products("PRODUCTO 2",  8, 7.5));
        datos.add(new Products("PRODUCTO 3", 9, 9.8));
    }

    /**
     * Obtiene el objeto unico de tipo AdministradorVentasImpl
     *
     * @return el objeto unico
     */
    public static AdministradorVentas getAdministradorVentas() {
        if (administradorVentas == null) {
            administradorVentas = new AdministradorVentasImpl();
        }
        return administradorVentas;
    }
/*
    @Override
    public void crear(Products obj) throws Exception {
        if (datos.contains(obj)) throw new Exception("Vehículo ya existe");
        datos.add(obj);
    }

    @Override
    public void modificar(Products obj) throws Exception {
        if (!datos.contains(obj)) throw new Exception("Vehículo no existe");
        datos.remove(obj);
        datos.add(obj);
    }

    @Override
    public void eliminar(Products obj) throws Exception {
        if (!datos.contains(obj)) throw new Exception("Vehículo no existe");
        datos.remove(obj);
    }*/

    @Override
    public int[] listarImagen() throws Exception {
        return mThumbIds;
    }

    @Override
    public List<Products> listarDatos() throws Exception {
        return datos;
    }
}
