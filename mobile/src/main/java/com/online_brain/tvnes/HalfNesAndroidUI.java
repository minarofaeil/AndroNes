package com.online_brain.tvnes;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.Toast;

import com.grapeshot.halfnes.NES;
import com.grapeshot.halfnes.ui.GUIInterface;

/**
 * @author Mina Rofaeil
 */

public class HalfNesAndroidUI extends SurfaceView implements GUIInterface {
	private NES nes;

	public HalfNesAndroidUI(Context context) {
		super(context);
	}

	public HalfNesAndroidUI(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public HalfNesAndroidUI(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@TargetApi(21)
	public HalfNesAndroidUI(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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

	}

	@Override
	public void messageBox(String message) {
		Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
	}

	@Override
	public void run() {
	}

	@Override
	public void render() {
	}

	@Override
	public void loadROMs(String path) {
	}
}
