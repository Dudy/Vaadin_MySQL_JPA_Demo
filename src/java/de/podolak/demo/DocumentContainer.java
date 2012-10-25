package de.podolak.demo;

import com.vaadin.data.util.BeanItemContainer;
import de.podolak.demo.jpa.Document;
import java.io.Serializable;

/**
 *
 * @author Dude
 */
public class DocumentContainer extends BeanItemContainer<Document> implements Serializable {
    
    public DocumentContainer() throws InstantiationException, IllegalAccessException {
        super(Document.class);
    }
    
}
