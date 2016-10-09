package com.online_brain.andrones;

import com.grapeshot.halfnes.audio.AudioOutInterface;
import com.grapeshot.halfnes.audio.AudioOutInterfaceFactory;

/**
 * @author Mina Rofaeil
 */

public class AndroidAudioOutFactory implements AudioOutInterfaceFactory {
	@Override
	public AudioOutInterface createAudioOutInterface() {
		return new AndroidAudioOut();
	}
}
