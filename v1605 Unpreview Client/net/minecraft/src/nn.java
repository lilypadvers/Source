package net.minecraft.src;

public class nn extends EntityCreature {
	public String[] a = new String[]{"", "", "", ""};
	public int b = -1;

	public void b(EntityItem var1) {
		super.b(var1);
		var1.a("Text1", this.a[0]);
		var1.a("Text2", this.a[1]);
		var1.a("Text3", this.a[2]);
		var1.a("Text4", this.a[3]);
	}

	public void a(EntityItem var1) {
		super.a(var1);

		for(int var2 = 0; var2 < 4; ++var2) {
			this.a[var2] = var1.i("Text" + (var2 + 1));
			if(this.a[var2].length() > 15) {
				this.a[var2] = this.a[var2].substring(0, 15);
			}
		}

	}
}
