/*
 *CS350
 *Dave Nearing
 *Model for individual surveys.
 */

package csampler;

/**
 *
 * @author danearing
 */
public class CSample {

    /**
     * @param args the command line arguments
     */
    private String id;
    private String zip;
    private boolean isFederal;
    private boolean isState;
    private boolean isPrivate;
    private boolean isSelf;
    private boolean isUnemployed;
    private boolean impYes;
    private boolean impNo;
    private boolean impUnknown;
    private boolean blameR;
    private boolean blameD;
    private boolean blameO;
    private boolean blameC;

    public CSample(String id, String zip, boolean isFederal, boolean isState, boolean isPrivate, boolean isSelf, 
            boolean isUnemployed, boolean impYes, boolean impNo, boolean impUnknown, boolean blameR, boolean blameD, 
            boolean blameO, boolean blameC) {
        this.id = id;
        this.zip = zip;
        this.isFederal = isFederal;
        this.isState = isState;
        this.isPrivate = isPrivate;
        this.isSelf = isSelf;
        this.isUnemployed = isUnemployed;
        this.impYes = impYes;
        this.impNo = impNo;
        this.impUnknown = impUnknown;
        this.blameR = blameR;
        this.blameD = blameD;
        this.blameO = blameO;
        this.blameC = blameC;
    }
    
    public String getEmployment(){
        String employment = null;
        if (this.isFederal){
            employment = "Federal";
        }
        if (this.isState){
            employment = "State/Local";
        }
        if (this.isPrivate){
            employment = "Private";
        }
        if (this.isSelf){
            employment = "Self-Employed";
        }
        if (this.isUnemployed){
            employment = "Unemployed";
        }
        return employment;
    }
    
    public String getImpact(){
        String impact = null;
        if (this.impNo){
            impact = "No";
        }
        if (this.impYes){
            impact = "Yes";
        }
        if (this.impUnknown){
            impact = "Unknown";
        }
        return impact;
    }
    
    public String getBlame(){
        //build
        String blameString = null;
        String R = null;
        String D = null;
        String O = null;
        String C = null;
        if (this.blameR){
            R = "R";
        } else {
            R = "-";
        }
        if (this.blameD){
            D = "D";
        } else {
            D = "-";
        }
        if (this.blameO){
            O = "O";
        } else {
            O = "-";
        }
        if (this.blameC){
            C = "C";
        } else {
            C = "-";
        }
        blameString = R+D+O+C;
        return blameString;
    }

    public String getId() {
        return id;
    }

    public String getZip() {
        return zip;
    }

    public Boolean isIsFederal() {
        return isFederal;
    }

    public Boolean isIsState() {
        return isState;
    }

    public Boolean isIsPrivate() {
        return isPrivate;
    }

    public Boolean isIsSelf() {
        return isSelf;
    }

    public Boolean isIsUnemployed() {
        return isUnemployed;
    }

    public Boolean isImpYes() {
        return impYes;
    }

    public Boolean isImpNo() {
        return impNo;
    }

    public Boolean isImpUnknown() {
        return impUnknown;
    }

    public Boolean isBlameR() {
        return blameR;
    }

    public Boolean isBlameD() {
        return blameD;
    }

    public Boolean isBlameO() {
        return blameO;
    }

    public Boolean isBlameC() {
        return blameC;
    }
    
    
    
    public String getString() {
        String surveyString;
        surveyString = (this.id + "                            " + this.zip + "            " + this.getEmployment() + 
                "             " + this.getImpact() + "                        " + this.getBlame());
        return surveyString;
    }
    
     public int getID() {
        return Integer.parseInt(id);
    }
     
}


