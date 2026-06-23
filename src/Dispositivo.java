/**
 * Representa un dispositivo vial del sistema.
 *
 * Puede ser utilizado para semaforos, camaras o sensores.
 * Se identifica mediante un codigo unico, que luego puede ser usado
 * por el DiccionarioDispositivos para recuperar o modificar el dispositivo.
 */
public class Dispositivo {

    private String codigo;
    private String tipo;
    private String estado;

    public Dispositivo(String codigo, String tipo, String estado) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Dispositivo)) {
            return false;
        }

        Dispositivo otro = (Dispositivo) obj;
        return this.codigo.equalsIgnoreCase(otro.codigo);
    }

    @Override
    public String toString() {
        return "Dispositivo { codigo='" + codigo + "', tipo='" + tipo + "', estado='" + estado + "' }";
    }
}
