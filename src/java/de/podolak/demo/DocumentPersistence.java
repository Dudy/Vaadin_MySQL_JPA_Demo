package de.podolak.demo;

import de.podolak.demo.jpa.Document;
import de.podolak.demo.jpa.DocumentJpaController;
import de.podolak.demo.jpa.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dude
 */
public class DocumentPersistence implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public DocumentPersistence() {
    }

    public Document loadDocument(Long id) {
        DocumentJpaController controller = new DocumentJpaController();
        return controller.findDocumentEntity(id);
    }
    
    public Document storeDocument(Document document) {
        DocumentJpaController controller = new DocumentJpaController();
        
        try {
            if (document.getId() == null) {
                controller.create(document);
                document.setId(document.getId());
            } else {
                controller.edit(document);
            }
            return document;
        } catch (RollbackFailureException ex) {
            Logger.getLogger(DocumentPersistence.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DocumentPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
