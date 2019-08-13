package ar.com.mercadolibre.tragamonedas;

import java.util.Random;

public class Tambor {

    private int posicion;

    public Tambor(){
        posicion = obtenerPosicion();
    }

    public void girar(){
        Random r = new Random();
        posicion = r.nextInt(8) + 1;
        System.out.println(posicion);
    }

    protected int obtenerPosicion(){
        return posicion;
    }

}
