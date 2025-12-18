package it.unisa.diem.inginf.biblioteca.types;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Prestito {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE;

    private Date dataPrestito;
    private Date dataRestituzione;
    private Libro libro;
    private Utente utente;

    public Prestito(Date dataPrestito, Date dataRestituzione, Libro libro, Utente utente) {
        this.dataPrestito = dataPrestito;
        this.dataRestituzione = dataRestituzione;
        this.libro = libro;
        this.utente = utente;
    }
    
    public Date getDataRestituzione() {
        return dataRestituzione;
    }

    public void setDataRestituzione(Date dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }

    public Date getDataPrestito() {
        return dataPrestito;
    }

    public Libro getLibro() {
        return libro;
    }

    public Utente getUtente() {
        return utente;
    }

    private static String formatDate(Date date) {
        if (date == null) {
            return "N/D";
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DATE_FORMAT);
    }

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
