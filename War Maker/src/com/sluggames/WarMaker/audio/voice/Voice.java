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
package com.sluggames.WarMaker.audio.voice;

import java.net.URL;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * @author david.boeger@sluggames.com
 */
public enum Voice {
	/*
		**************
		*** VALUES ***
		**************
	*/
	BLUEZBEKISTAN_WINS	(Voice.class.getResource("Bluezbekistan Wins.m4a")),
	REDANIA_WINS		(Voice.class.getResource("Redania Wins.m4a")),
	STORY			(Voice.class.getResource("Story.m4a"));


	/*
		********************
		*** MEDIA PLAYER ***
		********************
	*/
	private final MediaPlayer mediaPlayer;

	/*
			\\\\\\\
			\ GET \
			\\\\\\\
	*/
	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}


	/*
		********************
		*** CONSTRUCTION ***
		********************
	*/
	Voice(
	    URL fileURL
	) {
		if (fileURL == null) {
			throw new NullPointerException(
			    "fileURL == null"
			);
		}

		mediaPlayer = new MediaPlayer(
		    new Media(fileURL.toString())
		);
	}
}