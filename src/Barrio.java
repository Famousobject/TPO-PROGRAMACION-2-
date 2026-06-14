public class Barrio {
    private String nombre;
    private ListaDoble<Manzana> manzanas;

    public Barrio(String nombre) {
        this.nombre = nombre;
        this.manzanas = new ListaDoble<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarManzana(Manzana manzana) {
        manzanas.insertarFinal(manzana);
    }

    public Manzana buscarManzana(String codigo) {
        for (int i = 0; i < manzanas.cantidadElementos(); i++) {
            Manzana manzana = manzanas.obtener(i);
            if (manzana.getCodigo().equalsIgnoreCase(codigo)) {
                return manzana;
            }
        }
        return null;
    }

    public int cantidadManzanas() {
        return manzanas.cantidadElementos();
    }

    public String reporte() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Barrio: ").append(nombre).append("\n");
        for (int i = 0; i < manzanas.cantidadElementos(); i++) {
            sb.append("    ").append(manzanas.obtener(i)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return nombre;
    }
}

# 2026-05-31T21:57:04
# 2026-06-09T21:59:58
# 2026-06-02T22:01:26
# 2026-06-05T22:01:27
# 2026-06-10T22:01:28
# 2026-06-11T22:01:29
# 2026-06-11T22:14:39
# 2026-05-29T22:14:58
# 2026-06-08T22:15:01