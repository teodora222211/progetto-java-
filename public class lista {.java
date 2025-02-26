public class Lista {
    private Nodo head;
    private int elementi;

    public Lista() {
        head = null;
        elementi = 0;
    }
   
    public void inserisciTesta(Stella s){
        Nodo n = new Nodo(s);
        n.setLink(head);
        head = n;
        elementi++;
    }
    
    public void vistaLista(){
        Nodo p = head;
        while (p != null) {
            stampa(p.getDati());
            p = p.getLink();
        }
    }

    public void eliminazioneIntermedia(stella dati){
        Nodo p = head;
        while (p != null && p.getLink() != null) {
            if (p.getLink().getDati().nome.equals(dati.nome)) {
                p.setLink(p.getLink().getLink());
                elementi--;
                return;
            }
            p = p.getLink();
        }
    } 
}

class Nodo {
    private stella dati;
    private Nodo link;

    public Nodo(stella dati){
        this.dati = new stella(dati.luminosita, dati.nome);  // 构造时复制数据
        this.link = null;
    }

    public Nodo getLink(){
        return link;
    }

    public stella getDati(){
        return dati;
    }

    public void setLink(Nodo link){
        this.link = link;
    }

    public boolean diverso(stella input){
        return !this.dati.nome.equals(input.nome);
    }

    public void stampa(stella s){
        System.out.println("questa stella si chiama " + s.nome);
        System.out.println("\n ed ha intensità luminosa: " + s.luminosita);
    }
}

class stella {
    public int luminosita;
    public String nome;

    public stella(int luminosita, String nome){
        this.luminosita = luminosita;
        this.nome = nome;
    }
}
