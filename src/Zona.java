public class Zona {
    private String nombre;
    private ListaDoble<Barrio> barrios;

    public Zona(String nombre) {
        this.nombre = nombre;
        this.barrios = new ListaDoble<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarBarrio(Barrio barrio) {
        barrios.insertarFinal(barrio);
    }

    public Barrio buscarBarrio(String nombreBarrio) {
        for (int i = 0; i < barrios.cantidadElementos(); i++) {
            Barrio barrio = barrios.obtener(i);
            if (barrio.getNombre().equalsIgnoreCase(nombreBarrio)) {
                return barrio;
            }
        }
        return null;
    }

    public int cantidadBarrios() {
        return barrios.cantidadElementos();
    }

    public int cantidadManzanas() {
        int total = 0;
        for (int i = 0; i < barrios.cantidadElementos(); i++) {
            total += barrios.obtener(i).cantidadManzanas();
        }
        return total;
    }

    public String reporte() {
        StringBuilder sb = new StringBuilder();
        sb.append("Zona: ").append(nombre)
                .append(" | barrios: ").append(cantidadBarrios())
                .append(" | manzanas: ").append(cantidadManzanas())
                .append("\n");
        for (int i = 0; i < barrios.cantidadElementos(); i++) {
            sb.append(barrios.obtener(i).reporte());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return nombre;
    }
}

# 2026-05-30T21:58:03
# 2026-06-01T21:58:03
# 2026-06-02T21:58:04
# 2026-05-29T21:59:53
# 2026-05-29T22:01:25
# 2026-06-09T22:01:28
# 2026-06-12T22:12:30
# 2026-06-10T22:14:38
# 2026-06-01T22:14:59
# 2026-06-06T22:15:00
# 2026-06-09T22:15:01
# 2026-06-09T22:15:01