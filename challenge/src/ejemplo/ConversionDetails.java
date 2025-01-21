package ejemplo;

public class ConversionDetails {
    private String monedaOrigen;
    private String monedaDestino;
    private double cantidadOrigen;
    private double cantidadDestino;
    private double tasaCambio;

    public ConversionDetails(String monedaOrigen, String monedaDestino, double cantidadOrigen, double cantidadDestino, double tasaCambio) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.cantidadOrigen = cantidadOrigen;
        this.cantidadDestino = cantidadDestino;
        this.tasaCambio = tasaCambio;
    }

    // Getters y setters (opcional si necesitas acceder o modificar los valores)
}
