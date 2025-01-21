package src.main.java.com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
    public double convertirMoneda(String monedaOrigen, String monedaDestino, double cantidadOrigen) {
        // Lógica de conversión de moneda
        // Puedes agregar la lógica de conversión aquí según lo que necesites.
        return cantidadOrigen * 1.2; // Simulación de conversión
    }
}

