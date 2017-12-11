package com.example.santi.autos.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.example.santi.autos.entidades.Vehiculo;

/**
 * Implementa el patron de diseño Singleton
 */
public class AdministradorVentasImpl implements AdministradorVentas {
    private List<Vehiculo> datos;
    private static AdministradorVentas administradorVentas;

    /**
     * Constructor provado para no permitir crear objetos de esta clase
     */
    private AdministradorVentasImpl() {
        datos = new ArrayList<>();
        datos.add(new Vehiculo("PPJ0558", "NISSAN", "ROJO", new Date(), true));
        datos.add(new Vehiculo("ABJ0333", "TOYOTA", "NEGRO", new Date(), true));
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

    @Override
    public void crear(Vehiculo obj) throws Exception {
        if (datos.contains(obj)) throw new Exception("Vehículo ya existe");
        datos.add(obj);
    }

    @Override
    public void modificar(Vehiculo obj) throws Exception {
        if (!datos.contains(obj)) throw new Exception("Vehículo no existe");
        datos.remove(obj);
        datos.add(obj);
    }

    @Override
    public void eliminar(Vehiculo obj) throws Exception {
        if (!datos.contains(obj)) throw new Exception("Vehículo no existe");
        datos.remove(obj);
    }

    @Override
    public Vehiculo buscarPorPlaca(String placa) throws Exception {
        Vehiculo v = null;
        for (Vehiculo obj : datos) {
            if (obj.getPlaca().equals(placa)) {
                v = obj;
                break;
            }
        }
        return v;
    }

    @Override
    public Vehiculo buscarPorCodigo(int codigo) throws Exception {
        Vehiculo v = new Vehiculo();
        v.setCodigo(codigo);
        if (!datos.contains(v)) return null;

        int idx = datos.indexOf(v);
        return datos.get(idx);
    }

    @Override
    public List<Vehiculo> listar() throws Exception {
        return datos;
    }
}
