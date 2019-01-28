/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoire_cache;

import java.io.FileNotFoundException;

/**
 *
 * @author Nathan Vaty
 */
public class Cache_associatif {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        CacheAsso cache = new CacheAsso(3,2);
        
        cache.simuCache("matrice10");
    }
    
}






