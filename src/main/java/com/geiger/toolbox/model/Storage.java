package com.geiger.toolbox.model;

import ch.fhnw.geiger.localstorage.StorageException;
import ch.fhnw.geiger.localstorage.db.GenericController;
import ch.fhnw.geiger.localstorage.db.data.NodeImpl;
import ch.fhnw.geiger.localstorage.db.mapper.H2SqlMapper;

public class Storage {
GenericController gc;
  public void connectToDatabase() throws StorageException {
    
      //Example of how to use storageApi (Needs to be implemented within a function)
        gc = new GenericController("GeigerTest2", new H2SqlMapper("jdbc:h2:./testdb;AUTO_SERVER=TRUE", "sa2", "1234"));
        gc.add(new NodeImpl("testNode"));
        gc.add(new NodeImpl("testNode2"));
  }
}
