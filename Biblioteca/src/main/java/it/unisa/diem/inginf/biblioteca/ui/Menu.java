package it.unisa.diem.inginf.biblioteca.ui;

/**
 * Interfaccia comune per i menu/modali di creazione e modifica degli oggetti di dominio.
 */
public interface Menu<T> {
    
    /**
     * Mostra il menu in modalità modifica dell'oggetto.
     * @param ob oggetto da modificare (o {@code null} per delegare alla creazione)
     */
    public void show(T ob);

    /**
     * Mostra il menu in modalità creazione.
     */
    public void show();
}
