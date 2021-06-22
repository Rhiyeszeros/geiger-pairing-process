package com.geiger.toolbox.ui.components;

import java.awt.Color;

import com.geiger.toolbox.ui.BaseScreen;
import com.geiger.toolbox.util.Colors;
import com.geiger.toolbox.util.Fonts;
import com.geiger.toolbox.util.Images;
import com.geiger.toolbox.util.MaterialConstants;

import totalcross.ui.AccordionContainer;
import totalcross.ui.Button;
import totalcross.ui.Check;
import totalcross.ui.Container;
import totalcross.ui.Control;
import totalcross.ui.Label;
import totalcross.ui.ScrollContainer;
import totalcross.ui.dialog.MessageBox;
import totalcross.util.UnitsConverter;

public class CardRecommendation extends Container {
    private int gap = UnitsConverter.toPixels(Control.DP + 10);
    public Button btnChevronUp;
    public Button btnChevronDown;

    @Override
    public void initUI() {
 
        AccordionContainer.Group gr = new AccordionContainer.Group();
		AccordionContainer ac[] = new AccordionContainer[5];
        Label threatDetails[] = new Label[5];
        Button btnGetHelp[] = new Button [5] ;
        Button btnGetTool [] = new Button [5];
        Label riskLevel [] = new Label [5];
        Check order [] = new Check [5];

        Images chevronDown = new Images("images/chevron-down.png");
        Images chevronUp = new Images("images/chevron-up.png");

        btnChevronDown = new Button(chevronDown.getImage(), BORDER_NONE);
        btnChevronUp = new Button(chevronUp.getImage(), BORDER_NONE);

		Label question = new Label("");
        Container spacing = new Container();


        //set values
        for (int i = 0; i < ac.length; i++) {
            ac[i] = new AccordionContainer(gr);
            //ac[i].minH = UnitsConverter.toPixels(DP + 100);
            ac[i].setBorderStyle(BORDER_ROUNDED); 
            //ac[i].getPreferredHeight();

            ac[i].minH = UnitsConverter.toPixels(DP + 60);
            
            riskLevel[i] = new Label("High");

            order[i] = new Check("Unsolicited e-mails");
            order[i].checkColor = Colors.PRIMARY;
            order[i].setFont(Fonts.nunitoBoldFont);

            threatDetails[i] = new Label("Be wary of any unsolicited e-mails you receive. Particularly trustworthy companies are often used as false sender addresses.");
            threatDetails[i].autoSplit = true;

            btnGetHelp[i] = new Button("Get Help", Button.BORDER_OUTLINED);
            btnGetHelp[i].setBackForeColors(Colors.PRIMARY, Colors.TEXT_ON_P_LIGHT);

            btnGetTool[i] = new Button("Get Tool");
            btnGetTool[i].setBackColor(Colors.PRIMARY);
			
		}
		
        //ac[0].setBorderStyle(BORDER_SIMPLE);
	
        for( int i = 0; i < ac.length; i++){
           
            add(ac[i],LEFT + gap, AFTER + MaterialConstants.COMPONENT_SPACING, PARENTSIZE + 92, PARENTSIZE + UnitsConverter.toPixels(DP + 8));
            
            ac[i].setBackColor(Colors.WHITE);
            ac[i].add(ac[i].new Caption(""), RIGHT, AFTER);
            //ac[i].add(ac[i].new Caption(question, btnChevronDown, btnChevronUp), RIGHT, AFTER, PREFERRED, PREFERRED);
            ac[i].add(order[i], LEFT + gap, TOP);
            ac[i].add(riskLevel[i], RIGHT - UnitsConverter.toPixels(DP + 40), CENTER_OF);
            ac[i].add(threatDetails[i], LEFT + gap, AFTER + MaterialConstants.MINI_FAB_SIZE, FILL, PREFERRED);
            ac[i].add(btnGetHelp[i], RIGHT - UnitsConverter.toPixels(DP + 90) , AFTER+ MaterialConstants.BORDER_SPACING);
            ac[i].add(btnGetTool[i], RIGHT - gap, BOTTOM_OF);
       
        }

        
    }

   

}
