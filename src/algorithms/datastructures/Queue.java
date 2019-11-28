package src.algorithms.datastructures;

import src.exceptions.EmptyQueueException;
import src.exceptions.ExceptionHandler;

import java.util.LinkedList;

public class Queue<E> {

    private LinkedList<E> fila;

    public Queue() {
        fila = new LinkedList<E>();
        setExceptionWay();
    }

    public int size() {
        return fila.size();
    }

    public boolean isEmpty() {
        return fila.isEmpty();
    }

    public E head() throws EmptyQueueException {
        if (fila.isEmpty()) {
            throw new EmptyQueueException("A fila esta vazia");
        } else {
            E elem = fila.get(0);
            return elem;
        }
    }

    public void enqueue(E element) {
        fila.add(element);
    }

    public E dequeue() throws EmptyQueueException {
        if (fila.isEmpty()) {
            throw new EmptyQueueException("src.algorithms.datastructures.Queue is empty!");
        } else {
            E elem = fila.remove(0);
            return elem;            
        }
    }

    public void clear() {
        fila.clear();
    }

    private static void setExceptionWay(){
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
    }
}
