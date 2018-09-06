package myown.interfaces;

public interface MyMapper<S,T> {
    T map(S value);
}
