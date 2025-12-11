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
 *
 * @author nebbi
 */
public class LibroTest {
    
    public LibroTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
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
     * Test of getTitolo method, of class Libro.
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
     * Test of setTitolo method, of class Libro.
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
     * Test of getISBN method, of class Libro.
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
     * Test of setISBN method, of class Libro.
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
     * Test of getAutori method, of class Libro.
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
     * Test of setAutori method, of class Libro.
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
     * Test of getnCopie method, of class Libro.
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
     * Test of setnCopie method, of class Libro.
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
     * Test of getAnnoPublicazione method, of class Libro.
     */
    @Test
    public void testGetAnnoPublicazione() {
        System.out.println("getAnnoPublicazione");
        Libro instance = null;
        int expResult = 0;
        int result = instance.getAnnoPublicazione();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAnnoPublicazione method, of class Libro.
     */
    @Test
    public void testSetAnnoPublicazione() {
        System.out.println("setAnnoPublicazione");
        int annoPublicazione = 0;
        Libro instance = null;
        instance.setAnnoPublicazione(annoPublicazione);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Libro.
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
     * Test of hashCode method, of class Libro.
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
     * Test of equals method, of class Libro.
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
