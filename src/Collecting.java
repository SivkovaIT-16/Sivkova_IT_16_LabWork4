public interface Collecting <T, P> {
    P collect(T obj, CollectionFactory<P> collectionFactory, Betrayal<T, P> betrayal);
}
