
package hextex.matcher;

import hextex.references.*;

public class MatchesField implements Matcher {
    private String filter;

    public MatchesField(String filter) {
        this.filter = filter;
    }        
    
    @Override
    public boolean matches(Reference r) {
        return r.matchesFilter(filter);
    }
    
}
