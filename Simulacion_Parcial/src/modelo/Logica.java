package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.Ventana;
import vista.VentanaC;


public class Logica {

    Ventana view;
    VentanaC view2;
    ArrayList<Punto> dots = new ArrayList<>();
    boolean validar = false;
    int dias = 0;
    int poblacionTotal = 0;
    int proContagio = 0;
    int prueba;
    int cotagiadosDia = 0;
    int muetosDia = 0;
    int tapabocas;
    double dist;

    public Logica(Ventana v, VentanaC c) {
        view = v;
        view2 = c;
        view.getPanelMatriz().setPuntos(dots);
        view.getPanelMatriz().repaint();
    }

    public void actualizar() {
        view.getDias().setText("   Dias Transcurridos:   " + 0);
        dias = 0;
        dots.clear();
        recorridoPuntos();
        view.getPanelMatriz().repaint();
    }

    public void nivelIQ(int nivelInteli) {
        for (Punto dot : dots) {
            if (nivelInteli == 1) {
                dot.setInteligencia(1);
            } else {
                dot.setInteligencia(0);
            }
        }
    }

    public void insertarDatos() {
        int ancho = view.getPanelMatriz().getSize().width - 10;
        int alto = view.getPanelMatriz().getSize().height - 10;
        int posicionX;
        int posicionY;
        int color, edad;
        int infectados;
        int sanos;
        if (!view.infectados.getText().isEmpty() && !view.sanos.getText().isEmpty()) {
            infectados = Integer.valueOf(view.infectados.getText().trim());
            sanos = Integer.valueOf(view.sanos.getText().trim());
            poblacionTotal = infectados + sanos;
            for (int i = 0; i < poblacionTotal; i++) {
                if (i < infectados) {
                    int cont = (int) (Math.random() * 100);
                    if (cont < 40) {
                        color = (int) (Math.random() * (2) + 2);
                    } else {
                        color = 2;
                    }
                } else {
                    color = 1;
                }
                posicionX = (int) (Math.random() * ancho);
                posicionY = (int) (Math.random() * alto);
                edad = (int) (Math.random() * 100) + 1;
                dots.add(new Punto(posicionX, posicionY, color, edad, 0, 0, 0, 0));
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO SE HAN INGRESADO DATOS");
        }

        view.getPanelMatriz().setPuntos(dots);
        view.getPanelMatriz().repaint();
    }

    public void ingresarInfectado() {
        if (!view2.getNumEjex().getText().isEmpty() && !view2.getNumEjey().getText().isEmpty()) {
            int ejex = Integer.valueOf(view2.getNumEjex().getText().trim());
            int ejey = Integer.valueOf(view2.getNumEjey().getText().trim());
            int edad = (int) ((Math.random() * 100) + 1);
            dots.add(new Punto(ejex, ejey, 2, edad, 0, 0, 0, 0));
        } else {
            JOptionPane.showMessageDialog(null, "COORDENADAS VACIAS");
        }
        view.getPanelMatriz().setPuntos(dots);
        view.getPanelMatriz().repaint();
    }

    public void determinarEstado() {
        for (Punto persona : dots) {
            if (persona.getColor() == 2) {
                int muerte = (int) (Math.random() * 1000);
                persona.setDiasExistiendo(persona.getDiasExistiendo() + 1);
                if (persona.getDiasExistiendo() > 15) {
                    if (persona.getEdad() < 15) {
                        if (muerte < 10) {
                            persona.setColor(4);
                        }
                    } else if (persona.getEdad() > 15 && persona.getEdad() < 30) {
                        if (muerte < 15) {
                            persona.setColor(4);
                        }
                    } else if (persona.getEdad() > 30 && persona.getEdad() < 60) {
                        if (muerte < 30) {
                            persona.setColor(4);
                        }
                    } else if (persona.getEdad() > 65) {
                        if (muerte > 30) {
                            persona.setColor(4);
                        }
                    }
                }

            }
        }
        view.getPanelMatriz().setPuntos(dots);
        view.getPanelMatriz().repaint();
    }

    public void moverPunto() {
        for (Punto dot : dots) {
            if (dot.getColor() != 4) {
                int proba = (int) (Math.random() * 1000);
                int x = dot.getX();
                int y = dot.getY();
                if (proba >= 0 && proba <= 250) {
                    if (y > 3) {
                        y = y - 1;
                    }
                } else if (proba >= 251 && proba <= 500) {
                    if (y < 410) {
                        y = y + 1;
                    }

                } else if (proba >= 501 && proba <= 750) {
                    if (x < 840) {
                        x = x + 1;
                    }
                } else if (proba > 751) {
                    if (x > 3) {
                        x = x - 1;
                    }
                }
                dot.setX(x);
                dot.setY(y);
                view.getPanelMatriz().setPuntos(dots);
                view.getPanelMatriz().repaint();
                if (dot.getColor() == 1 && dot.getInteligencia() == 1) {
                    distancia(dot);
                }
            }
        }
        recorridoPuntos();
    }

    public void moverSano(Punto sano, Punto infectado, double modulo) {
        validar = true;
        int xsano = sano.getX();
        int ysano = sano.getY();
        int xinfect = infectado.getX();
        int yinfect = infectado.getY();
        if (modulo < 100) {
            if (xsano > xinfect) {
                sano.setX(sano.getX() + 1);
            } else if (ysano > yinfect) {
                sano.setY(sano.getY() + 1);
            } else if (xsano < xinfect) {
                sano.setX(sano.getX() - 1);
            } else if (ysano < yinfect) {
                sano.setY(sano.getY() - 1);
            }
            view.getPanelMatriz().setPuntos(dots);
            view.getPanelMatriz().repaint();
        }
    }

    public void usoTapabocas(int tapabocas) {
        for (Punto dot : dots) {
            dot.setTapaBocas(tapabocas);
        }
    }

    public void diasTrasncurridos() {
        view.getDias().setText("   Dias Transcurridos:   " + dias++);
        determinarEstado();
        recuperacion();
    }

    public void recuperacion() {
        for (Punto persona : dots) {
            if (persona.getColor() == 2) {
                if (persona.getDiasExistiendo() > 17) {
                    persona.setColor(1);
                    persona.setTasaContagio(-20);
                    persona.setDiasExistiendo(0);
                }
            }
            if (persona.getColor() == 3) {
                persona.setDiasExistiendo(persona.getDiasExistiendo() + 1);
                if (persona.diasExistiendo > 10) {
                    persona.setColor(1);
                    persona.setTasaContagio(-20);
                    persona.setDiasExistiendo(0);
                }
            }
        }
    }

    public void distancia(Punto dato) {
        int corX;
        int corY;
        double modu;
        for (Punto e : dots) {
            if (dato.getColor() == 1 && (e.getColor() == 2 || e.getColor() == 3)) {
                corX = dato.getX() - e.getX();
                corY = dato.getY() - e.getY();
                modu = Math.sqrt((corX * corX) + (corY * corY));
                dist = modu;
                selecViva(dato, modu);
                moverSano(dato, e, dist);
            } else if ((dato.getColor() == 2 || dato.getColor() == 3) && e.getColor() == 1) {
                corX = e.getX() - dato.getX();
                corY = e.getY() - dato.getY();
                modu = Math.sqrt((corX * corX) + (corY * corY));
                selecViva(e, modu);
            }
        }
    }

    public void determinarTasa(int numContagiados, int numMuertos) {
        double mont = ((double) numMuertos / (double) poblacionTotal) * 100;
        double cont = ((double) numContagiados / (double) poblacionTotal) * 100;
        
        String tContagio = String.format("%.2f", cont);
        String tMortalidad = String.format("%.2f", mont);
        view.getNumtasaContagio().setText(tContagio + "%");
        view.getNumtasaMuerte().setText(tMortalidad + "%");
        cotagiadosDia = 0;
        muetosDia = 0;

    }

    public void selecViva(Punto e, double modu) {
        int distancia, viralidad;
        if (view2.getNumViralidad().getText().isEmpty()) {
            viralidad = 0;
        } else {
            viralidad = Integer.valueOf(view2.getNumViralidad().getText().trim());
        }
        if (view2.getNumDistancia().getText().isEmpty()) {
            distancia = 10;
        } else {
            distancia = Integer.valueOf(view2.getNumDistancia().getText().trim());
        }
        if (modu < distancia) {
            e.setTasaContagio(e.getTasaContagio() + (10 + viralidad));
        } else if (distancia <= modu && modu < (distancia + 10)) {
            e.setTasaContagio(e.getTasaContagio() + (6 + viralidad));
        } else if (modu <= (distancia + 10) && modu < (distancia + 25)) {
            e.setTasaContagio(e.getTasaContagio() + (4 + viralidad));
        } else if ((distancia + 25) <= modu && modu < (distancia + 35)) {
            e.setTasaContagio(e.getTasaContagio() + (2 + viralidad));
        }
        contagiar(e);
        view.getPanelMatriz().setPuntos(dots);
        view.getPanelMatriz().repaint();
    }

    public void contagiar(Punto e) {
        int tasaContagio;
        if (e.getTapaBocas() == 0) {
            tasaContagio = 0;
        } else {
            tasaContagio = 150;
        }
        if (e.getTasaContagio() >= 100 + tasaContagio) {
            int contagio = (int) (Math.random() * 100);
            if (contagio < 80) {
                e.setColor(3);
            } else if (contagio > 80) {
                e.setColor(2);
            }
        }
    }

    public void recorridoPuntos() {
        int infectados = 0;
        int asintomaticos = 0;
        int muertos = 0;
        int sanos = 0;
        int pActual = 0;
        for (Punto dot : dots) {
            int color = dot.getColor();
            switch (color) {
                case 1:
                    sanos++;
                    break;
                case 2:
                    distancia(dot);
                    cotagiadosDia++;
                    infectados++;
                    break;
                case 3:
                    distancia(dot);
                    cotagiadosDia++;
                    asintomaticos++;
                    break;
                case 4:
                    muetosDia++;
                    muertos++;
                    break;
            }
        }
        editarInformacion(poblacionTotal, muertos, infectados, asintomaticos, sanos, pActual);
        determinarTasa(cotagiadosDia, muetosDia);
    }

    public void editarInformacion(int pTotal, int muertos, int infectados, int asintomaticos, int sanos, int pActual) {
        String espacio = "                                  ";
        pTotal = muertos + infectados + asintomaticos + sanos;
        pActual = pTotal - muertos;
        view.getpSanas().setText(String.valueOf("   Personas Sanas " + espacio + sanos));
        view.getpCovid().setText(String.valueOf("   Personas Covid " + espacio + infectados));
        view.getpAsintomaticas().setText(String.valueOf("   Personas Asintomaticas                      " + asintomaticos));
        view.getpFallecidos().setText(String.valueOf("   Fallecidos           " + espacio + muertos));
        view.getPoblacionT().setText("   Poblacion Total:  " + espacio + pTotal);
        view.getPoblacionA().setText("   Poblacion Actual:" + espacio + pActual);

    }

}
