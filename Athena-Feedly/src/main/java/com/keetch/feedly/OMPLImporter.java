package com.keetch.feedly;

import com.keetch.feedly.model.Outline;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by keetchc on 29/09/2014.
 */
public class OMPLImporter {

    static final String OUTLINE = "outline";
    static final String TYPE = "type";
    static final String TEXT = "text";
    static final String XMLURL = "xmlUrl";


    @SuppressWarnings({"unchecked", "null"})
    public List<Outline> readConfig(String configFile) {
        List<Outline> items = new ArrayList<Outline>();
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream in = classloader.getResourceAsStream(configFile);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            Outline outline = null;

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    if (startElement.getName().getLocalPart() == (OUTLINE)) {

                        outline = new Outline();
                        // We read the attributes from this tag and add the date
                        // attribute to our object
                        Iterator<Attribute> attributes = startElement
                                .getAttributes();
                        while (attributes.hasNext()) {

                            Attribute attribute = attributes.next();
                            if (attribute.getName().toString().equals(TEXT)) {
                                outline.setText(attribute.getValue());
                            }
                            if (attribute.getName().toString().equals(XMLURL)) {
                                outline.setXmlURL(attribute.getValue());
                            }
                            if (attribute.getName().toString().equals(TYPE)) {
                                outline.setType(attribute.getValue());

                            }
                        }
                    }


                }

                // If we reach the end of an item element, we add it to the list
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart() == (OUTLINE)) {
                        if (outline.getType() != null) {
                            items.add(outline);
                        }

                    }
                }

            }

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return items;
    }

}