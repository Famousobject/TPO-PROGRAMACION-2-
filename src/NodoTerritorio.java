/**
 * Nodo utilizado por el ArbolTerritorio.
 *
 * Representa un territorio de la ciudad.
 * Puede ser:
 * - Ciudad
 * - Zona
 * - Barrio
 * - Manzana
 *
 * Como es un arbol N-ario, cada nodo puede tener muchos hijos.
 * Los hijos se guardan usando la ListaDoble propia del proyecto.
 */
public class NodoTerritorio {

    private String nombre;
    private String tipo;
    private NodoTerritorio padre;
    private ListaDoble<NodoTerritorio> hijos;

    public NodoTerritorio(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.padre = null;
        this.hijos = new ListaDoble<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public NodoTerritorio getPadre() {
        return padre;
    }

    public void setPadre(NodoTerritorio padre) {
        this.padre = padre;
    }

    public ListaDoble<NodoTerritorio> getHijos() {
        return hijos;
    }

    /**
     * Agrega un hijo al nodo actual.
     *
     * Se usa insertarFinal porque ese es el nombre real del metodo
     * definido en la ListaDoble del proyecto.
     */
    public void agregarHijo(NodoTerritorio hijo) {
        if (hijo != null) {
            hijo.setPadre(this);
            hijos.insertarFinal(hijo);
        }
    }

    public void mostrar() {
        System.out.println(tipo + ": " + nombre);
    }
}
