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
package com.sluggames.WarMaker.views.Game;

import com.sluggames.WarMaker.audio.AudioManager;
import com.sluggames.WarMaker.audio.music.Music;
import com.sluggames.WarMaker.audio.sound.SoundEffect;
import com.sluggames.WarMaker.audio.voice.Voice;
import com.sluggames.WarMaker.views.MainMenu.MainMenuModel;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * @author david.boeger@sluggames.com
 */
public class GameController {
	/*
		******************
		*** GAME SCENE ***
		******************
	*/
	private Scene gameScene;

	/*
			--------------------
			| PAUSE KEYS TYPED |
			--------------------
	*/
	private final boolean pauseKeysTyped[] = new boolean[2];

	/*
			-------
			| SET |
			-------
	*/
	public void setGameScene(
	    Scene gameScene
	) {
		this.gameScene = gameScene;
		gameScene.setOnKeyPressed((
		    KeyEvent keyEvent
		) -> {
			if (keyEvent.getCode() == KeyCode.ESCAPE) {
				pauseKeysTyped[0] = true;
			} else if (keyEvent.getCode() == KeyCode.P) {
				pauseKeysTyped[1] = true;
			}
		});
		gameScene.setOnKeyReleased((
		    KeyEvent keyEvent
		) -> {
			if (keyEvent.getCode() == KeyCode.ESCAPE) {
				pauseKeysTyped[0] = false;
			} else if (keyEvent.getCode() == KeyCode.P) {
				pauseKeysTyped[1] = false;
			}
		});
	}


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
			-------
			| RED |
			-------
	*/
	/*
				\\\\\\\\
				\ PANE \
				\\\\\\\\
	*/
	@FXML
	private StackPane redStackPane;
	@FXML
	private Text redHealthText;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	private void initializeRedStackPane() {
		redBase.healthPointsProperty().addListener((
		    healthPointsObservableValue,
		    healthPointsOldValue,
		    healthPointsNewValue
		) -> {
			redHealthText.setText(
			    Integer.toString(healthPointsNewValue.intValue())
			);
		});

		redBase.setOnSpawn(() -> {
			if (
			    ThreadLocalRandom.current().nextDouble() >
			    1 / redPriceSlider.getValue()
			) {
				return;
			}

			SoundEffect.WEAPON_LOAD.getAudioClip().play();
			unitsScore += 1;

			for (DefenseTurret redDefenseTurret : redDefenseTurrets) {
				if (
				    redDefenseTurret.healthPointsProperty().get() <=
				    DefenseTurret.MINIMUM_HEALTH_POINTS
				) {
					redDefenseTurret.healthPointsProperty().set(
					    DefenseTurret.MAXIMUM_HEALTH_POINTS
					);
					return;
				}
			}

			Missile redMissile;
			if (freeRedMissiles.isEmpty()) {
				redMissile = new Missile();

				airGroup.getChildren().add(
				    redMissile.getPath()
				);
				airGroup.getChildren().add(
				    redMissile.getTriangle()
				);

				redMissile.setOnDeath(() -> {
					redMissiles.remove(redMissile);
					redMissile.reset();
					freeRedMissiles.add(redMissile);

					redMissile.getTriangle().setVisible(false);
					redMissile.getPath().setVisible(false);
				});
				redMissile.setOnTargetHit(() -> {
					redMissiles.remove(redMissile);
					redMissile.reset();
					freeRedMissiles.add(redMissile);

					redMissile.getTriangle().setVisible(false);
					redMissile.getPath().setVisible(false);

					redBase.heal(1);
					blueBase.damage(1);
				});
			} else {
				redMissile = freeRedMissiles.removeLast();
				redMissile.reset();

				redMissile.getTriangle().setVisible(true);
				redMissile.getPath().setVisible(true);
			}

			redMissile.setColor(Color.RED);
			redMissile.spawnCoordinatesProperty().set(
			    new Point2D(
			    redStackPane.getLayoutX(),
			    redStackPane.getLayoutY()
			));
			redMissile.targetCoordinatesProperty().set(
			    new Point2D(
			    blueStackPane.getLayoutX() - 75,
			    blueStackPane.getLayoutY()
			));

			redMissiles.add(redMissile);
		});
	}

	/*
				\\\\\\\\\\\
				\ CIRCLES \
				\\\\\\\\\\\
	*/
	@FXML
	private Circle redCircle1;
	@FXML
	private Circle redCircle2;
	@FXML
	private Circle redCircle3;
	@FXML
	private Circle redCircle4;
	@FXML
	private Circle redCircle5;
	@FXML
	private Circle redCircle6;
	@FXML
	private Circle redCircle7;
	@FXML
	private Circle redCircle8;
	@FXML
	private Circle redCircle9;
	@FXML
	private Circle redCircle10;
	@FXML
	private Circle redCircle11;
	@FXML
	private Circle redCircle12;
	@FXML
	private Circle redCircle13;
	@FXML
	private Circle redCircle14;
	@FXML
	private Circle redCircle15;
	@FXML
	private Circle redCircle16;
	@FXML
	private Circle redCircle17;
	@FXML
	private Circle redCircle18;
	@FXML
	private Circle redCircle19;
	@FXML
	private Circle redCircle20;

	private Circle[] redCircles;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	private void initializeRedCircles() {
		redCircles = new Circle[] {
			redCircle1,
			redCircle2,
			redCircle3,
			redCircle4,
			redCircle5,
			redCircle6,
			redCircle7,
			redCircle8,
			redCircle9,
			redCircle10,
			redCircle11,
			redCircle12,
			redCircle13,
			redCircle14,
			redCircle15,
			redCircle16,
			redCircle17,
			redCircle18,
			redCircle19,
			redCircle20
		};

		for (int index = 0; index < 20; index++) {
			final int indexFinal = index;
			redDefenseTurrets[index] = new DefenseTurret();
			redDefenseTurrets[index].healthPointsProperty().addListener((
			    ObservableValue<? extends Number> healthPointsObservableValue,
			    Number healthPointsOldValue,
			    Number healthPointsNewValue
			) -> {
				redCircles[indexFinal].setFill(
				    Color.BLACK.interpolate(
				    Color.RED,
				    healthPointsNewValue.doubleValue() /
				    DefenseTurret.MAXIMUM_HEALTH_POINTS
				));
			});
		}
	}

	/*
				\\\\\\\\\\\\\\\\
				\ PRICE SLIDER \
				\\\\\\\\\\\\\\\\
	*/
	@FXML
	private Slider redPriceSlider;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	private void initializeRedPriceSlider() {
	}

	/*
			--------
			| BLUE |
			--------
	*/
	/*
				\\\\\\\\
				\ PANE \
				\\\\\\\\
	*/
	@FXML
	private StackPane blueStackPane;
	@FXML
	private Text blueHealthText;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	private void initializeBlueStackPane() {
		blueBase.healthPointsProperty().addListener((
		    healthPointsObservableValue,
		    healthPointsOldValue,
		    healthPointsNewValue
		) -> {
			blueHealthText.setText(
			    Integer.toString(healthPointsNewValue.intValue())
			);
		});

		blueBase.setOnSpawn(() -> {
			if (
			    ThreadLocalRandom.current().nextDouble() >
			    1 / bluePriceSlider.getValue()
			) {
				return;
			}

			SoundEffect.WEAPON_LOAD.getAudioClip().play();
			unitsScore += 1;

			for (DefenseTurret blueDefenseTurret : blueDefenseTurrets) {
				if (
				    blueDefenseTurret.healthPointsProperty().get() <=
				    DefenseTurret.MINIMUM_HEALTH_POINTS
				) {
					blueDefenseTurret.healthPointsProperty().set(
					    DefenseTurret.MAXIMUM_HEALTH_POINTS
					);
					return;
				}
			}

			Missile blueMissile;
			if (freeBlueMissiles.isEmpty()) {
				blueMissile = new Missile();

				airGroup.getChildren().add(
				    blueMissile.getPath()
				);
				airGroup.getChildren().add(
				    blueMissile.getTriangle()
				);

				blueMissile.setOnDeath(() -> {
					blueMissiles.remove(blueMissile);
					blueMissile.reset();
					freeBlueMissiles.add(blueMissile);

					blueMissile.getTriangle().setVisible(false);
					blueMissile.getPath().setVisible(false);
				});
				blueMissile.setOnTargetHit(() -> {
					blueMissiles.remove(blueMissile);
					blueMissile.reset();
					freeBlueMissiles.add(blueMissile);

					blueMissile.getTriangle().setVisible(false);
					blueMissile.getPath().setVisible(false);

					blueBase.heal(1);
					redBase.damage(1);
				});
			} else {
				blueMissile = freeBlueMissiles.removeLast();
				blueMissile.reset();

				blueMissile.getTriangle().setVisible(true);
				blueMissile.getPath().setVisible(true);
			}

			blueMissile.setColor(Color.BLUE);
			blueMissile.spawnCoordinatesProperty().set(
			    new Point2D(
			    blueStackPane.getLayoutX(),
			    blueStackPane.getLayoutY()
			));
			blueMissile.targetCoordinatesProperty().set(
			    new Point2D(
			    redStackPane.getLayoutX() + 75,
			    redStackPane.getLayoutY()
			));

			blueMissiles.add(blueMissile);
		});
	}

	/*
				\\\\\\\\\\\
				\ CIRCLES \
				\\\\\\\\\\\
	*/
	@FXML
	private Circle blueCircle1;
	@FXML
	private Circle blueCircle2;
	@FXML
	private Circle blueCircle3;
	@FXML
	private Circle blueCircle4;
	@FXML
	private Circle blueCircle5;
	@FXML
	private Circle blueCircle6;
	@FXML
	private Circle blueCircle7;
	@FXML
	private Circle blueCircle8;
	@FXML
	private Circle blueCircle9;
	@FXML
	private Circle blueCircle10;
	@FXML
	private Circle blueCircle11;
	@FXML
	private Circle blueCircle12;
	@FXML
	private Circle blueCircle13;
	@FXML
	private Circle blueCircle14;
	@FXML
	private Circle blueCircle15;
	@FXML
	private Circle blueCircle16;
	@FXML
	private Circle blueCircle17;
	@FXML
	private Circle blueCircle18;
	@FXML
	private Circle blueCircle19;
	@FXML
	private Circle blueCircle20;

	private Circle[] blueCircles;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	private void initializeBlueCircles() {
		blueCircles = new Circle[] {
			blueCircle1,
			blueCircle2,
			blueCircle3,
			blueCircle4,
			blueCircle5,
			blueCircle6,
			blueCircle7,
			blueCircle8,
			blueCircle9,
			blueCircle10,
			blueCircle11,
			blueCircle12,
			blueCircle13,
			blueCircle14,
			blueCircle15,
			blueCircle16,
			blueCircle17,
			blueCircle18,
			blueCircle19,
			blueCircle20
		};

		for (int index = 0; index < 20; index++) {
			final int indexFinal = index;
			blueDefenseTurrets[index] = new DefenseTurret();
			blueDefenseTurrets[index].healthPointsProperty().addListener((
			    ObservableValue<? extends Number> healthPointsObservableValue,
			    Number healthPointsOldValue,
			    Number healthPointsNewValue
			) -> {
				blueCircles[indexFinal].setFill(
				    Color.BLACK.interpolate(
				    Color.BLUE,
				    healthPointsNewValue.doubleValue() /
				    DefenseTurret.MAXIMUM_HEALTH_POINTS
				));
			});
		}
	}

	/*
				\\\\\\\\\\\\\\\\
				\ PRICE SLIDER \
				\\\\\\\\\\\\\\\\
	*/
	@FXML
	private Slider bluePriceSlider;

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	private void initializeBluePriceSlider() {
	}

	/*
			-------------
			| AIR GROUP |
			-------------
	*/
	@FXML
	private Group airGroup;

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	private void initializeAirGroup() {
	}

	/*
			--------------
			| SCORE TEXT |
			--------------
	*/
	@FXML
	private Text scoreText;

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	private void initializeScoreText() {
	}

	/*
			--------------
			| PAUSE VBOX |
			--------------
	*/
	@FXML
	private VBox pauseMenuVBox;

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	public static final boolean DEFAULT_PAUSED = true;

	private void initializePauseVBox() {
		pauseMenuVBox.visibleProperty().addListener((
		    ObservableValue<? extends Boolean> visibleObservableValue,
		    Boolean visibleOldValue,
		    Boolean visibleNewValue
		) -> {
			if (visibleNewValue == null) {
				Platform.exit();
				throw new NullPointerException(
				    "visibleNewValue == null"
				);
			}

			SoundEffect.WEAPON_LOAD.getAudioClip().play();
		});

		pauseMenuVBox.setVisible(DEFAULT_PAUSED);
	}

	/*
			-------------------
			| PAUSE MENU TEXT |
			-------------------
	*/
	@FXML
	private Text pauseMenuText;

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	private void initializePauseMenuText() {
		pauseMenuText.setText("Paused");
		redBase.healthPointsProperty().addListener((
		    ObservableValue<? extends Number> healthPointsObservableValue,
		    Number healthPointsOldValue,
		    Number healthPointsNewValue
		) -> {
			if (
			    healthPointsNewValue.intValue() <=
			    Base.MINIMUM_HEALTH_POINTS
			) {
				audioManager.setVoice(Voice.BLUEZBEKISTAN_WINS);
				pauseMenuText.setText("Bluezbekistan Wins");
				resumeButton.setText("Restart");
				pauseMenuVBox.setVisible(true);
			}
		});
		blueBase.healthPointsProperty().addListener((
		    ObservableValue<? extends Number> healthPointsObservableValue,
		    Number healthPointsOldValue,
		    Number healthPointsNewValue
		) -> {
			if (
			    healthPointsNewValue.intValue() <=
			    Base.MINIMUM_HEALTH_POINTS
			) {
				audioManager.setVoice(Voice.REDANIA_WINS);
				pauseMenuText.setText("Redania Wins");
				resumeButton.setText("Restart");
				pauseMenuVBox.setVisible(true);
			}
		});
	}

	/*
			-----------------
			| RESUME BUTTON |
			-----------------
	*/
	@FXML
	private Button resumeButton;

	/*
				\\\\\\\\\\\\\\
				\ INITIALIZE \
				\\\\\\\\\\\\\\
	*/
	private void initializeResumeButton() {
		resumeButton.setOnAction((
		    ActionEvent actionEvent
		) -> {
			SoundEffect.WEAPON_LOAD.getAudioClip().play();
			pauseMenuVBox.setVisible(false);

			if (resumeButton.getText().equals("Restart")) {
				resetGame(false);
			}
		});
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
		initializeRedStackPane();
		initializeRedCircles();
		initializeRedPriceSlider();
		initializeBlueStackPane();
		initializeBlueCircles();
		initializeBluePriceSlider();
		initializeAirGroup();
		initializeScoreText();
		initializePauseVBox();
		initializePauseMenuText();
		initializeResumeButton();
		initializeMainMenuButton();

		/*
		Start game loop.
		*/
		gameLoop.start();
	}


	/*
		******************
		*** GAME LOGIC ***
		******************
	*/
	/*
			---------
			| STATE |
			---------
	*/
	/*
				\\\\\\\\\\
				\ SCORES \
				\\\\\\\\\\
	*/
	/*
					////////
					/ TIME /
					////////
	*/
	private Duration timeScore;

	/*
					/////////
					/ UNITS /
					/////////
	*/
	public int unitsScore;

	/*
				\\\\\\\\\
				\ BASES \
				\\\\\\\\\
	*/
	private final Base redBase = new Base();
	private final Base blueBase = new Base();

	/*
				\\\\\\\\\\\\\\\\\\\\
				\ DEFENSE TURRENTS \
				\\\\\\\\\\\\\\\\\\\\
	*/
	private final DefenseTurret[] redDefenseTurrets =
	    new DefenseTurret[20];
	private final DefenseTurret[] blueDefenseTurrets =
	    new DefenseTurret[20];

	/*
				\\\\\\\\\\\\
				\ MISSILES \
				\\\\\\\\\\\\
	*/
	private final LinkedList<Missile> freeRedMissiles = new LinkedList<>();
	private final ArrayList<Missile> redMissiles = new ArrayList<>();
	private final LinkedList<Missile> freeBlueMissiles = new LinkedList<>();
	private final ArrayList<Missile> blueMissiles = new ArrayList<>();

	/*
				\\\\\\\\\\\\\\\
				\ SPAWN RATES \
				\\\\\\\\\\\\\\\
	*/
	private double redSpawnRate;
	private Duration redSpawnRateDuration;
	private double blueSpawnRate;
	private Duration blueSpawnRateDuration;

	/*
				\\\\\\\\\
				\ RESET \
				\\\\\\\\\
	*/
	public void resetGame(
	    boolean isTutorial
	) {
		pauseMenuText.setText("Paused");
		resumeButton.setText("Resume");

		pauseMenuVBox.setVisible(true);

		timeScore = Duration.ZERO;
		unitsScore = 0;

		redBase.reset();
		blueBase.reset();

		for (DefenseTurret redDefenseTurret : redDefenseTurrets) {
			redDefenseTurret.healthPointsProperty().set(
			    DefenseTurret.DEFAULT_HEALTH_POINTS
			);
		}
		for (DefenseTurret blueDefenseTurret : blueDefenseTurrets) {
			blueDefenseTurret.healthPointsProperty().set(
			    DefenseTurret.DEFAULT_HEALTH_POINTS
			);
		}

		airGroup.getChildren().clear();

		redMissiles.clear();
		freeRedMissiles.clear();
		blueMissiles.clear();
		freeBlueMissiles.clear();

		accumulatedTime = Duration.ZERO;
		pauseMenuVBox.setVisible(false);
	}

	/*
				\\\\\\\\\\
				\ UPDATE \
				\\\\\\\\\\
	*/
	private void update() {
		redBase.update(fixedTimeStep);
		blueBase.update(fixedTimeStep);

		redMissiles.forEach((
		    Missile redMissile
		) -> {
			redMissile.update();
		});
		blueMissiles.forEach((
		    Missile blueMissile
		) -> {
			blueMissile.update();
		});

		timeScore = timeScore.plus(fixedTimeStep);
		scoreText.setText(
		    "Time: " + timeScore.getSeconds() +
		    "\n" +
		    "Units: " + unitsScore
		);

		if (pauseKeysTyped[0] || pauseKeysTyped[1]) {
			redMissiles.forEach((
			    redMissile
			) -> {
				redMissile.pause();
			});
			blueMissiles.forEach((
			    Missile blueMissile
			) -> {
				blueMissile.pause();
			});
			pauseMenuVBox.setVisible(true);
		}
	}

	/*
			--------
			| LOOP |
			--------
	*/
	private final Duration fixedTimeStep =
	    Duration.ofSeconds(1).dividedBy(60);
	private Duration accumulatedTime = Duration.ZERO;

	public final AnimationTimer gameLoop = new AnimationTimer() {
		private Instant previousTime;

		@Override
		public void handle(
		    long ignoredTime
		) {
			/*
			Simply return without updating the game state if the
			game is paused. Setting the previous time to null is
			used to detect when coming out of a pause so there is no
			chance of an unusually large gap.
			*/
			if (pauseMenuVBox.isVisible()) {
				previousTime = null;
				return;
			}

			/*
			If the previous time is null, the game is coming out of
			a pause, so just take a frame to establish the previous
			time again before updating game state.
			*/
			if (previousTime == null) {
				previousTime = Instant.now();
				redMissiles.forEach((
				    redMissile
				) -> {
					redMissile.resume();
				});
				blueMissiles.forEach((
				    Missile blueMissile
				) -> {
					blueMissile.resume();
				});
				return;
			}

			/*
			Now that pauses have been handled, being the real game
			loop.
			*/
			Instant currentTime = Instant.now();
			Duration elapsedTime = Duration.between(
			    previousTime,
			    currentTime
			);
			accumulatedTime =
			    accumulatedTime.plus(
			    elapsedTime
			);
			previousTime = currentTime;

			while (accumulatedTime.compareTo(fixedTimeStep) >= 0) {
				accumulatedTime =
				    accumulatedTime.minus(
				    fixedTimeStep
				);

				update();
			}
		}
	};
}