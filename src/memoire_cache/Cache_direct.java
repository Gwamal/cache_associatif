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
public class Cache_direct {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        
        Cache monCache1 = new Cache(32,2);
        Cache monCache2 = new Cache(32,3);
        Cache monCache3 = new Cache(32,4);
        Cache monCache4 = new Cache(32,5);
        Cache monCache5 = new Cache(32,6);
        Cache monCache6 = new Cache(32,7);
        
        monCache1.simuCacheDirect("matrice10");
        monCache2.simuCacheDirect("matrice10");
        monCache3.simuCacheDirect("matrice10");
        monCache4.simuCacheDirect("matrice10");
        monCache5.simuCacheDirect("matrice10");
        monCache6.simuCacheDirect("matrice10");
        
        
    }
    
}





























