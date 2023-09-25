package vista;

import java.awt.Color;

import javax.swing.*;
import controlador.Controlador;
import java.awt.Font;

/**
 *
 * @author Camilo Hernández
 */
public class Ventana extends JFrame {

    private Panel panelNav;
    private Panel panelPrincial;
    private Panel panelMatriz;
    private Panel panelInformacion;
    private Panel panelInteligencia;

    private JButton botonIniciar;
    private JButton botonDetener;
    private JButton botonReiniciar;
    private JButton botonReanudar;
    private JCheckBox inteligencia;
    private Controlador miControlador;

    private JLabel miTitulo;
    private JLabel miTitulo2;
    private JLabel miTitulo3;
    private JLabel pCovid;
    private JLabel pSanas;
    private JLabel pFallecidos;
    private JLabel pAsintomaticas;
    private JLabel infoAdicional;
    private JLabel poblacionT;
    private JLabel poblacionA;
    private JLabel tasaContagio;
    private JLabel numtasaContagio;
    private JLabel tasaMuerte;
    private JLabel numtasaMuerte;
    private JLabel dias;
    private JLabel personasSanas;
    private JLabel personasInfectadas;
    private JLabel inteli;

    private JMenu menu;
    private JMenu menuColores;
    private JMenu menuVelocidad;
    private JMenuBar barra;
    private JMenuItem itemOscuro;
    private JMenuItem itemClaro;
    private JMenuItem velNormal;
    private JMenuItem vel25;
    private JMenuItem vel5;
    private JMenuItem datos;

    public JTextField poblacion = new JTextField("33");
    public JTextField sanos = new JTextField("100");
    public JTextField infectados = new JTextField("66");

    public Ventana() {
        super("S I M U L A C I Ó N   P A R C I A L ");
        setLayout(null);
        setBounds(0, 0, 1360, 750);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        componentes();
    }

    public void componentes() {
        inicializarPaneles();
        inicializarEtiquetas();
        inicializarBotones();
        inicializarMenu();
        incializarTexto();
    }

    public void inicializarPaneles() {
        //Panel Principal
        panelPrincial = new Panel();
        panelPrincial.setLayout(null);
        panelPrincial.setBounds(0, 0, 1500, 850);
        panelPrincial.setBackground(new Color(158, 212, 208));
        this.add(panelPrincial);

        //Panel navegador
        panelNav = new Panel();
        panelNav.setLayout(null);
        panelNav.setBounds(0, 50, 900, 110);
        panelNav.setBackground(new Color(12, 38, 38));
        panelPrincial.add(panelNav);

        //Panel Matriz
        panelMatriz = new Panel();
        panelMatriz.setLayout(null);
        panelMatriz.setBounds(40, 200, 850, 420);
        panelMatriz.setBackground(Color.white);
        panelMatriz.setBorder(BorderFactory.createLineBorder(Color.black));
        panelPrincial.add(panelMatriz);

        //Panel Informacion
        panelInformacion = new Panel();
        panelInformacion.setLayout(null);
        panelInformacion.setBounds(950, 200, 320, 420);
        panelInformacion.setBackground(Color.white);
        panelInformacion.setBorder(BorderFactory.createLineBorder(Color.black));
        panelPrincial.add(panelInformacion);

        //Panel Inteligencia
        panelInteligencia = new Panel();
        panelInteligencia.setLayout(null);
        panelInteligencia.setBounds(950, 120, 320, 40);
        panelInteligencia.setBackground(new Color(12, 38, 38));
        panelInteligencia.setBorder(BorderFactory.createLineBorder(Color.black));
        panelPrincial.add(panelInteligencia);

        inteligencia = new JCheckBox();
        inteligencia.setBounds(280, 0, 40, 40);
        inteligencia.setOpaque(false);
        panelInteligencia.add(inteligencia);

    }

    public void inicializarBotones() {
        //Boton 1
        botonIniciar = new JButton("INICIAR");
        botonIniciar.setBounds(40, 640, 180, 60);
        botonIniciar.setBackground(new Color(89, 188, 171));
        botonIniciar.setForeground(Color.white);
        panelPrincial.add(botonIniciar);

        //Boton 2
        botonDetener = new JButton("DETENER");
        botonDetener.setBounds(265, 640, 180, 60);
        botonDetener.setBackground(new Color(89, 188, 171));
        botonDetener.setForeground(Color.white);
        panelPrincial.add(botonDetener);

        //Boton 3
        botonReanudar = new JButton("REANUDAR");
        botonReanudar.setBounds(485, 640, 180, 60);
        botonReanudar.setBackground(new Color(89, 188, 171));
        botonReanudar.setForeground(Color.white);
        panelPrincial.add(botonReanudar);

        //Boton 4
        botonReiniciar = new JButton("REINICIAR");
        botonReiniciar.setBounds(710, 640, 180, 60);
        botonReiniciar.setBackground(new Color(89, 188, 171));
        botonReiniciar.setForeground(Color.white);
        panelPrincial.add(botonReiniciar);

    }

    public void inicializarEtiquetas() {

        //Inteligencia
        inteli = new JLabel("I N T E L I G E N C I A");
        inteli.setBounds(20, 10, 190, 20);
        inteli.setForeground(Color.white);
        inteli.setFont(new Font("Myriad Pro", 0, 15));

        panelInteligencia.add(inteli);

        //Titulo
        miTitulo = new JLabel("SIMULACION CASOS COVID-19");
        miTitulo.setBounds(30, 15, 450, 25);
        miTitulo.setForeground(Color.white);
        miTitulo.setFont(new Font("Myriad Pro", 1, 25));
        panelNav.add(miTitulo);

        //Autores
        miTitulo2 = new JLabel("Juan Esteban Arias, Juan Camilo Hernandez, Christian David Jimenez");
        miTitulo2.setBounds(30, 45, 500, 22);
        miTitulo2.setForeground(Color.white);
        miTitulo2.setFont(new Font("Myriad Pro", 0, 14));
        panelNav.add(miTitulo2);

        //Universidad
        miTitulo3 = new JLabel("Universidad Sergio Arboleda");
        miTitulo3.setBounds(30, 75, 500, 25);
        miTitulo3.setForeground(Color.white);
        miTitulo3.setFont(new Font("Myriad Pro", 1, 21));
        panelNav.add(miTitulo3);

        //Personas Fallecidas
        pFallecidos = new JLabel("   Fallecidos");
        pFallecidos.setBounds(0, 0, 320, 40);
        pFallecidos.setForeground(Color.white);
        pFallecidos.setOpaque(true);
        pFallecidos.setBackground(Color.BLACK);
        pFallecidos.setFont(new Font("Myriad Pro", 1, 15));
        panelInformacion.add(pFallecidos);

        //Personas Covid
        pCovid = new JLabel("   Personas Covid");
        pCovid.setBounds(0, 40, 320, 40);
        pCovid.setForeground(Color.white);
        pCovid.setOpaque(true);
        pCovid.setBackground(Color.red);
        pCovid.setFont(new Font("Myriad Pro", 1, 15));
        panelInformacion.add(pCovid);

        //Personas Sanas
        pSanas = new JLabel("   Personas Sanas");
        pSanas.setBounds(0, 80, 320, 40);
        pSanas.setForeground(Color.white);
        pSanas.setOpaque(true);
        pSanas.setBackground(new Color(94, 177, 48));
        pSanas.setFont(new Font("Myriad Pro", 1, 15));
        panelInformacion.add(pSanas);

        //Personas Asintomaticas
        pAsintomaticas = new JLabel("   Personas Asintomaticas");
        pAsintomaticas.setBounds(0, 120, 320, 40);
        pAsintomaticas.setForeground(Color.white);
        pAsintomaticas.setOpaque(true);
        pAsintomaticas.setBackground(new Color(53, 99, 172));
        pAsintomaticas.setFont(new Font("Myriad Pro", 1, 15));
        panelInformacion.add(pAsintomaticas);

        //INFORMACION ADICIONAL
        infoAdicional = new JLabel("INFORMACION ADICIONAL");
        infoAdicional.setHorizontalAlignment((int) TOP_ALIGNMENT);
        infoAdicional.setBounds(0, 160, 320, 30);
        infoAdicional.setForeground(Color.black);
        infoAdicional.setFont(new Font("Myriad Pro", 1, 15));
        panelInformacion.add(infoAdicional);

        poblacionT = new JLabel("   Población Total:");
        poblacionT.setBounds(0, 190, 320, 30);
        poblacionT.setForeground(Color.black);
        poblacionT.setFont(new Font("Myriad Pro", 1, 15));
        panelInformacion.add(poblacionT);

        //POBLACION ACTUAL
        poblacionA = new JLabel("   Población Actual:");
        poblacionA.setBounds(0, 220, 320, 30);
        poblacionA.setForeground(Color.black);
        poblacionA.setFont(new Font("Myriad Pro", 1, 15));
        panelInformacion.add(poblacionA);

        //TASA CONTAGIOS
        tasaContagio = new JLabel("TASA DE CONTAGIOS");
        tasaContagio.setBounds(0, 250, 320, 30);
        tasaContagio.setHorizontalAlignment((int) TOP_ALIGNMENT);
        tasaContagio.setForeground(Color.black);
        tasaContagio.setFont(new Font("Myriad Pro", 1, 15));
        panelInformacion.add(tasaContagio);

        numtasaContagio = new JLabel("0%");
        numtasaContagio.setBounds(0, 280, 320, 30);
        numtasaContagio.setHorizontalAlignment((int) TOP_ALIGNMENT);
        numtasaContagio.setForeground(Color.red);
        numtasaContagio.setFont(new Font("Myriad Pro", 1, 15));
        panelInformacion.add(numtasaContagio);

        //TASA MUERTES
        tasaMuerte = new JLabel("TASA DE MUERTES");
        tasaMuerte.setBounds(0, 310, 320, 30);
        tasaMuerte.setHorizontalAlignment((int) TOP_ALIGNMENT);
        tasaMuerte.setForeground(Color.black);
        tasaMuerte.setFont(new Font("Myriad Pro", 1, 15));
        panelInformacion.add(tasaMuerte);

        numtasaMuerte = new JLabel("0%");
        numtasaMuerte.setBounds(0, 340, 320, 30);
        numtasaMuerte.setHorizontalAlignment((int) TOP_ALIGNMENT);
        numtasaMuerte.setForeground(Color.black);
        numtasaMuerte.setFont(new Font("Myriad Pro", 1, 15));
        panelInformacion.add(numtasaMuerte);

        //DIAS TRANSCURRIDOS
        dias = new JLabel("   Dias Transcurridos:   0");
        dias.setBounds(0, 385, 320, 30);
        dias.setForeground(Color.black);
        dias.setFont(new Font("Myriad Pro", 1, 15));
        panelInformacion.add(dias);

        // PERSONAS SANAS
        personasSanas = new JLabel(" Personas Sanas:");
        personasSanas.setOpaque(true);
        personasSanas.setBounds(950, 630, 175, 30);
        personasSanas.setFont(new Font("Myriad Pro", 1, 15));
        personasSanas.setBackground(Color.yellow);
        personasSanas.setForeground(Color.black);
        personasSanas.setBorder(BorderFactory.createLineBorder(Color.black));
        panelPrincial.add(personasSanas);

        //PERSONAS CONTAGIADAS
        personasInfectadas = new JLabel(" Personas Infectadas:");
        personasInfectadas.setOpaque(true);
        personasInfectadas.setBounds(950, 670, 175, 30);
        personasInfectadas.setFont(new Font("Myriad Pro", 1, 15));
        personasInfectadas.setBackground(Color.yellow);
        personasInfectadas.setForeground(Color.black);
        personasInfectadas.setBorder(BorderFactory.createLineBorder(Color.black));
        panelPrincial.add(personasInfectadas);

    }

    public void inicializarMenu() {

        barra = new JMenuBar();
        barra.setBounds(950, 50, 320, 60);
        barra.setBackground(new Color(12, 38, 38));
        barra.setBorderPainted(true);
        barra.setBorder(BorderFactory.createLineBorder(Color.white));
        panelPrincial.add(barra);

        String espacio = "                          ";
        menu = new JMenu(espacio + "Configuraciones Generales" + espacio);
        menu.setForeground(Color.white);
        menu.setBorder(BorderFactory.createLineBorder(Color.white));
        menu.setBounds(0, 0, 50, 0);
        barra.add(menu);

        menuColores = new JMenu("   Tema");
        menu.add(menuColores);
        itemOscuro = new JMenuItem("Modo Oscuro");
        itemOscuro.addActionListener(miControlador);
        menuColores.add(itemOscuro);

        itemClaro = new JMenuItem("Modo Claro");
        itemClaro.addActionListener(miControlador);
        menuColores.add(itemClaro);

        menuVelocidad = new JMenu("   Velocidad       ");
        menu.add(menuVelocidad);

        vel25 = new JMenuItem("   x 1.25 ");
        vel25.addActionListener(miControlador);
        menuVelocidad.add(vel25);

        velNormal = new JMenuItem("   Normal      ");
        velNormal.addActionListener(miControlador);
        menuVelocidad.add(velNormal);

        vel5 = new JMenuItem("   x 0.5 ");
        vel5.addActionListener(miControlador);
        menuVelocidad.add(vel5);

        datos = new JMenuItem("   Datos");
        datos.addActionListener(miControlador);
        menu.add(datos);

    }

    public void incializarTexto() {

        //SANOS
        sanos = new JTextField();
        sanos.setBounds(1130, 630, 40, 30);
        sanos.setBackground(Color.white);
        sanos.setBorder(BorderFactory.createLineBorder(Color.black));
        sanos.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        sanos.setFont(new Font("Myriad Pro", 1, 15));
        panelPrincial.add(sanos);

        //INFECTADOS
        infectados = new JTextField();
        infectados.setBounds(1130, 670, 40, 30);
        infectados.setBackground(Color.white);
        infectados.setBorder(BorderFactory.createLineBorder(Color.black));
        infectados.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        infectados.setFont(new Font("Myriad Pro", 1, 15));
        panelPrincial.add(infectados);

    }

    public void setControlador(Controlador c) {
        miControlador = c;
        botonIniciar.addActionListener(miControlador);
        botonDetener.addActionListener(miControlador);
        botonReiniciar.addActionListener(miControlador);
        botonReanudar.addActionListener(miControlador);
        itemOscuro.addActionListener(miControlador);
        itemClaro.addActionListener(miControlador);
        vel25.addActionListener(miControlador);
        vel5.addActionListener(miControlador);
        velNormal.addActionListener(miControlador);
        datos.addActionListener(miControlador);
        inteligencia.addActionListener(miControlador);
    }

    public JTextField getSanos() {
        return sanos;
    }

    public JTextField getInfectados() {
        return infectados;
    }

    public JLabel getNumtasaContagio() {
        return numtasaContagio;
    }

    public void setNumtasaContagio(JLabel numtasaContagio) {
        this.numtasaContagio = numtasaContagio;
    }

    public JLabel getNumtasaMuerte() {
        return numtasaMuerte;
    }

    public void setNumtasaMuerte(JLabel numtasaMuerte) {
        this.numtasaMuerte = numtasaMuerte;
    }

    public JLabel getDias() {
        return dias;
    }

    public void setDias(JLabel dias) {
        this.dias = dias;
    }

    public Panel getPanelNav() {
        return panelNav;
    }

    public void setPanelNav(Panel panelNav) {
        this.panelNav = panelNav;
    }

    public Panel getPanelMatriz() {
        return panelMatriz;
    }

    public void setPanelMatriz(Panel panelMatriz) {
        this.panelMatriz = panelMatriz;
    }

    public Panel getPanelInformacion() {
        return panelInformacion;
    }

    public void setPanelInformacion(Panel panelInformacion) {
        this.panelInformacion = panelInformacion;
    }

    public JButton getBotonIniciar() {
        return botonIniciar;
    }

    public void setBotonIniciar(JButton botonIniciar) {
        this.botonIniciar = botonIniciar;
    }

    public JButton getBotonDetener() {
        return botonDetener;
    }

    public void setBotonDetener(JButton botonDetener) {
        this.botonDetener = botonDetener;
    }

    public JButton getBotonReiniciar() {
        return botonReiniciar;
    }

    public void setBotonReiniciar(JButton botonReiniciar) {
        this.botonReiniciar = botonReiniciar;
    }

    public Controlador getMiControlador() {
        return miControlador;
    }

    public void setMiControlador(Controlador miControlador) {
        this.miControlador = miControlador;
    }

    public JLabel getpCovid() {
        return pCovid;
    }

    public void setpCovid(JLabel pCovid) {
        this.pCovid = pCovid;
    }

    public JLabel getpSanas() {
        return pSanas;
    }

    public void setpSanas(JLabel pSanas) {
        this.pSanas = pSanas;
    }

    public JLabel getpFallecidos() {
        return pFallecidos;
    }

    public void setpFallecidos(JLabel pFallecidos) {
        this.pFallecidos = pFallecidos;
    }

    public JLabel getpAsintomaticas() {
        return pAsintomaticas;
    }

    public void setpAsintomaticas(JLabel pAsintomaticas) {
        this.pAsintomaticas = pAsintomaticas;
    }

    public JLabel getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(JLabel infoAdicional) {
        this.infoAdicional = infoAdicional;
    }

    public JLabel getPoblacionT() {
        return poblacionT;
    }

    public void setPoblacionT(JLabel poblacionT) {
        this.poblacionT = poblacionT;
    }

    public JLabel getPoblacionA() {
        return poblacionA;
    }

    public void setPoblacionA(JLabel poblacionA) {
        this.poblacionA = poblacionA;
    }

    public JMenuItem getItem1() {
        return itemOscuro;
    }

    public JCheckBox getInteligencia() {
        return inteligencia;
    }

    public JMenuItem getDatos() {
        return datos;
    }

    public JMenuItem getItem2() {
        return itemClaro;
    }

    public JMenuItem getvelocidadNormal() {
        return velNormal;
    }

    public JMenuItem getvelocidadRapida() {
        return vel25;
    }

    public JMenuItem getvelocidadLenta() {
        return vel5;
    }

}
