package com.kandclay.cbcopy;

import com.badlogic.gdx.Game;

public class MyDemoGame extends Game {
	@Override
	public void create() {
		this.setScreen(new MainMenuScreen(this));
	}
}
