public class Oggetto {
    public String nome;

    public Oggetto(String nome) {
        this.nome = nome;
    }
}

class Stella extends Oggetto {
    public int luminosita;

    public Stella(int luminosita, String nome) {
        super(nome);
        this.luminosita = luminosita;
    }
}

class Nodo {
    public Oggetto oggetto;
    public Nodo next;

    public Nodo(Oggetto oggetto) {
        this.oggetto = oggetto;
        this.next = null;
    }
}

class Lista {
    private Nodo head;

    public void inserisciTesta(Oggetto oggetto) {
        Nodo nuovoNodo = new Nodo(oggetto);
        nuovoNodo.next = head;
        head = nuovoNodo;
    }

    
    public void vistaLista() {
        Nodo p = head;
        while (p != null) {
            if (p.oggetto instanceof Stella) {
                Stella s = (Stella) p.oggetto;
                System.out.println("Stella: " + s.nome + ", Luminosita: " + s.luminosita);
            }
            p = p.next;
        }
    }


    public void eliminazioneStella(Oggetto oggetto) {
        if (head == null) return;

        if (head.oggetto.nome.equals(oggetto.nome)) {
            head = head.next;  
            return;
        }

        Nodo p = head;
        while (p.next != null) {
            if (p.next.oggetto.nome.equals(oggetto.nome)) {
                p.next = p.next.next; 
                return;
            }
            p = p.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();

        Stella s1 = new Stella(10, "Nettuno");
        Stella s2 = new Stella(20, "Marte");
        Stella s3 = new Stella(5, "Mercurio");

        lista.inserisciTesta(s1);
        lista.inserisciTesta(s2);
        lista.inserisciTesta(s3);

        System.out.println("Lista delle stelle:");
        lista.vistaLista();

        
        System.out.println("\nRimuovi la stella 'Marte':");
        lista.eliminazioneStella(new Stella(20, "Marte"));

        lista.vistaLista();
    }
}
