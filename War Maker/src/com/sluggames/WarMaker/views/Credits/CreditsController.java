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
package com.sluggames.WarMaker.views.Credits;

import com.sluggames.WarMaker.audio.sound.SoundEffect;
import com.sluggames.WarMaker.views.MainMenu.MainMenuModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * @author david.boeger@sluggames.com
 */
public class CreditsController {
	/*
		******************
		*** COMPONENTS ***
		******************
	*/
	/*
			----------------
			| CREDITS TEXT |
			----------------
	*/
	@FXML
	private Text creditsText;

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	public static final String CREDITS_TEXT =
	    "War Maker\n" +
	    "Developed by Slug Games." +
	    "\n\n\n" +
	    "Programming:\n" +
	    "\nDavid Boeger" +
	    "\n\n\n" +
	    "Voice:\n" +
	    "\nDavid Boeger" +
	    "\n\n\n" +
	    "\"Battle Themes\" Music:\n" +
	    "\nAlexandr Zhelanov" +
	    "\n(https://soundcloud.com/alexandr-zhelanov)" +
	    "\n(https://opengameart.org/users/alexandr-zhelanov)" +
	    "\n\n\n" +
	    "\"Weapon Load\" Sound Effect:\n" +
	    "\nMichel Baradari" +
	    "\n(http://apollo-sound.de/)";

	private void initializeCreditsText() {
		creditsText.setText(CREDITS_TEXT);
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
			if (mainMenuModel == null) {
				Platform.exit();
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
		initializeCreditsText();
		initializeMainMenuButton();
	}
}