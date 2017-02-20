package ru.dzhinn.dbdatatoxml.jaxb;



//import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
//import com.sun.xml.bind.marshaller.*;
//import com.sun.xml.bind.marshaller.CharacterEscapeHandler;
import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
import ru.dzhinn.dbdatatoxml.dto.Licenses;
import ru.dzhinn.dbdatatoxml.dto.input.Input;
import ru.dzhinn.dbdatatoxml.dto.item.Item;

//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by A.Dzhioev on 15.02.2017.
 */
public class Structure33 {

    private static String getFormattedDate(Date date){
        if (date == null){
            return "";
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

        return df.format(date);
    }

    public static void createXML(List<Item> items) {



        Licenses licenses = new Licenses();

        Input input = new Input();
        input.setLicStatuses("Good");
        input.setGovtName("");
        input.setLicSd(getFormattedDate(new Date()));
        input.setLicEd(getFormattedDate(null));

        licenses.setInput(input);
        licenses.setItems(items);

        try {

            File file = new File("file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Licenses.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders",
                    "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            CharacterEscapeHandler characterEscapeHandler = MyCharacterEscapeHandler.theInstance;
            jaxbMarshaller.setProperty("com.sun.xml.internal.bind.characterEscapeHandler", characterEscapeHandler);

            jaxbMarshaller.marshal(licenses, file);
            jaxbMarshaller.marshal(licenses, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
