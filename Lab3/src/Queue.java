import java.util.LinkedList;

import Animals.classis.Arachnids;
import Animals.phylum.Chordates;
import Animals.species.Euscorpius_alpha;
import Animals.species.Missulena_hoggi;

public class Queue<T> {
    private final LinkedList<T> data = new LinkedList<>();
    private final int maxSize;
    private int currentSize = 0;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
    }

    public static Queue<Arachnids> produce(Queue<Chordates> source) {
        int size = source.currentSize;
        Queue<Arachnids> arachnids = new Queue<>(size);
        for (int i = 0; i < size; i++) {
            Chordates curr = source.get();
            if (Arachnids.class != curr.getClass() && Arachnids.class.isAssignableFrom(curr.getClass())) {
                arachnids.add((Arachnids) curr);
            }
        }
        return arachnids;
    }

    public static LinkedList<Queue<Arachnids>> consume(Queue<Arachnids> source) {
        int size = source.currentSize;
        Queue<Arachnids> euscorpius = new Queue<>(size);
        Queue<Arachnids> missulena = new Queue<>(size);
        LinkedList<Queue<Arachnids>> parents = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            Arachnids curr = source.get();
            if (Euscorpius_alpha.class != curr.getClass() && curr.getClass().isAssignableFrom(Euscorpius_alpha.class)) {
                euscorpius.add(curr);
            }
            if (Missulena_hoggi.class != curr.getClass() && curr.getClass().isAssignableFrom(Missulena_hoggi.class)) {
                missulena.add(curr);
            }
        }
        parents.addLast(euscorpius);
        parents.addLast(missulena);
        return parents;
    }

    public void add(T element) throws StackOverflowError {
        if (currentSize >= maxSize) {
            throw new StackOverflowError("The Queue is full!");
        }
        data.addLast(element);
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
