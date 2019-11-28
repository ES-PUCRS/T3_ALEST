package src;

import src.algorithms.tree.NodeLog;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.FileWriter;
import java.util.Scanner;
import java.lang.String;
import java.io.File;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    


public class Log{
	private static PrintWriter logDataWriter;
	private static Path logDateTime;
	private static Log instance;

	private static DateTimeFormatter time;

	private static final String command = "";
	private boolean printOnTerminal = true;
	private boolean log = true;

	private Log(){
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH'H'.mm'M'.ss'S'");
		time = DateTimeFormatter.ofPattern("HH:mm:ss:SSS' - '"); 
        
        String filePath = Paths.get("").toAbsolutePath().toString();
        LocalDateTime now = LocalDateTime.now(); 
        filePath += "\\SavedLogs\\" + "LogRuntime_" + dt.format(now) + ".txt";   
        
        logDateTime =  Paths.get(filePath);
		String welcome = "";

		try{
			File logFile = new File(logDateTime.toString());

			if(!logFile.exists()){
            	logFile.createNewFile();

				welcome = "Log file has been created on " +
						  logDateTime.subpath((logDateTime.getNameCount()-3), (logDateTime.getNameCount()-1)) + 
					 	  ",\nat file " +
	  					  logDateTime.getFileName() + ".";

				if(printOnTerminal)
					System.out.println(welcome + "\n");
			}
		
			logDataWriter = new PrintWriter(new FileWriter(logFile, true));
	        logDataWriter.println(welcome);

			String logEnviroment =
				"\nProcessor: "+System.getenv("PROCESSOR_IDENTIFIER") 	+ ". " +
				"\nComputer: " +System.getenv("COMPUTERNAME")	 		+ ", " +
				"User: " + 		System.getenv("USERNAME") 				+ "."  +
				"\nSystem: " +	System.getenv("OS") 					+ ", " +
								System.getenv("NUMBER_OF_PROCESSORS")	+ " Core(s)," +
				" v. " + 		System.getenv("PROCESSOR_REVISION") 	+ ".\n";

			logDataWriter.append(logEnviroment);		
	        logDataWriter.close();
        
        }catch(IOException x){
             System.err.format("Erro de E/S: %s%n", x);
        }
		
	}
	
	public static Log getInstance() {
        if (instance == null)
            instance = new Log();
        return instance;
    }

    public String add(NodeLog added){
    	String log = "";
			log += "Added on root: {" + added.element + "}";
			if(printOnTerminal)
	            System.out.println(log);
    		publishLog(command + log);
    	return log;
    }
    public String add(NodeLog father, NodeLog son){
    	String log = "";
    			log += "Added: {" + father.element + "'"
    							  + father.color + "'" +"{";
    			if(father.element > son.element)
    				log += "L";
				else
					log += "R";
				log += son.element + "\'R\'}}"; 
    			if(printOnTerminal)
		            System.out.println(log);
    		publishLog(command + log);
    	return log;
    }

	public String remove(NodeLog nAux, NodeLog leftLeaf, NodeLog rightLeaf){
		String log = "";
		Integer nAuxI = null;
		Integer leftLeafI = null;
		Integer rightLeafI = null;
		if(nAux != null)
			nAuxI = nAux.element;
		if(leftLeaf != null)				
			leftLeafI = leftLeaf.element;
    	if(rightLeaf != null)
			rightLeafI = rightLeaf.element;

    	String paramLog ="Remove: " + nAuxI +
						 "\nrightLeaf: " + rightLeafI +
						 "\nleftLeaf: " + leftLeafI;

	 	if(printOnTerminal)
	 		System.out.println(paramLog);

		log += paramLog;

	    	if(nAux != null &&  leftLeaf != null && rightLeaf != null){
			System.out.println("LOGGEDin");
		        //---------LEFT-CHANGE---------------------------------------------------------------------------//
		        if(printOnTerminal)
		        	System.out.println("LEFT-CHANGE");
		        if(leftLeaf.left != null && nAux.left != null){
		        	log += "leftLeaf.left = nAux.left => "+leftLeaf.element+"("+leftLeaf.left+")"+" = "+nAux.element+"("+nAux.left+")\n";
		        	if(printOnTerminal)
			            System.out.println("leftLeaf.left = nAux.left => "+
			                leftLeaf.element+"("+leftLeaf.left+")"+" = "+nAux.element+"("+nAux.left+")");
		        }else if(leftLeaf.left == null){
		        	log += "leftLeaf.left = nAux.left => "+"null"+" = "+nAux.element+"("+nAux.left+")\n";
		        	if(printOnTerminal)
			            System.out.println("leftLeaf.left = nAux.left => "+
			                "null"+" = "+nAux.element+"("+nAux.left+")");
		        }else{
		        	log +="leftLeaf.father = nAux.father => "+leftLeaf.element+"("+leftLeaf.left+")"+" = "+"null\n";
		        	if(printOnTerminal)
			            System.out.println("leftLeaf.father = nAux.father => "+
			                leftLeaf.element+"("+leftLeaf.left+")"+" = "+"null");
		        }
		        //---------RIGHT-CHANGE---------------------------------------------------------------------------//
		       	if(printOnTerminal)
		       		System.out.println("RIGHT-CHANGE");
		        if(rightLeaf.right != null && nAux.right != null){
		        	log +="rightLeaf.right = nAuxright => "+rightLeaf+"("+rightLeaf.right+")"+" = "+nAux.element+"("+nAux.right+")\n";
		        	if(printOnTerminal)
			            System.out.println("rightLeaf.right = nAuxright => "+
			                rightLeaf.element+"("+rightLeaf.right+")"+" = "+nAux.element+"("+nAux.right+")");
		        }else if(rightLeaf.right == null){
		        	log +="rightLeaf.right = nAux.right => "+"null"+" = "+nAux.element+"("+nAux.right+")\n";
		        	if(printOnTerminal)
			            System.out.println("rightLeaf.right = nAux.right => "+
			                			   "null"+" = "+nAux.element+"("+nAux.right+")");
		        }else{
		        	log +="rightLeaf.father = nAux.father => "+rightLeaf.element+"("+rightLeaf.right+")"+" = "+"null\n";
		        	if(printOnTerminal)
			            System.out.println("rightLeaf.father = nAux.father => "+
			                rightLeaf.element+"("+rightLeaf.right+")"+" = "+"null");	
	            }     
	            //---------RIGHT-FATHER-CHANGE-----------------------------------------------------------------------//
		        if(printOnTerminal)
		        	System.out.println("RIGHT-FATHER-CHANGE");
		        if(nAux != null && rightLeaf != null){
		        	log +="nAux.right.father = rightLeaf => "+nAux.right+"("+nAux.element+")"+" = "+rightLeaf.element+"\n";
		        	if(printOnTerminal)
			            System.out.println("nAux.right.father = rightLeaf => "+
			                nAux.right+"("+nAux.element+")"+" = "+rightLeaf.element);
		        }else if(nAux == null){
		        	log +="nAux.right.father = rightLeaf => "+"null"+" = "+rightLeaf.element+"\n";
		        	if(printOnTerminal)
			            System.out.println("nAux.right.father = rightLeaf => "+
			                "null"+" = "+rightLeaf.element);
		        }else{
		        	log +="nAux.right.father = rightLeaf => "+nAux.right+"("+nAux.element+")"+" = "+"null\n";
		        	if(printOnTerminal)
			            System.out.println("nAux.right.father = rightLeaf => "+
			                nAux.right+"("+nAux.element+")"+" = "+"null");
		        }
		        //---------FATHER-CHANGE---------------------------------------------------------------------------//
		        if(printOnTerminal)
		        	System.out.println("FATHER-CHANGE");
		        if(leftLeaf.father != null && nAux.father != null){
		        	log +="leftLeaf.father = nAux.father => "+leftLeaf.element+"("+leftLeaf.father+")"+" = "+nAux.element+"("+nAux.father+")\n";
		        	if(printOnTerminal)
			            System.out.println("leftLeaf.father = nAux.father => "+
			                leftLeaf.element+"("+leftLeaf.father+")"+" = "+nAux.element+"("+nAux.father+")");
		        }else if(leftLeaf.father == null){
		        	log +="leftLeaf.father = nAux.father => "+"null"+" = "+nAux.element+"("+nAux.father+")\n";
		        	if(printOnTerminal)
			            System.out.println("leftLeaf.father = nAux.father => "+
			                "null"+" = "+nAux.element+"("+nAux.father+")");
		        }else{
		        	log +="leftLeaf.father = nAux.father => "+leftLeaf.element+"("+leftLeaf.father+")"+" = "+"null\n";
		        	if(printOnTerminal)
			            System.out.println("leftLeaf.father = nAux.father => "+
			                leftLeaf.element+"("+leftLeaf.father+")"+" = "+"null");
	            }
		    }           
			publishLog(command + log);
	    return log;
	}

	public String replaceChild(NodeLog father, NodeLog n, NodeLog r){
		String log = "";

			if(n != null){
            	log += "Replace: " + n.element + "\n";
	        	if(printOnTerminal)
                	System.out.println("Child: " + n.element);
            }else{
            	log += "Replace: " + "null" + "\n";
	        	if(printOnTerminal)
                	System.out.println("Child: " + "null");
            }

            if(father != null){
            	log += "On father: " + father.element + "\n";
	        	if(printOnTerminal)
                	System.out.println("Father: " + father.element);
            }else{
            	log += "On father: " + "null" + "\n";
	        	if(printOnTerminal)
               		System.out.println("Father: " + "null");
            }

            if(r != null){
            	log += "With child: " + r.element +"\n";
	        	if(printOnTerminal)
                	System.out.println("Replace: " + r.element);
            }else
            	log += "With child: " + "null\n";
	        	if(printOnTerminal)
                	System.out.println("Replace: " + "null\n");

			publishLog(command + log);
        return log;    
	}

	public String replaceChild(NodeLog n, NodeLog r){
		String log = ""; 
		
	    	if(n != null && r != null)
	    		log += n.element + " replaced on root by " + r.element;
	    	else if(n != null)
	    		log += n.element + " replaced on root by " + "null";
	    	else
	    		log += "null" + " replaced on root by " + r.element;
        	
        	if(printOnTerminal)
	        	System.out.println(log);
			publishLog(command + log);
        return log;   
	}


	public void exception(Thread t, Throwable e){
		String exception = "THROWN EXCEPTION\n";
		exception += "Thread "+ t.getId() +", " + t.getState() + "\n";
		exception += e.toString();

		publishLog(exception);
	}


	private void publishLog(String data){
		if(data == null)
			return;

		try{
			File logFile = new File(logDateTime.toString());

			if(!logFile.exists()){
            	logFile.createNewFile();
			
				if(printOnTerminal)
					System.out.println("New log file has been created: " + logDateTime.getFileName());
			}
		
			logDataWriter = new PrintWriter(new FileWriter(logFile, true));
        
        }catch(IOException x){
             System.err.format("Erro de E/S: %s%n", x);
        }

		data = data.replaceAll("\n", "\n               ");
		logDataWriter.append("\n" + time.format(LocalDateTime.now()) + data);
        logDataWriter.close();
	}

}