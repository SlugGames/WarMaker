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

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

/**
 * @author david.boeger@sluggames.com
 */
public class Base {
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
					//////////
					/ DAMAGE /
					//////////
	*/
	public static final int MINIMUM_HEAL_POINTS = 1;

	public void heal(
	    int healPoints
	) {
		if (healPoints < MINIMUM_HEAL_POINTS) {
			Platform.exit();
			throw new IllegalArgumentException(
			    "healPoints (" + healPoints + ")" +
			    " < " +
			    "MINIMUM_HEAL_POINTS (" + MINIMUM_HEAL_POINTS + ")"
			);
		}

		if (
		    healthPointsProperty.get() + healPoints >
		    MAXIMUM_HEALTH_POINTS)
		{
			healthPointsProperty.set(MAXIMUM_HEALTH_POINTS);
		} else {
			healthPointsProperty.set(
			    healthPointsProperty.get() + healPoints
			);
		}
	}

	/*
				\\\\\\\\\\\\\\
				\ SPAWN RATE \
				\\\\\\\\\\\\\\
	*/
	public static final double MINIMUM_SPAWN_RATE = 1;
	public static final double DEFAULT_SPAWN_RATE = MINIMUM_SPAWN_RATE;

	private final SimpleDoubleProperty spawnRateProperty =
	    new SimpleDoubleProperty(DEFAULT_SPAWN_RATE);

	/*
					///////
					/ GET /
					///////
	*/
	public DoubleProperty spawnRateProperty() {
		return spawnRateProperty;
	}


	/*
					////////////
					/ ON SPAWN /
					////////////
	*/
	private Runnable onSpawn;

	/*
						\\\\\\\
						\ SET \
						\\\\\\\
	*/
	public void setOnSpawn(
	    Runnable onSpawn
	) {
		this.onSpawn = onSpawn;
	}

	/*
					///////
					/ CAP /
					///////
	*/
	public static final double SPAWN_RATE_CAP_GROWTH_RATE = 2.0 / 5;
	public static final double DEFAULT_SPAWN_RATE_CAP =
	    DEFAULT_SPAWN_RATE + 20 * SPAWN_RATE_CAP_GROWTH_RATE;

	private final SimpleDoubleProperty spawnRateCapProperty =
	    new SimpleDoubleProperty(DEFAULT_SPAWN_RATE_CAP);


	/*
		*************
		*** RESET ***	
		*************
	*/
	public void reset() {
		healthPointsProperty.set(DEFAULT_HEALTH_POINTS);
		spawnRateProperty.set(DEFAULT_SPAWN_RATE);
		spawnRateCapProperty.set(DEFAULT_SPAWN_RATE_CAP);
		accumulatedTime = Duration.ZERO;
		totalTime = Duration.ZERO;
	}


	/*
		**************
		*** UPDATE ***
		**************
	*/
	private Duration accumulatedTime = Duration.ZERO;
	private Duration totalTime = Duration.ZERO;

	public void update(Duration elapsedTime) {
		accumulatedTime =
		    accumulatedTime.plus(
		    elapsedTime
		);
		totalTime =
		    totalTime.plus(
		    elapsedTime
		);

		Duration spawnTimeStep =
		    Duration.ofSeconds(1).dividedBy(
		    spawnRateProperty.getValue().longValue()
		);
		spawnRateCapProperty.set(
		    DEFAULT_SPAWN_RATE_CAP +
		    (totalTime.getSeconds() * SPAWN_RATE_CAP_GROWTH_RATE)
		);

		if (accumulatedTime.compareTo(spawnTimeStep) >= 0) {
			spawnRateProperty.set(
			    ThreadLocalRandom.current().nextDouble(
			    MINIMUM_SPAWN_RATE,
			    spawnRateCapProperty.get()
			));

			while (accumulatedTime.compareTo(spawnTimeStep) >= 0) {
				accumulatedTime =
				    accumulatedTime.minus(
				    spawnTimeStep
				);

				onSpawn.run();
			}
		}
	}


	/*
		********************
		*** CONSTRUCTION ***
		********************
	*/
	public Base() {
		/*
		Initialize properties.
		*/
		initializeHealthPointsProperty();
	}
}