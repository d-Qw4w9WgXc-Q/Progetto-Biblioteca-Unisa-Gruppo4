package it.unisa.diem.inginf.biblioteca;

import it.unisa.diem.inginf.biblioteca.types.*;
import it.unisa.diem.inginf.biblioteca.types.Comparators.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.TestInstance;

/**
 *
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
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of registraUtente method, of class Biblioteca.
     */
    @Test
    public void testRegistraUtente() {
        biblioteca.registraUtente(utenteAttesoA);
        assertTrue(biblioteca.utenti.contains(utenteAttesoA));
    }

    /**
     * Test of cercaUtente method, of class Biblioteca.
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
     * Test of getUtenti method, of class Biblioteca.
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
     * Test of eliminaUtente method, of class Biblioteca.
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
     * Test of eliminaUtente method, of class Biblioteca.
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
     * Test of registraLibro method, of class Biblioteca.
     */
    @Test
    public void testRegistraLibro() {
        biblioteca.registraLibro(libroAttesoA);
        assertTrue(biblioteca.libri.contains(libroAttesoA));
    }

    /**
     * Test of cercaLibro method, of class Biblioteca.
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
     * Test of getLibri method, of class Biblioteca.
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
     * Test of eliminaLibro method, of class Biblioteca.
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
     * Test of eliminaLibro method, of class Biblioteca.
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
     * Test of registraPrestito method, of class Biblioteca.
     */
    @Test
    public void testRegistraPrestito() {
        biblioteca.registraPrestito(prestitoAttesoA);
        assertTrue(biblioteca.prestiti.contains(prestitoAttesoA));
    }

    /**
     * Test of eliminaPrestito method, of class Biblioteca.
     */
    @Test
    public void testEliminaPrestito_Prestito() {
        System.out.println("eliminaPrestito");
        Prestito e = null;
        Biblioteca instance = new Biblioteca();
        boolean expResult = false;
        boolean result = instance.eliminaPrestito(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaPrestito method, of class Biblioteca.
     */
    @Test
    public void testEliminaPrestito_Prestito_Comparator() {
        System.out.println("eliminaPrestito");
        Prestito e = null;
        Comparator<Prestito> c = null;
        Biblioteca instance = new Biblioteca();
        boolean expResult = false;
        boolean result = instance.eliminaPrestito(e, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrestiti method, of class Biblioteca.
     */
    @Test
    public void testGetPrestiti() {
        System.out.println("getPrestiti");
        Biblioteca instance = new Biblioteca();
        ObservableList<Prestito> expResult = null;
        ObservableList<Prestito> result = instance.getPrestiti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordinaPrestiti method, of class Biblioteca.
     */
    @Test
    public void testOrdinaPrestiti() {
        System.out.println("ordinaPrestiti");
        Comparator<Prestito> c = null;
        Biblioteca instance = new Biblioteca();
        instance.ordinaPrestiti(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Biblioteca.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Biblioteca.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
