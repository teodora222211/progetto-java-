public class Main {

    public static void main(String[] args) {
        Lista lista = new Lista();

        stella s1 = new stella(10, "Nettuno");
        stella s2 = new stella(20, "Marte");
        stella s3 = new stella(5, "Mercurio");

        lista.inserisciTesta(s1);
        lista.inserisciTesta(s2);
        lista.inserisciTesta(s3);

        System.out.println("stelle nell'elenco collegato:");
        lista.vistaLista();

      
        System.out.println("\nRimuovi le stelle'Marte' Indietro:");
        lista.eliminazioneIntermedia(new stella(20, "Marte"));

        
        lista.vistaLista();
    }
}

class Lista {
    private Nodo head;

   
    public void inserisciTesta(stella s) {
        Nodo n = new Nodo(s);
        n.setLink(head);
        head = n;
    }

    
    public void vistaLista() {
        Nodo p = head;
        while (p != null) {
            System.out.println("Stella: " + p.getDati().nome + ", Luminosita: " + p.getDati().luminosita);
            p = p.getLink();
        }
    }

   
    public void eliminazioneIntermedia(stella s) {
        Nodo p = head;
        if (p != null && p.getDati().nome.equals(s.nome)) {
            head = p.getLink(); 
            return;
        }
        while (p != null && p.getLink() != null) {
            if (p.getLink().getDati().nome.equals(s.nome)) {
                p.setLink(p.getLink().getLink());  
                return;
            }
            p = p.getLink();
        }
    }
}

class Nodo {
    private stella dati;
    private Nodo link;

    public Nodo(stella dati) {
        this.dati = dati;
        this.link = null;
    }

    public Nodo getLink() {
        return link;
    }

    public stella getDati() {
        return dati;
    }

    public void setLink(Nodo link) {
        this.link = link;
    }
}

class stella {
    public int luminosita;
    public String nome;

    public stella(int luminosita, String nome) {
        this.luminosita = luminosita;
        this.nome = nome;
    }
}
