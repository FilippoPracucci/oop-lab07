package it.unibo.mvc;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private final static int N_VIEWS = 3;

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
    public static void main(final String... args) throws
        ClassNotFoundException,
        InstantiationException,
        IllegalAccessException,
        IllegalArgumentException,
        InvocationTargetException,
        NoSuchMethodException {

        final DrawNumberImpl model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);
        for (final String name : List.of("Swing", "Stdout")) {
            final Class<?> viewClass = Class.forName("it.unibo.mvc.view.DrawNumber" + name + "View");
            for (int i = 0; i < N_VIEWS; i++) {
                final Object newClass = viewClass.getConstructor().newInstance();
                if (DrawNumberView.class.isAssignableFrom(newClass.getClass())) {
                    app.addView((DrawNumberView) newClass);
                } else {
                    throw new IllegalStateException (
                        newClass.getClass() + " view is not a subclass of " + DrawNumberView.class
                    );
                }
            }
        }
    }
}
