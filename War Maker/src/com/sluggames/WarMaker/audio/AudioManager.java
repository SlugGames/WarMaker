/*
 * The MIT License
 *
 * Copyright (c) 2018 Slug Games
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.sluggames.WarMaker.audio;

import com.sluggames.WarMaker.audio.music.Music;
import com.sluggames.WarMaker.audio.sound.SoundEffect;
import com.sluggames.WarMaker.audio.voice.Voice;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * @author david.boeger@sluggames.com
 */
public class AudioManager {
	/*
		******************
		*** PROPERTIES ***
		******************
	*/
	/*
			----------
			| VOLUME |
			----------
	*/
	/*
				\\\\\\\\\
				\ MUSIC \
				\\\\\\\\\
	*/
	public static final double MINIMUM_MUSIC_VOLUME = 0;
	public static final double MAXIMUM_MUSIC_VOLUME = 1;
	public static final double DEFAULT_MUSIC_VOLUME =
	    MAXIMUM_MUSIC_VOLUME;

	private final SimpleDoubleProperty musicVolumeProperty =
	    new SimpleDoubleProperty(DEFAULT_MUSIC_VOLUME);

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	private void initializeMusicVolumeProperty() {
		for (Music music : Music.values()) {
			music.getMediaPlayer().volumeProperty().bind(
			    musicVolumeProperty
			);
		}
	}

	/*
					///////
					/ GET /
					///////
	*/
	public DoubleProperty musicVolumeProperty() {
		return musicVolumeProperty;
	}

	/*
				\\\\\\\\\
				\ VOICE \
				\\\\\\\\\
	*/
	public static final double MINIMUM_VOICE_VOLUME = 0;
	public static final double MAXIMUM_VOICE_VOLUME = 1;
	public static final double DEFAULT_VOICE_VOLUME =
	    MAXIMUM_VOICE_VOLUME;

	private final SimpleDoubleProperty voiceVolumeProperty =
	    new SimpleDoubleProperty(DEFAULT_VOICE_VOLUME);

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	private void initializeVoiceVolumeProperty() {
		for (Voice voice : Voice.values()) {
			voice.getMediaPlayer().volumeProperty().bind(
			    voiceVolumeProperty
			);
		}
	}

	/*
					///////
					/ GET /
					///////
	*/
	public DoubleProperty voiceVolumeProperty() {
		return voiceVolumeProperty;
	}

	/*
				\\\\\\\\\\\\\\\\
				\ SOUND EFFECT \
				\\\\\\\\\\\\\\\\
	*/
	public static final double MINIMUM_SOUND_EFFECT_VOLUME = 0;
	public static final double MAXIMUM_SOUND_EFFECT_VOLUME = 1;
	public static final double DEFAULT_SOUND_EFFECT_VOLUME =
	    MAXIMUM_SOUND_EFFECT_VOLUME;

	private final SimpleDoubleProperty soundEffectVolumeProperty =
	    new SimpleDoubleProperty(DEFAULT_SOUND_EFFECT_VOLUME);

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	private void initializeSoundEffectVolumeProperty() {
		for (SoundEffect soundEffect : SoundEffect.values()) {
			soundEffect.getAudioClip().volumeProperty().bind(
			    soundEffectVolumeProperty
			);
		}
	}

	/*
					///////
					/ GET /
					///////
	*/
	public DoubleProperty soundEffectVolumeProperty() {
		return soundEffectVolumeProperty;
	}


	/*
		******************
		*** COMPONENTS ***
		******************
	*/
	/*
			---------
			| MUSIC |
			---------
	*/
	private Music music;

	/*
				\\\\\\\
				\ SET \
				\\\\\\\
	*/
	public void setMusic(
	    Music music
	) {
		if (this.music != null) {
			this.music.getMediaPlayer().stop();
		}

		this.music = music;

		if (music != null) {
			music.getMediaPlayer().play();
		}
	}

	/*
			---------
			| VOICE |
			---------
	*/
	private Voice voice;

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	private void initializeVoice() {
		for (Voice voice : Voice.values()) {
			voice.getMediaPlayer().setOnEndOfMedia(() -> {
				this.voice = null;
			});
		}
	}

	/*
				\\\\\\\
				\ SET \
				\\\\\\\
	*/
	public void setVoice(
	    Voice voice
	) {
		if (this.voice != null) {
			this.voice.getMediaPlayer().stop();
		}

		this.voice = voice;

		if (voice != null) {
			voice.getMediaPlayer().play();
		}
	}


	/*
		********************
		*** CONSTRUCTION ***
		********************
	*/
	public AudioManager() {
		/*
		Initialize properties.
		*/
		initializeMusicVolumeProperty();
		initializeVoiceVolumeProperty();
		initializeSoundEffectVolumeProperty();

		/*
		Initialize components.
		*/
		initializeVoice();
	}
}