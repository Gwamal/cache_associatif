/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoire_cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Nathan Vaty
 */
public class CacheAsso {
    
     private int tailleBloc;
     private int nbLignes;
     private int nbEntrees;
     
     //private TreeSet<Case> caches;
     private int[][] lru;
     private int[][] etiquettes;
    
    public CacheAsso(int nbL, int nbE) {
        this.tailleBloc = 32;
        this.nbLignes = (int) Math.pow(2,nbL);
        this.nbEntrees = nbE;
        System.out.println(this.nbLignes);
        lru = new int [this.nbLignes][nbE];
        etiquettes = new int [this.nbLignes][nbE];
        
        for(int i=0; i<nbLignes;i++){
            for(int j=0;j<nbE;j++){
               // Attention !! lru[i][j]= -1;
               // Attention j'ai dit
               lru[i][j]= 4 - j;
            }
        }
    }
    public void triLRU(int ligne,int prem) {
        
        if(lru[ligne][prem] != 1) {
            lru[ligne][prem] = 1;
            for (int i=0; i<nbEntrees;i++) {
                if(i != prem) {
                   lru[ligne][i]++; 
                }
            }
        } 
        
        
    }
    
    public int getLastLRU(int ligne) {
        int maxIndice = 0;
        for (int i=0; i<nbEntrees; i++) {
            if(lru[ligne][i] == 4) {
                maxIndice = i;
            }
        }
        System.out.println(maxIndice);
        return maxIndice;
    }
    
    public void simuCache(String chemin) throws FileNotFoundException {
        String fichier = "fichiers/"+ chemin + ".txt";
        
        int succes = 0;
        int echec = 0;
        double tempsTotal = 0.;
        double compteur = 0;
        boolean stop;
        
        Scanner entree = new Scanner(new File(fichier));
        String nextLigne;
        
        int donnee;
        int ligne;
        int etiquette;
        
        while(entree.hasNext()) {
            stop = false;
            nextLigne = entree.next();
            donnee =  Integer.parseInt(nextLigne.substring(0,nextLigne.length()-2));
            
            ligne = (donnee/this.tailleBloc)%nbLignes;
            etiquette = (donnee/this.tailleBloc)/nbLignes;
            for (int i=0; i < nbEntrees; i++){
                
                if (etiquettes[ligne][i] == etiquette && !stop) {
                    stop = true;
                    succes++;
                    tempsTotal+=5;
                    triLRU(ligne,i);
                }
            }
            if (!stop) {
                echec++;
                int indice = getLastLRU(ligne);
                etiquettes[ligne][indice] = etiquette;
                tempsTotal+= 50;
                triLRU(ligne,indice);
            }
           
            compteur++;
        }
        
        System.out.println("succès: " + succes );
        System.out.println("echec: " + echec );
        System.out.println("temps moyen: " + tempsTotal/compteur + " ns");
    }
    
    
}






















