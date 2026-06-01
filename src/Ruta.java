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

# 2026-06-02T21:58:04
# 2026-06-04T21:58:04
# 2026-06-04T21:58:04
# 2026-06-06T21:58:04
# 2026-06-08T21:59:57
# 2026-06-08T22:01:28
# 2026-06-12T22:01:30
# 2026-06-02T22:14:36
# 2026-06-05T22:18:01
# 2026-06-08T22:18:02
# 2026-05-30T22:20:25
# 2026-06-04T22:20:26
# 2026-06-07T22:20:28
