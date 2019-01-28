/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoire_cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Nathan Vaty
 */
public class Cache {
    
    private int tailleBloc;
    
    private int nbLigne;
    
    private int[][] cache;
    
    public Cache(int tailleBloc, int nbLigne) {
        this.tailleBloc = tailleBloc;
        this.nbLigne = (int) Math.pow(2,nbLigne);
        this.cache = new int[this.nbLigne][2];
    }
    
    public void simuCacheDirect(String chemin) throws FileNotFoundException {
        String fichier = "fichiers/"+ chemin + ".txt";
        
        int succes = 0;
        int echec = 0;
        double tempsTotal = 0.;
        double compteur = 0;
        
        Scanner entree = new Scanner(new File(fichier));
        String nextLigne;
        
        int donnee;
        int ligne;
        int etiquette;
        
        while(entree.hasNext()) {
            nextLigne = entree.next();
            donnee =  Integer.parseInt(nextLigne.substring(0,nextLigne.length()-2));
            
            ligne = (donnee/this.tailleBloc)%nbLigne;
            etiquette = (donnee/this.tailleBloc)/nbLigne;
            if (this.cache[ligne][1] == etiquette) {
                succes++;
                tempsTotal+= 5;
            } else {
                echec++;
                this.cache[ligne][1] = etiquette;
                tempsTotal+= 50;
            }
            compteur++;
        }
        
        System.out.println("succès: " + succes );
        System.out.println("echec: " + echec );
        System.out.println("temps moyen: " + tempsTotal/compteur + " ns");
    }
}























