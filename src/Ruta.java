public class Ruta {
    private boolean existe;
    private String camino;
    private double tiempoTotal;

    public Ruta(boolean existe, String camino, double tiempoTotal) {
        this.existe = existe;
        this.camino = camino;
        this.tiempoTotal = tiempoTotal;
    }

    public static Ruta sinRuta(String origen, String destino) {
        return new Ruta(false, "No existe ruta entre " + origen + " y " + destino, -1);
    }

    public boolean existe() {
        return existe;
    }

    public String getCamino() {
        return camino;
    }

    public double getTiempoTotal() {
        return tiempoTotal;
    }

    @Override
    public String toString() {
        if (!existe) {
            return camino;
        }
        return "Ruta: " + camino + " | Tiempo total: " + tiempoTotal + " minutos";
    }
}


