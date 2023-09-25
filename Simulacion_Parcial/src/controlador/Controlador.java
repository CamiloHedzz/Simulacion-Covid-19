package controlador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import modelo.*;
import vista.*;

public class Controlador implements ActionListener {

    Timer myTimer = new Timer();
    Tiempo tiempo;
    Logica l;
    Ventana view;
    VentanaC view2;
    int opcicon, velTiempo = 250;

    public Controlador(Logica log, Ventana v, VentanaC c) {
        l = log;
        view = v;
        view2 = c;
        tiempo = new Tiempo(log, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "INICIAR":
                opcicon = 1;
                l.insertarDatos();
                myTimer = new Timer();
                velTiempo = 2;
                tiempo();
                break;
            case "DETENER":
                myTimer.cancel();
                myTimer = new Timer();
                break;
            case "REANUDAR":
                myTimer = new Timer();
                velTiempo = 2;
                tiempo();
                break;
            case "REINICIAR":
                l.actualizar();
                myTimer.cancel();
                myTimer = new Timer();
                break;
            case "INSERTAR":
                l.ingresarInfectado();
            default:
                break;
        }
        if (view2.getTapabocas().isSelected()) {
            l.usoTapabocas(1);
        } else {
            l.usoTapabocas(0);
        }
        
        if (view.getInteligencia().isSelected()) {
            l.nivelIQ(1);
        } else {
            l.nivelIQ(0);
        }

        opcionesTema(e);
        opcionesDatos(e);
        opcionesVelocidad(e);
    }

    public void opcionesTema(ActionEvent e) {
        if (e.getSource() == view.getItem1()) {
            view.getPanelMatriz().setBackground(Color.DARK_GRAY);
        } else if (e.getSource() == view.getItem2()) {
            view.getPanelMatriz().setBackground(Color.white);
        }
    }

    public void opcionesDatos(ActionEvent e) {
        if (e.getSource() == view.getDatos()) {
            if (view2.isVisible() == false) {
                view2.setVisible(true);
            }
        }

    }

    public void opcionesVelocidad(ActionEvent e) {
        if (e.getSource() == view.getvelocidadLenta()) {
            velTiempo = 1;
            myTimer.cancel();
            myTimer = new Timer();
            tiempo();
        } else if (e.getSource() == view.getvelocidadNormal()) {
            velTiempo = 2;
            myTimer.cancel();
            myTimer = new Timer();
            tiempo();
        } else if (e.getSource() == view.getvelocidadRapida()) {
            velTiempo = 3;
            myTimer.cancel();
            myTimer = new Timer();
            tiempo();
        }

    }

    public void tiempo() {
        tiempo = new Tiempo(l, this);
        switch (velTiempo) {
            case 1:
                myTimer.schedule(tiempo, 1000, 600);
                break;
            case 2:
                myTimer.schedule(tiempo, 1000, 150);
                break;
            case 3:
                myTimer.schedule(tiempo, 1000, 50);
                break;
        }
    }

    public int getOpcion() {
        return opcicon;
    }

    public void setL(Logica l) {
        this.l = l;
    }


}
