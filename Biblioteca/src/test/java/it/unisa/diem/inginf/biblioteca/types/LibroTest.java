package it.unisa.diem.inginf.biblioteca.types;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nebbi
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LibroTest {
    
    private Libro libro;
    
    @BeforeEach
    public void setUpClass() {
        String[] autori = {"J.R.R. Tolkien", "Alan Lee", "Ottavio Fatica"};
        libro = new Libro("Il Signore Degli Anelli", "978-88-301-0471-6", Arrays.asList(autori), 7, 2020);
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    

    /**
     * Test of getTitolo method, of class Libro.
     */
    @Test
    public void testGetTitolo() {
        String titoloAtteso = "Il Signore Degli Anelli";
        assertEquals(titoloAtteso, libro.getTitolo());
    }

    /**
     * Test of setTitolo method, of class Libro.
     */
    @Test
    public void testSetTitolo() {
        String titoloAtteso = "Nuovo Titolo";
        libro.setTitolo(titoloAtteso);
        assertEquals(titoloAtteso, libro.getTitolo());
    }

    /**
     * Test of getISBN method, of class Libro.
     */
    @Test
    public void testGetISBN() {
        String ISBNAtteso = "978-88-301-0471-6";
        assertEquals(ISBNAtteso, libro.getISBN());
    }

    /**
     * Test of setISBN method, of class Libro.
     */
    @Test
    public void testSetISBN() {
        String ISBNAtteso = "123-45-678-9101-1";
        libro.setISBN(ISBNAtteso);
        assertEquals(ISBNAtteso, libro.getISBN());
    }

    /**
     * Test of getAutori method, of class Libro.
     */
    @Test
    public void testGetAutori() {
        String[] autoriAttesi = {"J.R.R. Tolkien", "Alan Lee", "Ottavio Fatica"};
        assertIterableEquals(Arrays.asList(autoriAttesi), libro.getAutori());
    }

    /**
     * Test of setAutori method, of class Libro.
     */
    @Test
    public void testSetAutori() {
        String[] autoriAttesi = {"autoreA", "autoreB", "autoreC"};
        libro.setAutori(Arrays.asList(autoriAttesi));
        assertIterableEquals(Arrays.asList(autoriAttesi),libro.getAutori());
    }

    /**
     * Test of getnCopie method, of class Libro.
     */
    @Test
    public void testGetnCopie() {
        assertEquals(7, libro.getnCopie());
    }

    /**
     * Test of setnCopie method, of class Libro.
     */
    @Test
    public void testSetnCopie() {
        int nCopieAtteso = 0;
        libro.setnCopie(nCopieAtteso);
        assertEquals(nCopieAtteso, libro.getnCopie());
    }

    /**
     * Test of getAnnoPublicazione method, of class Libro.
     */
    @Test
    public void testGetAnnoPublicazione() {
        int annoPubblicazioneAtteso = 2020;
        assertEquals(annoPubblicazioneAtteso, libro.getAnnoPublicazione());
    }

    /**
     * Test of setAnnoPublicazione method, of class Libro.
     */
    @Test
    public void testSetAnnoPublicazione() {
        int annoPubblicazioneAtteso = 1234;
        libro.setAnnoPublicazione(annoPubblicazioneAtteso);
        assertEquals(annoPubblicazioneAtteso, libro.getAnnoPublicazione());
    }

    /**
     * Test of toString method, of class Libro.
     */
    @Test
    public void testToString() {
        String outputAtteso = "Titolo: Il Signore Degli Anelli, ISBN: 978-88-301-0471-6, Numero copie: 7, Anno publicazione: 2020, Autori:\n- J.R.R. Tolkien\n- Alan Lee\n- Ottavio Fatica\n";
        assertEquals(outputAtteso, libro.toString());
    }
    
}
