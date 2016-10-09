package com.online_brain.andrones;

import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.widget.Toast;

import com.grapeshot.halfnes.NES;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class GamePlayActivity extends Activity implements Callback {

    private NES nes;
	private AndroidUI androidUI;
	private AndroidController controller1;
	private AndroidController controller2;

	private NESRunnerThread nesRunnerThread;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

	    androidUI = (AndroidUI) findViewById(R.id.game_play_view);
	    SurfaceHolder surfaceHolder = androidUI.getHolder();
	    surfaceHolder.addCallback(this);
	    nes = new NES(androidUI, new AndroidAudioOutFactory());
		controller1 = new AndroidController();
		controller2 = new AndroidController();
		nes.setControllers(controller1, controller2);
		nesRunnerThread = new NESRunnerThread();
    }

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		nesRunnerThread.start();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		nes.quit();
	}

	private class NESRunnerThread extends Thread {
		@Override
		public void run() {
			String romFileName = "BattleTank.nes";
			File romFile = new File(getCacheDir(), romFileName);
			try (InputStream inputStream = getAssets().open(romFileName); FileOutputStream romFileOutputStream = new FileOutputStream(romFile)) {
				byte[] buffer = new byte[5120];

				int read;
				while ((read = inputStream.read(buffer)) >= 0) {
					romFileOutputStream.write(buffer, 0, read);
				}

				inputStream.close();
				romFileOutputStream.close();

				nes.run(romFile.getPath());
			} catch (IOException ex) {
				Toast.makeText(GamePlayActivity.this, R.string.unable_to_load_rom, Toast.LENGTH_SHORT).show();
				finish();
			}
		}
	}
}
