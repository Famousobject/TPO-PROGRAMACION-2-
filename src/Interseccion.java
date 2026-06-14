public class Interseccion {
    private String codigo;
    private String nombre;
    private ListaDoble<Calle> calles;

    public Interseccion(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.calles = new ListaDoble<>();
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
