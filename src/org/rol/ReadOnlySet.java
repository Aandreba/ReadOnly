package org.rol;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public abstract class ReadOnlySet<T> extends AbstractSet<T> {
    public static <T> ReadOnlySet<T> ofSet (Set<T> parent) {
        return new ReadOnlySet<T>() {
            @Override
            public Iterator<T> iterator() {
                return parent.iterator();
            }

            @Override
            public int size() {
                return parent.size();
            }

            @Override
            public Spliterator<T> spliterator() {
                return parent.spliterator();
            }

            @Override
            public <T1> T1[] toArray(IntFunction<T1[]> generator) {
                return parent.toArray(generator);
            }

            @Override
            public Stream<T> stream() {
                return parent.stream();
            }

            @Override
            public Stream<T> parallelStream() {
                return parent.stream();
            }

            @Override
            public void forEach(Consumer<? super T> action) {
                parent.forEach(action);
            }
        };
    }

    @Override
    public abstract Iterator<T> iterator();

    @Override
    public abstract int size();

    @Override
    final public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public boolean add(T t) {
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
    final public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    final public boolean removeIf(Predicate<? super T> filter) {
        throw new UnsupportedOperationException();
    }
}
