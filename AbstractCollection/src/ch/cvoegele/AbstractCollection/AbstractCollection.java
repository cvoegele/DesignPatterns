package ch.cvoegele.AbstractCollection;

import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractCollection<E> implements Collection<E> {

    /*
        2. Which methods cannot be implemented in the abstract class (or as Java 8 default methods) in terms of the other methods?
        In other words: For which methods is information about the data structure used to store the elements necessary?
        Hint: Only two methods cannot be implemented!

        Method iterator() or toArray() cannot be implemented because if we implemented both they would depend on each other.
        Either iterator depends on toArray() or toArray() uses the iterator.

        We also cannot implement add() because we don't know how to store exactly the elements


        3. Which of the methods which you could implement should be overridden by a concrete implementation? Justify your answer!

        Several methods like size or remove are very inefficient here and can be greatly improved once we know the concrete implementation.
     */

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        for (var element : c) {
            boolean changed = remove(c);
            if (changed) result = true;
        }
        return result;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;

        for (var element : c) {
            boolean changed = add(element);
            if (changed) result = true;
        }

        return result;
    }

    @Override
    public void clear() {
        removeAll(this);
    }

    @Override
    public boolean isEmpty() {
        // return size() == 0;
        return !iterator().hasNext();
    }

    @Override
    public boolean contains(Object o) {
        while (iterator().hasNext()) {
            if (iterator().next().equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size()];
        for (int i = 0; i < result.length; i++) {
            var element = iterator().next();
            result[i] = element;
        }
        return result;
    }

    @Override
    public int size() {
        int counter = 0;
        while (iterator().hasNext()) {
            iterator().next();
            counter++;
        }
        return counter;
    }

    @Override
    public <T> T[] toArray(T[] a) {

        if (size() > a.length) toArray();

        for (int i = 0; i < size(); i++) {
            var element = iterator().next();
            a[i] = (T) element;
        }
        return a;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean result = true;
        for (var element : c) {
            boolean singleContained = contains(c);
            if (!singleContained) return false;
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean changed = false;
        for (var element : c) {
            if (!contains(c)) {
                remove(c);
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public boolean remove(Object o) {
        if (!contains(o)) return false;

        var copy = this.toArray();
        clear();
        for (var element : copy) {
            if (element != o) add((E) element);
        }

        return true;
    }

    /*
        only here for educational purposes
     */
    @Override
    public Iterator<E> iterator() {
        return new AbstractIterator();
    }

    private class AbstractIterator implements Iterator<E> {

        private int position = 0;

        @Override
        public boolean hasNext() {
            return position < toArray().length;
        }

        @Override
        public E next() {
            return (E) toArray()[position++];
        }
    }
}
