import java.util.Arrays;

public final class ArrayBasedStack<T> implements StackInterface<T>
{
	private T[] stack;
	private int topOfStack;
	private boolean initialized = false;
	private static final int INITIAL_CAPACITY = 5;
	private static final int MAX_CAPACITY = 100;

	public ArrayBasedStack()
	{
		this(INITIAL_CAPACITY);
	}

	public ArrayBasedStack(int initialCapacity)
	{
		checkCapacity(initialCapacity);

		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack = tempStack;
		topOfStack = -1;
		initialized = true;
	}


	public void push(T newEntry)
	{
		checkInitialization();
		ensureCapacity();
		stack[topOfStack + 1] = newEntry;
		topOfStack++;
	}

	private void checkInitialization()
	{
		if (!initialized)
			throw new SecurityException("Array based Stack object is not initialized properly.");
	}

	private void checkCapacity(int initialCapacity)
	{
		if (initialCapacity > 5)
		throw new IllegalStateException("Initial capacity not " + INITIAL_CAPACITY);
	}

	private void ensureCapacity()
	{
		if (topOfStack == stack.length -1)
		{
			int newLength = 2 * stack.length;
			checkCapacity(newLength);
			stack = Arrays.copyOf(stack, newLength);
		}
	}


	public void clear()
	{
		topOfStack = -1;
	}



}