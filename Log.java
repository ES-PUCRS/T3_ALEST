public class Log{
	private boolean log = true;
	
	public String remove(){ 
	    if(log == true){
	        //---------LEFT-CHANGE---------------------------------------------------------------------------//
	        if(leftLeaf.left != null && nAux.left != null)
	            System.out.println("leftLeaf.left = nAux.left => "+
	                leftLeaf.element+"("+leftLeaf.left.element+")"+" = "+nAux.element+"("+nAux.left.element+")");
	        else if(leftLeaf.left == null)
	            System.out.println("leftLeaf.left = nAux.left => "+
	                "null"+" = "+nAux.element+"("+nAux.left.element+")");
	        else
	            System.out.println("leftLeaf.father = nAux.father => "+
	                leftLeaf.element+"("+leftLeaf.left.element+")"+" = "+"null");
	        //---------RIGHT-CHANGE---------------------------------------------------------------------------//
	        if(rightLeaf.right != null && nAux.right != null)
	            System.out.println("rightLeaf.right = nAux.right => "+
	                rightLeaf.element+"("+rightLeaf.right.element+")"+" = "+nAux.element+"("+nAux.right.element+")");
	        else if(rightLeaf.right == null)
	            System.out.println("rightLeaf.right = nAux.right => "+
	                "null"+" = "+nAux.element+"("+nAux.right.element+")");
	        else
	            System.out.println("rightLeaf.father = nAux.father => "+
	                rightLeaf.element+"("+rightLeaf.right.element+")"+" = "+"null");
	        //---------FATHER-CHANGE---------------------------------------------------------------------------//
	        if(leftLeaf.father != null && nAux.father != null)
	            System.out.println("leftLeaf.father = nAux.father => "+
	                leftLeaf.element+"("+leftLeaf.father.element+")"+" = "+nAux.element+"("+nAux.father.element+")");
	        else if(leftLeaf.father == null)
	            System.out.println("leftLeaf.father = nAux.father => "+
	                "null"+" = "+nAux.element+"("+nAux.father.element+")");
	        else
	            System.out.println("leftLeaf.father = nAux.father => "+
	                leftLeaf.element+"("+leftLeaf.father.element+")"+" = "+"null");
	    }
	}

	public String replaceChild(Node father, Node n, Node r){
        if(log == true){
            if(father != null)
                System.out.println("Father: " + father.element);
            else
                System.out.println("Father: " + "null");
            if(n != null)
                System.out.println("Child: " + n.element);
            else
                System.out.println("Child: " + "null");
            if(r != null)
                System.out.println("Replace: " + r.element);
            else
                System.out.println("Replace: " + "null\n");
        }    
	}
	public String replaceChild(Node n, Node r){
	    if(log == true)
	        System.out.println(n.element + " replaced on root by " + r.element);        
	}
}