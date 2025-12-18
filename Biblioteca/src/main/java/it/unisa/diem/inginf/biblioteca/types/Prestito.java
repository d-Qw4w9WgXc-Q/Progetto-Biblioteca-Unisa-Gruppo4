package it.unisa.diem.inginf.biblioteca.types;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Rappresenta un prestito di un libro ad un utente, con data di prestito e data di scadenza/restituzione.
 */
public class Prestito {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE;

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
     * Formatta una data in formato ISO (yyyy-MM-dd).
     * @param date data da formattare
     * @return data formattata o {@code "N/D"} se nulla
     */
    private static String formatDate(Date date) {
        if (date == null) {
            return "N/D";
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DATE_FORMAT);
    }

    /**
     * Restituisce una rappresentazione testuale compatta del prestito.
     * @return stringa descrittiva
     */
    @Override
    public String toString() {
        String utenteStr = utente == null ? "N/D" : (utente.getNome() + " " + utente.getCognome());
        String libroStr = libro == null ? "N/D" : libro.getTitolo();
        return "Utente: " + utenteStr
                + ", Libro: " + libroStr
                + ", Data prestito: " + formatDate(dataPrestito)
                + ", Scadenza: " + formatDate(dataRestituzione);
    }
}
