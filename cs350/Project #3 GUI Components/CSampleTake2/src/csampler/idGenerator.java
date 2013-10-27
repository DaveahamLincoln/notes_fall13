/*
 *CS350
 *Dave Nearing
 *Tool for generating unique ids for surveys.
 */

package csampler;

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
