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
public class Role {
    
    private String nameRole;
    private String descriptionRole;
    private int id;
    
    
    public Role() {
        this.nameRole = "";
        this.descriptionRole = "";
        this.id=0;
    }
    
    public Role(String nameRole, String descriptionRole) {
        this.nameRole = nameRole;
        this.descriptionRole = descriptionRole;
        this.id=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public String getDescriptionRole() {
        return descriptionRole;
    }

    public void setDescriptionRole(String descriptionRole) {
        this.descriptionRole = descriptionRole;
    }

    @Override
    public String toString() {
        return "Roles{" + "nameRole=" + nameRole + ", descriptionRole=" + descriptionRole + '}';
    }
    
    
    

}
