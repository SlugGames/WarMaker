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

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;

/**
 * @author david.boeger@sluggames.com
 */
public class SettingsModel {
	/*
		******************
		*** GAME SCENE ***
		******************
	*/
	private Scene gameScene;

	/*
			-------
			| SET |
			-------
	*/
	public void setGameScene(
	    Scene gameScene
	) {
		this.gameScene = gameScene;
	}

	/*
			-------------
			| SHOW VIEW |
			-------------
	*/
	public void showView() {
		if (gameScene == null) {
			Platform.exit();
			throw new NullPointerException(
			    "gameScene == null"
			);
		}

		gameScene.setRoot(viewLoader.getRoot());
	}


	/*
		******************
		*** COMPONENTS ***
		******************
	*/
	/*
			---------------
			| VIEW LOADER |
			---------------
	*/
	public static final URL VIEW_FXML_FILE_URL =
	    SettingsModel.class.getResource(
	    "SettingsView.fxml"
	);

	private final FXMLLoader viewLoader =
	    new FXMLLoader(VIEW_FXML_FILE_URL);

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	private void initializeViewLoader() {
		viewLoader.setRoot(new ScrollPane());
		viewLoader.setController(new SettingsController());

		try {
			viewLoader.load();
		} catch (IOException exception) {
			Logger.getLogger(
			    SettingsModel.class.getName()).log(
			    Level.SEVERE,
			    null,
			    exception
			);

			Platform.exit();
		}
	}

	/*
				\\\\\\\\\\\\\\\\\\
				\ GET CONTROLLER \
				\\\\\\\\\\\\\\\\\\
	*/
	public SettingsController getController() {
		return viewLoader.getController();
	}


	/*
		********************
		*** CONSTRUCTION ***
		********************
	*/
	public SettingsModel() {
		/*
		Initialize components.
		*/
		initializeViewLoader();
	}
}