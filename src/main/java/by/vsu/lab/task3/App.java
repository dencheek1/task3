package by.vsu.lab.task3;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import by.vsu.lab.task3.gem.Gem;
import by.vsu.lab.task3.gem.comparators.CompareByValue;
import by.vsu.lab.task3.xml.GemXmlReader;
import by.vsu.lab.task3.xml.GemXmlValidator;
import by.vsu.lab.task3.xml.GemXmlWriter;

public class App {
    
    public static void main(String[] args) throws IOException, XMLStreamException {
	
	GemXmlValidator validator = new GemXmlValidator("resources"+ File.separator+"gems.xml");

	if (validator.validate()) {
	    System.out.println("OK");
	    GemXmlReader reader = new GemXmlReader();
	    List<Gem> gems = reader.read("resources"+ File.separator+"gems.xml");

	    Collections.sort(gems, new CompareByValue());

	    for (Gem gem : gems) {
		System.out.println(gem);
	    }

	    GemXmlWriter writer = new GemXmlWriter();
	    writer.write(gems, "gems-res.xml");

	} else {
	    System.out.println(validator.getError());
	}
    }
}
