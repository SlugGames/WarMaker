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
package com.sluggames.WarMaker;

import com.sluggames.WarMaker.audio.AudioManager;
import com.sluggames.WarMaker.audio.music.Music;
import com.sluggames.WarMaker.views.Credits.CreditsModel;
import com.sluggames.WarMaker.views.Game.GameModel;
import com.sluggames.WarMaker.views.License.LicenseModel;
import com.sluggames.WarMaker.views.MainMenu.MainMenuModel;
import com.sluggames.WarMaker.views.Settings.SettingsModel;
import com.sluggames.WarMaker.views.Story.StoryModel;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * @author david.boeger@sluggames.com
 */
public class WarMaker
    extends Application
{
	/*
		******************
		*** COMPONENTS ***
		******************
	*/
	/*
			-----------------
			| AUDIO MANAGER |
			-----------------
	*/
	private AudioManager audioManager;

	/*
			---------------
			| VIEW MODELS |
			---------------
	*/
	private Scene gameScene;
	private Stage gameStage;
	
	/*
				\\\\\\\\\\\\\
				\ MAIN MENU \
				\\\\\\\\\\\\\
	*/
	private MainMenuModel mainMenuModel;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	private void initializeMainMenuModel() {
		mainMenuModel.setGameScene(gameScene);
		mainMenuModel.getController().setGameModel(gameModel);
		mainMenuModel.getController().setStoryModel(storyModel);
		mainMenuModel.getController().setSettingsModel(settingsModel);
		mainMenuModel.getController().setCreditsModel(creditsModel);
		mainMenuModel.getController().setLicenseModel(licenseModel);

		mainMenuModel.showView();
	}

	/*
				\\\\\\\\
				\ GAME \
				\\\\\\\\
	*/
	private GameModel gameModel;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	private void initializeGameModel() {
		gameModel.setAudioManager(audioManager);
		gameModel.setGameScene(gameScene);
		gameModel.getController().setGameScene(gameScene);
		gameModel.getController().setAudioManager(audioManager);
		gameModel.getController().setMainMenuModel(mainMenuModel);
	}

	/*
				\\\\\\\\\
				\ STORY \
				\\\\\\\\\
	*/
	private StoryModel storyModel;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	private void initializeStoryModel() {
		storyModel.setAudioManager(audioManager);
		storyModel.setGameScene(gameScene);
		storyModel.getController().setAudioManager(audioManager);
		storyModel.getController().setMainMenuModel(mainMenuModel);
	}

	/*
				\\\\\\\\\\\\
				\ SETTINGS \
				\\\\\\\\\\\\
	*/
	private SettingsModel settingsModel;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	private void initializeSettingsModel() {
		settingsModel.setGameScene(gameScene);
		settingsModel.getController().setGameStage(gameStage);
		settingsModel.getController().setAudioManager(audioManager);
		settingsModel.getController().setMainMenuModel(mainMenuModel);
	}

	/*
				\\\\\\\\\\\
				\ CREDITS \
				\\\\\\\\\\\
	*/
	private CreditsModel creditsModel;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	private void initializeCreditsModel() {
		creditsModel.setGameScene(gameScene);
		creditsModel.getController().setMainMenuModel(mainMenuModel);
	}

	/*
				\\\\\\\\\\\
				\ LICENSE \
				\\\\\\\\\\\
	*/
	private LicenseModel licenseModel;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	private void initializeLicenseModel() {
		licenseModel.setGameScene(gameScene);
		licenseModel.getController().setMainMenuModel(mainMenuModel);
	}


	/*
		**************
		*** LAUNCH ***
		**************
	*/
	/*
			--------
			| MAIN |
			--------
	*/
	public static void main(
	    String[] args
	) {
		launch(args);
	}

	/*
			---------
			| START |
			---------
	*/
	@Override
	public void start(
	    Stage gameStage
	) {
		/*
		Create components.
		*/
		audioManager = new AudioManager();
		gameScene = new Scene(new Group());
		this.gameStage = gameStage;
		mainMenuModel = new MainMenuModel();
		gameModel = new GameModel();
		storyModel = new StoryModel();
		settingsModel = new SettingsModel();
		creditsModel = new CreditsModel();
		licenseModel = new LicenseModel();

		/*
		Initialize components.
		*/
		initializeMainMenuModel();
		initializeGameModel();
		initializeStoryModel();
		initializeSettingsModel();
		initializeCreditsModel();
		initializeLicenseModel();

		/*
		Play main menu music.
		*/
		audioManager.setMusic(Music.BATTLE_THEME_2);

		/*
		Prepare game stage.
		*/
		gameStage.setTitle("War Maker");
		gameStage.setFullScreenExitHint("");
		gameStage.setFullScreenExitKeyCombination(
		    KeyCombination.NO_MATCH
		);
		gameStage.setScene(gameScene);
		gameStage.setX(
		    Screen.getPrimary().getBounds().getMinX() + 50
		);
		gameStage.setY(
		    Screen.getPrimary().getBounds().getMinY() + 50
		);
		gameStage.setWidth(
		    Screen.getPrimary().getBounds().getWidth() / 2
		);
		gameStage.setHeight(
		    Screen.getPrimary().getBounds().getHeight() / 2
		);
		gameStage.show();
	}
}