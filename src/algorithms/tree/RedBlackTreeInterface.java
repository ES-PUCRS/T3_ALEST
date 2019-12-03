package src.algorithms.tree;

import src.algorithms.datastructures.LinkedList;

public interface RedBlackTreeInterface{
	public void add(Integer element);
	public Integer getParent(Integer element);
	public boolean contains(Integer element);
	public Integer get(Integer element);
	public int height();
	public int size();
	public boolean isEmpty();
	public RedBlackTree clone();
	public LinkedList positionsPre();
	public LinkedList positionsCentral();
	public LinkedList positionsPos();
	public LinkedList positionsWidth();
}