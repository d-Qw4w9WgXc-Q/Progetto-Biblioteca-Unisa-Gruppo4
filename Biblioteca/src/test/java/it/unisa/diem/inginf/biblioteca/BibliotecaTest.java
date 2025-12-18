package it.unisa.diem.inginf.biblioteca;

import it.unisa.diem.inginf.biblioteca.types.*;
import it.unisa.diem.inginf.biblioteca.types.Comparators.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.TestInstance;

/**
 * Test JUnit generati per {@link it.unisa.diem.inginf.biblioteca.Biblioteca}.
 * @author nebbi
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Utente utenteAttesoA;
    private Utente utenteAttesoB;
    
    String[] autoriA = {"J.R.R. Tolkien", "Alan Lee", "Ottavio Fatica"};
    private Libro libroAttesoA;
    String[] autoriB = {"Mark Twain"};
    private Libro libroAttesoB;
    
    SimpleDateFormat sdf;
    Date dataPrestitoAttesaA;
    Date dataRestituzioneAttesaA;
    Date dataPrestitoAttesaB;
    Date dataRestituzioneAttesaB;
    private Prestito prestitoAttesoA;
    private Prestito prestitoAttesoB;
    /**
     * Costruttore di default del test.
     */
    public BibliotecaTest() {
    }
    
    /**
     * Setup eseguito una volta prima della classe di test.
     */
    @BeforeAll
    public void setUpClass() throws ParseException {
        utenteAttesoA = new Utente("Vincenzo", "Natale", "0612709907", "v.natale10@studenti.unisa.it");
        utenteAttesoB = new Utente("Matteo", "Nebbia", "0612709400", "m.nebbia@studenti.unisa.it");
        
        libroAttesoA = new Libro("Il Signore Degli Anelli", "978-88-301-0471-6", Arrays.asList(autoriA), 7, 2020);
        libroAttesoB = new Libro("Le Avventure Di Tom Sawyer", "978-88-046-1838", Arrays.asList(autoriB), 2, 2012);
        
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        dataPrestitoAttesaA = sdf.parse("01/01/2025");
        dataRestituzioneAttesaA = sdf.parse("01/02/2025");
        dataPrestitoAttesaB = sdf.parse("01/10/2025");
        dataRestituzioneAttesaB = sdf.parse("01/11/2025");
        
        prestitoAttesoA = new Prestito(dataPrestitoAttesaA, dataRestituzioneAttesaA, libroAttesoA, utenteAttesoA);
        prestitoAttesoB = new Prestito(dataPrestitoAttesaB, dataRestituzioneAttesaB, libroAttesoB, utenteAttesoB);
    }
    
    /**
     * Teardown eseguito una volta dopo la classe di test.
     */
    @AfterAll
    public static void tearDownClass() {
    }
    
    /**
     * Setup eseguito prima di ogni test.
     */
    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca();
    }
    
    /**
     * Teardown eseguito dopo ogni test.
     */
    @AfterEach
    public void tearDown() {
    }

    /**
     * Verifica il comportamento di {@link Biblioteca#registraUtente(it.unisa.diem.inginf.biblioteca.types.Utente)}.
     */
    @Test
    public void testRegistraUtente() {
        biblioteca.registraUtente(utenteAttesoA);
        assertTrue(biblioteca.utenti.contains(utenteAttesoA));
    }

    /**
     * Verifica il comportamento di {@link Biblioteca#cercaUtente(it.unisa.diem.inginf.biblioteca.types.Utente, java.util.Comparator)}.
     */
    @Test

    public void testCercaUtentePerNome() {
        biblioteca.registraUtente(utenteAttesoA);
        CompUtenteNome c = new CompUtenteNome();
        assertEquals(utenteAttesoA , biblioteca.cercaUtente(utenteAttesoA, c));
    }
    
    @Test

    public void testCercaUtentePerCognome() {
        biblioteca.registraUtente(utenteAttesoA);
        CompUtenteCognome c = new CompUtenteCognome();
        assertEquals(utenteAttesoA , biblioteca.cercaUtente(utenteAttesoA, c));
    }
    
    @Test

    public void testCercaUtentePerMatricola() {
        biblioteca.registraUtente(utenteAttesoA);
        CompUtenteMatricola c = new CompUtenteMatricola();
        assertEquals(utenteAttesoA , biblioteca.cercaUtente(utenteAttesoA, c));
    }

    @Test

    public void testCercaUtentePerNomeFallito() {
        CompUtenteNome c = new CompUtenteNome();
        assertNull(biblioteca.cercaUtente(utenteAttesoA, c));
    }
    
    @Test

    public void testCercaUtentePerCognomeFallito() {
        CompUtenteCognome c = new CompUtenteCognome();
        assertNull(biblioteca.cercaUtente(utenteAttesoA, c));
    }
    
    @Test

    public void testCercaUtentePerMatricolaFallito() {
        CompUtenteMatricola c = new CompUtenteMatricola();
        assertNull(biblioteca.cercaUtente(utenteAttesoA, c));
    }
    
    
    /**
     * Verifica il comportamento di {@link Biblioteca#getUtenti()}.
     */
    @Test
    public void testGetUtenti() {
        biblioteca.registraUtente(utenteAttesoA);
        biblioteca.registraUtente(utenteAttesoB);
        ArrayList<Utente> listaUtentiAttesa = new ArrayList<>();
        listaUtentiAttesa.add(utenteAttesoA);
        listaUtentiAttesa.add(utenteAttesoB);
        assertIterableEquals(listaUtentiAttesa, biblioteca.getUtenti());
    }

    /**
     * Verifica il comportamento di {@link Biblioteca#eliminaUtente(it.unisa.diem.inginf.biblioteca.types.Utente)}.
     */
    @Test
    public void testEliminaUtente_Utente() {
        biblioteca.registraUtente(utenteAttesoA);
        biblioteca.registraUtente(utenteAttesoB);
        biblioteca.eliminaUtente(utenteAttesoA);
        CompUtenteNome c = new CompUtenteNome();
        assertNull(biblioteca.cercaUtente(utenteAttesoA, c));
    }

    /**
     * Verifica il comportamento di {@link Biblioteca#eliminaUtente(it.unisa.diem.inginf.biblioteca.types.Utente, java.util.Comparator)}.
     */
    @Test
    public void testEliminaUtentePerNome() {
        CompUtenteNome c = new CompUtenteNome();
        biblioteca.registraUtente(utenteAttesoA);
        biblioteca.registraUtente(utenteAttesoB);
        biblioteca.eliminaUtente(utenteAttesoA, c);
        assertNull(biblioteca.cercaUtente(utenteAttesoA, c));
    }
    
    /**
     * Test of eliminaUtente method, of class Biblioteca.
     */
    @Test
    public void testEliminaUtentePerCognome() {
        CompUtenteCognome c = new CompUtenteCognome();
        biblioteca.registraUtente(utenteAttesoA);
        biblioteca.registraUtente(utenteAttesoB);
        biblioteca.eliminaUtente(utenteAttesoA, c);
        assertNull(biblioteca.cercaUtente(utenteAttesoA, c));
    }
    
    /**
     * Test of eliminaUtente method, of class Biblioteca.
     */
    @Test
    public void testEliminaUtentePerMatricola() {
        CompUtenteMatricola c = new CompUtenteMatricola();
        biblioteca.registraUtente(utenteAttesoA);
        biblioteca.registraUtente(utenteAttesoB);
        biblioteca.eliminaUtente(utenteAttesoA, c);
        assertNull(biblioteca.cercaUtente(utenteAttesoA, c));
    }

    /**
     * Verifica il comportamento di {@link Biblioteca#registraLibro(it.unisa.diem.inginf.biblioteca.types.Libro)}.
     */
    @Test
    public void testRegistraLibro() {
        biblioteca.registraLibro(libroAttesoA);
        assertTrue(biblioteca.libri.contains(libroAttesoA));
    }

    /**
     * Verifica il comportamento di {@link Biblioteca#cercaLibro(it.unisa.diem.inginf.biblioteca.types.Libro, java.util.Comparator)}.
     */
    @Test
    public void testCercaLibroPerTitolo() {
        biblioteca.registraLibro(libroAttesoA);
        CompLibroTitolo c = new CompLibroTitolo();
        assertEquals(libroAttesoA, biblioteca.cercaLibro(libroAttesoA, c));
    }
    
    @Test
    public void testCercaLibroPerISBN() {
        biblioteca.registraLibro(libroAttesoA);
        CompLibroISBN c = new CompLibroISBN();
        assertEquals(libroAttesoA, biblioteca.cercaLibro(libroAttesoA, c));
    }
    
    @Test
    public void testCercaLibroPerAutori() {
        biblioteca.registraLibro(libroAttesoA);
        CompLibroAutori c = new CompLibroAutori();
        assertEquals(libroAttesoA, biblioteca.cercaLibro(libroAttesoA, c));
    }
    
    @Test
    public void testCercaLibroPerTitoloFallito() {
        CompLibroTitolo c = new CompLibroTitolo();
        assertNull(biblioteca.cercaLibro(libroAttesoA, c));
    }
    
    @Test
    public void testCercaLibroPerISBNFallito() {
        CompLibroISBN c = new CompLibroISBN();
        assertNull(biblioteca.cercaLibro(libroAttesoA, c));
    }
    
    @Test
    public void testCercaLibroPerAutoriFallito() {
        CompLibroAutori c = new CompLibroAutori();
        assertNull(biblioteca.cercaLibro(libroAttesoA, c));
    }

    /**
     * Verifica il comportamento di {@link Biblioteca#getLibri()}.
     */
    @Test
    public void testGetLibri() {
        biblioteca.registraLibro(libroAttesoA);
        biblioteca.registraLibro(libroAttesoB);
        ArrayList<Libro> listaLibriAttesa = new ArrayList<>();
        listaLibriAttesa.add(libroAttesoA);
        listaLibriAttesa.add(libroAttesoB);
        assertIterableEquals(listaLibriAttesa, biblioteca.getLibri());
    }

    /**
     * Verifica il comportamento di {@link Biblioteca#eliminaLibro(it.unisa.diem.inginf.biblioteca.types.Libro)}.
     */
    @Test
    public void testEliminaLibro_Libro() {
        biblioteca.registraLibro(libroAttesoA);
        biblioteca.registraLibro(libroAttesoB);
        biblioteca.eliminaLibro(libroAttesoA);
        CompLibroTitolo c = new CompLibroTitolo();
        assertNull(biblioteca.cercaLibro(libroAttesoA, c));
    }

    /**
     * Verifica il comportamento di {@link Biblioteca#eliminaLibro(it.unisa.diem.inginf.biblioteca.types.Libro, java.util.Comparator)}.
     */
    @Test
    public void testEliminaLibroPerTitolo() {
        CompLibroTitolo c = new CompLibroTitolo();
        biblioteca.registraLibro(libroAttesoA);
        biblioteca.registraLibro(libroAttesoB);
        biblioteca.eliminaLibro(libroAttesoA, c);
        assertNull(biblioteca.cercaLibro(libroAttesoA, c));
    }
    
    @Test
    public void testEliminaLibroPerISBN() {
        CompLibroISBN c = new CompLibroISBN();
        biblioteca.registraLibro(libroAttesoA);
        biblioteca.registraLibro(libroAttesoB);
        biblioteca.eliminaLibro(libroAttesoA, c);
        assertNull(biblioteca.cercaLibro(libroAttesoA, c));
    }
    
    @Test
    public void testEliminaLibroPerAutori() {
        CompLibroAutori c = new CompLibroAutori();
        biblioteca.registraLibro(libroAttesoA);
        biblioteca.registraLibro(libroAttesoB);
        biblioteca.eliminaLibro(libroAttesoA, c);
        assertNull(biblioteca.cercaLibro(libroAttesoA, c));
    }

    /**
     * Verifica il comportamento di {@link Biblioteca#registraPrestito(it.unisa.diem.inginf.biblioteca.types.Prestito)}.
     */
    @Test
    public void testRegistraPrestito() {
        biblioteca.registraPrestito(prestitoAttesoA);
        assertTrue(biblioteca.prestiti.contains(prestitoAttesoA));
    }

    /**
     * Verifica il comportamento di {@link Biblioteca#eliminaPrestito(it.unisa.diem.inginf.biblioteca.types.Prestito)}.
     */
    @Test
    public void testEliminaPrestito_Prestito() {
        biblioteca.registraPrestito(prestitoAttesoA);
        biblioteca.registraPrestito(prestitoAttesoB);
        biblioteca.eliminaPrestito(prestitoAttesoA);
        assertFalse(biblioteca.prestiti.contains(prestitoAttesoA));
    }

    /**
     * Verifica il comportamento di {@link Biblioteca#eliminaPrestito(it.unisa.diem.inginf.biblioteca.types.Prestito, java.util.Comparator)}.
     */
    @Test
    public void testEliminaPrestito_Prestito_Comparator() {
        biblioteca.registraPrestito(prestitoAttesoA);
        biblioteca.registraPrestito(prestitoAttesoB);
        CompPrestitoDataPrestito c = new CompPrestitoDataPrestito();
        biblioteca.eliminaPrestito(prestitoAttesoA, c);
        assertFalse(biblioteca.prestiti.contains(prestitoAttesoA));
    }

    /**
     * Verifica il comportamento di {@link Biblioteca#getPrestiti()}.
     */
    @Test
    public void testGetPrestiti() {
        assertIterableEquals(biblioteca.prestiti, biblioteca.getPrestiti());
    }

}
