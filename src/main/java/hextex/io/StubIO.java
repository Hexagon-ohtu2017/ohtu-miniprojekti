/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.io;

import java.util.ArrayList;
import java.util.List;

public class StubIO implements IO {

    private List<String> lines;
    private int i;
    private ArrayList<String> prints;

    public StubIO(List<String> values) {
        this.lines = values;
        prints = new ArrayList<>();
    }

    public void print(String toPrint) {
        prints.add(toPrint);
    }

    public int readInt(String prompt) {
        print(prompt);
        return Integer.parseInt(lines.get(i++));
    }

    public ArrayList<String> getPrints() {
        return prints;
    }

    public String readLine(String prompt) {
        print(prompt);
        if (i < lines.size()) {
            return lines.get(i++);
        }
        return "";
    }

    @Override
    public String readAuthors(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}