package com.geiger.toolbox.ui.screens;

import com.geiger.toolbox.ui.BaseScreen;
import totalcross.io.device.scanner.Scanner;
import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.gfx.Color;
import totalcross.ui.event.*;

public class EmployeesScreen extends Container {

    private MultiEdit edtBarCode;
    private PushButtonGroup pbg;

    public void initUI()
    {
        if (!Settings.platform.equals(Settings.ANDROID) && !Settings.onJavaSE)
        {
            add(new Label("This sample works only on Android"),CENTER,CENTER);
            return;
        }
        setBackColor(UIColors.controlsBack = Color.WHITE);
        pbg = new PushButtonGroup(new String[]{"SCAN 1D barcodes","SCAN 2D QR codes","SCAN Both types"},fmH/2,3);
        add(pbg,LEFT,TOP+fmH,FILL,PREFERRED+fmH);

        add(edtBarCode = new MultiEdit(3,1), LEFT, BOTTOM-fmH,FILL,PREFERRED);
        edtBarCode.setEditable(false);

        add(new Label("Result:"),LEFT,BEFORE);
    }

    private static final String msg = "Place a barcode inside the viewfinder rectangle to scan it";

    public void onEvent(Event event)
    {
        switch (event.type)
        {
            case ControlEvent.PRESSED:
                if (event.target == pbg)
                {
                    int sel = pbg.getSelectedIndex();
                    String mode = sel == 0 ? "1D" : sel == 1 ? "2D" : "";
                    String scan = Scanner.readBarcode("mode="+mode+"&msg="+msg);
                    if (scan != null)
                        edtBarCode.setText(scan);
                }
                break;
        }
    }
}