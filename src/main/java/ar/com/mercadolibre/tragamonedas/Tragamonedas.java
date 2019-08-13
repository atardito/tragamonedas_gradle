package ar.com.mercadolibre.tragamonedas;

import java.util.ArrayList;
import java.util.List;

public class Tragamonedas {
    private List<Tambor> tambores = new ArrayList<>();

    public Tragamonedas(List<Tambor> tambores) {
       this.tambores = tambores;
    }

    public boolean entregarPremio(){
        int posicion = 0;
        int contador = 1;
        for (Tambor tambor: tambores) {
            if(posicion == 0){
                posicion = tambor.obtenerPosicion();
            }else{
                if(posicion == tambor.obtenerPosicion()){
                    contador++;
                }
            }
        }
        return contador == tambores.size();
    }

    public void activar(){
        for (Tambor tambor: tambores) {
            tambor.girar();
        }
    }
}
