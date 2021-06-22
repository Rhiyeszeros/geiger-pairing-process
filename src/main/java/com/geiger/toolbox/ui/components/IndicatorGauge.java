package com.geiger.toolbox.ui.components;

import com.geiger.toolbox.util.Colors;
import com.geiger.toolbox.util.MaterialConstants;

import totalcross.ui.Container;
import totalcross.ui.chart.Velocimeter;
import totalcross.ui.event.Event;
import totalcross.ui.event.TimerEvent;
import totalcross.util.UnitsConverter;

public class IndicatorGauge extends Container {
    private TimerEvent tt;
	private Velocimeter vel;
    private int value;

    public IndicatorGauge(int value){
        this.value = value;
    }

    public void initUI() {
		try {

			tt = addTimer(50);
			vel = new Velocimeter();
            	//new Velocimeter("images/green.png", "images/pointer1.png");
			vel.max = 100;
			vel.drawMin = false;
			vel.drawMax = false;
			vel.drawValue = false;
			vel.min = 0;	
    		vel.pointerColor = Colors.PRIMARY;
			add(vel, RIGHT, TOP, PREFERRED + UnitsConverter.toPixels(DP + 45), PREFERRED+UnitsConverter.toPixels(DP + 45));
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

    @Override
	public void onEvent(Event e) {
		if (e.type == TimerEvent.TRIGGERED && tt.triggered) {
			vel.value = value;
			repaint();	
		}
	}
    
}
