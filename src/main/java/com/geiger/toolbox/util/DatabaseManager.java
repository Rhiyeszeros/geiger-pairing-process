package com.geiger.toolbox.util;

import ch.fhnw.geiger.localstorage.StorageController;
import ch.fhnw.geiger.localstorage.StorageException;
import ch.fhnw.geiger.localstorage.db.GenericController;
import ch.fhnw.geiger.localstorage.db.mapper.H2SqlMapper;

public class DatabaseManager {
  private GenericController gc;

  public void connectToDatabase() throws StorageException {
    gc = new GenericController("GeigerTest2", new H2SqlMapper("jdbc:h2:./testdb;AUTO_SERVER=TRUE", "sa2", "1234"));
  }

  public StorageController getController(){
    return gc;
  }


}
