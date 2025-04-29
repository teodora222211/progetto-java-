class Nodo {
    int valore;
    Nodo sinistro;
    Nodo destro;

    public Nodo(int valore) {
        this.valore = valore;
        sinistro = destro = null;
    }
}

public class AlberoBinario {
    Nodo radice;

    public AlberoBinario() {
        radice = null;
    }

    public void inserisci(int valore) {
        radice = inserisciRicorsivo(radice, valore);
    }

    private Nodo inserisciRicorsivo(Nodo corrente, int valore) {
        if (corrente == null) {
            return new Nodo(valore);
        }

        if (valore % 2 == 0) {
            corrente.sinistro = inserisciRicorsivo(corrente.sinistro, valore);
        } else {
            corrente.destro = inserisciRicorsivo(corrente.destro, valore);
        }

        return corrente;
    }

    public void inOrdine() {
        inOrdineRicorsivo(radice);
    }

    private void inOrdineRicorsivo(Nodo nodo) {
        if (nodo != null) {
            inOrdineRicorsivo(nodo.sinistro);
            System.out.print(nodo.valore + " ");
            inOrdineRicorsivo(nodo.destro);
        }
    }

    public static void main(String[] args) {
        AlberoBinario albero = new AlberoBinario();
        
        albero.inserisci(5);
        albero.inserisci(3);
        albero.inserisci(8);
        albero.inserisci(1);
        albero.inserisci(4);
        albero.inserisci(7);
        albero.inserisci(9);

        System.out.println("Attraversamento in ordine:");
        albero.inOrdine();
    }
}
