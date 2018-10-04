/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormServerControlling.webservice;

import FormServerControlling.dao.ScriptDao;
import FormServerControlling.domain.ListsContainer;
import FormServerControlling.domain.Role;
import FormServerControlling.domain.Script;
import FormServerControlling.domain.User;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Oscar Luis
 */
@Service
public class ScriptService {

    private final ScriptDao scriptDao;

    public ScriptService() {
        this.scriptDao = new ScriptDao();
    }

    public List<User> showEverything() {
        return this.scriptDao.showEverything();
    }
    public List<Role> showEverythingRoles() {
        return this.scriptDao.showEverythingRoles();
    }
    public ListsContainer getListsContainer() {
        return scriptDao.getListsContainer();
    }
    public void generateScript(Script script) {
        scriptDao.generateScript(script);
    }
}
