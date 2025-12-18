package it.unisa.diem.inginf.biblioteca.types;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test JUnit generati per {@link it.unisa.diem.inginf.biblioteca.types.Libro}.
 * @author nebbi
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LibroTest {
    
    private Libro libro;
    
    /**
     * Setup eseguito una volta prima della classe di test.
     */
    @BeforeEach
    public void setUpClass() {
        String[] autori = {"J.R.R. Tolkien", "Alan Lee", "Ottavio Fatica"};
        libro = new Libro("Il Signore Degli Anelli", "978-88-301-0471-6", Arrays.asList(autori), 7, 2020);

    }
    
    /**
     * Teardown eseguito una volta dopo la classe di test.
     */
    @AfterAll
    public static void tearDownClass() {
    }
    

    /**
     * Verifica il comportamento di {@link Libro#getTitolo()}.
     */
    @Test
    public void testGetTitolo() {
        String titoloAtteso = "Il Signore Degli Anelli";
        assertEquals(titoloAtteso, libro.getTitolo());
    }

    /**
     * Verifica il comportamento di {@link Libro#setTitolo(java.lang.String)}.
     */
    @Test
    public void testSetTitolo() {
        String titoloAtteso = "Nuovo Titolo";
        libro.setTitolo(titoloAtteso);
        assertEquals(titoloAtteso, libro.getTitolo());
    }

    /**
     * Verifica il comportamento di {@link Libro#getISBN()}.
     */
    @Test
    public void testGetISBN() {
        String ISBNAtteso = "978-88-301-0471-6";
        assertEquals(ISBNAtteso, libro.getISBN());
    }

    /**
     * Verifica il comportamento di {@link Libro#setISBN(java.lang.String)}.
     */
    @Test
    public void testSetISBN() {
        String ISBNAtteso = "123-45-678-9101-1";
        libro.setISBN(ISBNAtteso);
        assertEquals(ISBNAtteso, libro.getISBN());
    }

    /**
     * Verifica il comportamento di {@link Libro#getAutori()}.
     */
    @Test
    public void testGetAutori() {
        String[] autoriAttesi = {"J.R.R. Tolkien", "Alan Lee", "Ottavio Fatica"};
        assertIterableEquals(Arrays.asList(autoriAttesi), libro.getAutori());
    }

    /**
     * Verifica il comportamento di {@link Libro#setAutori(java.util.Collection)}.
     */
    @Test
    public void testSetAutori() {
        String[] autoriAttesi = {"autoreA", "autoreB", "autoreC"};
        libro.setAutori(Arrays.asList(autoriAttesi));
        assertIterableEquals(Arrays.asList(autoriAttesi),libro.getAutori());
    }

    /**
     * Verifica il comportamento di {@link Libro#getnCopie()}.
     */
    @Test
    public void testGetnCopie() {
        assertEquals(7, libro.getnCopie());
    }

    /**
     * Verifica il comportamento di {@link Libro#setnCopie(int)}.
     */
    @Test
    public void testSetnCopie() {
        int nCopieAtteso = 0;
        libro.setnCopie(nCopieAtteso);
        assertEquals(nCopieAtteso, libro.getnCopie());
    }

    /**
     * Verifica il comportamento di {@link Libro#getAnnoPubblicazione()}.
     */
    @Test
    public void testGetAnnoPublicazione() {
        int annoPubblicazioneAtteso = 2020;
        assertEquals(annoPubblicazioneAtteso, libro.getAnnoPubblicazione());
    }

    /**
     * Verifica il comportamento di {@link Libro#setAnnoPubblicazione(int)}.
     */
    @Test
    public void testSetAnnoPublicazione() {
        int annoPubblicazioneAtteso = 1234;
        libro.setAnnoPubblicazione(annoPubblicazioneAtteso);
        assertEquals(annoPubblicazioneAtteso, libro.getAnnoPubblicazione());
    }

    /**
     * Verifica il comportamento di {@link Libro#toString()}.
     */
    @Test
    public void testToString() {
        String outputAtteso = "Titolo: Il Signore Degli Anelli, ISBN: 978-88-301-0471-6, Numero copie: 7, Anno publicazione: 2020, Autori:\n- J.R.R. Tolkien\n- Alan Lee\n- Ottavio Fatica\n";
        assertEquals(outputAtteso, libro.toString());
    }
    
}
