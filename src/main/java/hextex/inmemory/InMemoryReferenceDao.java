/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.inmemory;

import hextex.matcher.Matcher;
import hextex.matcher.QueryBuilder;
import hextex.references.Reference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ilarilai
 */
public class InMemoryReferenceDao implements ReferenceDao {

    private List<Reference> references;
    private Set<String> filters;
    private QueryBuilder queryBuilder;

    public InMemoryReferenceDao() {
        references = new ArrayList<>();
        filters = new HashSet<>();
        queryBuilder = new QueryBuilder();
    }

    @Override
    public List<Reference> listAll() {
        return references;
    }

    public void setReferences(List<Reference> references) {
        this.references = references;
    }

    public List<Reference> getReferences() {
        return references;
    }

    @Override
    public void add(Reference reference) {
        if (reference != null) {
            references.add(reference);
        }
    }

    @Override
    public void delete(String key) {
        Iterator<Reference> iterator = references.iterator();
        while (iterator.hasNext()) {
            Reference r = iterator.next();
            if (r.getKey().equals(key)) {
                references.remove(r);
                break;
            }
        }
    }

    public void addFilter(String filterString) {
        this.filters.add(filterString);
    }

    public List<Reference> listFiltered() {
        for (String s : filters) {
            queryBuilder.matchesField(s);
        }
        Matcher m = queryBuilder.build();
        
        List<Reference> matches = new ArrayList<>();
        for (Reference r : references) {
            if (m.matches(r)) {
                matches.add(r);
            }
        }

        return matches;
    }

    public Set<String> getFilters() {
        return filters;
    }

    public void clearFilters() {
        filters.clear();
    }

    public void removeFilter(String filter) {
        filters.remove(filter);
    }
    
}
