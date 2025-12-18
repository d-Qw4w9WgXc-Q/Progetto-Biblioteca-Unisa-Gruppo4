package it.unisa.diem.inginf.biblioteca.types;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Rappresenta un prestito di un libro ad un utente, con data di prestito e data di scadenza/restituzione.
 */
public class Prestito implements Serializable {


    private Date dataPrestito;
    private Date dataRestituzione;
    private Libro libro;
    private Utente utente;

    /**
     * Crea un prestito.
     * @param dataPrestito data di prestito
     * @param dataRestituzione data di scadenza/restituzione
     * @param libro libro prestato
     * @param utente utente a cui viene prestato
     */
    public Prestito(Date dataPrestito, Date dataRestituzione, Libro libro, Utente utente) {
        this.dataPrestito = dataPrestito;
        this.dataRestituzione = dataRestituzione;
        this.libro = libro;
        this.utente = utente;
    }
    
    /**
     * Restituisce la data di scadenza/restituzione.
     * @return data restituzione
     */
    public Date getDataRestituzione() {
        return dataRestituzione;
    }

    /**
     * Imposta la data di scadenza/restituzione.
     * @param dataRestituzione nuova data
     */
    public void setDataRestituzione(Date dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }

    /**
     * Restituisce la data di prestito.
     * @return data prestito
     */
    public Date getDataPrestito() {
        return dataPrestito;
    }

    /**
     * Restituisce il libro del prestito.
     * @return libro
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Restituisce l'utente del prestito.
     * @return utente
     */
    public Utente getUtente() {
        return utente;
    }
    /**
     * Restituisce una rappresentazione testuale compatta del prestito.
     * @return stringa descrittiva
     */
    @Override
    public String toString() {
        Date oggi = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String ret = new String();
        if(oggi.after(getDataRestituzione())) {
            ret += "[RESTITUZIONE IN RITARDO]\n";
        }
        ret += String.format("%s preso da %s %s il %s, da restituire entro il %s\n", getLibro().getTitolo(), getUtente().getNome(), getUtente().getCognome(), sdf.format(getDataPrestito()), sdf.format(getDataRestituzione()));
        return ret;

    }
}
