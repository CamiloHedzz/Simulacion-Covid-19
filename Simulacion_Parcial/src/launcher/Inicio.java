package launcher;

import controlador.Controlador;
import modelo.*;
import vista.*;


public class Inicio {
    public static void main(String[] args) {
        Ventana miVentana = new Ventana();
        VentanaC ventanaConfi = new VentanaC();
        Logica miLogica = new Logica(miVentana, ventanaConfi);
        Controlador miControlador = new Controlador(miLogica, miVentana, ventanaConfi);
        Tiempo miTiempo = new Tiempo(miLogica, miControlador);
        miVentana.setControlador(miControlador);
        ventanaConfi.setControlador(miControlador);
    }
}
