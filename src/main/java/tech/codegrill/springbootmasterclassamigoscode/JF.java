package tech.codegrill.springbootmasterclassamigoscode;

import java.util.Scanner;

public class JF {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Initialisation by Junior Medjo ");
        String chaine;
        String mot;
        int occurence = 0;
        boolean trouve;
        System.out.println("entrez une chaine de caractere");
        chaine = scan.nextLine();
        System.out.println("la chaine entree est " + chaine + " et sa taille est " + chaine.length());
        System.out.println(" ");
        System.out.println("Veuillez entrer un mot et nous allons verifier qu'il existe dans la chaine");
        mot = scan.nextLine();
        int i = 0;
        while (i < chaine.length() - 1) {
            trouve = false;
            if ((chaine.charAt(i) == mot.charAt(0))) {
                int j;
                for (j = 0; j < mot.length(); j++) {
                    if (chaine.charAt(i) == mot.charAt(j)) {
                        trouve = true;
                    } else {
                        trouve = false;
                    }
                    i++;

                }
                occurence += 1;
            }
        }
        System.out.println("Dans la chaine " + chaine + " on retrouvre le mot " + mot + " " + occurence + " fois");
    }
}