package ift3913.tp1;

import ift3913.tp1.parser.ModelParser;
import ift3913.tp1.parser.SyntaxError;
import ift3913.tp1.parser.ast.Klass;
import ift3913.tp1.parser.ast.Model;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestFiles {

    public static Model readFile(String path) throws IOException {
        String data = new String(Files.readAllBytes(Paths.get(path)), "UTF-8");
        return ModelParser.parseModel(data);
    }

    @Test
    public void testLigue() throws IOException {
        Model model = readFile("Ligue.ucd");
        assertEquals("Ligue", model.name);
        assertEquals(9, model.declarations.size());
    }

    @Test
    public void testLigueBlanks() throws IOException {
        Model model = readFile("Ligue_blanks.ucd");
        assertEquals("Ligue", model.name);
        assertEquals(9, model.declarations.size());
    }

    @Test(expected = SyntaxError.class)
    public void testLigueVide() throws IOException {
        readFile("Ligue_vide.ucd");
    }

    @Test(expected = SyntaxError.class)
    public void testInvalidFile() throws IOException {
        readFile("Ligue_invalid.ucd");
    }

    @Test
    public void testLigueNoAttribute() throws IOException {
        Model model = readFile("Ligue_NoAttributes.ucd");
        assertEquals("Ligue", model.name);

        Klass k = (Klass) model.declarations.get(0);
        assertEquals(0, k.attributes.size());
        assertEquals(0, k.operations.size());
    }
}
