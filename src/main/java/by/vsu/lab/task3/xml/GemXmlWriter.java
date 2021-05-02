package by.vsu.lab.task3.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import by.vsu.lab.task3.gem.Gem;

public class GemXmlWriter {
    public void write(List<Gem> gems, String fileName) throws FileNotFoundException  {
        XMLStreamWriter writer = null;
        try {
            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            writer = factory.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeCharacters("\n");
            writer.writeStartElement("gems");
            writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeAttribute("xmlns", "http://www.example.org/gems");
            writer.writeAttribute("xsi:schemaLocation", "http://www.example.org/gemes gems.xsd");
            writer.writeCharacters("\n");
            for (Gem gem : gems) {
        	writer.writeCharacters("\t");
                writer.writeStartElement("gem");
                writer.writeAttribute("id", gem.getId());
                writer.writeCharacters("\n\t\t");
                writer.writeStartElement("name");
                writer.writeCharacters(gem.getName());
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t");
                writer.writeStartElement("origin");
                writer.writeCharacters(gem.getOrigin());
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t");
                writer.writeStartElement("preciousness");
                writer.writeCharacters(gem.getPreciousness().toString());
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t");
                writer.writeStartElement("visualParametrs");
                writer.writeCharacters("\n\t\t\t");
                writer.writeStartElement("color");
                writer.writeCharacters(gem.getColor().toString());
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t\t");
                writer.writeStartElement("opacity");
                writer.writeCharacters(gem.getOpacity().toString());
                writer.writeEndElement();
                if(gem.getFace() != null) {
                    writer.writeCharacters("\n\t\t\t");
                    writer.writeStartElement("face");
                    writer.writeCharacters(gem.getFace().toString());
                    writer.writeEndElement();
                }
                writer.writeCharacters("\n\t\t");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t");
                writer.writeStartElement("value");
                writer.writeCharacters(gem.getValue().toString());
                writer.writeEndElement();
                writer.writeCharacters("\n\t");
                writer.writeEndElement();
                writer.writeCharacters("\n");
            }
            writer.writeEndElement();
            writer.writeEndDocument();
        }catch(XMLStreamException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }

}
