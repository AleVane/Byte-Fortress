package mx.edu.uacm.is.slt.ds.vitalpet.managers;


import mx.edu.uacm.is.slt.ds.vitalpet.models.Persona;

public class VeterinariaManager {
    private static VeterinariaManager instance;
    private Persona usuarioActual;
    
    private VeterinariaManager() {
        // Constructor privado para evitar instanciación directa
    }
    
    public static synchronized VeterinariaManager getInstance() {
        if (instance == null) {
            instance = new VeterinariaManager();
        }
        return instance;
    }
    
    public void setUsuarioActual(Persona persona) {
        this.usuarioActual = persona;
    }
    
    public Persona getUsuarioActual() {
        return usuarioActual;
    }
}