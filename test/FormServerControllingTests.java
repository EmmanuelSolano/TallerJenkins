/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FormServerControlling.domain.ConectionDataBase;
import FormServerControlling.domain.Role;
import FormServerControlling.domain.Script;
import FormServerControlling.domain.User;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oscar Luis
 */
public class FormServerControllingTests {
    
    public FormServerControllingTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
           User user = new User("manfredgh@hotmail.com", "Manfred", "Gonzalez", "Fernandez", "Technician");
           user.setContrasena("12345");
           user.setId(2);
//         user.setContrasena("123");
//         System.out.println(user);
//         System.out.println("PRUEBA DE TRAMITE");
//         Script script = new Script("Insertar", user);
//         System.out.println(script);
         
         ConectionDataBase conection = new ConectionDataBase();
//         List<User> list = new ArrayList<User>();
//         list = (List<User>) conection.chargeUsers();
//         User userList;
         //conection.EliminarUsuario("adsfs@hotmail.com");
         conection.UpdateUser(user);
//         Role role = new Role("System Administrator", "Administrador del sistema");
//         //conection.insertRole(role);
//         List<Role> list = new ArrayList<Role>();
//         list = (List<Role>) conection.chargeRoles();
//         Role roleList;
//         for (int i = 0; i < list.size(); i++) {
//             roleList = list.get(i);
//             System.out.println(roleList);
//         }
         
     }
}
