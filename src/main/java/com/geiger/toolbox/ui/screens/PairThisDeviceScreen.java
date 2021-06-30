package com.geiger.toolbox.ui.screens;

import com.geiger.toolbox.util.Colors;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import totalcross.io.FileNotFoundException;
import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.util.UnitsConverter;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;

public class PairThisDeviceScreen extends Container {

    public ScrollContainer scrollContainer;
    int margin = UnitsConverter.toPixels(Control.DP + 10);


    @Override
    public void initUI() {

        scrollContainer = new ScrollContainer() {
            @Override
            public void initUI() {
                setScrollBars(false, false);
                super.initUI();
            }
        };

        add(scrollContainer, LEFT, TOP, FILL, FILL);

        String text = "{'deviceName' = 'Huawei P30 Pro', 'score' = 25, 'type' = 'Smartphone'}";

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 800, 800);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        try {
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] pngData = pngOutputStream.toByteArray();

        ImageControl ic = null;
        try {
            ic = new ImageControl(new Image(pngData));
        } catch (ImageException e) {
            e.printStackTrace();
        }

        ic.scaleToFit = true;
        ic.centerImage = true;
        scrollContainer.add(ic, CENTER, TOP, PREFERRED, PREFERRED);

        Label lb1 = new Label("To pair this device, please scan \n the QR code with your Smartphone.", CENTER);
        scrollContainer.add(lb1, CENTER, AFTER, Settings.screenWidth - margin * 2, PREFERRED);
    }
}
