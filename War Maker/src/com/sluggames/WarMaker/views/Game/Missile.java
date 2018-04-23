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

import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.QuadCurveTo;
import javafx.util.Duration;

/**
 * @author david.boeger@sluggames.com
 */
public class Missile {
	/*
		******************
		*** PROPERTIES ***
		******************
	*/
	/*
			----------
			| COMBAT |
			----------
	*/
	/*
				\\\\\\\\\\\\\\\\\
				\ HEALTH POINTS \
				\\\\\\\\\\\\\\\\\
	*/
	public static final int MINIMUM_HEALTH_POINTS = 0;
	public static final int MAXIMUM_HEALTH_POINTS = 100;
	public static final int DEFAULT_HEALTH_POINTS = MAXIMUM_HEALTH_POINTS;

	private final SimpleIntegerProperty healthPointsProperty =
	    new SimpleIntegerProperty(DEFAULT_HEALTH_POINTS);

	/*
					//////////////
					/ INITIALIZE /
					//////////////
	*/
	private void initializeHealthPointsProperty() {
		healthPointsProperty.addListener((
		    ObservableValue<? extends Number> healthPointsObservableValue,
		    Number healthPointsOldValue,
		    Number healthPointsNewValue
		) -> {
			if (healthPointsNewValue == null) {
				Platform.exit();
				throw new NullPointerException(
				    "healthPointsNewValue == null"
				);
			}
			if (healthPointsNewValue.intValue() < MINIMUM_HEALTH_POINTS) {
				Platform.exit();
				throw new IllegalArgumentException(
				    "healthPointsNewValue.intValue() (" + healthPointsNewValue.intValue() + ")" +
				    " < " +
				    "MINIMUM_HEALTH_POINTS (" + MINIMUM_HEALTH_POINTS + ")"
				);
			}
			if (healthPointsNewValue.intValue() > MAXIMUM_HEALTH_POINTS) {
				Platform.exit();
				throw new IllegalArgumentException(
				    "healthPointsNewValue.intValue() (" + healthPointsNewValue.intValue() + ")" +
				    " > " +
				    "MAXIMUM_HEALTH_POINTS (" + MAXIMUM_HEALTH_POINTS + ")"
				);
			}
		});
	}

	/*
					///////
					/ GET /
					///////
	*/
	public IntegerProperty healthPointsProperty() {
		return healthPointsProperty;
	}

	/*
					//////////
					/ DAMAGE /
					//////////
	*/
	public static final int MINIMUM_DAMAGE_POINTS = 1;

	public void damage(
	    int damagePoints
	) {
		if (damagePoints < MINIMUM_DAMAGE_POINTS) {
			Platform.exit();
			throw new IllegalArgumentException(
			    "damagePoints (" + damagePoints + ")" +
			    " < " +
			    "MINIMUM_DAMAGE_POINTS (" + MINIMUM_DAMAGE_POINTS + ")"
			);
		}

		if (
		    healthPointsProperty.get() - damagePoints <
		    MINIMUM_HEALTH_POINTS)
		{
			healthPointsProperty.set(MINIMUM_HEALTH_POINTS);
		} else {
			healthPointsProperty.set(
			    healthPointsProperty.get() - damagePoints
			);
		}
	}

	/*
				\\\\\\\\\\\\\\\\\\\\\
				\ SPAWN COORDINATES \
				\\\\\\\\\\\\\\\\\\\\\
	*/
	private final SimpleObjectProperty<Point2D> spawnCoordinatesProperty =
	    new SimpleObjectProperty<>();

	/*
					///////
					/ GET /
					///////
	*/
	public ObjectProperty<Point2D> spawnCoordinatesProperty() {
		return spawnCoordinatesProperty;
	}

	/*
				\\\\\\\\\\\\\\\\\\\\\\
				\ TARGET COORDINATES \
				\\\\\\\\\\\\\\\\\\\\\\
	*/
	private final SimpleObjectProperty<Point2D> targetCoordinatesProperty =
	    new SimpleObjectProperty<>();

	/*
					///////
					/ GET /
					///////
	*/
	public ObjectProperty<Point2D> targetCoordinatesProperty() {
		return targetCoordinatesProperty;
	}


	/*
		****************
		*** TRIANGLE ***
		****************
	*/
	private final Polygon triangle = new Polygon(
	    -10, 10,
	    10, 0,
	    -10, -10
	);

	/*
			-------
			| GET |
			-------
	*/
	public Polygon getTriangle() {
		return triangle;
	}


	/*
		************
		*** PATH ***
		************
	*/
	private final Path path = new Path();

	/*
			-------
			| GET |
			-------
	*/
	public Path getPath() {
		return path;
	}


	/*
		*********************
		*** ON TARGET HIT ***
		*********************
	*/
	private Runnable onTargetHit;

	/*
			-------
			| SET |
			-------
	*/
	public void setOnTargetHit(
	    Runnable onTargetHit
	) {
		pathTransition.setOnFinished((
		    ActionEvent actionEvent
		) -> {
			onTargetHit.run();
		});
	}


	/*
		****************
		*** ON DEATH ***
		****************
	*/
	private Runnable onDeath;

	/*
			-------
			| SET |
			-------
	*/
	public void setOnDeath(
	    Runnable onDeath
	) {
		this.onDeath = onDeath;
	}


	/*
		*************
		*** PAUSE ***
		*************
	*/
	public void pause() {
		pathTransition.pause();
	}
	public void resume() {
		pathTransition.play();
	}


	/*
		*************
		*** RESET ***
		*************
	*/
	public void reset() {
		path.getElements().clear();
	}


	/*
		**************
		*** UPDATE ***
		**************
	*/
	private final PathTransition pathTransition = new PathTransition();

	public void update() {
		if (healthPointsProperty.get() <= MINIMUM_HEALTH_POINTS) {
			pathTransition.stop();
			onDeath.run();
			return;
		}

		if (path.getElements().isEmpty()) {
			double lowX =
			    spawnCoordinatesProperty.get().getX() <
			    targetCoordinatesProperty.get().getX() ?
			    spawnCoordinatesProperty.get().getX() :
			    targetCoordinatesProperty.get().getX();
			double highX =
			    spawnCoordinatesProperty.get().getX() >
			    targetCoordinatesProperty.get().getX() ?
			    spawnCoordinatesProperty.get().getX() :
			    targetCoordinatesProperty.get().getX();
			double lowY =
			    targetCoordinatesProperty.get().getY() - 400;
			double highY =
			    targetCoordinatesProperty.get().getY() + 400;

			path.getElements().add(
			    new MoveTo(
			    spawnCoordinatesProperty.get().getX(),
			    spawnCoordinatesProperty.get().getY()
			));
			path.getElements().add(
			    new QuadCurveTo(
			    ThreadLocalRandom.current().nextDouble(lowX, highX),
			    ThreadLocalRandom.current().nextDouble(lowY, highY),
			    targetCoordinatesProperty.get().getX(),
			    targetCoordinatesProperty.get().getY()
			));

			pathTransition.setNode(triangle);
			pathTransition.setPath(path);
			pathTransition.setOrientation(
			    PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT
			);
			pathTransition.setDuration(Duration.seconds(2));
			pathTransition.play();
		}
	}


	/*
		********************
		*** CONSTRUCTION ***
		********************
	*/
	public Missile() {
		triangle.setFill(Color.BLACK);
		path.setStroke(Color.BLACK);
		path.getStrokeDashArray().setAll(5d, 5d);
	}

	public void setColor(
	    Color color
	) {
		triangle.setFill(color);
		path.setStroke(color);
	}
}