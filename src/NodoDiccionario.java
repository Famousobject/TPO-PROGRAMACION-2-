/**
 * Nodo utilizado por el DiccionarioDispositivos.
 *
 * Cada nodo representa una entrada de la tabla hash:
 * - codigo: clave unica del dispositivo.
 * - dispositivo: objeto Dispositivo asociado.
 * - siguiente: referencia al siguiente nodo en caso de colision.
 *
 * Las colisiones se resuelven mediante encadenamiento.
 */
public class NodoDiccionario {

    private String codigo;
    private Dispositivo dispositivo;
    private NodoDiccionario siguiente;

    public NodoDiccionario(String codigo, Dispositivo dispositivo) {
        this.codigo = codigo;
        this.dispositivo = dispositivo;
        this.siguiente = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public NodoDiccionario getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDiccionario siguiente) {
        this.siguiente = siguiente;
    }
}
