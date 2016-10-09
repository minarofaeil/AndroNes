package com.online_brain.andrones;

import com.grapeshot.halfnes.audio.AudioOutInterface;

/**
 * @author Mina Rofaeil
 */

class AndroidAudioOut implements AudioOutInterface {
	@Override
	public void outputSample(int sample) {
	}

	@Override
	public void flushFrame(boolean waitIfBufferFull) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void destroy() {
	}

	@Override
	public boolean bufferHasLessThan(int samples) {
		return true;
	}
}
