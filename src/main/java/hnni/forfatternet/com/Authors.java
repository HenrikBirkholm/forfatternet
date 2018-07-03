package hnni.forfatternet.com;

import java.util.ArrayList;

class Authors {
    private ArrayList<Author> authors;

    Authors(String list) {
        authors = new ArrayList<>();
        if (list != null && !list.equalsIgnoreCase("")) {
            String[] authorStrings = list.split(";");
            for (String authorString : authorStrings) {
                authors.add(new Author(authorString));
            }
        }
    }
}
