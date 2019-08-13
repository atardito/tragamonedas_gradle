package ar.com.mercadolibre.tragamonedas;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TamborTest {
    @Test
    public void girarTambor(){
        Tambor tambor = new Tambor();
        tambor.girar();
        Assertions.assertThat(tambor.obtenerPosicion()).isBetween(1,8);
    }
}
