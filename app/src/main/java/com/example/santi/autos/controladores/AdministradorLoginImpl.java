package com.example.santi.autos.controladores;


public class AdministradorLoginImpl implements AdministradorLogin {
    @Override
    public boolean login(String user, String pwd) throws Exception {
        if (user == null) throw new Exception("Usuario null");
        if (pwd == null) throw new Exception("Contraseña null");

        if (user.equals("Santiago") && pwd.equals("Orozco")) {
            return true;
        } else if (user.equals("Sheyla") && pwd.equals("Cabrera")) {
            return true;
        } else if (user.equals("Paulo") && pwd.equals("Muñoz")) {
            return true;
        }
        return false;
    }
}
