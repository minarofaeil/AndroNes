package com.online_brain.tvnes;

import android.app.Activity;
import android.os.Bundle;

import com.grapeshot.halfnes.NES;

public class GamePlayActivity extends Activity {

    private NES nes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

	    HalfNesAndroidUI halfNesAndroidUI = (HalfNesAndroidUI) findViewById(R.id.game_play_view);
	    nes = new NES(halfNesAndroidUI);


    }
}
