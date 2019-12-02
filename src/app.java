package src;

import src.algorithms.tree.*;
import src.ui.UserInterface;

public class app {
   
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();



        tree.add(21);
        tree.add(25);
        tree.add(3);
        tree.add(27);
        tree.add(11);
        System.out.println(tree);
        tree.add(4);
        System.out.println(tree);

        
        // tree.add(22);
        // tree.add(32);
        // tree.add(10);
        // tree.add(12);
        // tree.add(8);
        // System.out.println(tree);
        // tree.add(11);
        // System.out.println(tree);
        // tree.add(31);
        // tree.add(30);
        // System.out.println(tree);


        // 1
        // tree.add(7);
        // tree.add(4);
        // System.out.println(tree);
        // tree.add(6);
        // System.out.println(tree);

        // 2
        // tree.add(7);
        // tree.add(4);
        // System.out.println(tree);
        // tree.add(2);
        // System.out.println(tree);

        // 3
        // tree.add(7);
        // tree.add(8);
        // System.out.println(tree);
        // tree.add(9);
        // System.out.println(tree);

        // 4
        // tree.add(7);
        // tree.add(9);
        // System.out.println(tree);
        // tree.add(8);
        // System.out.println(tree);


    }   

    // public static void main(String[] args) {
    //     UserInterface ui = new UserInterface();
    //     RedBlackTree tree = new RedBlackTree();
    //     String fx = "";

    //     do{
    //         fx = ui.menu();

    //         if(fx.charAt(0) == 'A'){
    //             Integer a = Integer.parseInt(fx.substring(1));
    //             tree.add(a);
    //             System.out.println(tree);
    //             fx = "";
    //             continue;
    //         }


    //         if(fx.charAt(0) == 'O'){
    //             System.exit(0);
    //         }


    //         if(fx.charAt(0) == 'Q'){
    //             System.exit(0);
    //         }

    //     }while(fx.equals(""));
    // }   
}