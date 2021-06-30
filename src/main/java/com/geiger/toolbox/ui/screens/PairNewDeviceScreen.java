package com.geiger.toolbox.ui.screens;


import com.geiger.toolbox.model.Device;
import com.geiger.toolbox.model.Model;
import com.geiger.toolbox.util.Colors;
import com.google.gson.Gson;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.QRCode;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import totalcross.io.FileNotFoundException;
import totalcross.io.device.scanner.Scanner;
import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;
import totalcross.util.UnitsConverter;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PairNewDeviceScreen extends Container {

    private Label edtBarCode;
    private PushButtonGroup pbg;

    PairNewDeviceScreen(DevicesScreen deviceListScrollContainer){
        this.deviceListScrollContainer = deviceListScrollContainer;
    }
    DevicesScreen deviceListScrollContainer;
    public ScrollContainer scrollContainer;
    int margin = UnitsConverter.toPixels(Control.DP + 10);


    @Override
    public void initUI(){

        scrollContainer = new ScrollContainer() {
            @Override
            public void initUI() {
                setScrollBars(false, false);
                super.initUI();
            }
        };

        add(scrollContainer, LEFT, TOP, FILL, FILL);


        try {
            String filePath = "src/main/resources/images/qrscan.png";
            String charset = "UTF-8";
            Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            String jsonString = readQRCode(filePath, charset, hintMap);


            totalcross.ui.image.Image img = new totalcross.ui.image.Image("src/main/resources/images/qrcode_smartphone.png");
            ImageControl ic = new ImageControl(img);
            ic.scaleToFit = true;
            ic.borderColor = Colors.SECONDARY;

            scrollContainer.add(ic, CENTER, AFTER + margin, 300, 300);

            Gson g = new Gson();

            Device p = g.fromJson(jsonString, Device.class);

            if (Model.devices.contains(p)){
                Toast.backColor = Color.RED;
                Toast.show("Device is already paired.", 5000);
            }
            else {
                Model.devices.add(p);
                deviceListScrollContainer.removeAll();
                deviceListScrollContainer.initUI();
                Toast.backColor = Colors.PRIMARY;
                Toast.show("Device paired successfully!", 5000);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        Label lb1 = new Label("To pair a new device, scan the QR-Code \n of the device you want to pair.", CENTER);
        scrollContainer.add(lb1, CENTER, AFTER + margin, Settings.screenWidth - margin * 2, PREFERRED);

       /* if (!Settings.platform.equals(Settings.ANDROID) && !Settings.onJavaSE)
        {
            add(new Label("This sample works only on Android"),CENTER,CENTER);
            return;
        }
        setBackColor(UIColors.controlsBack = Color.WHITE);
        pbg = new PushButtonGroup(new String[]{"SCAN 1D barcodes","SCAN 2D QR codes","SCAN Both types"},fmH/2,3);
        add(pbg,LEFT,TOP+fmH,FILL,PREFERRED+fmH);

        add(edtBarCode = new Label(""), LEFT, BOTTOM-fmH,FILL,PREFERRED);

        add(new Label("Result:"),LEFT,BEFORE);

        String mode = "2D";
                    String scan = Scanner.readBarcode("mode=" + mode + "&msg=" + msg);
                    if (scan != null)
                        edtBarCode.setText(scan);
*/

    }

    public static String readQRCode(String filePath, String charset, Map hintMap) throws FileNotFoundException, IOException, NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(
                        ImageIO.read(new FileInputStream(filePath)))));
        Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap, hintMap);
        return qrCodeResult.getText();
    }

    private static final String msg = "Place a barcode inside the viewfinder rectangle to scan it";
}
