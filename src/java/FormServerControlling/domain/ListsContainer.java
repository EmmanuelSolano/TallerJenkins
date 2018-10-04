/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormServerControlling.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oscar Luis
 */
public class ListsContainer {
    private List<User> listWithUsers;
    private List<Role> listWithRoles;
    private ConectionDataBase conectionDB;

    public ListsContainer(boolean id) {
        conectionDB = new ConectionDataBase();
        listWithUsers =(List<User>) conectionDB.chargeUsers();
        listWithRoles = (List<Role>) conectionDB.chargeRoles();
    }

    public ListsContainer() {
        conectionDB = new ConectionDataBase();
        listWithUsers = new ArrayList<>();
        listWithRoles = new ArrayList<>();
    }
    
    public List<User> getListWithUsers() {
        listWithUsers = (List<User>) conectionDB.chargeUsers();
        return listWithUsers;
    }

    public void setListWithUsers(List<User> listWithUsers) {
        this.listWithUsers = listWithUsers;
    }

    public List<Role> getListWithRoles() {
         listWithRoles = (List<Role>) conectionDB.chargeRoles();
        return listWithRoles;
    }

    public void setListWithRoles(List<Role> listWithRoles) {
        this.listWithRoles = listWithRoles;
    }
    
}
