public class Calle {
    private String nombre;
    private Interseccion origen;
    private Interseccion destino;
    private double tiempoMinutos;
    private boolean habilitada;

    public Calle(String nombre, Interseccion origen, Interseccion destino, double tiempoMinutos) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.tiempoMinutos = tiempoMinutos;
        this.habilitada = true;
    }

    public String getNombre() {
        return nombre;
    }

    public Interseccion getOrigen() {
        return origen;
    }

    public Interseccion getDestino() {
        return destino;
    }

    public double getTiempoMinutos() {
        return tiempoMinutos;
    }

    public boolean estaHabilitada() {
        return habilitada;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }

    @Override
    public String toString() {
        String estado = habilitada ? "habilitada" : "cortada";
        return destino.getCodigo() + "(" + nombre + ", " + tiempoMinutos + " min, " + estado + ")";
    }
}

# 2026-06-07T21:57:06
# 2026-06-07T21:58:04
# 2026-05-31T21:59:54
# 2026-06-03T21:59:56
# 2026-06-06T21:59:56
# 2026-06-12T21:59:59
# 2026-05-29T22:01:25
# 2026-06-06T22:01:27
# 2026-06-07T22:01:27
# 2026-05-30T22:12:25
# 2026-06-08T22:14:38
# 2026-05-29T22:14:58
# 2026-06-07T22:18:02
