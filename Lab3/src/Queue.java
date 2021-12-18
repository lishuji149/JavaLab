import Animals.classis.Xenusia;
import Animals.familia.Peripatidae;
import Animals.genus.Facivermis;
import Animals.phylum.Onychophora;
import Animals.species.Facivermis_carbotubulus;
import Animals.species.Luolishania_lenisambulatrix;
import Animals.species.Peripatus_collinsovermis;

import java.util.LinkedList;

@SuppressWarnings("all")
public class Queue<T extends Onychophora> {
    private final int maxSize;
    private final LinkedList<T> data = new LinkedList<>();
    private int currentSize = 0;

    public static Queue<Xenusia> produce(Queue<Onychophora> source) {
        int size = source.currentSize;
        Queue<Xenusia> xenusia = new Queue<>(size);
        for (int i = 0; i < size; i++) {
            Onychophora curr = source.get();
            if (Xenusia.class.isAssignableFrom(curr.getClass())) {
                xenusia.add((Xenusia) curr);
            }
        }
        return xenusia;
    }

    public static LinkedList<Queue<Xenusia>> consume(Queue<Xenusia> source) {
        int size = source.currentSize;
        Queue<Xenusia> luolishania = new Queue<>(size);
        Queue<Xenusia> peripatus = new Queue<>(size);
        LinkedList<Queue<Xenusia>> parents = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            Xenusia curr = source.get();
            if (curr.getClass().isAssignableFrom(Luolishania_lenisambulatrix.class)) {
                luolishania.add(curr);
            }
            if (curr.getClass().isAssignableFrom(Peripatus_collinsovermis.class)) {
                peripatus.add(curr);
            }
        }
        parents.addLast(luolishania);
        parents.addLast(peripatus);
        return parents;
    }

    public Queue(int maxSize) {

        this.maxSize = maxSize;
    }

    public void add(T element) throws StackOverflowError {
        if (currentSize >= maxSize) {
            throw new StackOverflowError("The Queue is full!");
        }
        data.add(element);
        currentSize++;
    }

    public T get() throws IndexOutOfBoundsException {
        if (currentSize == 0) {
            throw new IndexOutOfBoundsException("The Queue is empty!");
        }
        currentSize--;
        return data.removeFirst();
    }

    public int getCurrentSize() {
        return currentSize;
    }
}
