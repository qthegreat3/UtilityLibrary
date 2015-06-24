public class Pair<T, T2>
{
	private T _left;
	private T2 _right;

	public Pair()
	{
		_left = null;
		_right = null;
	}

	public Pair(T left, T2 right)
	{
		_left = left;
		_right = right;
	}

	public T2 getRight()
	{
		return _right;
	}

	public T getLeft()
	{
		return _left;
	}

	public void setLeft(T left)
	{
		_left = left;
	}

	public void setRight(T2 right)
	{
		_right = right;
	}
}