package src.algorithms.tree;

public class NodeLog{

    public Integer element;
    public Integer father;
    public Integer right;	
    public Integer left;
    public char color;
    
    public NodeLog(
		        	Integer father,
		        	Integer right,
		        	Integer left,
		        	char color,
		        	Integer element
					){ 
 	    this.father = father;
        this.right = right;
        this.left = left;	        
        this.color = color;
        this.element = element;
    }
}