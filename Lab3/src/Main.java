import Animals.classis.Udeonychophora;
import Animals.classis.Xenusia;
import Animals.familia.Luolishaniidae;
import Animals.familia.Peripatidae;
import Animals.familia.Peripatopsidae;
import Animals.genus.Facivermis;
import Animals.genus.Luolishania;
import Animals.phylum.Onychophora;
import Animals.species.*;

import java.util.LinkedList;
@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        Queue<Onychophora>animals=new Queue<>(20);
        animals.add(new Xenusia());
        animals.add(new Udeonychophora());
        animals.add(new Luolishaniidae());
        animals.add(new Peripatidae());
        animals.add(new Peripatopsidae());
        animals.add(new Facivermis());
        animals.add(new Luolishania());
        animals.add(new Facivermis_carbotubulus());
        animals.add(new Facivermis_thanahita());
        animals.add(new Peripatus_acinocricus());
        animals.add(new Peripatus_collinsovermis());
        animals.add(new Luolishania_lenisambulatrix());
        animals.add(new Luolishania_quadratapora());

        Queue<Xenusia>xenusia=Queue.produce(animals);

        LinkedList<Queue<Xenusia>> parents = Queue.consume(xenusia);

        Queue<Xenusia> temp = parents.getFirst();
        int size = temp.getCurrentSize();
        System.out.println("\nArachnids, which are parents of Luolishania_lenisambulatrix:");
        for (int i = 0; i < size; i++) {
            System.out.println(temp.get().getClass().getSimpleName());
        }
        temp = parents.getLast();
        size = temp.getCurrentSize();
        System.out.println("\nArachnids, which are parents of Peripatus_collinsovermis:");
        for (int i = 0; i < size; i++) {
            System.out.println(temp.get().getClass().getSimpleName());
        }
    }
}
