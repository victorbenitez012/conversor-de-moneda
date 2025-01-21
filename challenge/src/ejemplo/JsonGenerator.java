package ejemplo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonGenerator {

    public static class Conversion {
        private final String monedaOrigen;
        private final String monedaDestino;
        private final double cantidadOrigen;
        private final double cantidadDestino;

        public Conversion(String monedaOrigen, String monedaDestino, double cantidadOrigen, double cantidadDestino) {
            this.monedaOrigen = monedaOrigen;
            this.monedaDestino = monedaDestino;
            this.cantidadOrigen = cantidadOrigen;
            this.cantidadDestino = cantidadDestino;
        }

        public String getMonedaOrigen() {
            return monedaOrigen;
        }

        public String getMonedaDestino() {
            return monedaDestino;
        }

        public double getCantidadOrigen() {
            return cantidadOrigen;
        }

        public double getCantidadDestino() {
            return cantidadDestino;
        }
    }

    public String generarJsonLista(List<Conversion> conversiones) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(conversiones);
    }

    public void guardarJsonEnArchivo(String json, String nombreArchivo) throws IOException {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(json);
        }
    }
}
