public class StaticList<E> implements List<E> {
	private E[] elements;
	private int numElements;

	public StaticList(int maxSize) {
		elements = (E[])new Object[maxSize];
		numElements = 0;
	}

	public int numElements() {
		return numElements;
	}

	public boolean isEmpty() {
		return numElements == 0;
	}

	public boolean isFull() {
		return numElements == elements.length;
	}

	public void insert(E element, int pos) throws OverflowException, IndexOutOfBoundsException{
		if (isFull())
			throw new OverflowException();

		if (pos < 0  ||  pos > numElements)
			throw new IndexOutOfBoundsException();

		for (int i = numElements-1; i >= pos; i--)
			elements[i+1] = elements[i];
		
		elements[pos] = element;
		numElements++;
	}

	public E remove(int pos) throws UnderflowException, IndexOutOfBoundsException{
		if(isEmpty())
			throw new UnderflowException();
		
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();
		
		E element = elements[pos];

		for (int i = pos; i < numElements-1; i++)
			elements[i] = elements[i+1];

		elements[numElements-1] = null;
		numElements--;

		return element;
	}

	public E get(int pos) throws IndexOutOfBoundsException{
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();

		return elements[pos];
	}

	public int search(E element) {
		for (int i = 0; i < numElements; i++)
			if (element.equals(elements[i]))
				return i;
		
		return -1;
	}

	public int contaElementos(E el) {
		if(isEmpty())
			throw new UnderflowException();

		return contaElementos(el, 0, 0);
	}

	private int contaElementos(E element, int pos, int count) {
		if (pos < 0  ||  pos >= numElements)
			return count;

		if(element.equals(elements[pos]))
			count++;

		return contaElementos(element, pos + 1, count);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < numElements; i++)
			s.append(elements[i]).append(" ");
		return s.toString();
	}
}