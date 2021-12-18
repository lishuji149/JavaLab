import java.util.LinkedList;

import Animals.classis.Arachnids;
import Animals.classis.Birds;
import Animals.familia.Euscorpiidae_Laurie;
import Animals.genus.Columba;
import Animals.genus.Missulena;
import Animals.ordo.Scorpions;
import Animals.ordo.Spiders;
import Animals.phylum.Chordates;
import Animals.species.Columba_albinucha;
import Animals.species.Euscorpius_alpha;
import Animals.species.Missulena_bradleyi;

public class Main {

    public static void main(String[] args) {
        Queue<Chordates> animals = new Queue<>(20);
        animals.add(new Birds());
        animals.add(new Euscorpius_alpha());
        animals.add(new Missulena_bradleyi());
        animals.add(new Columba_albinucha());
        animals.add(new Spiders());
        animals.add(new Scorpions());
        animals.add(new Columba());
        animals.add(new Missulena());
        animals.add(new Euscorpiidae_Laurie());
        animals.add(new Arachnids());

        System.out.println("First breakpoint");

        Queue<Arachnids> arachnids = Queue.produce(animals);

        System.out.println("Second breakpoint");

        LinkedList<Queue<Arachnids>> parents = Queue.consume(arachnids);

        Queue<Arachnids> temp = parents.getFirst();
        int size = temp.getCurrentSize();
        System.out.println("\nArachnids, which are parents of Euscorpius_alpha:");
        for (int i = 0; i < size; i++) {
            System.out.println(temp.get().getClass().getSimpleName());
        }
        temp = parents.getLast();
        size = temp.getCurrentSize();
        System.out.println("\nArachnids, which are parents of Missulena_hoggi:");
        for (int i = 0; i < size; i++) {
            System.out.println(temp.get().getClass().getSimpleName());
        }
    }

}
