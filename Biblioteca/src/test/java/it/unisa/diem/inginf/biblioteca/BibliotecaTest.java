package it.unisa.diem.inginf.biblioteca;

import it.unisa.diem.inginf.biblioteca.types.Comparators.CompUtenteCognome;
import it.unisa.diem.inginf.biblioteca.types.Comparators.CompUtenteMatricola;
import it.unisa.diem.inginf.biblioteca.types.Comparators.CompUtenteNome;
import it.unisa.diem.inginf.biblioteca.types.Libro;
import it.unisa.diem.inginf.biblioteca.types.Prestito;
import it.unisa.diem.inginf.biblioteca.types.Utente;
import java.util.Comparator;
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
    
    public Biblioteca biblioteca;
    
    @BeforeAll
    public void setUpClass() {
        biblioteca = new Biblioteca();
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of registraUtente method, of class Biblioteca.
     */
    @Test
    public void testRegistraUtente() {
        Utente utenteAtteso = new Utente("Vincenzo", "Natale", "0612709907", "v.natale10@studenti.unisa.it");
        biblioteca.registraUtente(utenteAtteso);
        assertTrue(biblioteca.utenti.contains(utenteAtteso));
    }

    /**
     * Test of cercaUtente method, of class Biblioteca.
     */
    @Test

    public void testCercaUtentePerNome() {
        Utente utenteAtteso = new Utente("Vincenzo", "Natale", "0612709907", "v.natale10@studenti.unisa.it");
        biblioteca.registraUtente(utenteAtteso);
        CompUtenteNome c = new CompUtenteNome();
        assertEquals(utenteAtteso , biblioteca.cercaUtente(utenteAtteso, c));
    }
    
    @Test

    public void testCercaUtentePerCognome() {
        Utente utenteAtteso = new Utente("Vincenzo", "Natale", "0612709907", "v.natale10@studenti.unisa.it");
        biblioteca.registraUtente(utenteAtteso);
        CompUtenteCognome c = new CompUtenteCognome();
        assertEquals(utenteAtteso , biblioteca.cercaUtente(utenteAtteso, c));
    }
    
        @Test

    public void testCercaUtentePerMatricola() {
        Utente utenteAtteso = new Utente("Vincenzo", "Natale", "0612709907", "v.natale10@studenti.unisa.it");
        biblioteca.registraUtente(utenteAtteso);
        CompUtenteMatricola c = new CompUtenteMatricola();
        assertEquals(utenteAtteso , biblioteca.cercaUtente(utenteAtteso, c));
    }

    /**
     * Test of getUtenti method, of class Biblioteca.
     */
    @Test
    public void testGetUtenti() {
        System.out.println("getUtenti");
        Biblioteca instance = new Biblioteca();
        ObservableList<Utente> expResult = null;
        ObservableList<Utente> result = instance.getUtenti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordinaUtenti method, of class Biblioteca.
     */
    @Test
    public void testOrdinaUtenti() {
        System.out.println("ordinaUtenti");
        Comparator<Utente> c = null;
        Biblioteca instance = new Biblioteca();
        instance.ordinaUtenti(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaUtente method, of class Biblioteca.
     */
    @Test
    public void testEliminaUtente_Utente() {
        System.out.println("eliminaUtente");
        Utente e = null;
        Biblioteca instance = new Biblioteca();
        boolean expResult = false;
        boolean result = instance.eliminaUtente(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaUtente method, of class Biblioteca.
     */
    @Test
    public void testEliminaUtente_Utente_Comparator() {
        System.out.println("eliminaUtente");
        Utente e = null;
        Comparator<Utente> c = null;
        Biblioteca instance = new Biblioteca();
        boolean expResult = false;
        boolean result = instance.eliminaUtente(e, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registraLibro method, of class Biblioteca.
     */
    @Test
    public void testRegistraLibro() {
        System.out.println("registraLibro");
        Libro e = null;
        Biblioteca instance = new Biblioteca();
        boolean expResult = false;
        boolean result = instance.registraLibro(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cercaLibro method, of class Biblioteca.
     */
    @Test
    public void testCercaLibro() {
        System.out.println("cercaLibro");
        Libro e = null;
        Comparator<Libro> c = null;
        Biblioteca instance = new Biblioteca();
        Libro expResult = null;
        Libro result = instance.cercaLibro(e, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLibri method, of class Biblioteca.
     */
    @Test
    public void testGetLibri() {
        System.out.println("getLibri");
        Biblioteca instance = new Biblioteca();
        ObservableList<Libro> expResult = null;
        ObservableList<Libro> result = instance.getLibri();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordinaLibri method, of class Biblioteca.
     */
    @Test
    public void testOrdinaLibri() {
        System.out.println("ordinaLibri");
        Comparator<Libro> c = null;
        Biblioteca instance = new Biblioteca();
        instance.ordinaLibri(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaLibro method, of class Biblioteca.
     */
    @Test
    public void testEliminaLibro_Libro() {
        System.out.println("eliminaLibro");
        Libro e = null;
        Biblioteca instance = new Biblioteca();
        boolean expResult = false;
        boolean result = instance.eliminaLibro(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaLibro method, of class Biblioteca.
     */
    @Test
    public void testEliminaLibro_Libro_Comparator() {
        System.out.println("eliminaLibro");
        Libro e = null;
        Comparator<Libro> c = null;
        Biblioteca instance = new Biblioteca();
        boolean expResult = false;
        boolean result = instance.eliminaLibro(e, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registraPrestito method, of class Biblioteca.
     */
    @Test
    public void testRegistraPrestito() {
        System.out.println("registraPrestito");
        Prestito e = null;
        Biblioteca instance = new Biblioteca();
        boolean expResult = false;
        boolean result = instance.registraPrestito(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
