/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormServerControlling.webcontroller;

import FormServerControlling.domain.ListsContainer;
import FormServerControlling.domain.Role;
import FormServerControlling.domain.Script;
import FormServerControlling.domain.User;
import FormServerControlling.webservice.ScriptService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Oscar Luis
 */
@Controller
public class ScriptController {
    private ScriptService scriptService;
    public void setScriptService(ScriptService scriptService){
        this.scriptService = scriptService;
    }
    @RequestMapping("/scriptSubmit")
    public ModelAndView scriptSubmit(
            @RequestParam("correo")String correo,
            @RequestParam("id")String id,
            @RequestParam("nombre")String nombre,
            @RequestParam("primerA")String primerA,
            @RequestParam("segundoA")String segundoA,
            @RequestParam("contrasena")String contrasena,
            @RequestParam("role")String role,
            @RequestParam("tramite")String tramite
    ){
        User user = new User(correo, nombre, primerA, segundoA, role);
        user.setContrasena(contrasena);
        if(id.equals("")){
            user.setId(0);
        }else{
            user.setId(Integer.parseInt(id));
        }
        
        Script script = new Script(tramite, user);
        scriptService.generateScript(script);
        ListsContainer listscontainer = scriptService.getListsContainer();
        List<User> list = listscontainer.getListWithUsers();
        user.setId(0);
        return new ModelAndView("script","lists",listscontainer);
    }
    @RequestMapping("/script")
    public ModelAndView script(){
        ListsContainer listscontainer = scriptService.getListsContainer();
        List<User> list = scriptService.showEverything();
        return new ModelAndView("script","lists",listscontainer);
    }
    @RequestMapping("/scriptRole")
    public ModelAndView scriptRole(){
        List<Role> list = scriptService.showEverythingRoles();
        return new ModelAndView("scriptRole","listRoles",list);
    }
    @RequestMapping("/scriptRoleSubmit")
    public ModelAndView scriptRoleSubmit(
            @RequestParam("name")String name,
            @RequestParam("id")String id,
            @RequestParam("description")String description,
            @RequestParam("tramite")String tramite
    ){
        Role role = new Role(name, description);
        if(!id.equals("")){
            role.setId(Integer.parseInt(id));
        }
        
        Script script = new Script(tramite, role);
        scriptService.generateScript(script);
        List<Role> list = scriptService.showEverythingRoles();
        return new ModelAndView("scriptRole","listRoles",list);
    }
    
}
