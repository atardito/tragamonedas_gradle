package ar.com.mercadolibre.tragamonedas;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TragamonedasTest {

    private Tambor tambor1 = new TamborMock();
    private Tambor tambor2 = new TamborMock();
    private Tambor tambor3 = new TamborMock();


    /*private Tambor tambor1m = mock(Tambor.class);
    private Tambor tambor2m = mock(Tambor.class);
    private Tambor tambor3m = mock(Tambor.class);*/

    @Mock
    private Tambor tambor1m;
    @Mock
    private Tambor tambor2m;
    @Mock
    private Tambor tambor3m;

    @Test
    public void entregarPremio(){
        List<Tambor> tambores = new ArrayList<Tambor>();
        tambores.add(tambor1);
        tambores.add(tambor2);
        tambores.add(tambor3);
        Tragamonedas tragamonedas = new Tragamonedas(tambores);
        tragamonedas.activar();
        Assertions.assertThat(tragamonedas.entregarPremio()).isTrue();
    }

    @Test
    public void entregarPremioMockito(){
        List<Tambor> tambores = new ArrayList<Tambor>();

        when(tambor1m.obtenerPosicion()).thenReturn(3);
        when(tambor2m.obtenerPosicion()).thenReturn(3);
        when(tambor3m.obtenerPosicion()).thenReturn(3);

        tambores.add(tambor1m);
        tambores.add(tambor2m);
        tambores.add(tambor3m);
        Tragamonedas tragamonedas = new Tragamonedas(tambores);
        tragamonedas.activar();
        Assertions.assertThat(tragamonedas.entregarPremio()).isTrue();
    }

    @Test
    public void verificarQueGirenLosTambores(){
        List<Tambor> tambores = new ArrayList<Tambor>();

        when(tambor1m.obtenerPosicion()).thenReturn(3);
        when(tambor2m.obtenerPosicion()).thenReturn(3);
        when(tambor3m.obtenerPosicion()).thenReturn(3);

        tambores.add(tambor1m);
        tambores.add(tambor2m);
        tambores.add(tambor3m);
        Tragamonedas tragamonedas = new Tragamonedas(tambores);
        tragamonedas.activar();

        //Verifica que el metodo girar() se haya ejecutado una vez
        verify(tambor1m, times(1)).girar();
        verify(tambor2m, times(1)).girar();
        verify(tambor3m, times(1)).girar();
    }
}
