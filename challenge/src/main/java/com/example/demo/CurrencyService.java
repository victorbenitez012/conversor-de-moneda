package src.main.java.com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class CurrencyService {
    private final Map<String, Double> tasasDeCambio;

    public CurrencyService() {
        tasasDeCambio = new HashMap<>();
        tasasDeCambio.put("USD-ARS", 1200.0);
        tasasDeCambio.put("USD-BRL", 5.0);
        tasasDeCambio.put("USD-COP", 4000.0);
        tasasDeCambio.put("ARS-USD", 1 / 1200.0);
        tasasDeCambio.put("BRL-USD", 1 / 5.0);
        tasasDeCambio.put("COP-USD", 1 / 4000.0);
        // Agregar más tasas según sea necesario
    }

    public double convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad) throws Exception {
        if (monedaOrigen.equals(monedaDestino)) {
            return cantidad;
        }
        String clave = monedaOrigen + "-" + monedaDestino;
        if (!tasasDeCambio.containsKey(clave)) {
            throw new Exception("Conversión no soportada entre " + monedaOrigen + " y " + monedaDestino);
        }
        return cantidad * tasasDeCambio.get(clave);
    }
}

