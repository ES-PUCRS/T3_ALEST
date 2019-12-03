package src;

import src.algorithms.tree.*;
import src.ui.UserInterface;

public class app {

    public static final boolean printOnTerminal = false;
   
    // public static void main(String[] args) {
    //     RedBlackTree tree = new RedBlackTree();

        // tree.add(21);
        // tree.add(25);
        // tree.add(3);
        // tree.add(27);
        // tree.add(11);
        // tree.add(4);
        // System.out.println(tree.positionsWidth());

        
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


    // }   

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        RedBlackTree tree = new RedBlackTree();
        String fx = "";

        do{
            fx = ui.menu();

            while(fx.equals("Statement not found")){
                System.out.println(fx);
                fx = ui.menu();
            }

            //ADD
            if(fx.charAt(0) == 'A'){
                Integer a = Integer.parseInt(fx.substring(1));
                tree.add(a);
                System.out.println(tree);
                fx = "";
                continue;
            }

            //REMOVE
            if(fx.charAt(0) == 'R'){
                Integer a = Integer.parseInt(fx.substring(1));
                System.out.println(tree.remove(a));
                fx = "";
                continue;
            }

            //PRINT
            if(fx.charAt(0) == 'P'){
                System.out.println(tree);
                fx = "";
                continue;
            }

            //CONTAINS
            if(fx.charAt(0) == 'T'){
                Integer a = Integer.parseInt(fx.substring(1));
                System.out.println(tree.contains(a));
                fx = "";
                continue;
            }

            //SIZE
            if(fx.charAt(0) == 'S'){
                System.out.println(tree.size());
                fx = "";
                continue;
            }

            //TREE HEIGHT
            if(fx.charAt(0) == 'H'){
                System.out.println(tree.height());
                fx = "";
                continue;
            }

            //TREE CLONE
            if(fx.charAt(0) == 'K'){
                System.out.println("Original tree: " + tree);
                System.out.println("Clone tree: " + tree.clone());
                fx = "";
                continue;
            }

            //TREE EMPTY
            if(fx.charAt(0) == 'N'){
                System.out.println(tree.isEmpty());
                fx = "";
                continue;
            }

            //POSITIONS
            if(fx.charAt(0) == 'C'){

                //PRE
                if(fx.charAt(1) == 'P'){
                    System.out.println(tree.positionsPre());
                    fx = "";
                    continue;
                }
                //POS
                if(fx.charAt(1) == 'X'){
                    System.out.println(tree.positionsPos());
                    fx = "";
                    continue;
                }
                //CENTRAL
                if(fx.charAt(1) == 'C'){
                    System.out.println(tree.positionsCentral());
                    fx = "";
                    continue;
                }
                //WIDTH
                if(fx.charAt(1) == 'W'){
                    System.out.println(tree.positionsWidth());
                    fx = "";
                    continue;
                }
            }

            //EXIT
            if(fx.charAt(0) == 'Q'){
                System.exit(0);
            }

        }while(fx.equals(""));
    }   
}