package it.unisa.diem.inginf.biblioteca.types;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nebbi
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UtenteTest {
    
    private Utente utente;
    
    @BeforeEach
    public void setUpClass() {
        utente = new Utente("Vincenzo", "Natale", "0612709907", "v.natale10@studenti.unisa.it");
    }
    
    

    /**
     * Test of getNome method, of class Utente.
     */
    @Test
    public void testGetNome() {
        String nomeAtteso = "Vincenzo";
        assertEquals(nomeAtteso, utente.getNome());

    }

    /**
     * Test of getCognome method, of class Utente.
     */
    @Test
    public void testGetCognome() {
        String cognomeAtteso = "Natale";
        assertEquals(cognomeAtteso, utente.getCognome());
    }

    /**
     * Test of getMatricola method, of class Utente.
     */
    @Test
    public void testGetMatricola() {
        String matricolaAttesa = "0612709907";
        assertEquals(matricolaAttesa, utente.getMatricola());
    }

    /**
     * Test of getEmail method, of class Utente.
     */
    @Test
    public void testGetEmail() {
        String emailAttesa = "v.natale10@studenti.unisa.it";
        assertEquals(emailAttesa, utente.getEmail());
    }

    /**
     * Test of setNome method, of class Utente.
     */
    @Test
    public void testSetNome() {
        String nomeAtteso = "Matteo";
        utente.setNome(nomeAtteso);
        assertEquals(nomeAtteso, utente.getNome());
    }

    /**
     * Test of setCognome method, of class Utente.
     */
    @Test
    public void testSetCognome() {
        String cognomeAtteso = "Nebbia";
        utente.setCognome(cognomeAtteso);
        assertEquals(cognomeAtteso, utente.getCognome());
    }

    /**
     * Test of setMatricola method, of class Utente.
     */
    @Test
    public void testSetMatricola() {
        String matricolaAttesa = "0612709400";
        utente.setMatricola(matricolaAttesa);
        assertEquals(matricolaAttesa, utente.getMatricola());
    }

    /**
     * Test of setEmail method, of class Utente.
     */
    @Test
    public void testSetEmail() {
        String emailAttesa = "m.nebbia@studenti.unisa.it";
        utente.setEmail(emailAttesa);
        assertEquals(emailAttesa, utente.getEmail());
    }

    @Test
    public void testToString() {
        String outputAtteso = "Nome: Vincenzo, Cognome: Natale, Matricola: 0612709907, Email: v.natale10@studenti.unisa.it";
        assertEquals(outputAtteso, utente.toString());
    }
    
}
