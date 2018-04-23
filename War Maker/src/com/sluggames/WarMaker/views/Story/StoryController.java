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
package com.sluggames.WarMaker.views.Story;

import com.sluggames.WarMaker.audio.AudioManager;
import com.sluggames.WarMaker.audio.music.Music;
import com.sluggames.WarMaker.audio.sound.SoundEffect;
import com.sluggames.WarMaker.views.MainMenu.MainMenuModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * @author dmboe
 */
public class StoryController {
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
		this.audioManager = audioManager;
	}


	/*
		******************
		*** COMPONENTS ***
		******************
	*/
	/*
			--------------
			| STORY TEXT |
			--------------
	*/
	@FXML
	private Text storyText;

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	public static final String STORY_TEXT =
	    "War. The world is engulfed by it. Millions have died. Millions " +
	    "more will starve or be killed. The global economy is in ruins. " +
	    "The last remaining nations on Earth have divided themselves " +
	    "into 2 opposing sides, each bound by ideology to conquer the " +
	    "other." +
	    "\n\n" +
	    "Redania fights for law and order. Bluezbekistan fights for " +
	    "liberty. Many predict this will be the war to end all wars..." +
	    "\n\n" +
	    "...which would be terrible for business! As the newest sales " +
	    "recruit for Freedom and Piece, Inc., the only remaining arms " +
	    "dealer and defense contractor large enough to supply both " +
	    "sides, you have been tasked with preserving the power " +
	    "equilibrium between Redania and Bluezbekistan through strategic " +
	    "pricing and contract negotiation. You are the military " +
	    "industrial complex's last line of defense. Now go, prolong the " +
	    "war, and secure this company's financial future!" +
	    "\n\n" +
	    "And remember our company motto: Having freedom, means having a " +
	    "piece!";

	private void initializeStoryText() {
		storyText.setText(STORY_TEXT);
	}

	/*
			--------------------
			| MAIN MENU BUTTON |
			--------------------
	*/
	@FXML
	private Button mainMenuButton;

	/*
				\\\\\\\\\\\\\\
				\ VIEW MODEL \
				\\\\\\\\\\\\\\
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
			if (audioManager == null) {
				Platform.exit();
				throw new NullPointerException(
				    "audioManager == null"
				);
			}
			if (mainMenuModel == null) {
				Platform.exit();
				throw new NullPointerException(
				    "mainMenuModel == null"
				);
			}

			SoundEffect.WEAPON_LOAD.getAudioClip().play();
			audioManager.setVoice(null);
			audioManager.setMusic(Music.BATTLE_THEME_2);
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
		initializeStoryText();
		initializeMainMenuButton();
	}
}
