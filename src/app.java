package src;

import src.algorithms.tree.*;
import src.ui.UserInterface;

public class app {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        RedBlackTree tree = new RedBlackTree();
        String fx = "";

        do{
            fx = ui.menu();

            if(fx.charAt(0) == 'A'){
                Integer a = Integer.parseInt(fx.substring(1));
                tree.add(a);
                System.out.println(tree);
                fx = "";
                continue;
            }


            if(fx.charAt(0) == 'O'){
                System.exit(0);
            }


            if(fx.charAt(0) == 'Q'){
                System.exit(0);
            }

        }while(fx.equals(""));
    }   
}