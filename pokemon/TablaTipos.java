package pokemon;
import java.util.HashMap;
import java.util.Map;

public class TablaTipos{

     TablaTipos(){// Mapa principal: tipo atacante → (tipo defensor → efectividad)
            Map<String, Map<String, Double>> tablaTipos = new HashMap<>();

            // --- Tipo Fuego ---
            Map<String, Double> fuego = new HashMap<>();
            fuego.put("Planta", 2.0);
            fuego.put("Agua", 0.5);
            fuego.put("Roca", 0.5);
            fuego.put("Fuego", 0.5);
            tablaTipos.put("Fuego", fuego);

            // --- Tipo Agua ---
            Map<String, Double> agua = new HashMap<>();
            agua.put("Fuego", 2.0);
            agua.put("Planta", 0.5);
            agua.put("Roca", 2.0);
            agua.put("Agua", 0.5);
            tablaTipos.put("Agua", agua);

            // --- Tipo Planta ---
            Map<String, Double> planta = new HashMap<>();
            planta.put("Fuego", 0.5);
            planta.put("Agua", 2.0);
            planta.put("Roca", 2.0);
            planta.put("Planta", 0.5);
            tablaTipos.put("Planta", planta);

            // --- Tipo Roca ---
            Map<String, Double> roca = new HashMap<>();
            roca.put("Fuego", 2.0);
            roca.put("Agua", 1.0);
            roca.put("Planta", 1.0);
            roca.put("Roca", 1.0);
            tablaTipos.put("Roca", roca);

            // Recorrer tabla con for-each
            for (Map.Entry<String, Map<String, Double>> atacante : tablaTipos.entrySet()) {
                String tipoAtacante = atacante.getKey();
                Map<String, Double> defensores = atacante.getValue();

                for (Map.Entry<String, Double> defensor : defensores.entrySet()) {
                    String tipoDefensor = defensor.getKey();
                    double efectividad = defensor.getValue();
                    System.out.println(tipoAtacante + " → " + tipoDefensor + " = " + efectividad + "x");
                }
            } 
        }
    }    
}
