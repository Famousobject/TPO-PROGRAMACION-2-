public class Dispositivo {
    private int codigo;
    private String tipo;
    private String ubicacion;
    private String estado;
    private int ultimaLectura;

    public Dispositivo(int codigo, String tipo, String ubicacion, String estado, int ultimaLectura) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.ultimaLectura = ultimaLectura;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public int getUltimaLectura() {
        return ultimaLectura;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setUltimaLectura(int ultimaLectura) {
        this.ultimaLectura = ultimaLectura;
    }

    @Override
    public String toString() {
        return "Codigo " + codigo
                + " | " + tipo
                + " | ubicacion: " + ubicacion
                + " | estado: " + estado
                + " | lectura: " + ultimaLectura;
    }
}

# 2026-06-05T21:57:05
# 2026-06-11T21:57:06
# 2026-06-07T21:59:57
# 2026-06-08T21:59:57
# 2026-06-01T22:01:26
# 2026-06-12T22:01:30
# 2026-05-29T22:12:25
# 2026-05-30T22:12:25
# 2026-05-31T22:12:26
# 2026-06-05T22:12:27
# 2026-06-12T22:12:30
# 2026-05-29T22:14:35
# 2026-06-06T22:14:37
# 2026-06-06T22:18:02
# 2026-06-11T22:18:03
# 2026-05-29T22:20:24
# 2026-06-10T22:20:29
