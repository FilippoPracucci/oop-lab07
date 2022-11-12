package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberStdoutView implements DrawNumberView {

    @Override
    public void setController(DrawNumberController observer) {
        /*
         * Empty because is output only
         */
    }

    @Override
    public void start() {
        /*
         * Empty because is output only
         */
    }

    @Override
    public void result(final DrawResult res) {
        System.out.println(res.getDescription());
    }
    
}
