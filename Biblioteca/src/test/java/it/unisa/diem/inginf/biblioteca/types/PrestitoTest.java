package it.unisa.diem.inginf.biblioteca.types;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nebbi
 */
public class PrestitoTest {
    
    private Prestito prestito;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date dataPrestitoAttesa;
    Date dataRestituzioneAttesa;
    Date dataRestituzioneAttesa2;
            
    String[] autori = {"J.R.R. Tolkien", "Alan Lee", "Ottavio Fatica"};
    private final Libro libro = new Libro("Il Signore Degli Anelli", "978-88-301-0471-6", Arrays.asList(autori), 7, 2020);
    
    private final Utente utente = new Utente("Vincenzo", "Natale", "0612709907", "v.natale10@studenti.unisa.it");
    
    
    

    @BeforeEach
    public void setUpClass() throws Exception{
        
        
        dataPrestitoAttesa = sdf.parse("01/01/2025");
        dataRestituzioneAttesa = sdf.parse("01/12/2025");
        dataRestituzioneAttesa = sdf.parse("02/12/2025");
        
        prestito = new Prestito(dataPrestitoAttesa, dataRestituzioneAttesa, libro, utente);
    }

    /**
     * Test of getDataRestituzione method, of class Prestito.
     */
    @Test
    public void testGetDataRestituzione() {

        assertEquals(dataRestituzioneAttesa, prestito.getDataRestituzione());

    }

    /**
     * Test of setDataRestituzione method, of class Prestito.
     */
    @Test
    public void testSetDataRestituzione() {

        prestito.setDataRestituzione(dataRestituzioneAttesa2);
        assertEquals(dataRestituzioneAttesa2, prestito.getDataRestituzione());
    }

    /**
     * Test of getDataPrestito method, of class Prestito.
     */
    @Test
    public void testGetDataPrestito() {

        assertEquals(dataPrestitoAttesa, prestito.getDataPrestito());
    }

    /**
     * Test of getLibro method, of class Prestito.
     */
    @Test
    public void testGetLibro() {

        assertEquals(libro, prestito.getLibro());
    }

    /**
     * Test of getUtente method, of class Prestito.
     */
    @Test
    public void testGetUtente() {

        assertEquals(utente, prestito.getUtente());
    }
    
}
