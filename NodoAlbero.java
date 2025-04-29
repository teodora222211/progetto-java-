public class NodoAlbero{
    private tipo_generico dati;
    //tipo generico lo cambieremo più tardi
    private NodoAlbero puntatoreFratello;
    private NodoAlbero puntatoreFiglio;

    //costrettore
    public NodoAlbero(tipo_generico dati){
        this.dati = new tipo_generico(dati);
        puntatoreFratello = null;
        puntatoreFiglio = null;
    }

    public void modificaData(tipo_generico dati){//
    }
}