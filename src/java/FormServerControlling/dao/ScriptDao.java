/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormServerControlling.dao;

import FormServerControlling.domain.ListsContainer;
import FormServerControlling.domain.Role;
import FormServerControlling.domain.Script;
import FormServerControlling.domain.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Oscar Luis
 */
@Repository
public class ScriptDao {
    private Dato dato;
    private List<User> listWithUsers;
    private List<Role> listWithRoles;
    private ListsContainer listsContainer;
    
    public ScriptDao() {
        this.dato = new Dato();
        this.listWithUsers = new ArrayList<>();
        listsContainer = new ListsContainer();
    }

    public ListsContainer getListsContainer() {
        listsContainer = dato.getListsContainer();
        return listsContainer;
    }
    
    public List<User> showEverything(){
        listWithUsers = dato.chargeUsers();
        return listWithUsers;
    }
    public List<Role> showEverythingRoles(){
        listWithRoles = dato.chargeRoles();
        return listWithRoles;
    }
    public void generateScript(Script script){
        dato.generateScript(script);
    }
}
