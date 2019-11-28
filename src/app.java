package src;

import src.algorithms.tree.*;

public class app {
    public static void main(String[] args) {

        RedBlackTree b = new RedBlackTree();

        b.add(22);
        b.add(14);
        b.add(64);
        b.add(6);
        b.add(62);
        b.add(70);
        b.add(13);

        b.remove(64);

        System.out.println("\n\nTree: \n"+ b);



        // for(int i = 15; i > 0 ; i -= 5){
        //     b.add(i);
        //     System.out.println("\n\nTree: \n"+ b);
        //     try{
        //         Thread.sleep(1000);
        //     }catch(Exception e){
        //         System.out.println(e);   
        //     }
        // }

        // System.out.println("\n\npositionsCentral\n"+ b.positionsCentral().toString());
        // System.out.println("\n\npositionsPre\n"+ b.positionsPre().toString());
        // System.out.println("\n\nTree: \n"+ b);
    }   
}
