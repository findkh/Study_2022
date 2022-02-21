package Data.ArrayList;

import java.util.Arrays;

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

  public Object[] toArray() {
    Object[] arr = new Object[size];
    for (int i = 0; i < size; i++) {
      arr[i] = list[i];
    }
    return arr;
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    if (arr.length >= size) {
      for (int i = 0; i < size; i++) {
        arr[i] = (E) list[i];
      }
      return arr;

    } else {
      return (E[]) Arrays.copyOf(list, size, arr.getClass());
    }
  }
}

