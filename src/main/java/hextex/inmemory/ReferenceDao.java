/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.inmemory;

import hextex.references.Reference;
import java.util.List;

/**
 *
 * @author ilarilai
 */
public interface ReferenceDao {
    List<Reference> listAll();
    void add(Reference reference);
    void delete(String key);
}
