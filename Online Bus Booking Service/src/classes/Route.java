/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author rafikhan
 */
public class Route {
    private String name;
    private List<String> routes;
    private final Date created = new Date();
    private final String id = UUID.randomUUID().toString();
    
    public Date getCreated() {
        return created;
    }
   
    public String getId() {
        return id;
    }


    public Route(String name, List<String> routes) {
        this.name = name;
        this.routes = routes;
    }

    public String getName() {
        return name;
    }

    public List<String> getRoutes() {
        return routes;
    }

    public void setRoutes(List<String> routes) {
        this.routes = routes;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
