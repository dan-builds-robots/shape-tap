package com.danielajayi.shapetap.game;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.danielajayi.shapetap.game.ShapeTap;



public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		AdapterAndroid adapterAndroid = new AdapterAndroid(this);

		ShapeTap shapeTap = new ShapeTap();

		shapeTap.setNotificationHandler(adapterAndroid);

		initialize(shapeTap, config);
	}
}
