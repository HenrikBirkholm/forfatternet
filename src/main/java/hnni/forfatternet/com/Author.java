package hnni.forfatternet.com;

public class Author {
    private String firstname;
    private String surname;

    public Author(String name) {
        if (name != null && !name.equalsIgnoreCase("")) {
            if (name.indexOf(",") > 0) { // comma notation used surname, firstname
                int index = name.indexOf(",");
                this.surname = name.substring(0, index-1).trim();
                this.firstname = name.substring(index).trim();

            } else { // regular notation firstname surname
                int index = name.lastIndexOf(" ");
                this.firstname = name.substring(0, index).trim();
                this.surname = name.substring(index).trim();
            }
        } else {
            this.firstname = "";
            this.surname = "";
        }
    }

    @Override
    public String toString() {
        if (this.firstname.equalsIgnoreCase("") && this.surname.equalsIgnoreCase("")) {
            return "";
        } else {
            return "Fornavn: " + this.firstname + ", Efternavn: " + this.surname;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (firstname != null ? !firstname.equals(author.firstname) : author.firstname != null) return false;
        return surname != null ? surname.equals(author.surname) : author.surname == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}
