package com.online_brain.andrones;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;
import android.widget.Toast;

import com.grapeshot.halfnes.NES;
import com.grapeshot.halfnes.ui.GUIInterface;

/**
 * @author Mina Rofaeil
 */

public class AndroidUI extends SurfaceView implements GUIInterface {
	private int frames;
	private long time;

	private NES nes;

	public AndroidUI(Context context) {
		super(context);
	}

	public AndroidUI(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public AndroidUI(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@TargetApi(21)
	public AndroidUI(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	@Override
	public NES getNes() {
		return nes;
	}

	@Override
	public void setNES(NES nes) {
		this.nes = nes;
	}

	@Override
	public void setFrame(int[] frame, int[] bgcolor, boolean dotcrawl) {
//		Log.d("HalfNESAndroid", "setFrame() is called");
		frames++;
		long now = System.currentTimeMillis();

		if (now - time >= 1000) {
			Log.d("HalfNESAndroid", "Frame rate: " + (frames / ((now - time) / 1000.0)));
			time = now;
			frames = 0;
		}
	}

	@Override
	public void messageBox(String message) {
		Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
	}

	@Override
	public void run() {
		Log.d("HalfNESAndroid", "run() is called");
	}

	@Override
	public void render() {
		Log.d("HalfNESAndroid", "render() is called");
	}

	@Override
	public void loadROMs(String path) {
		Log.d("HalfNESAndroid", "loadRom() is called with: " + path);
		nes.loadROM(path);
		frames = 0;
		time = System.currentTimeMillis();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Log.d("HalfNESAndroid", "onDraw() is called");
	}
}
