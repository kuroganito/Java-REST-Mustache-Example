/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuroganito.restdemo;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author oscar.paredes
 */
@Path("user")
public class User {
    
    @GET
    @Produces("text/html")
    public String getHtml() {
        
       HashMap<String, Object> body = new HashMap<String, Object>();
        
        ArrayList<HashMap<String,Object>> users = new  ArrayList();
        HashMap<String, Object> user = new HashMap<String, Object>();
        user.put("name", "Oscar");
        user.put("colors", Arrays.asList("Red","Yellow"));
        users.add(user);
        user = new HashMap<String, Object>();
        user.put("name", "Jose");
        user.put("colors", Arrays.asList("White","Green"));
        users.add(user);
        body.put("users", users);
        
        String htmlResponse="";
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("template.mustache");
        htmlResponse = mustache.execute(new StringWriter(),body ).toString();
        return htmlResponse;
    }
    
}
