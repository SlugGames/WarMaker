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
package com.sluggames.WarMaker.views.MainMenu;

import com.sluggames.WarMaker.audio.sound.SoundEffect;
import com.sluggames.WarMaker.views.Credits.CreditsModel;
import com.sluggames.WarMaker.views.Game.GameModel;
import com.sluggames.WarMaker.views.License.LicenseModel;
import com.sluggames.WarMaker.views.Settings.SettingsModel;
import com.sluggames.WarMaker.views.Story.StoryModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * @author david.boeger@sluggames.com
 */
public class MainMenuController {
	/*
		******************
		*** COMPONENTS ***
		******************
	*/
	/*
			-------------------
			| NEW GAME BUTTON |
			-------------------
	*/
	@FXML
	private Button newGameButton;

	/*
				\\\\\\\\\\\\\\
				\ VIEW MODEL \
				\\\\\\\\\\\\\\
	*/
	private GameModel gameModel;

	/*
					///////
					/ SET /
					///////
	*/
	public void setGameModel(
	    GameModel gameModel
	) {
		this.gameModel = gameModel;
	}

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	private void initializeNewGameButton() {
		newGameButton.setOnAction((
		    ActionEvent actionEvent
		) -> {
			if (gameModel == null) {
				Platform.exit();
				throw new NullPointerException(
				    "gameModel == null"
				);
			}

			SoundEffect.WEAPON_LOAD.getAudioClip().play();
			gameModel.showView(false);
		});
	}

	/*
			----------------
			| STORY BUTTON |
			----------------
	*/
	@FXML
	private Button storyButton;

	/*
				\\\\\\\\\\\\\\
				\ VIEW MODEL \
				\\\\\\\\\\\\\\
	*/
	private StoryModel storyModel;

	/*
					///////
					/ SET /
					///////
	*/
	public void setStoryModel(
	    StoryModel storyModel
	) {
		this.storyModel = storyModel;
	}

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	private void initializeStoryButton() {
		storyButton.setOnAction((
		    ActionEvent actionEvent
		) -> {
			if (storyModel == null) {
				Platform.exit();
				throw new NullPointerException(
				    "storyModel == null"
				);
			}

			SoundEffect.WEAPON_LOAD.getAudioClip().play();
			storyModel.showView();
		});
	}

	/*
			-------------------
			| SETTINGS BUTTON |
			-------------------
	*/
	@FXML
	private Button settingsButton;

	/*
				\\\\\\\\\\\\\\
				\ VIEW MODEL \
				\\\\\\\\\\\\\\
	*/
	private SettingsModel settingsModel;

	/*
					///////
					/ SET /
					///////
	*/
	public void setSettingsModel(
	    SettingsModel settingsModel
	) {
		this.settingsModel = settingsModel;
	}

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	private void initializeSettingsButton() {
		settingsButton.setOnAction((
		    ActionEvent actionEvent
		) -> {
			if (settingsModel == null) {
				Platform.exit();
				throw new NullPointerException(
				    "settingsModel == null"
				);
			}

			SoundEffect.WEAPON_LOAD.getAudioClip().play();
			settingsModel.showView();
		});
	}

	/*
			------------------
			| CREDITS BUTTON |
			------------------
	*/
	@FXML
	private Button creditsButton;

	/*
				\\\\\\\\\\\\\\
				\ VIEW MODEL \
				\\\\\\\\\\\\\\
	*/
	private CreditsModel creditsModel;

	/*
					///////
					/ SET /
					///////
	*/
	public void setCreditsModel(
	    CreditsModel creditsModel
	) {
		this.creditsModel = creditsModel;
	}

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	private void initializeCreditsButton() {
		creditsButton.setOnAction((
		    ActionEvent actionEvent
		) -> {
			if (creditsModel == null) {
				Platform.exit();
				throw new NullPointerException(
				    "creditsModel == null"
				);
			}

			SoundEffect.WEAPON_LOAD.getAudioClip().play();
			creditsModel.showView();
		});
	}

	/*
			------------------
			| LICENSE BUTTON |
			------------------
	*/
	@FXML
	private Button licenseButton;

	/*
				\\\\\\\\\\\\\\
				\ VIEW MODEL \
				\\\\\\\\\\\\\\
	*/
	private LicenseModel licenseModel;

	/*
					///////
					/ SET /
					///////
	*/
	public void setLicenseModel(
	    LicenseModel licenseModel
	) {
		this.licenseModel = licenseModel;
	}

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	private void initializeLicenseButton() {
		licenseButton.setOnAction((
		    ActionEvent actionEvent
		) -> {
			if (licenseModel == null) {
				Platform.exit();
				throw new NullPointerException(
				    "licenseModel == null"
				);
			}

			SoundEffect.WEAPON_LOAD.getAudioClip().play();
			licenseModel.showView();
		});
	}

	/*
			---------------
			| QUIT BUTTON |
			---------------
	*/
	@FXML
	private Button quitButton;

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	private void initializeQuitButton() {
		quitButton.setOnAction((
		    ActionEvent actionEvent
		) -> {
			SoundEffect.WEAPON_LOAD.getAudioClip().play();
			Platform.exit();
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
		initializeNewGameButton();
		initializeStoryButton();
		initializeSettingsButton();
		initializeCreditsButton();
		initializeLicenseButton();
		initializeQuitButton();
	}
}