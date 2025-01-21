package src.main.java.com.example.demo;


import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class JsonGenerator {

    public static class Conversion {
        private String monedaOrigen;
        private String monedaDestino;
        private double cantidadOrigen;
        private double cantidadDestino;

        public Conversion(String monedaOrigen, String monedaDestino, double cantidadOrigen, double cantidadDestino) {
            this.monedaOrigen = monedaOrigen;
            this.monedaDestino = monedaDestino;
            this.cantidadOrigen = cantidadOrigen;
            this.cantidadDestino = cantidadDestino;
        }

        // Getters y setters
    }

    public String generarJsonLista(List<Conversion> conversiones) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(conversiones);
    }

    public void guardarJsonEnArchivo(String json, String archivo) throws IOException {
        File file = new File(archivo);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(file, json);
    }
}

