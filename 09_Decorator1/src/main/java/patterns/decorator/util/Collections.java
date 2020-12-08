package patterns.decorator.util;

import java.util.Collection;
import java.util.Iterator;

public class Collections {

	public static <T> Collection<T> unmodifiableCollection(Collection<T> c) {
		return new UnmodifiableCollection<T>(c);
	}

	public static class UnmodifiableCollection<T> implements Collection<T> {

		private Collection<T> inner;

		public UnmodifiableCollection(Collection<T> inner) {
			this.inner = inner;
		}

		@Override
		public int size() {
			return inner.size();
		}

		@Override
		public boolean isEmpty() {
			return inner.isEmpty();
		}

		@Override
		public boolean contains(Object o) {
			return inner.contains(o);
		}

		@Override
		public Iterator<T> iterator() {
			return new Iterator<T>() {

				@Override
				public boolean hasNext() {
					return inner.iterator().hasNext();
				}

				@Override
				public T next() {
					return inner.iterator().next();
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}
			};
		}

		@Override
		public Object[] toArray() {
			return inner.toArray();
		}

		@Override
		public <T1> T1[] toArray(T1[] a) {
			return inner.toArray(a);
		}

		@Override
		public boolean add(T t) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean remove(Object o) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			return inner.containsAll(c);
		}

		@Override
		public boolean addAll(Collection<? extends T> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void clear() {
			throw new UnsupportedOperationException();
		}

	}


}
