package Data.ArrayList;

public class MyListGeneric<E> {
  Object[] list = new Object[5];
  int size;

  public void add(E value) {
    list[size++] = value;
  }

  @SuppressWarnings("unchecked")
  public E get(int i) {
    return (E) list[i];
  }

  public int size() {
    return size;
  }
}
