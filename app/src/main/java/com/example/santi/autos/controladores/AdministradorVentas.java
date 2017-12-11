package com.example.santi.autos.controladores;

import com.example.santi.autos.entidades.Vehiculo;

import java.util.List;

public interface AdministradorVentas {
    void crear(Vehiculo obj) throws Exception;

    void modificar(Vehiculo obj) throws Exception;

    void eliminar(Vehiculo obj) throws Exception;

    Vehiculo buscarPorPlaca(String placa) throws Exception;

    Vehiculo buscarPorCodigo(int codigo) throws Exception;

    List<Vehiculo> listar() throws Exception;
}
