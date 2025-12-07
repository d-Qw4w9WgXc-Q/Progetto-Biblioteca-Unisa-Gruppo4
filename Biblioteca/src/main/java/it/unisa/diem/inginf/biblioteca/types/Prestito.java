package it.unisa.diem.inginf.biblioteca.types;

import java.util.Date;

public class Prestito {
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
}
