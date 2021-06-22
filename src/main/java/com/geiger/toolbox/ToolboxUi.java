package com.geiger.toolbox;


import com.geiger.toolbox.ui.SplashScreen;


import com.geiger.toolbox.ui.screens.CompareRiskScreen;
import com.geiger.toolbox.ui.screens.ContactDefenderScreen;
import com.geiger.toolbox.ui.screens.DevicesScreen;
import com.geiger.toolbox.ui.screens.EmployeesScreen;

import com.geiger.toolbox.ui.screens.ReportIncidentScreen;
import com.geiger.toolbox.ui.screens.ScanRiskScreen;
import com.geiger.toolbox.ui.screens.SettingsScreen;
import com.geiger.toolbox.ui.screens.ToolsScreen;
import com.geiger.toolbox.ui.screens.UpdateToolboxScreen;
import com.geiger.toolbox.util.Colors;
import com.geiger.toolbox.util.Fonts;

import com.geiger.toolbox.util.MaterialConstants;

import totalcross.io.IOException;
import totalcross.json.JSONArray;
import totalcross.json.JSONObject;
import totalcross.sys.Settings;
import totalcross.ui.Button;

import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.ScrollContainer;
import totalcross.ui.SideMenuContainer;

import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.MaterialIcons;
import totalcross.ui.image.ImageException;
import totalcross.util.UnitsConverter;
public class ToolboxUi extends MainWindow {



    public ToolboxUi() {
        setUIStyle(Settings.MATERIAL_UI);
        setDefaultFont(Font.getFont(Fonts.FONT_DEFAULT_SIZE));
    }
    static {
		Settings.applicationId = "CGTB";
		Settings.appVersion = "1.0.0";
		Settings.iosCFBundleIdentifier = "com.geiger.toolboxUi";
	}

    

    @Override
    public void initUI(){
        MainWindow.getMainWindow().addTimer(100);
        SideMenuContainer.Item scanRisk = new SideMenuContainer.Item("GEIGER ToolBox", MaterialIcons._DO_NOT_DISTURB_ALT, Color.WHITE, () -> { return new ScanRiskScreen(); });
        SideMenuContainer.Item compareRisk = new SideMenuContainer.Item("Compare Risk", MaterialIcons._DO_NOT_DISTURB_ALT, Color.WHITE, () -> { return new CompareRiskScreen(); });
        SideMenuContainer.Item devices = new SideMenuContainer.Item("Devices", MaterialIcons._DO_NOT_DISTURB_ALT, Color.WHITE, () -> { return new DevicesScreen(); });
        SideMenuContainer.Item employees = new SideMenuContainer.Item("Employees", MaterialIcons._DO_NOT_DISTURB_ALT, Color.WHITE, () -> { return new EmployeesScreen(); });
        SideMenuContainer.Item tools = new SideMenuContainer.Item("Tools", MaterialIcons._DO_NOT_DISTURB_ALT, Color.WHITE, () -> { return new ToolsScreen(); });
        SideMenuContainer.Item settings = new SideMenuContainer.Item("Settings", MaterialIcons._DO_NOT_DISTURB_ALT, Color.WHITE, () -> { return new SettingsScreen();});
        SideMenuContainer.Item contactDefender = new SideMenuContainer.Item("Contact Defender", MaterialIcons._DO_NOT_DISTURB_ALT, Color.WHITE, () -> { return new ContactDefenderScreen(); });
        SideMenuContainer.Item reportIncident = new SideMenuContainer.Item("Report Incident", MaterialIcons._DO_NOT_DISTURB_ALT, Color.WHITE, () -> { return new ReportIncidentScreen(); });
        SideMenuContainer.Item updateToolbox = new SideMenuContainer.Item("Update Toolbox", MaterialIcons._DO_NOT_DISTURB_ALT, Color.WHITE, () -> { return new UpdateToolboxScreen(); });

        SideMenuContainer sideMenu = new SideMenuContainer(null, scanRisk, compareRisk, devices, employees, tools, settings, contactDefender, reportIncident, updateToolbox );



        SplashScreen sp;
        ScanRiskScreen homeScreen = new ScanRiskScreen();
        //swap(homeScreen);
           
        try{
            sp = new SplashScreen();
            sp.popupNonBlocking();
            swap(homeScreen);
        }

        catch(ImageException |  IOException ee){
            ee.printStackTrace();
        } 
        

        //side menu
        sideMenu.setItemForeColor(Color.BLACK);
        sideMenu.topMenu.drawSeparators = false;
        sideMenu.setBackColor(Colors.PRIMARY);
        sideMenu.setBarFont(Fonts.nunitoBoldFont);
        // sideMenu.setBarFont(Font.getFont(Font.getDefaultFontSize() + 5));
        sideMenu.setBackForeColors(0xFFFFFF, 0x2F4858);
        add(sideMenu, LEFT, TOP, PARENTSIZE, PARENTSIZE);
        
    }

}
