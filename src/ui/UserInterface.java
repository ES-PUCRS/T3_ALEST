 package src.ui;

import java.util.regex.Pattern;
import java.util.Scanner;

public class UserInterface{

	public UserInterface() {}

	public static String menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("\n\n----------------Menu----------------");
        System.out.println("1 - Adicionar cliente");
        System.out.println("2 - Remover cliente");
        System.out.println("3 - Procurar cliente");
        System.out.println("4 - Mostrar árvore");

        System.out.println("\n5 - PRE order");
        System.out.println("6 - POS order");
        System.out.println("7 - Central");
        System.out.println("8 - Width");

        System.out.println("\n9 - Tree size");
        System.out.println("10 - Tree height");
        System.out.println("11 - Tree clone");
        System.out.println("12 - Tree empty");
        System.out.println("13 - Contains");

        System.out.println("\n99 - Sair");
        
            String fct = ""; 
            fct = in.nextLine();
            fct = fct.toUpperCase();

        if(fct.equals("99") || fct.equals("SAIR")) return"Q";


        if(fct.equals("1") || fct.equals("ADICIONAR")){
            do{
                System.out.println("CPF do cliente: ");   
    
                    fct = in.nextLine();
                    fct = fct.toUpperCase();

            	if(Pattern.matches("[0-9]+", fct)){
            		fct = 'A' + fct;
            		return(fct);
            	}

                System.out.println("Valor invalido, digite um valor valido.");   
            }while(true);
        }
        if(fct.equals("2") || fct.equals("Remover cliente")){
            do{
                System.out.println("CPF do cliente: ");   
    
                    fct = in.nextLine();
                    fct = fct.toUpperCase();

            	if(Pattern.matches("[0-9]+", fct)){
            		fct = 'R' + fct;
            		return(fct);
            	}
                System.out.println("Valor invalido, digite um valor valido.");   
            }while(true);
        }

        if(fct.equals("3") || fct.equals("PROCURAR")){
            do{
                System.out.println("CPF do cliente: ");   
    
                    fct = in.nextLine();
                    fct = fct.toUpperCase();

                if(Pattern.matches("[0-9]+", fct)){
                    fct = 'G' + fct;
                    return(fct);
                }
                System.out.println("Valor invalido, digite um valor valido.");   
            }while(true);
        }

        if(fct.equals("13") || fct.equals("CONTAINS")){
            do{
                System.out.println("CPF do cliente: ");   
    
                    fct = in.nextLine();
                    fct = fct.toUpperCase();

                if(Pattern.matches("[0-9]+", fct)){
                    fct = 'T' + fct;
                    return(fct);
                }
                System.out.println("Valor invalido, digite um valor valido.");   
            }while(true);
        }

        
        if(fct.equals("4") || fct.equals("IMPRIMIR")){
            return("P");
        }




        if(fct.equals("5") || fct.equals("PRE")){
            return("CP");
        }
        if(fct.equals("6") || fct.equals("POS")){
            return("CX");
        }
        if(fct.equals("7") || fct.equals("CENTRAL")){
            return("CC");
        }
        if(fct.equals("8") || fct.equals("WIDTH")){
            return("CW");
        }




        if(fct.equals("9") || fct.equals("SIZE")){
            return("S");
        }
        if(fct.equals("10") || fct.equals("HEIGHT")){
            return("H");
        }



        if(fct.equals("11") || fct.equals("CLONE")){
            return("K");
        }
        if(fct.equals("12") || fct.equals("EMPTY")){
            return("N");
        }

        return "Statement not found";
    }
}