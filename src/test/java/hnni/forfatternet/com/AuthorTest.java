package hnni.forfatternet.com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AuthorTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void authorRegularCase() {
        /*
         * John Doe
         * Hans-Christian Jensen
         * H-C Jensen
         * P. H. Kristensen
         * Peter Hans Kristensen
         * Peter H. Kristensen
         *
         * Fornavn: John, Efternavn: Doe
         * Fornavn: Hans-Christian, Efternavn: Jensen
         * Fornavn: H-C, Efternavn: Jensen
         * Fornavn: P. H., Efternavn: Kristensen
         * Fornavn: Peter Hans, Efternavn: Kristensen
         * Fornavn: Peter H., Efternavn: Kristensen
         */

        assertEquals(new Author("John Doe").toString(), "Fornavn: John, Efternavn: Doe");
        assertEquals(new Author("Hans-Christian Jensen").toString(), "Fornavn: Hans-Christian, Efternavn: Jensen");
        assertEquals(new Author("H-C Jensen").toString(), "Fornavn: H-C, Efternavn: Jensen");
        assertEquals(new Author("P. H. Kristensen").toString(), "Fornavn: P. H., Efternavn: Kristensen");
        assertEquals(new Author("Peter Hans Kristensen").toString(), "Fornavn: Peter Hans, Efternavn: Kristensen");
        assertEquals(new Author("Peter H. Kristensen").toString(), "Fornavn: Peter H., Efternavn: Kristensen");

    }

    @Test
    public void authorCommaCase() {
        /*
         * Doe, John
         * Jensen, Hans-Christian
         * Jensen, H-C
         * Kristensen, P. H.
         * Kristensen, Peter Hans
         * Kristensen, Peter H.
         *
         * Fornavn: John, Efternavn: Doe
         * Fornavn: Hans-Christian, Efternavn: Jensen
         * Fornavn: Hans-Christian, Efternavn: Jensen
         * Fornavn: P. H., Efternavn: Kristensen
         * Fornavn: Peter Hans, Efternavn: Kristensen
         * Fornavn: Peter H., Efternavn: Kristensen
         */

        assertEquals(new Author("Doe, John").toString(), "Fornavn: John, Efternavn: Doe");
        assertEquals(new Author("Jensen, Hans-Christian").toString(), "Fornavn: Hans-Christian, Efternavn: Jensen");
        assertEquals(new Author("Jensen, H-C").toString(), "Fornavn: H-C, Efternavn: Jensen");
        assertEquals(new Author("Kristensen, P. H.").toString(), "Fornavn: P. H., Efternavn: Kristensen");
        assertEquals(new Author("Kristensen, Peter Hans").toString(), "Fornavn: Peter Hans, Efternavn: Kristensen");
        assertEquals(new Author("Kristensen, Peter H.").toString(), "Fornavn: Peter H., Efternavn: Kristensen");

    }

    @Test
    public void emptyName() {
        assertEquals(new Author("").toString(), "");
    }
}
