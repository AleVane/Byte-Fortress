package mx.edu.uacm.is.slt.ds.vitalpet.facades;

import mx.edu.uacm.is.slt.ds.vitalpet.managers.VeterinariaManager;
import mx.edu.uacm.is.slt.ds.vitalpet.models.*;

public class VeterinariaFacade {
    private final VeterinariaManager manager;
    
    public VeterinariaFacade() {
        this.manager = VeterinariaManager.getInstance();
    }
    
    public boolean registrarNuevoCliente(Persona persona, Usuario usuario, Direccion direccion) {
        persona.setUsuario(usuario);
        persona.setDireccion(direccion);
        manager.setUsuarioActual(persona);
        return true;
    }
    
    public boolean agendarCita(Cita cita, Mascota mascota, Tarjeta metodoPago) {
        if (!metodoPago.validarTarjeta()) {
            return false;
        }
        cita.setMascota(mascota);
        return true;
    }
}