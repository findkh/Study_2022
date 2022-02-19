package Data.ArrayList;

public class MyList {
  Object[] list = new Object[5];
  int size;

  public void add(Object value) {
    list[size++] = value;
  }

  public Object get(int i) {
    return list[i];
  }

  public int size() {
    return size;
  }
}
