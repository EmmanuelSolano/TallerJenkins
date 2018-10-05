/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormServerControlling.domain;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oscar Luis
 */
public class ConectionDataBase {

    public Object stablishConectionDataBase() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //jdbc:sqlserver://192.168.1.9:1433;databaseName=DevFormServerControllingDataBase [SA on db_accessadmin]
            String connectionURL = "jdbc:sqlserver://192.168.43.53:1433;databaseName=DevFormServerControllingDataBase;user=SA;password=sql_devdata4001";
            Connection con = DriverManager.getConnection(connectionURL);
            return con;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConectionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public Object chargeUsers() {
        try {
            List<User> listWithUsers = new ArrayList<>();
            Connection con = (Connection) stablishConectionDataBase();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select *from UserApp ");
            User user;
            while (rs.next()) {
                int id = rs.getInt(1);
                String Correo = rs.getString(2);
                String Nombre = rs.getString(3);
                String PrimerApellido = rs.getString(4);
                String SegundoApellido = rs.getString(5);
                String Contrasena = rs.getString(6);
                String RoleEnLaApp = rs.getString(7);
                user = new User(Correo, Nombre, PrimerApellido, SegundoApellido, RoleEnLaApp);
                user.setContrasena(Contrasena);
                user.setId(id);
                listWithUsers.add(user);
            }
            con.close();
            return listWithUsers;
        } catch (Exception ex) {
            return 0;
        }

    }
    public Object chargeRoles() {
        try {
            List<Role> listWithUsers = new ArrayList<>();
            Connection con = (Connection) stablishConectionDataBase();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select *from Roles ");
            Role role;
            while (rs.next()) {

                String nameRole = rs.getString(2);
                String DescriptionRole = rs.getString(3);
                int id = rs.getInt(1);
                role = new Role(nameRole, DescriptionRole);
                role.setId(id);
                listWithUsers.add(role);
            }
            con.close();
            return listWithUsers;
        } catch (Exception ex) {
            return 0;
        }

    }
    public void insertUser(User user) {
        try {
            String sqlInsert = "INSERT INTO UserApp(Email,Username,Surname,"
                    + "Second_Surname,Password,Role) values(?,?,?,?,?,?)";
            Connection con = (Connection) stablishConectionDataBase();
            CallableStatement stmtInsert = con.prepareCall(sqlInsert);
            ListsContainer lists = new ListsContainer(true);
            List<Role>listUser =lists.getListWithRoles();
            Role aux;
            int role=0;
            for (int i = 0; i < listUser.size(); i++) {
                 aux = listUser.get(i);
                 if(aux.getNameRole().equals(user.getRoleEnLaApp())){
                     role = aux.getId();
                 }
            }
            stmtInsert.setString(1, user.getCorreo());
            stmtInsert.setString(2, user.getNombre());
            stmtInsert.setString(3, user.getPrimerApellido());
            stmtInsert.setString(4, user.getSegundoApellido());
            stmtInsert.setString(5, user.getContrasena());
            stmtInsert.setInt(6, role);
            
            stmtInsert.executeUpdate();
            stmtInsert.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertRole(Role role) {
        try {
            String sqlInsert = "INSERT INTO Roles(NameRole,DescriptionRole) values(?,?)";
            Connection con = (Connection) stablishConectionDataBase();
            CallableStatement stmtInsert = con.prepareCall(sqlInsert);
            stmtInsert.setString(1, role.getNameRole());
            stmtInsert.setString(2, role.getDescriptionRole());
            
            stmtInsert.executeUpdate();
            stmtInsert.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void DeleteUser(int id){
        try {
            Connection con = (Connection) stablishConectionDataBase();
            CallableStatement input = con.prepareCall("{call DeleteUser(?)}");
            input.setInt(1, id);
            input.execute();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void DeleteRole(int Role){
        try {
            Connection con = (Connection) stablishConectionDataBase();
            CallableStatement input = con.prepareCall("{call DeleteRole(?)}");
            input.setInt(1, Role);
            input.execute();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //(Email,Username,Surname,"
                    //+ "Second_Surname,Password,Role)
    public void UpdateUser(User user){
        try{
             ListsContainer lists = new ListsContainer(true);
            List<Role>listUser =lists.getListWithRoles();
            Role aux;
            int role=0;
            for (int i = 0; i < listUser.size(); i++) {
                 aux = listUser.get(i);
                 if(aux.getNameRole().equals(user.getRoleEnLaApp())||aux.getId()==user.getId()){
                     role = aux.getId();
                 }
            }
            Connection con = (Connection) stablishConectionDataBase();
            PreparedStatement pps = con.prepareStatement("update UserApp set Email='"
                    +user.getCorreo()
                    + "', Username='"
                    +user.getNombre()+"', Surname='"
                    +user.getPrimerApellido()+"', Second_Surname='"+user.getSegundoApellido()
                    + "', Password='"+user.getContrasena()+"', Role='"
                    +role+
                    "' where Id='"+user.getId()+"'");
            pps.executeUpdate();
            pps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void UpdateRole(Role roles){
        try{
            Connection con = (Connection) stablishConectionDataBase();
            PreparedStatement pps = con.prepareStatement("update Roles set NameRole='"
                    +roles.getNameRole()+"', DescriptionRole='"
                    +roles.getDescriptionRole()
                    +"' where Id='"+roles.getId()+"'");
            pps.executeUpdate();
            pps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
