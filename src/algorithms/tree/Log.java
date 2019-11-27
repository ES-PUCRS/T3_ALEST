package src.algorithms.tree;

import src.algorithms.tree.NodeLog;

public class Log{
	private static Log instance;

	private boolean printOnTerminal = true;
	private boolean log = true;

	private Log(){}

	public static Log getInstance() {
        if (instance == null)
            instance = new Log();
        return instance;
    }

    public String add(Integer added){
    	String log = "";
    		if(this.log){
    			log += "Added on root: {" + added + "}";
    			if(printOnTerminal)
		            System.out.println(log);
    		}
    	return log;
    }
    public String add(Integer father, Integer son){
    	String log = "";
    		if(this.log){
    			log += "Added: {" + father + "{";
    			if(father > son)
    				log += "L";
				else
					log += "R";
				log += son + "\'R\'}}"; 
    			if(printOnTerminal)
		            System.out.println(log);
    		}
    	return log;
    }

	public String remove(NodeLog nAux, NodeLog leftLeaf, NodeLog rightLeaf, Integer nAuxrightfather){

		String log = "";
	    if(this.log){
	        //---------LEFT-CHANGE---------------------------------------------------------------------------//
	        if(leftLeaf.left != null && nAux.left != null){
	        	log += "leftLeaf.left = nAux.left => "+leftLeaf+"("+leftLeaf.left+")"+" = "+nAux+"("+nAux.left+")\n";
	        	if(printOnTerminal)
		            System.out.println("leftLeaf.left = nAux.left => "+
		                leftLeaf+"("+leftLeaf.left+")"+" = "+nAux+"("+nAux.left+")");
	        }else if(leftLeaf.left == null){
	        	log += "leftLeaf.left = nAux.left => "+"null"+" = "+nAux+"("+nAux.left+")\n";
	        	if(printOnTerminal)
		            System.out.println("leftLeaf.left = nAux.left => "+
		                "null"+" = "+nAux+"("+nAux.left+")");
	        }else{
	        	log +="leftLeaf.father = nAux.father => "+leftLeaf+"("+leftLeaf.left+")"+" = "+"null\n";
	        	if(printOnTerminal)
		            System.out.println("leftLeaf.father = nAux.father => "+
		                leftLeaf+"("+leftLeaf.left+")"+" = "+"null");
	        }
	        //---------RIGHT-CHANGE---------------------------------------------------------------------------//
	        if(rightLeaf.right != null && nAux.right != null){
	        	log +="rightLeaf.right = nAuxright => "+rightLeaf+"("+rightLeaf.right+")"+" = "+nAux+"("+nAux.right+")\n";
	        	if(printOnTerminal)
		            System.out.println("rightLeaf.right = nAuxright => "+
		                rightLeaf+"("+rightLeaf.right+")"+" = "+nAux+"("+nAux.right+")");
	        }else if(rightLeaf.right == null){
	        	log +="rightLeaf.right = nAux.right => "+"null"+" = "+nAux+"("+nAux.right+")\n";
	        	if(printOnTerminal)
		            System.out.println("rightLeaf.right = nAux.right => "+
		                "null"+" = "+nAux+"("+nAux.right+")");
	        }else{
	        	log +="rightLeaf.father = nAux.father => "+rightLeaf+"("+rightLeaf.right+")"+" = "+"null\n";
	        	if(printOnTerminal)
		            System.out.println("rightLeaf.father = nAux.father => "+
		                rightLeaf+"("+rightLeaf.right+")"+" = "+"null");	
            }        
            //---------RIGHT-FATHER-CHANGE-----------------------------------------------------------------------//
	        if(nAuxrightfather != null && rightLeaf != null){
	        	log +="nAux.right.father = rightLeaf => "+nAux.right+"("+nAuxrightfather+")"+" = "+rightLeaf+"\n";
	        	if(printOnTerminal)
		            System.out.println("nAux.right.father = rightLeaf => "+
		                nAux.right+"("+nAuxrightfather+")"+" = "+rightLeaf);
	        }else if(nAuxrightfather == null){
	        	log +="nAux.right.father = rightLeaf => "+"null"+" = "+rightLeaf+"\n";
	        	if(printOnTerminal)
		            System.out.println("nAux.right.father = rightLeaf => "+
		                "null"+" = "+rightLeaf);
	        }else{
	        	log +="nAux.right.father = rightLeaf => "+nAux.right+"("+nAuxrightfather+")"+" = "+"null\n";
	        	if(printOnTerminal)
		            System.out.println("nAux.right.father = rightLeaf => "+
		                nAux.right+"("+nAuxrightfather+")"+" = "+"null");
	        }
	        //---------FATHER-CHANGE---------------------------------------------------------------------------//
	        if(leftLeaf.father != null && nAux.father != null){
	        	log +="leftLeaf.father = nAux.father => "+leftLeaf+"("+leftLeaf.father+")"+" = "+nAux+"("+nAux.father+")\n";
	        	if(printOnTerminal)
		            System.out.println("leftLeaf.father = nAux.father => "+
		                leftLeaf+"("+leftLeaf.father+")"+" = "+nAux+"("+nAux.father+")");
	        }else if(leftLeaf.father == null){
	        	log +="leftLeaf.father = nAux.father => "+"null"+" = "+nAux+"("+nAux.father+")\n";
	        	if(printOnTerminal)
		            System.out.println("leftLeaf.father = nAux.father => "+
		                "null"+" = "+nAux+"("+nAux.father+")");
	        }else{
	        	log +="leftLeaf.father = nAux.father => "+leftLeaf+"("+leftLeaf.father+")"+" = "+"null\n";
	        	if(printOnTerminal)
		            System.out.println("leftLeaf.father = nAux.father => "+
		                leftLeaf+"("+leftLeaf.father+")"+" = "+"null");
            }
	    }
	    return log;
	}

	public String replaceChild(Integer father, Integer n, Integer r){
    System.out.println("got here");
		String log = "";
        if(this.log){
            if(father != null){
            	log += "Father: " + father + "\n";
	        	if(printOnTerminal)
                	System.out.println("Father: " + father);
            }else{
            	log += "Father: " + "null" + "\n";
	        	if(printOnTerminal)
               		System.out.println("Father: " + "null");
            }if(n != null){
            	log += "Child: " + n + "\n";
	        	if(printOnTerminal)
                	System.out.println("Child: " + n);
            }else{
            	log += "Child: " + "null" + "\n";
	        	if(printOnTerminal)
                	System.out.println("Child: " + "null");
            }if(r != null){
            	log += "Replace: " + r +"\n";
	        	if(printOnTerminal)
                	System.out.println("Replace: " + r);
            }else
            	log += "Replace: " + "null\n";
	        	if(printOnTerminal)
                	System.out.println("Replace: " + "null\n");
        }
        return log;    
	}

	public String replaceChild(Integer n, Integer r){
		String log = "";
	    if(this.log)
	    	if(n != null && r != null)
	    		log += n + " replaced on root by " + r;
	    	else if(n != null)
	    		log += n + " replaced on root by " + "null";
	    	else
	    		log += "null" + " replaced on root by " + r;
        	
        	if(printOnTerminal)
	        	System.out.println(log);
        return log;   
	}

	public String nodeTeste(NodeLog n){
		System.out.println("{"+n.element+"}");
		return "";
	}
}