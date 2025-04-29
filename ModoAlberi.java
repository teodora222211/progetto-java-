public class ModoAlberi {

    static class NodoAlbero {
        int valore;      
        NodoAlbero sinistro;  
        NodoAlbero destro;    
        public NodoAlbero(int valore) {
            this.valore = valore;
            this.sinistro = null;
            this.destro = null;
        }
    }
    
    private NodoAlbero radice;
    public ModoAlberi() {
        this.radice = null;
    }
    
    public void aggiungiValore(int valore) {
        radice = aggiungiValoreRicorsivo(radice, valore);
    }
    
    private NodoAlbero aggiungiValoreRicorsivo(NodoAlbero nodo, int valore) {
        if (nodo == null) {
            return new NodoAlbero(valore);
        }
        
        if (nodo.sinistro == null) {
            nodo.sinistro = aggiungiValoreRicorsivo(nodo.sinistro, valore);
        } else if (nodo.destro == null) {
            nodo.destro = aggiungiValoreRicorsivo(nodo.destro, valore);
        } else {
    
            aggiungiValoreRicorsivo(nodo.sinistro, valore);
        }
        
        return nodo;
    }
    
    
    public void stampaAlbero() {
        System.out.println("Contenuto dell'albero (in-ordine):");
        stampaNodo(radice);
        System.out.println();
    }
    
    private void stampaNodo(NodoAlbero nodo) {
        if (nodo != null) {
            stampaNodo(nodo.sinistro);
            System.out.print(nodo.valore + " ");
            stampaNodo(nodo.destro);
        }
    }
    
    public boolean contiene(int valore) {
        return cercaValore(radice, valore);
    }
    
    private boolean cercaValore(NodoAlbero nodo, int valore) {
        if (nodo == null) {
            return false;
        }
        if (nodo.valore == valore) {
            return true;
        }
        return cercaValore(nodo.sinistro, valore) || cercaValore(nodo.destro, valore);
    }
    
    public static void main(String[] args) {
        ModoAlberi albero = new ModoAlberi();
        

        albero.aggiungiValore(10);
        albero.aggiungiValore(5);
        albero.aggiungiValore(15);
        albero.aggiungiValore(3);
        albero.aggiungiValore(7);
        albero.stampaAlbero();
        
        System.out.println("L'albero contiene 7? " + albero.contiene(7));
        System.out.println("L'albero contiene 12? " + albero.contiene(12));
    }
}