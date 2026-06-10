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

# 2026-05-30T21:57:04
# 2026-06-01T21:57:04
# 2026-06-02T21:57:05
# 2026-06-02T21:57:05
# 2026-06-08T21:57:06
# 2026-06-01T21:58:03
# 2026-06-10T21:58:05
# 2026-06-12T21:58:05
# 2026-06-07T22:12:28
# 2026-06-04T22:14:37
# 2026-06-12T22:15:02
# 2026-05-30T22:18:00
# 2026-06-07T22:20:28
# 2026-06-09T22:20:29