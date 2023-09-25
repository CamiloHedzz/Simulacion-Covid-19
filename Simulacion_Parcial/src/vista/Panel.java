package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import modelo.Punto;

public class Panel extends JPanel {

    
    private ArrayList<Punto> puntos = new ArrayList<>();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.lightGray);
        for (int i = 0; i < puntos.size(); i++) {
            int color = puntos.get(i).getColor();
            switch (color) {
                case 1:
                    g.setColor(Color.green);
                    break;
                case 2:
                    g.setColor(Color.RED);
                    break;
                case 3:
                    g.setColor(Color.BLUE);
                    break;
                case 4:
                    g.setColor(Color.BLACK);
                    break;
                default:
                    g.setColor(Color.lightGray);
            }
            g.fillOval(puntos.get(i).x, puntos.get(i).y , 7, 7);

        }

    }

    public void setPuntos(ArrayList<Punto> pps) {
        this.puntos = pps;
    }

}
