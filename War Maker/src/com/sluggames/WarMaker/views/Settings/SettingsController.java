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
package com.sluggames.WarMaker.views.Settings;

import com.sluggames.WarMaker.audio.AudioManager;
import com.sluggames.WarMaker.audio.sound.SoundEffect;
import com.sluggames.WarMaker.views.MainMenu.MainMenuModel;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

/**
 * @author david.boeger@sluggames.com
 */
public class SettingsController {
	/*
		*********************
		*** AUDIO MANAGER ***
		*********************
	*/
	private AudioManager audioManager;

	/*
			-------
			| SET |
			-------
	*/
	public void setAudioManager(
	    AudioManager audioManager
	) {
		if (this.audioManager != null) {
			this.audioManager.soundEffectVolumeProperty().unbind();
			this.audioManager.voiceVolumeProperty().unbind();
			this.audioManager.musicVolumeProperty().unbind();
		}

		this.audioManager = audioManager;

		if (audioManager != null) {
			audioManager.musicVolumeProperty().bind(
			    musicVolumeSlider.valueProperty()
			);
			audioManager.voiceVolumeProperty().bind(
			    voiceVolumeSlider.valueProperty()
			);
			audioManager.soundEffectVolumeProperty().bind(
			    soundEffectsVolumeSlider.valueProperty()
			);
		}
	}


	/*
		******************
		*** COMPONENTS ***
		******************
	*/
	/*
			-------------------------
			| FULL SCREEN CHECK BOX |
			-------------------------
	*/
	@FXML
	private CheckBox fullScreenCheckBox;

	/*
				\\\\\\\\\\\\\\
				\ GAME STAGE \
				\\\\\\\\\\\\\\
	*/
	private Stage gameStage;

	/*
					///////
					/ SET /
					///////
	*/
	public void setGameStage(
	    Stage gameStage
	) {
		this.gameStage = gameStage;
	}

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	private void initializeFullScreenCheckBox() {
		fullScreenCheckBox.selectedProperty().addListener((
		    ObservableValue<? extends Boolean> selectedObservableValue,
		    Boolean selectedOldValue,
		    Boolean selectedNewValue
		) -> {
			if (selectedNewValue == null) {
				Platform.exit();
				throw new NullPointerException(
				    "selectedNewValue == null"
				);
			}
			if (gameStage == null) {
				Platform.exit();
				throw new NullPointerException(
				    "gameStage == null"
				);
			}

			SoundEffect.WEAPON_LOAD.getAudioClip().play();
			gameStage.setFullScreen(selectedNewValue);
		});
	}

	/*
			------------------
			| VOLUME SLIDERS |
			------------------
	*/
	/*
				\\\\\\\\\
				\ MUSIC \
				\\\\\\\\\
	*/
	@FXML
	private Slider musicVolumeSlider;

	/*
					/////////
					/ LABEL /
					/////////
	*/
	@FXML
	private Label musicVolumeSliderLabel;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	public static final double MINIMUM_MUSIC_VOLUME = 0;
	public static final double MAXIMUM_MUSIC_VOLUME = 1;
	public static final double DEFAULT_MUSIC_VOLUME = MAXIMUM_MUSIC_VOLUME;

	private void initializeMusicVolumeSlider() {
		musicVolumeSliderLabel.setLabelFor(
		    musicVolumeSlider
		);

		musicVolumeSlider.setMin(MINIMUM_MUSIC_VOLUME);
		musicVolumeSlider.setMax(MAXIMUM_MUSIC_VOLUME);
		musicVolumeSlider.setValue(DEFAULT_MUSIC_VOLUME);
	}

	/*
				\\\\\\\\\
				\ VOICE \
				\\\\\\\\\
	*/
	@FXML
	private Slider voiceVolumeSlider;

	/*
					/////////
					/ LABEL /
					/////////
	*/
	@FXML
	private Label voiceVolumeSliderLabel;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	public static final double MINIMUM_VOICE_VOLUME = MINIMUM_MUSIC_VOLUME;
	public static final double MAXIMUM_VOICE_VOLUME = MAXIMUM_MUSIC_VOLUME;
	public static final double DEFAULT_VOICE_VOLUME = MAXIMUM_VOICE_VOLUME;

	private void initializeVoiceVolumeSlider() {
		voiceVolumeSliderLabel.setLabelFor(
		    voiceVolumeSlider
		);

		voiceVolumeSlider.setMin(MINIMUM_VOICE_VOLUME);
		voiceVolumeSlider.setMax(MAXIMUM_VOICE_VOLUME);
		voiceVolumeSlider.setValue(DEFAULT_VOICE_VOLUME);
	}

	/*
				\\\\\\\\\\\\\\\\\
				\ SOUND EFFECTS \
				\\\\\\\\\\\\\\\\\
	*/
	@FXML
	private Slider soundEffectsVolumeSlider;

	/*
					/////////
					/ LABEL /
					/////////
	*/
	@FXML
	private Label soundEffectsVolumeSliderLabel;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	public static final double MINIMUM_SOUND_EFFECTS_VOLUME = 0;
	public static final double MAXIMUM_SOUND_EFFECTS_VOLUME = 1;
	public static final double DEFAULT_SOUND_EFFECTS_VOLUME =
	    MAXIMUM_SOUND_EFFECTS_VOLUME;

	private void initializeSoundEffectsVolumeSlider() {
		soundEffectsVolumeSliderLabel.setLabelFor(
		    soundEffectsVolumeSlider
		);

		soundEffectsVolumeSlider.setMin(MINIMUM_SOUND_EFFECTS_VOLUME);
		soundEffectsVolumeSlider.setMax(MAXIMUM_SOUND_EFFECTS_VOLUME);
		soundEffectsVolumeSlider.setValue(DEFAULT_SOUND_EFFECTS_VOLUME);
	}

	/*
			--------------------
			| MAIN MENU BUTTON |
			--------------------
	*/
	@FXML
	private Button mainMenuButton;

	/*
				\\\\\\\\\
				\ MODEL \
				\\\\\\\\\
	*/
	private MainMenuModel mainMenuModel;

	/*
					///////
					/ SET /
					///////
	*/
	public void setMainMenuModel(
	    MainMenuModel mainMenuModel
	) {
		this.mainMenuModel = mainMenuModel;
	}

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	private void initializeMainMenuButton() {
		mainMenuButton.setOnAction((
		    ActionEvent actionEvent
		) -> {
			if (mainMenuModel == null) {
				throw new NullPointerException(
				    "mainMenuModel == null"
				);
			}

			SoundEffect.WEAPON_LOAD.getAudioClip().play();
			mainMenuModel.showView();
		});
	}


	/*
		******************
		*** INITIALIZE ***
		******************
	*/
	@FXML
	public void initialize() {
		/*
		Initialize components.
		*/
		initializeFullScreenCheckBox();
		initializeMusicVolumeSlider();
		initializeVoiceVolumeSlider();
		initializeSoundEffectsVolumeSlider();
		initializeMainMenuButton();
	}
}