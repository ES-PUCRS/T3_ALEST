package src.ui;

import java.util.regex.Pattern;
import java.util.Scanner;

public class UserInterface{

	public UserInterface() {}

	public static String menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("\n\n----------------Menu----------------");
        System.out.println("1 - Adicionar elemento");
        System.out.println("2 - Remover elemento");
        System.out.println("3 - Remover branch");
        System.out.println("4 - Procurar elemento");

        System.out.println("\n99 - Sair");
        
            String fct = in.nextLine();
            fct = fct.toUpperCase();

        if(fct.equals("99") || fct.equals("SAIR")) return"Q";


        if(fct.equals("1") || fct.equals("ADICIONAR")){
            do{
                System.out.println("Valor do elemento: ");   
    
                    fct = in.nextLine();
                    fct = fct.toUpperCase();

            	if(Pattern.matches("[0-9]+", fct)){
            		fct = 'A' + fct;
            		return(fct);
            	}
                System.out.println("Valor invalido, digite um valor valido.");   
            }while(true);
        }
        if(fct.equals("2") || fct.equals("ADICIONAR")){
            do{
                System.out.println("Valor do elemento: ");   
    
                    fct = in.nextLine();
                    fct = fct.toUpperCase();

            	if(Pattern.matches("[0-9]+", fct)){
            		fct = 'A' + fct;
            		return(fct);
            	}
                System.out.println("Valor invalido, digite um valor valido.");   
            }while(true);
        }
        return "Statement not found";
    }
}