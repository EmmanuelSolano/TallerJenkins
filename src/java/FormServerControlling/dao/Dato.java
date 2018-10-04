/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormServerControlling.dao;

import FormServerControlling.domain.ConectionDataBase;
import FormServerControlling.domain.ListsContainer;
import FormServerControlling.domain.Role;
import FormServerControlling.domain.Script;
import FormServerControlling.domain.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oscar Luis
 */
public class Dato {

    private ConectionDataBase conectionDB;
    private List<User> listWithUsers;
    private List<Role> listWithRoles;
    private ListsContainer listsContainer;

    public Dato() {
        conectionDB = new ConectionDataBase();
        listWithUsers = new ArrayList<User>();
        listWithRoles = new ArrayList<Role>();
        listsContainer = new ListsContainer(true);
    }

    public ListsContainer getListsContainer() {
        return listsContainer;
    }
    
    public List<User> chargeUsers() {
        listWithUsers = (List<User>) conectionDB.chargeUsers();

        return listWithUsers;
    }
    
    public List<Role> chargeRoles() {
        listWithRoles = (List<Role>) conectionDB.chargeRoles();

        return listWithRoles;
    }

    public void generateScript(Script script) {
        if (script.getData() instanceof User) {
            User user = (User)script.getData();
            if (script.getClaseTramite().equals("Ingresar Usuario")) {
                conectionDB.insertUser(user);
            } else if (script.getClaseTramite().equals("Eliminar")) {
                conectionDB.DeleteUser(user.getId());
            } else if (script.getClaseTramite().equals("Editar")) {
                conectionDB.UpdateUser(user);
            }
        }else if(script.getData() instanceof Role){
            Role role = (Role) script.getData();
            if (script.getClaseTramite().equals("Insertar Role")) {
                conectionDB.insertRole(role);
            }else if (script.getClaseTramite().equals("Eliminar")) {
                conectionDB.DeleteRole(role.getId());
            }else if (script.getClaseTramite().equals("Editar")) {
                conectionDB.UpdateRole(role);
            }
        }

        
    }
}
