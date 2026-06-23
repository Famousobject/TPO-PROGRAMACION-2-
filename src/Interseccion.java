public class Interseccion {
    private String codigo;
    private String nombre;
    private ListaDoble<Calle> calles;
    private ColaVehiculos colaVehiculos;

    public Interseccion(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.calles = new ListaDoble<>();
        this.colaVehiculos = new ColaVehiculos();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public ListaDoble<Calle> getCalles() {
        return calles;
    }

    public void agregarCalle(Calle calle) {
        calles.insertarFinal(calle);
    }

    /**
     * Agrega un vehiculo a la cola de espera de esta interseccion.
     *
     * La cola respeta el orden FIFO:
     * el primer vehiculo que llega es el primero en salir.
     */
    public void recibirVehiculo(Vehiculo vehiculo) {
        colaVehiculos.encolar(vehiculo);
    }

    /**
     * Libera el siguiente vehiculo de la interseccion.
     *
     * Devuelve null si no hay vehiculos esperando.
     */
    public Vehiculo liberarVehiculo() {
        return colaVehiculos.desencolar();
    }

    /**
     * Muestra los vehiculos que estan esperando en esta interseccion.
     */
    public void mostrarColaVehiculos() {
        System.out.println("Interseccion: " + codigo + " - " + nombre);
        colaVehiculos.mostrar();
    }

    /**
     * Devuelve la cantidad de vehiculos esperando.
     */
    public int cantidadVehiculosEsperando() {
        return colaVehiculos.getCantidad();
    }

    /**
     * Devuelve la cola de vehiculos asociada a esta interseccion.
     */
    public ColaVehiculos getColaVehiculos() {
        return colaVehiculos;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Interseccion)) {
            return false;
        }
        Interseccion otra = (Interseccion) obj;
        return this.codigo.equalsIgnoreCase(otra.codigo);
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
