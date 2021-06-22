package com.geiger.toolbox.ui;

import ch.fhnw.geiger.localstorage.StorageException;
import totalcross.ui.Bar;

import totalcross.ui.Container;

import totalcross.ui.ScrollContainer;





public abstract class BaseScreen extends Container {
    public Bar bar;
    protected ScrollContainer content;
    protected boolean allowVerticalScroll = true;
    protected boolean allowHorizontalScroll = false;



    @Override
    public void initUI(){
        
        content = new ScrollContainer() {
            @Override
            public void initUI() {
                setScrollBars(allowHorizontalScroll, allowVerticalScroll);
                super.initUI();
            }
        };
        
        // Content
        add(content, CENTER, AFTER, PARENTSIZE, FILL);
        try {
            onContent(content);
        } catch (StorageException e) {
            e.printStackTrace();
        }

    }
    public abstract void onContent(ScrollContainer content) throws StorageException;
    
   
}
