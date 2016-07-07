package es.jglancho.calculadorahipotecaria;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creado por Javier García on 21/06/2016.
 */
public class SplashScreenActivity extends Activity {

    private static final long SPLASH_SCREEN_DELAY = 3000;
    private static boolean ejecutarTareasIniciales = true;

    private static Logger log = LoggerFactory.getLogger(SplashScreenActivity.class);

    // Definición de la fuente para la splash screen
    private Typeface fuenteSplashScreen;


    /**
     * onCreate()
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        log.info("Actividad " + this.getLocalClassName().toString() + " - Método " + Thread.currentThread().getStackTrace()[2].getMethodName());

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash_screen);

        ejecutarTareasIniciales();

        irActividadPrincipal();
    }

    /**
     * onResume()
     *
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * onDestroy()
     *
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    /**
     * ejecutarTareasIniciales()
     *
     */
    private void ejecutarTareasIniciales() {

        // Establecemos la fuente por defecto
        fuenteSplashScreen = Typeface.createFromAsset(getAssets(), "fonts/actionjackson.ttf");

        TextView textViewNombreApp = (TextView) findViewById(R.id.textViewNombreApp);
        textViewNombreApp.setTypeface(fuenteSplashScreen);

        TextView textViewVersion = (TextView) findViewById(R.id.textViewVersion);
        textViewVersion.setTypeface(fuenteSplashScreen);

        ejecutarTareasIniciales = false;
    }


    /**
     * irActividadPrincipal()
     *
     */
    public void irActividadPrincipal() {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                Intent mainIntent = new Intent().setClass(SplashScreenActivity.this, MainActivity.class);
                startActivity(mainIntent);

                // Finaliza la actividad Splash Screen
                finish();
            }
        };

        // Se muestra la Splash Screen mientras se termina de realizar un determinado proceso
        // que se debería realizar en otro hilo de ejecución y devolver la ejecución a este
        // cuando acabe para que este continúe. Se podría ir refrescando este hilo también, mostrando
        // el avance del hilo secundario en el hilo primario.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

}
