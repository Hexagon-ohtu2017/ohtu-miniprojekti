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
        authors.trim(); //remove extra dashes around the authors
        String key = "";
        if (manyAuthors(authors)) {
            key = keyMakerMultipleAuthors(authors, year, key);
        } else {
            key = oneAuthorKey(authors, key, year);
        }
        if (referenceExistsAlready(key)) {
            key = keyMakerSameYear(key);
        }
        return key;
    }

    public String keyMakerMultipleAuthors(String authors, int year, String key) {
        List<String> authorList = Arrays.asList(authors.split(",[ ]*"));
        List<String> lastNames = getLastNames(authorList); // get only lastnames
        String lastName = "";
        for (int i = 0; i < lastNames.size(); i++) {
            lastName = lastNames.get(i);
            key = nameCutter(key, lastName);
        }
        key += year;
        return key;
    }

    public String oneAuthorKey(String author, String key, int year) {
        List<String> authorFirstAndLastName = Arrays.asList(author.split(" "));
        String lastName = authorFirstAndLastName.get(0);
        key = nameCutter(key, lastName) + year;
        return key;
    }

    public List<String> getLastNames(List<String> authorList) {
        ArrayList<String> lastNames = new ArrayList<>();
        for (String name : authorList) {
            String[] lastAndFirst = name.split(" ");
            String lastName = lastAndFirst[0];
            lastNames.add(lastName);
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
                if (referenceExistsAlready(key)) {
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

    public String nameCutter(String key, String lastName) {
        if (lastName.length() >= 3) {
            key += lastName.substring(0, 3);
        } else {
            key += lastName;
        }
        return key;
    }

    public boolean referenceExistsAlready(String key) {
        for (Reference ref : dao.getReferences()) {
            if (ref.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean manyAuthors(String authors) {
        return authors.contains(",");
    }
}
