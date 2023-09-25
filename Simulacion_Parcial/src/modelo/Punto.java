package modelo;

public class Punto {

    public int x;
    public int y;
    public int color;
    public int edad;
    public int tasaContagio;
    public int diasExistiendo;
    public int tapaBocas;
    public int inteligencia;

    public Punto(int x, int y, int color, int edad, int tasaContagio, int diasExistiendo, int tapaBocas, int inteligencia) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.edad = edad;
        this.tasaContagio = tasaContagio;
        this.diasExistiendo = diasExistiendo;
        this.tapaBocas = tapaBocas;
        this.inteligencia = inteligencia;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getTasaContagio() {
        return tasaContagio;
    }

    public void setTasaContagio(int tasaContagio) {
        this.tasaContagio = tasaContagio;
    }

    public int getDiasExistiendo() {
        return diasExistiendo;
    }

    public void setDiasExistiendo(int diasExistiendo) {
        this.diasExistiendo = diasExistiendo;
    }

    public int getTapaBocas() {
        return tapaBocas;
    }

    public void setTapaBocas(int tapaBocas) {
        this.tapaBocas = tapaBocas;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

}
