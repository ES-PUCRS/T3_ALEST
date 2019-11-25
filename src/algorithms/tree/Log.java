package src.algorithms.tree;

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


	public String remove(Integer nAux, Integer nAuxleft, Integer nAuxright, Integer nAuxfather, Integer nAuxrightfather,
                         Integer leftLeaf, Integer leftLeafleft, Integer leftLeaffather,
                         Integer rightLeaf, Integer rightLeafright){

		String log = "";
	    if(this.log){
	        //---------LEFT-CHANGE---------------------------------------------------------------------------//
	        if(leftLeafleft != null && nAuxleft != null){
	        	log += "leftLeaf.left = nAux.left => "+leftLeaf+"("+leftLeafleft+")"+" = "+nAux+"("+nAuxleft+")\n";
	        	if(printOnTerminal)
		            System.out.println("leftLeaf.left = nAux.left => "+
		                leftLeaf+"("+leftLeafleft+")"+" = "+nAux+"("+nAuxleft+")");
	        }else if(leftLeafleft == null){
	        	log += "leftLeaf.left = nAux.left => "+"null"+" = "+nAux+"("+nAuxleft+")\n";
	        	if(printOnTerminal)
		            System.out.println("leftLeaf.left = nAux.left => "+
		                "null"+" = "+nAux+"("+nAuxleft+")");
	        }else{
	        	log +="leftLeaf.father = nAux.father => "+leftLeaf+"("+leftLeafleft+")"+" = "+"null\n";
	        	if(printOnTerminal)
		            System.out.println("leftLeaf.father = nAux.father => "+
		                leftLeaf+"("+leftLeafleft+")"+" = "+"null");
	        }
	        //---------RIGHT-CHANGE---------------------------------------------------------------------------//
	        if(rightLeafright != null && nAuxright != null){
	        	log +="rightLeaf.right = nAuxright => "+rightLeaf+"("+rightLeafright+")"+" = "+nAux+"("+nAuxright+")\n";
	        	if(printOnTerminal)
		            System.out.println("rightLeaf.right = nAuxright => "+
		                rightLeaf+"("+rightLeafright+")"+" = "+nAux+"("+nAuxright+")");
	        }else if(rightLeafright == null){
	        	log +="rightLeaf.right = nAux.right => "+"null"+" = "+nAux+"("+nAuxright+")\n";
	        	if(printOnTerminal)
		            System.out.println("rightLeaf.right = nAux.right => "+
		                "null"+" = "+nAux+"("+nAuxright+")");
	        }else{
	        	log +="rightLeaf.father = nAux.father => "+rightLeaf+"("+rightLeafright+")"+" = "+"null\n";
	        	if(printOnTerminal)
		            System.out.println("rightLeaf.father = nAux.father => "+
		                rightLeaf+"("+rightLeafright+")"+" = "+"null");	
            }        
            //---------RIGHT-FATHER-CHANGE-----------------------------------------------------------------------//
	        if(nAuxrightfather != null && rightLeaf != null){
	        	log +="nAux.right.father = rightLeaf => "+nAuxright+"("+nAuxrightfather+")"+" = "+rightLeaf+"\n";
	        	if(printOnTerminal)
		            System.out.println("nAux.right.father = rightLeaf => "+
		                nAuxright+"("+nAuxrightfather+")"+" = "+rightLeaf);
	        }else if(nAuxrightfather == null){
	        	log +="nAux.right.father = rightLeaf => "+"null"+" = "+rightLeaf+"\n";
	        	if(printOnTerminal)
		            System.out.println("nAux.right.father = rightLeaf => "+
		                "null"+" = "+rightLeaf);
	        }else{
	        	log +="nAux.right.father = rightLeaf => "+nAuxright+"("+nAuxrightfather+")"+" = "+"null\n";
	        	if(printOnTerminal)
		            System.out.println("nAux.right.father = rightLeaf => "+
		                nAuxright+"("+nAuxrightfather+")"+" = "+"null");
	        }
	        //---------FATHER-CHANGE---------------------------------------------------------------------------//
	        if(leftLeaffather != null && nAuxfather != null){
	        	log +="leftLeaf.father = nAux.father => "+leftLeaf+"("+leftLeaffather+")"+" = "+nAux+"("+nAuxfather+")\n";
	        	if(printOnTerminal)
		            System.out.println("leftLeaf.father = nAux.father => "+
		                leftLeaf+"("+leftLeaffather+")"+" = "+nAux+"("+nAuxfather+")");
	        }else if(leftLeaffather == null){
	        	log +="leftLeaf.father = nAux.father => "+"null"+" = "+nAux+"("+nAuxfather+")\n";
	        	if(printOnTerminal)
		            System.out.println("leftLeaf.father = nAux.father => "+
		                "null"+" = "+nAux+"("+nAuxfather+")");
	        }else{
	        	log +="leftLeaf.father = nAux.father => "+leftLeaf+"("+leftLeaffather+")"+" = "+"null\n";
	        	if(printOnTerminal)
		            System.out.println("leftLeaf.father = nAux.father => "+
		                leftLeaf+"("+leftLeaffather+")"+" = "+"null");
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
}