/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoire_cache;

/**
 *
 * @author Nathan Vaty
 */
public class Case {
    
    /* -1 quand LRU pas valide */
    private int lru;
    
    private int etiquette;
    
    public Case() {
        this.lru = -1;
        this.etiquette = 0;
    }
}


