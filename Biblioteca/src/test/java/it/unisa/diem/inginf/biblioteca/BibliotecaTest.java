/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.diem.inginf.biblioteca;

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

/**
 * Test JUnit generati per {@link it.unisa.diem.inginf.biblioteca.Biblioteca}.
 * @author nebbi
 */
public class BibliotecaTest {
    
    /**
     * Costruttore di default del test.
     */
    public BibliotecaTest() {
    }
    
    /**
     * Setup eseguito una volta prima della classe di test.
     */
    @BeforeAll
    public static void setUpClass() {
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
        System.out.println("registraUtente");
        Utente e = null;
        Biblioteca instance = new Biblioteca();
        boolean expResult = false;
        boolean result = instance.registraUtente(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Verifica il comportamento di {@link Biblioteca#cercaUtente(it.unisa.diem.inginf.biblioteca.types.Utente, java.util.Comparator)}.
     */
    @Test
    public void testCercaUtente() {
        System.out.println("cercaUtente");
        Utente e = null;
        Comparator<Utente> c = null;
        Biblioteca instance = new Biblioteca();
        Utente expResult = null;
        Utente result = instance.cercaUtente(e, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Verifica il comportamento di {@link Biblioteca#getUtenti()}.
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
     * Verifica il comportamento di {@link Biblioteca#ordinaUtenti(java.util.Comparator)}.
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
     * Verifica il comportamento di {@link Biblioteca#eliminaUtente(it.unisa.diem.inginf.biblioteca.types.Utente)}.
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
     * Verifica il comportamento di {@link Biblioteca#eliminaUtente(it.unisa.diem.inginf.biblioteca.types.Utente, java.util.Comparator)}.
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
     * Verifica il comportamento di {@link Biblioteca#registraLibro(it.unisa.diem.inginf.biblioteca.types.Libro)}.
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
     * Verifica il comportamento di {@link Biblioteca#cercaLibro(it.unisa.diem.inginf.biblioteca.types.Libro, java.util.Comparator)}.
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
     * Verifica il comportamento di {@link Biblioteca#getLibri()}.
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
     * Verifica il comportamento di {@link Biblioteca#ordinaLibri(java.util.Comparator)}.
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
     * Verifica il comportamento di {@link Biblioteca#eliminaLibro(it.unisa.diem.inginf.biblioteca.types.Libro)}.
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
     * Verifica il comportamento di {@link Biblioteca#eliminaLibro(it.unisa.diem.inginf.biblioteca.types.Libro, java.util.Comparator)}.
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
     * Verifica il comportamento di {@link Biblioteca#registraPrestito(it.unisa.diem.inginf.biblioteca.types.Prestito)}.
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
     * Verifica il comportamento di {@link Biblioteca#eliminaPrestito(it.unisa.diem.inginf.biblioteca.types.Prestito)}.
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
     * Verifica il comportamento di {@link Biblioteca#eliminaPrestito(it.unisa.diem.inginf.biblioteca.types.Prestito, java.util.Comparator)}.
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
     * Verifica il comportamento di {@link Biblioteca#getPrestiti()}.
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
     * Verifica il comportamento di {@link Biblioteca#ordinaPrestiti(java.util.Comparator)}.
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
     * Verifica il comportamento del {@link Biblioteca#main(java.lang.String[])}.
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
