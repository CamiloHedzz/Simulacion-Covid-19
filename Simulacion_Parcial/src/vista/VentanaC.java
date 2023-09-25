package vista;

import controlador.Controlador;
import java.awt.*;
import javax.swing.*;

public class VentanaC extends JFrame {

    private Panel panelPrincial;
    private JLabel titulo;
    private JLabel info;
    private JLabel info2;
    private JLabel ejes;
    private JTextField numDistancia;
    private JTextField numViralidad;
    private JTextField numEjex;
    private JTextField numEjey;
    private JCheckBox tapabocas;
    private JButton botonInsertar;

    private Controlador miControlador;

    public VentanaC() {
        super("C O N F I G U R A C I O N");
        setLayout(null);
        setBounds(920, 220, 400, 440);
        setVisible(false);
        componentes();
    }

    public void componentes() {
        inicializarPaneles();
        inicializarEtiquetas();
        inicializarTexto();
        inicializarBotones();
    }

    public void inicializarPaneles() {
        //Panel Principal
        panelPrincial = new Panel();
        panelPrincial.setLayout(null);
        panelPrincial.setBounds(0, 0, 400, 410);
        panelPrincial.setBackground(new Color(186, 217, 197));
        this.add(panelPrincial);

    }

    public void inicializarEtiquetas() {

        //Distancia
        titulo = new JLabel("   DISTANCIA MINIMA DE CONTAGIO");
        titulo.setBounds(0, 0, 220, 40);
        titulo.setForeground(Color.white);
        titulo.setOpaque(true);
        titulo.setBackground(new Color(217, 75, 24));
        titulo.setFont(new Font("Myriad Pro", 1, 12));
        panelPrincial.add(titulo);

        //INFORMACION DISTANCIA
        info = new JLabel("Ingrese la distancia minima de contagio, se");
        info2 = new JLabel("recomienda usar valores de entre 20 y 120");
        info.setBounds(0, 70, 400, 40);
        info2.setBounds(0, 85, 400, 40);
        info.setHorizontalAlignment((int) TOP_ALIGNMENT);
        info2.setHorizontalAlignment((int) TOP_ALIGNMENT);
        info.setForeground(Color.black);
        info2.setForeground(Color.black);
        info.setFont(new Font("Myriad Pro", 0, 12));
        info2.setFont(new Font("Myriad Pro", 0, 12));
        panelPrincial.add(info);
        panelPrincial.add(info2);

        //UBICAR PUNTO DE INFECCION
        titulo = new JLabel("   UBICAR PUNTO DE INFECCION");
        titulo.setBounds(0, 120, 220, 40);
        titulo.setForeground(Color.white);
        titulo.setOpaque(true);
        titulo.setBackground(new Color(217, 75, 24));
        titulo.setFont(new Font("Myriad Pro", 1, 12));
        panelPrincial.add(titulo);

        //UBICAR EJES
        ejes = new JLabel("EJE X");
        ejes.setBounds(66, 200, 50, 30);
        ejes.setForeground(Color.black);
        ejes.setFont(new Font("Myriad Pro", 1, 12));
        panelPrincial.add(ejes);

        ejes = new JLabel("EJE Y");
        ejes.setBounds(171, 200, 50, 30);
        ejes.setForeground(Color.black);
        ejes.setFont(new Font("Myriad Pro", 1, 12));
        panelPrincial.add(ejes);

        //INFORMACION EJES
        info = new JLabel("    Para que el punto sea visible recuerde:");
        info2 = new JLabel("    Eje x debe estar entre 0 y 840");
        info.setBounds(0, 215, 400, 40);
        info2.setBounds(0, 230, 400, 40);
        info.setForeground(Color.black);
        info2.setForeground(Color.black);
        info.setFont(new Font("Myriad Pro", 0, 13));
        info2.setFont(new Font("Myriad Pro", 0, 13));
        panelPrincial.add(info);
        panelPrincial.add(info2);
        info = new JLabel("    Eje y debe estar entre 0 y 420");
        info.setBounds(0, 245, 400, 40);
        info.setForeground(Color.black);
        info.setFont(new Font("Myriad Pro", 0, 13));
        panelPrincial.add(info);

        //USO DE TAPABOCAS
        titulo = new JLabel("   USO DE TAPABOCAS");
        titulo.setBounds(0, 370, 170, 20);
        titulo.setForeground(Color.white);
        titulo.setOpaque(true);
        titulo.setBackground(new Color(217, 75, 24));
        titulo.setFont(new Font("Myriad Pro", 1, 12));
        panelPrincial.add(titulo);

        //VIRALIDAD
        titulo = new JLabel("   VIRALIDAD");
        titulo.setBounds(0, 285, 120, 40);
        titulo.setForeground(Color.white);
        titulo.setOpaque(true);
        titulo.setBackground(new Color(217, 75, 24));
        titulo.setFont(new Font("Myriad Pro", 1, 12));
        panelPrincial.add(titulo);

        //IFORMACION VIRALIDAD
        info = new JLabel("    ¿Cuan rapido quiere que sea la propagacion del virus?");
        info.setBounds(0, 325, 400, 40);
        info.setForeground(Color.black);
        info.setHorizontalAlignment((int) TOP_ALIGNMENT);
        info.setFont(new Font("Myriad Pro", 0, 13));
        panelPrincial.add(info);

    }

    public void inicializarTexto() {

        numDistancia = new JTextField();
        numDistancia.setBounds(120, 50, 150, 30);
        numDistancia.setBackground(Color.white);
        numDistancia.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        numDistancia.setFont(new Font("Myriad Pro", 1, 15));
        panelPrincial.add(numDistancia);

        numEjex = new JTextField();
        numEjex.setBounds(50, 170, 70, 30);
        numEjex.setBackground(Color.white);
        numEjex.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        numEjex.setFont(new Font("Myriad Pro", 1, 15));
        panelPrincial.add(numEjex);

        numEjey = new JTextField();
        numEjey.setBounds(150, 170, 70, 30);
        numEjey.setBackground(Color.white);
        numEjey.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        numEjey.setFont(new Font("Myriad Pro", 1, 15));
        panelPrincial.add(numEjey);

        numViralidad = new JTextField();
        numViralidad.setBounds(130, 285, 70, 40);
        numViralidad.setBackground(Color.white);
        numViralidad.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        numViralidad.setFont(new Font("Myriad Pro", 1, 15));
        panelPrincial.add(numViralidad);

    }

    public void inicializarBotones() {

        tapabocas = new JCheckBox();
        tapabocas.setBounds(180, 360, 40, 40);
        tapabocas.setOpaque(false);
        panelPrincial.add(tapabocas);

        botonInsertar = new JButton("INSERTAR");
        botonInsertar.setBounds(250, 170, 100, 30);
        botonInsertar.setForeground(Color.black);
        panelPrincial.add(botonInsertar);

    }

    public void setControlador(Controlador c) {
        miControlador = c;
        tapabocas.addActionListener(miControlador);
        botonInsertar.addActionListener(miControlador);
    }

    public Controlador getMiControlador() {
        return miControlador;
    }

    public JCheckBox getTapabocas() {
        return tapabocas;
    }

    public JTextField getNumDistancia() {
        return numDistancia;
    }

    public JTextField getNumViralidad() {
        return numViralidad;
    }

    public JTextField getNumEjex() {
        return numEjex;
    }

    public JTextField getNumEjey() {
        return numEjey;
    }

}
