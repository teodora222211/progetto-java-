package progetto1;
private void visualizzaRicorsivo(Nodo n) {
    if (n == null)  
        return;
    System.out.println("Stella: " + ((Stella)n.oggetto).nome + ", Luminosita: " + ((Stella)n.oggetto).luminosita);
    visualizzaRicorsivo(n.next); 
}

public void visualizzalista() {
    visualizzaRicorsivo(head); 
}

public void inserisaInTesta(Oggetto dati) {
    Nodo n = new Nodo(dati);
    n.next = head;  
    head = n;         
    Nelementi++;      
}
public void inserisaCoda(Oggetto dati) {
    Nodo c = new Nodo(dati);  
    Nodo n = head;            
    while (n.next != null) { 
        n = n.next;
    }
    n.next = c;   
    c.next = null; 
    Nelementi++;    
}

public void inserimentoInOrdine(Oggetto dati) {
    Nodo n = new Nodo(dati); 
    Nodo p = head;           
    Nodo d = head != null ? head.next : null;

    while (d != null && ((Stella) p.oggetto).controllo((Stella) dati)) {
        p = d;
        d = d.next;
    }

    if (d == null) {
        inserisaCoda(dati); 
    } else {
        n.next = d;  
        p.next = n;  
        Nelementi++;  
    }
}

public class Main {
public static void main(String[] args) {
    Lista lista = new Lista();

    Stella s1 = new Stella(10, "Nettuno");
    Stella s2 = new Stella(20, "Marte");
    Stella s3 = new Stella(5, "Mercurio");

    lista.inserisaInTesta(s1);
    lista.inserisaInTesta(s2);
    lista.inserisaInTesta(s3);

    System.out.println("Lista delle stelle (visualizzalista):");
    lista.visualizzalista();

    System.out.println("\nRimuovi la stella 'Marte':");
    lista.inserimentoInOrdine(new Stella(15, "Marte")); 

    lista.visualizzalista();
}
}