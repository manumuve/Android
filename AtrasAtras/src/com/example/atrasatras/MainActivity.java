package com.example.atrasatras;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	/**
     * Implementa la doble pulsación atrás para salir de la aplicación.
     * 
     * Si han pasado más de mTimeLimit milisegundos desde la última pulsación
     * del botón atrás, se muestra un mensaje pidiendo una segunda pulsación.
     * Si se pulsa el botón atrás antes de que pasen mTimeLimit milisegundos
     * desde la última pulsación, se llama al método onBackPressed() y (por
     * defecto) se sale de la aplicación.
     * 
     * Nota: la duración de los toast en Android es la siguiente:
     *	private static final int LONG_DELAY = 3500; // 3.5 seconds
     *	private static final int SHORT_DELAY = 2000; // 2 seconds
     *
     * @author manumuve
     * @version 1.0
     */
    private long mLastPress = 0;	// Cuándo se pulsó atrás por última vez
    private long mTimeLimit = 2000;	// Límite de tiempo entre pulsaciones, en ms
    
    @Override
    public void onBackPressed() {
        Toast onBackPressedToast = Toast.makeText(this, R.string.press_once_again_to_exit, Toast.LENGTH_SHORT);
        long currentTime = System.currentTimeMillis();
        
        if (currentTime - mLastPress > mTimeLimit) {
        	onBackPressedToast.show();
            mLastPress = currentTime;
        } else {
            onBackPressedToast.cancel();
            super.onBackPressed();
        }
        
    }
	
}
