package net.minecraft.isom;

import java.applet.Applet;
import java.awt.BorderLayout;
import net.minecraft.src.RecipesArmor;

public class IsomPreviewApplet extends Applet {
	private RecipesArmor a = new RecipesArmor();

	public IsomPreviewApplet() {
		this.setLayout(new BorderLayout());
		this.add(this.a, "Center");
	}

	public void start() {
		this.a.b();
	}

	public void stop() {
		this.a.c();
	}
}
