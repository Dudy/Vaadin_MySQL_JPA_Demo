/*
 * VaadinMySQLJPADemoApp.java
 *
 * Created on 25. Oktober 2012, 19:37
 */
package de.podolak.demo;

import com.vaadin.Application;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.*;
import de.podolak.demo.jpa.Document;

/**
 *
 * @author Dude
 * @version
 */
public class VaadinMySQLJPADemoApp extends Application {

    private DocumentPersistence documentPersistence;
    private IndexedContainer dataContainer;
    
    @Override
    public void init() {
        initData();
        
        Window mainWindow = new Window("MyApplication");
        Label label = new Label(dataContainer.getContainerProperty(1, "id"));
        TextField textField = new TextField(dataContainer.getContainerProperty(1, "content"));
        mainWindow.addComponent(label);
        mainWindow.addComponent(textField);
        setMainWindow(mainWindow);
    }

    public void initData() {
        documentPersistence = new DocumentPersistence();
        Document document = documentPersistence.loadDocument(1L);

        dataContainer = new IndexedContainer();
        dataContainer.addContainerProperty("id", Long.class, 0L);
        dataContainer.addContainerProperty("content", String.class, "");

        Item item = dataContainer.addItem(1);
        item.getItemProperty("id").setValue(document.getId());
        item.getItemProperty("content").setValue(document.getContent());
    }
}
