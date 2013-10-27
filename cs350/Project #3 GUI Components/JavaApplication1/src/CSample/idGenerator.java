/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CSample;

/**
 *
 * @author danearing
 */
public class idGenerator {
    private int pKeyCounter;
    public String pKeyPut;
    
    public idGenerator() {
        pKeyCounter = 1;
    }
    
    public String generateId() {
        pKeyPut = Integer.toString(pKeyCounter);
        pKeyCounter = pKeyCounter + 1;
        return pKeyPut;
    }

    void decrementID() {
        pKeyCounter = pKeyCounter - 1;
    }
}
