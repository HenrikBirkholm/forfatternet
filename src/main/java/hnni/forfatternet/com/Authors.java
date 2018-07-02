package hnni.forfatternet.com;

import java.util.ArrayList;

public class Authors {
    private ArrayList<Author> authors;

    public Authors (String list) {
        authors = new ArrayList<Author>();
        if (list != null && !list.equalsIgnoreCase("")) {
            String[] authorStrings = list.split(",");
            for (String authorString : authorStrings) {
                authors.add(new Author(authorString));
            }
        }
    }
}
