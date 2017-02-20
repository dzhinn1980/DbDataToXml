package ru.dzhinn.dbdatatoxml.jaxb;

import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by A.Dzhioev on 16.02.2017.
 */
public class MyCharacterEscapeHandler implements CharacterEscapeHandler {

    public static final CharacterEscapeHandler theInstance = new MyCharacterEscapeHandler();

    private MyCharacterEscapeHandler() {
    }
    @Override
    public void escape(char[] chars, int i, int i1, boolean b, Writer writer) throws IOException {
        writer.write(chars, i, i1);
    }
}
