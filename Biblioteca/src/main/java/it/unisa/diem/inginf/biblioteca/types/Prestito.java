package it.unisa.diem.inginf.biblioteca.types;

import java.util.Date;
import java.text.SimpleDateFormat;


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
