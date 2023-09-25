
package modelo;

import controlador.Controlador;
import java.util.TimerTask;

public class Tiempo extends TimerTask {

    Controlador control;
    Logica l;
    int contador;

    public Tiempo(Logica log, Controlador c) {
        this.l = log;
        this.control = c;
    }

    @Override
    public void run() {
        switch (control.getOpcion()) {
            case 1:
                contador++;
                if (contador == 10) {
                    l.diasTrasncurridos();
                    contador = 0;
                }
                l.moverPunto();
                break;
        }

    }

}
