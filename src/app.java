package src;

import src.algorithms.tree.*;

public class app {
    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.add(15);
        b.add(23);
        b.add(9);
        b.add(11);
        b.add(2);
        b.add(20);
        b.add(38);
        b.add(1);

        b.remove(15);


        System.out.println("\n\npositionsCentral\n"+ b.positionsCentral().toString());
        System.out.println("\n\npositionsPre\n"+ b.positionsPre().toString());
        System.out.println("\n\nTree: \n"+ b);
    }   
}
