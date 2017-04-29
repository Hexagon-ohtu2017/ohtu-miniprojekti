/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.references;

import java.util.ArrayList;

/**
 *
 * @author omistaja
 */
public interface Reference {

    public String getBibtexName();
    public String getEasyName();
    public String getKey();
    public String getAuthor();
    public boolean matchesFilter(String filterString);
    public ArrayList<String> addAllFields();

}
