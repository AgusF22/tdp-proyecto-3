package data;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import game.labyrinth.ZoneMatrixBuilder;
import game.labyrinth.ZoneType;

public class LabyrinthFileParser extends DefaultHandler {
	
	private ZoneMatrixBuilder matrixBuilder;
	private StringBuilder stringBuilder;
	
	@Override
	public void characters(char [] ch, int start, int lenght) throws SAXException {
		stringBuilder.append(new String(ch, start, lenght));
	}
	
	@Override
	public void startDocument() throws SAXException {
		matrixBuilder = new ZoneMatrixBuilder();
		stringBuilder = new StringBuilder();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		stringBuilder = new StringBuilder();
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
	}

	public ZoneType[][] getMatrix() {
		return matrixBuilder.build();
	}
	
}
