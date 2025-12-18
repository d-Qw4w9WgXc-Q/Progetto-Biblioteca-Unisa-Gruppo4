/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.diem.inginf.biblioteca.types;

import java.util.Collection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test JUnit generati per {@link it.unisa.diem.inginf.biblioteca.types.Libro}.
 * @author nebbi
 */
public class LibroTest {
    
    /**
     * Costruttore di default del test.
     */
    public LibroTest() {
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
     * Verifica il comportamento di {@link Libro#getTitolo()}.
     */
    @Test
    public void testGetTitolo() {
        System.out.println("getTitolo");
        Libro instance = null;
        String expResult = "";
        String result = instance.getTitolo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Verifica il comportamento di {@link Libro#setTitolo(java.lang.String)}.
     */
    @Test
    public void testSetTitolo() {
        System.out.println("setTitolo");
        String titolo = "";
        Libro instance = null;
        instance.setTitolo(titolo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Verifica il comportamento di {@link Libro#getISBN()}.
     */
    @Test
    public void testGetISBN() {
        System.out.println("getISBN");
        Libro instance = null;
        String expResult = "";
        String result = instance.getISBN();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Verifica il comportamento di {@link Libro#setISBN(java.lang.String)}.
     */
    @Test
    public void testSetISBN() {
        System.out.println("setISBN");
        String ISBN = "";
        Libro instance = null;
        instance.setISBN(ISBN);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Verifica il comportamento di {@link Libro#getAutori()}.
     */
    @Test
    public void testGetAutori() {
        System.out.println("getAutori");
        Libro instance = null;
        Collection<String> expResult = null;
        Collection<String> result = instance.getAutori();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Verifica il comportamento di {@link Libro#setAutori(java.util.Collection)}.
     */
    @Test
    public void testSetAutori() {
        System.out.println("setAutori");
        Collection<String> autori = null;
        Libro instance = null;
        instance.setAutori(autori);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Verifica il comportamento di {@link Libro#getnCopie()}.
     */
    @Test
    public void testGetnCopie() {
        System.out.println("getnCopie");
        Libro instance = null;
        int expResult = 0;
        int result = instance.getnCopie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Verifica il comportamento di {@link Libro#setnCopie(int)}.
     */
    @Test
    public void testSetnCopie() {
        System.out.println("setnCopie");
        int nCopie = 0;
        Libro instance = null;
        instance.setnCopie(nCopie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Verifica il comportamento di {@link Libro#getAnnoPubblicazione()}.
     */
    @Test
    public void testGetAnnoPublicazione() {
        System.out.println("getAnnoPublicazione");
        Libro instance = null;
        int expResult = 0;
        int result = instance.getAnnoPubblicazione();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Verifica il comportamento di {@link Libro#setAnnoPubblicazione(int)}.
     */
    @Test
    public void testSetAnnoPublicazione() {
        System.out.println("setAnnoPublicazione");
        int annoPublicazione = 0;
        Libro instance = null;
        instance.setAnnoPubblicazione(annoPublicazione);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Verifica il comportamento di {@link Libro#toString()}.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Libro instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Verifica il comportamento di {@link Libro#hashCode()}.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Libro instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Verifica il comportamento di {@link Libro#equals(java.lang.Object)}.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Libro instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
