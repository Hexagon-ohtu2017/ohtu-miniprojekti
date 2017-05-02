package hextex.matcher;

import hextex.references.*;

public class And implements Matcher {

    private Matcher[] matchers;

    public And(Matcher... matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Reference r) {
        for (Matcher matcher : matchers) {
            if (!matcher.matches(r)) {
                return false;
            }
        }
        return true;
    }
}
