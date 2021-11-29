package org.rol;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class ReadOnlyMap<K,V> extends AbstractMap<K,V> {
    public static <K,V> ReadOnlyMap<K,V> ofMap (Map<K,V> parent) {
        return new ReadOnlyMap<>() {
            @Override
            protected Set<Entry<K, V>> defaultEntrySet() {
                return parent.entrySet();
            }

            @Override
            public V getOrDefault (Object key, V defaultValue) {
                return parent.getOrDefault(key, defaultValue);
            }

            @Override
            public void forEach (BiConsumer<? super K, ? super V> action) {
                parent.forEach(action);
            }
        };
    }

    protected abstract Set<Entry<K,V>> defaultEntrySet ();

    @Override
    final public Set<Entry<K, V>> entrySet() {
        return new AbstractSet<>() {
            final private Set<Entry<K,V>> parent = defaultEntrySet();

            @Override
            public Iterator<Entry<K, V>> iterator() {
                return new Iterator<>() {
                    final private Iterator<Entry<K,V>> iter = parent.iterator();

                    @Override
                    public boolean hasNext() {
                        return iter.hasNext();
                    }

                    @Override
                    public Entry<K, V> next() {
                        return new Entry<>() {
                            final private Entry<K,V> entry = iter.next();

                            @Override
                            public K getKey() {
                                return entry.getKey();
                            }

                            @Override
                            public V getValue() {
                                return entry.getValue();
                            }

                            @Override
                            public V setValue(V value) {
                                throw new UnsupportedOperationException();
                            }
                        };
                    }
                };
            }

            @Override
            public int size() {
                return parent.size();
            }
        };
    }

    @Override
    final public V put (K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    final public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public V putIfAbsent(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public boolean remove(Object key, Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public boolean replace(K key, V oldValue, V newValue) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public V replace(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        throw new UnsupportedOperationException();
    }

    @Override
    final public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        throw new UnsupportedOperationException();
    }
}
