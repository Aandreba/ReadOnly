package org.rol;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public abstract class ReadOnlyList<T> extends AbstractList<T> {
    public static <T> ReadOnlyList<T> ofArray (T... array) {
        return new ReadOnlyList<T>() {
            @Override
            public T get (int index) {
                return array[index];
            }

            @Override
            public int size() {
                return array.length;
            }

            @Override
            public Spliterator<T> spliterator() {
                return Arrays.spliterator(array);
            }
        };
    }

    public static <T> ReadOnlyList<T> ofList (List<T> list) {
        return new ReadOnlyList<T> () {
            @Override
            public T get (int index) {
                return list.get(index);
            }

            @Override
            public int size() {
                return list.size();
            }

            @Override
            public int indexOf (Object o) {
                return list.indexOf(o);
            }

            @Override
            public int lastIndexOf(Object o) {
                return list.lastIndexOf(o);
            }

            @Override
            public Iterator<T> iterator() {
                return list.iterator();
            }

            @Override
            public ReadOnlyList<T> subList (int fromIndex, int toIndex) {
                return ReadOnlyList.ofList(list.subList(fromIndex, toIndex));
            }

            @Override
            public boolean isEmpty() {
                return list.isEmpty();
            }

            @Override
            public boolean contains(Object o) {
                return list.contains(o);
            }

            @Override
            public Object[] toArray() {
                return list.toArray();
            }

            @Override
            public <T1> T1[] toArray(T1[] a) {
                return list.toArray(a);
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return list.containsAll(c);
            }

            @Override
            public String toString() {
                return list.toString();
            }

            @Override
            public void sort(Comparator<? super T> c) {
                list.sort(c);
            }

            @Override
            public Spliterator<T> spliterator() {
                return list.spliterator();
            }

            @Override
            public <T1> T1[] toArray(IntFunction<T1[]> generator) {
                return list.toArray(generator);
            }

            @Override
            public Stream<T> stream() {
                return list.stream();
            }

            @Override
            public Stream<T> parallelStream() {
                return list.parallelStream();
            }

            @Override
            public void forEach(Consumer<? super T> action) {
                list.forEach(action);
            }
        };
    }

    @Override
    public abstract T get (int index);

    @Override
    public abstract int size ();

    @Override
    public ReadOnlyList<T> subList(int fromIndex, int toIndex) {
        return ReadOnlyList.ofList(super.subList(fromIndex, toIndex));
    }

    @Override
    final public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    final public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    final protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public void replaceAll(UnaryOperator<T> operator) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public boolean removeIf(Predicate<? super T> filter) {
        throw new UnsupportedOperationException();
    }
}
