package es.jglancho.calculadorahipotecaria;

import android.app.Activity;
import android.os.Bundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainActivity extends Activity {

    private static Logger log = LoggerFactory.getLogger(SplashScreenActivity.class);

    /**
     * onCreate()
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log.info("Actividad " + this.getLocalClassName().toString() + " - Método " + Thread.currentThread().getStackTrace()[2].getMethodName());
    }
}
