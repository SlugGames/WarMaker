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

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

/**
 * @author david.boeger@sluggames.com
 */
public class DefenseTurret {
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
	public static final int DEFAULT_HEALTH_POINTS = MINIMUM_HEALTH_POINTS;

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
		********************
		*** CONSTRUCTION ***
		********************
	*/
	public DefenseTurret() {
		/*
		Initialize properties.
		*/
		initializeHealthPointsProperty();
	}
}