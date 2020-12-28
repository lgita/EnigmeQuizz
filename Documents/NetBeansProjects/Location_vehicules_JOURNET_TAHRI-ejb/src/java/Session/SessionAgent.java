/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entite.Agent;
import Facade.AgentFacadeLocal;
import Facade.ClientFacadeLocal;
import Facade.FraisFacadeLocal;
import Facade.LocationFacadeLocal;
import Facade.VehiculeFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author journ
 */
@Stateless
public class SessionAgent implements SessionAgentLocal {

    @EJB
    private VehiculeFacadeLocal vehiculeFacade;

    @EJB
    private LocationFacadeLocal locationFacade;

    @EJB
    private FraisFacadeLocal fraisFacade;

    @EJB
    private ClientFacadeLocal clientFacade;

    @EJB
    private AgentFacadeLocal agentFacade;
    
    
    
    @Override
    public Agent AuthentificationSession(String l, String mdp) {
        Agent a;
        a = agentFacade.Authetification(l,mdp);
        return a; }

}
