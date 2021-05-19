package SobekDataModel;

public class KeyValuePair<E, T> {

	private E key;
	private T value;

	public KeyValuePair(E key, T value) {
		this.key = key;
		this.value = value;
	}

	public void setKey(E key) {
		this.key = key;
	}

	public E getKey() {
		return this.key;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public T getValue() {
		return this.value;
	}
}
