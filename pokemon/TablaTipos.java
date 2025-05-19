package pokemon;
import java.util.HashMap;
import java.util.Map;

public class TablaTipos{

    private Map<Pokemon.tipo, Map<Pokemon.tipo, Double>> tablaTipos; // Declaración como variable de instancia

    TablaTipos(){// Mapa principal: tipo atacante → (tipo defensor → efectividad)
        tablaTipos = new HashMap<>();

        // --- Tipo Fuego ---
        Map<Pokemon.tipo, Double> fuego = new HashMap<>();
        fuego.put(Pokemon.tipo.PLANTA, 2.0);
        fuego.put(Pokemon.tipo.AGUA, 0.5);
        fuego.put(Pokemon.tipo.ELECTRICO, 1.0);
        fuego.put(Pokemon.tipo.TIERRA, 0.5);
        fuego.put(Pokemon.tipo.FUEGO, 0.5);
        tablaTipos.put(Pokemon.tipo.FUEGO, fuego);

        // --- Tipo Agua ---
        Map<Pokemon.tipo, Double> agua = new HashMap<>();
        agua.put(Pokemon.tipo.FUEGO, 2.0);
        agua.put(Pokemon.tipo.PLANTA, 0.5);
        agua.put(Pokemon.tipo.TIERRA, 2.0);
        agua.put(Pokemon.tipo.ELECTRICO, 1.0);
        agua.put(Pokemon.tipo.AGUA, 0.5);
        tablaTipos.put(Pokemon.tipo.AGUA, agua);

        // --- Tipo Planta ---
        Map<Pokemon.tipo, Double> planta = new HashMap<>();
        planta.put(Pokemon.tipo.FUEGO, 0.5);
        planta.put(Pokemon.tipo.AGUA, 2.0);
        planta.put(Pokemon.tipo.TIERRA, 2.0);
        planta.put(Pokemon.tipo.ELECTRICO, 1.5);
        planta.put(Pokemon.tipo.PLANTA, 0.5);
        tablaTipos.put(Pokemon.tipo.PLANTA, planta);

        // --- Tipo Roca ---
        Map<Pokemon.tipo, Double> tierra = new HashMap<>();
        tierra.put(Pokemon.tipo.FUEGO, 2.0);
        tierra.put(Pokemon.tipo.AGUA, 1.0);
        tierra.put(Pokemon.tipo.ELECTRICO, 2.0);
        tierra.put(Pokemon.tipo.PLANTA, 0.5);
        tierra.put(Pokemon.tipo.TIERRA, 1.0);
        tablaTipos.put(Pokemon.tipo.TIERRA, tierra);

        Map<Pokemon.tipo, Double> electrico = new HashMap<>();
        electrico.put(Pokemon.tipo.FUEGO, 1.0);
        electrico.put(Pokemon.tipo.AGUA, 2.0);
        electrico.put(Pokemon.tipo.TIERRA, 0.0);
        electrico.put(Pokemon.tipo.PLANTA, 0.5);
        electrico.put(Pokemon.tipo.ELECTRICO, 0.5);
        tablaTipos.put(Pokemon.tipo.ELECTRICO, electrico);

        // Recorrer tabla con for-each
        for (Map.Entry<Pokemon.tipo, Map<Pokemon.tipo, Double>> atacante : tablaTipos.entrySet()) {
            Pokemon.tipo tipoAtacante = atacante.getKey();
            Map<Pokemon.tipo, Double> defensores = atacante.getValue();

            for (Map.Entry<Pokemon.tipo, Double> defensor : defensores.entrySet()) {
                Pokemon.tipo tipoDefensor = defensor.getKey();
                double efectividad = defensor.getValue();
                System.out.println(tipoAtacante + " → " + tipoDefensor + " = " + efectividad + "x");
            }
        }
    }
    public double getMultiplicador(Pokemon.tipo tipoAtacante, Pokemon.tipo tipoDefensor) {
        if (tablaTipos.containsKey(tipoAtacante)) {
            Map<Pokemon.tipo, Double> efectividades = tablaTipos.get(tipoAtacante);
            if (efectividades.containsKey(tipoDefensor)) {
                return efectividades.get(tipoDefensor);
            }
        }
        return 1.0; // Valor por defecto si no se encuentra la combinación
    }
}