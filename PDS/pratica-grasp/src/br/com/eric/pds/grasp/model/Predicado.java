package br.com.eric.pds.grasp.model;

public interface Predicado<T> {
    boolean aplicarA(T type, Object criteria);
}
