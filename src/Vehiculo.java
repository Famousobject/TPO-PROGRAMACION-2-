/**
 * Representa un vehiculo dentro del sistema de flujo vehicular.
 *
 * Si el proyecto ya tiene una clase Vehiculo, no usar este archivo.
 */
public class Vehiculo {

    private String patente;
    private String tipo;

    public Vehiculo(String patente, String tipo) {
        this.patente = patente;
        this.tipo = tipo;
    }

    public String getPatente() {
        return patente;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Vehiculo { patente='" + patente + "', tipo='" + tipo + "' }";
    }
}
