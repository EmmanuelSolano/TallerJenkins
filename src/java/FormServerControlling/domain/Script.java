/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormServerControlling.domain;

/**
 *
 * @author Oscar Luis
 */
public class Script {
    private String claseTramite;
    private Object data;
    public Script(String claseTramite, Object dato) {
        this.claseTramite = claseTramite;
        
        this.data = dato;
        
        
    }

    public String getClaseTramite() {
        return claseTramite;
    }

    public void setClaseTramite(String claseTramite) {
        this.claseTramite = claseTramite;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    

    

    @Override
    public String toString() {
        return "Tramite{" + "claseTramite=" + claseTramite +"\n"
                + ", usuario=" + data + '}';
    }
    
    
}
