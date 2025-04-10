package progetto2;
public class NodoAlbero{
    private tipo_generico dati;
    //tipo generico lo cambieremo più tardi
    private NodoAlbero puntatoreFratello;
    private NodoAlbero puntatoreFiglio;

    //costruttore
    public NodoAlbero(tipo_generico dati){
        this.dati = dati;
        puntatoreFratello = null;
        puntatoreFiglio = null;
    }

    public void modificaData(tipo_generico dati){//
    }

    public NodoAlbero getPunFratello(){
        return puntatoreFratello;
    }

    public NodoAlbero getPunFiglio(){
        return puntatoreFiglio;
    }
}