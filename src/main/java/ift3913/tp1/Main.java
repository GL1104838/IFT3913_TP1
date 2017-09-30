package ift3913.tp1;

import ift3913.tp1.parser.ModelParser;
import ift3913.tp1.parser.ast.Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        String data = new String(Files.readAllBytes(Paths.get("Ligue.ucd")), "UTF-8");
        Model m = ModelParser.parseModel(data);
        System.out.println(m.name);
    }

}
