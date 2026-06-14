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
