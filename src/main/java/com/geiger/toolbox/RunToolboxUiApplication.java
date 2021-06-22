package com.geiger.toolbox;

import com.geiger.toolbox.model.Model;
import totalcross.TotalCrossApplication;

public class RunToolboxUiApplication {
    public static void main(String [] args) {
        // , "/scr", "1125x2436", "/scale", "0.33"
		TotalCrossApplication.run(ToolboxUi.class, "/r", "5443444B5AAEEB90306B00E4");
        Model.addDevices();
    }
}
