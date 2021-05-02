package by.vsu.lab.task3.xml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.vsu.lab.task3.gem.*;

public class GemXmlReader {

    public List<Gem> read(String fileName){
	XMLStreamReader reader = null;
	List<Gem> gems = new ArrayList<Gem>();
	try {
	    XMLInputFactory factory = XMLInputFactory.newFactory();
	    reader = factory.createXMLStreamReader(new FileReader(fileName));
	    Gem gem = null;
	    while (reader.hasNext()) {
		int type = reader.next();
		switch (type) {
		case XMLStreamConstants.START_ELEMENT: {
		    String tagName = reader.getLocalName();
		    if ("gem".equals(tagName)) {
			gem = new Gem();
			gem.setId(reader.getAttributeValue(null, "id"));
		    } else if ("name".equals(tagName)) {
			gem.setName(reader.getElementText());
		    } else if ("origin".equals(tagName)) {
			gem.setOrigin(reader.getElementText());
		    } else if ("preciousness".equals(tagName)) {
			gem.setPreciousness(GemPreciousnessType.valueOf(
				reader.getElementText()));
		    } else if ("color".equals(tagName)) {
			gem.setColor(GemColorType.valueOf(
				reader.getElementText()));
		    } else if ("opacity".equals(tagName)) {
			gem.setOpacity(Double.valueOf(
				reader.getElementText()));
		    } else if ("face".equals(tagName)) {
			gem.setFace(Integer.valueOf(reader.getElementText()));
		    } else if ("value".equals(tagName)) {
			gem.setValue(Double.valueOf(reader.getElementText()));
		    }

		}
		    break;
		case XMLStreamConstants.END_ELEMENT: {
		    String tagName = reader.getLocalName();
		    if ("gem".equals(tagName)) {
			gems.add(gem);
		    }
		}
		}
	    }

	} catch (FileNotFoundException | XMLStreamException e) {
	    return null;
	} finally {
	    try {
		reader.close();
	    } catch (Exception ignored) {
	    }
	}

	return gems;
    }

}
