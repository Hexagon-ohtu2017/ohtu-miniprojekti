/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.service;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.references.Reference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Ilari
 */
public class KeyMaker {

    private InMemoryReferenceDao dao;

    public KeyMaker(InMemoryReferenceDao dao) {
        this.dao = dao;
    }

    public String generateKey(String authors, int year) {
        authors.trim();
        String key = "";
        if (authors.contains(",")) {
            key = keyMakerMultipleAuthors(authors, year, key);
        } else if (authors.contains(" ")) { // if no dots, only one author
            List<String> authorFirstAndLastName = Arrays.asList(authors.split(" "));
            key = authorFirstAndLastName.get(0).substring(0, 3) + year;
        } else {
            key = authors.substring(0, 3) + year;
        }
        for (Reference ref : dao.getReferences()) {
            if (ref.getKey().equals(key)) {
                key = keyMakerSameYear(key);
            }
        }
        return key;
    }

    public String keyMakerMultipleAuthors(String authors, int year, String key) {
        List<String> authorList = Arrays.asList(authors.split(",[ ]*"));
        List<String> lastNames = getLastNames(authorList); // get only lastnames
        for (int i = 0; i < lastNames.size(); i++) {
            key += lastNames.get(i).substring(0, 3);
        }
        key += year;
        return key;
    }

    public List<String> getLastNames(List<String> authorList) {
        ArrayList<String> lastNames = new ArrayList<>();
        int helper = 0;
        for (String name : authorList) { 
            if (helper % 2 == 0) {
                lastNames.add(name);
            }
        }
        return lastNames;
    }

    public String keyMakerSameYear(String key) {
        if (Character.isDigit(key.charAt(key.length() - 1))) {
            key += "a";
            return key;
        }
        key = addCharacters(key);

        return key;
    }

    public String addCharacters(String key) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        int helper = 1;
        while (true) {
            for (Reference ref : dao.getReferences()) {
                if (ref.getKey().equals(key)) {
                    StringBuilder sb = new StringBuilder(key);
                    sb.setCharAt(key.length() - 1, alphabets.charAt(helper));
                    key = sb.toString();
                    helper++;
                }
            }
            break;
        }
        return key;
    }

}
