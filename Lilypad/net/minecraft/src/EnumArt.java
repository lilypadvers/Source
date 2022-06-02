package net.minecraft.src;

public enum EnumArt {
	Kebab("Kebab", 16, 16, 0, 0),
	Aztec("Aztec", 16, 16, 16, 0),
	Alban("Alban", 16, 16, 32, 0),
	Aztec2("Aztec2", 16, 16, 48, 0),
	Bomb("Bomb", 16, 16, 64, 0),
	Plant("Plant", 16, 16, 80, 0),
	Wasteland("Wasteland", 16, 16, 96, 0),
	Pool("Pool", 32, 16, 0, 32),
	Courbet("Courbet", 32, 16, 32, 32),
	Sea("Sea", 32, 16, 64, 32),
	Sunset("Sunset", 32, 16, 96, 32),
	Creebet("Wanderer", 16, 32, 0, 64),
	Wanderer("Match", 32, 32, 0, 128),
	Graham("Bust", 32, 32, 32, 128),
	Match("Stage", 32, 32, 64, 128),
	Bust("Void", 32, 32, 96, 128),
	Stage("SkullAndRoses", 32, 32, 128, 128),
	Void("Fighters", 64, 32, 0, 96),
	SkullAndRoses("Pointer", 64, 64, 0, 192);

	public final String t;
	public final int u;
	public final int v;
	public final int w;
	public final int x;

	private EnumArt(String title, int sizeX, int sizeY, int offsetX, int offsetY) {
		this.t = title;
		this.u = sizeX;
		this.v = sizeY;
		this.w = offsetX;
		this.x = offsetY;
	}
}
