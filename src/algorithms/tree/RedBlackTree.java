package src.algorithms.tree;

public class RedBlackTree extends BinarySearchTree{

	
    // Classe interna privada
    protected static final class Node {
        public Integer element;
        public Node father;
        public Node left;
        public Node right;
        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }


	public RedBlackTree(){
		super();
	}	
    @Override
    public String toString(){    
    	return super.toString();
    }
    private String toStringAux(Node n){
        String line = "{123";
        
        if(n != null)
            line += n.element;

            if(n.left != null)
                line += ", " + toStringAux(n.left);
            if(n.right != null)
                line += ", " + toStringAux(n.right);
        
        line += "}";
        return line;
    }
}