package com.geiger.toolbox.util;

import totalcross.ui.font.Font;

public class Fonts {
    public static final int FONT_DEFAULT_SIZE = 16;

    public static Font nunitoRegularDefaultSize;
    public static Font nunitoLightDefaultSize;
    public static Font nunitoBoldFont;
    public static Font nunitoItalic;
    public static Font nunitoBoldScoreSize;
    public static Font nunitoRiskLevel;
    static{

        //Nunito Regular
        nunitoRegularDefaultSize = Font.getFont("fonts/Nunito-Regular.ttf", false, FONT_DEFAULT_SIZE);

        //Nunito Light
        nunitoLightDefaultSize = Font.getFont("fonts/Nunito-Light.ttf", false, FONT_DEFAULT_SIZE);

        //Nunito bold
        nunitoBoldFont = Font.getFont("fonts/Nunito-Bold.ttf", false, FONT_DEFAULT_SIZE);

        //Nunito italic
        nunitoItalic = Font.getFont("fonts/Nunito-Italic.ttf", false, FONT_DEFAULT_SIZE);

        nunitoBoldScoreSize = Font.getFont("fonts/Nunito-Bold.ttf", false, 36);

        nunitoRiskLevel = Font.getFont("fonts/Nunito-Bold.ttf", false, 12);
    }
}
