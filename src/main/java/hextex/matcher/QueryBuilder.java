/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.matcher;

import hextex.references.Reference;
import java.util.ArrayList;

/**
 *
 * @author aleksisvuoksenmaa
 */
public class QueryBuilder {
    
    private ArrayList<Matcher> matchers;

    public QueryBuilder() {
        this.matchers = new ArrayList();
    }
    
    public QueryBuilder matchesField(String filter) {
        this.matchers.add(new MatchesField(filter));
        return this;
    }
    
    
    public Matcher[] matchersToArray() {
        Matcher[] matchers = new Matcher[this.matchers.size()];
        return this.matchers.toArray(matchers);
        
    }
    
    public void initialize() {
        this.matchers = new ArrayList();
    }
    
    public Matcher build() {
        Matcher[] matchers = matchersToArray();
        this.initialize();
        
        return new And(matchers);
    }
    

    
    
}
