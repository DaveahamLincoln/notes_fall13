/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CSample;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

/**
 *
 * @author danearing
 */
public class Survey {
    private String id;
    private String zip;
    private String employment;
    private String impact;
    private String R;
    private String D;
    private String O;
    private String C;
    private String surveyString;
    private String blameString;
    
    //for the modify thing
    private JTextField mi;
    private JTextField mz;
    private ButtonGroup me;
    private ButtonGroup mim;
    private JCheckBox mr;
    private JCheckBox md;
    private JCheckBox mo;
    private JCheckBox mc;
    
    public Survey(JTextField i, JTextField z, ButtonGroup e, ButtonGroup im, JCheckBox r, JCheckBox d, JCheckBox o, JCheckBox c) {
        this.id = i.getText();
        this.zip = z.getText();
        this.employment = getSelectedButtonText(e);
        this.impact = getSelectedButtonText(im);
        
        if(r.isSelected()) {
            this.R = "R";
        } else{
            this.R = "-";
        }
        
        if(d.isSelected()) {
            this.D = "D";
        } else{
            this.D = "-";
        }
        
        if(o.isSelected()) {
            this.O = "O";
        } else{
            this.O = "-";
        }
        
        if(c.isSelected()) {
            this.C = "C";
        } else{
            this.C = "-";
        }
        
        this.blameString = (this.R + this.D + this.O + this.C);
        this.surveyString = (this.id + "                            " + this.zip + "            " + this.employment + "             " + this.impact + "                        " + this.blameString);
        
        //store form data for modifying later
        this.mi = i;
        this.mz = z;
        this.mim = im;
        this.mr = r;
        this.md = d;
        this.mo = o;
        this.mc = c;
    }

        private String getSelectedButtonText(ButtonGroup buttonGroup) {
            //courtesy of /u/endicahya
            for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();

                if (button.isSelected()) {
                    return button.getText();
                }
            }

            return null;
        }

    public String getSurveyString() {
        return surveyString;
    }

    public JTextField getMi() {
        return mi;
    }

    public JTextField getMz() {
        return mz;
    }

    public ButtonGroup getMe() {
        return me;
    }

    public ButtonGroup getMim() {
        return mim;
    }

    public JCheckBox getMr() {
        return mr;
    }

    public JCheckBox getMd() {
        return md;
    }

    public JCheckBox getMo() {
        return mo;
    }

    public JCheckBox getMc() {
        return mc;
    }
    
    public String getSurvey() {
        return this.surveyString;
    };
    
    public int getID() {
        return Integer.parseInt(id);
    }
    
    
}