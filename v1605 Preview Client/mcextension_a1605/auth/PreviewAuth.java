package mcextension_a1605.auth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import net.minecraft.src.TileEntityMobSpawner;
import org.lwjgl.Sys;

public class PreviewAuth {
	public static Thread authThread = null;
	public static boolean shownPreviewMessage = false;
	public static volatile long start;
	public static int rdMins = -1;
	public static volatile long endtime;

	public static void U3RhcnRUaW1lclRocmVhZA() {
		if(!shownPreviewMessage) {
			shownPreviewMessage = true;
			File var0 = new File(System.getProperty("user.dir") + "/preview_data");
			if(var0.exists()) {
				try {
					Scanner var1 = new Scanner(var0);

					try {
						rdMins = var1.nextInt();
						if(rdMins > 40 || rdMins < 0) {
							throw new NumberFormatException();
						}
					} catch (NumberFormatException var3) {
						System.out.println("FILE TAMPERED; EXITING");
						System.exit(-1);
					}

					if(rdMins == 0) {
						Sys.alert("", "Preview time expired");
						System.exit(0);
					}
				} catch (FileNotFoundException var4) {
					System.out.println("????????????????????????????");
					System.exit(-1);
				}
			} else {
				rdMins = 40;
				writePreviewFile("40");
			}

			Sys.alert("1.0.16.05 Preview version", "Welcome to the preview version of 1.0.16.05. You will be given 40 minutes to play.\n\nPlease remember that this preview version is not representative of the final product.");
			authThread = new Thread(new Runnable() {
				public void run() {
					PreviewAuth.start = System.currentTimeMillis();
					PreviewAuth.endtime = PreviewAuth.start + (long)('\uea60' * PreviewAuth.rdMins);

					while(System.currentTimeMillis() < PreviewAuth.endtime) {
						if(TileEntityMobSpawner.minRemaining() != PreviewAuth.rdMins) {
							PreviewAuth.rdMins = TileEntityMobSpawner.minRemaining();
							PreviewAuth.writePreviewFile(Integer.toString(PreviewAuth.rdMins));
						}

						try {
							Thread.sleep(100L);
						} catch (InterruptedException var2) {
						}
					}

					PreviewAuth.writePreviewFile("0");
					Sys.alert("", "Thanks for playing the preview");
					System.exit(0);
				}
			});
			authThread.start();
		}

	}

	public static void writePreviewFile(String var0) {
		try {
			File var1 = new File(System.getProperty("user.dir") + "/preview_data");
			if(var1.exists()) {
				var1.delete();
			}

			FileWriter var2 = new FileWriter(System.getProperty("user.dir") + "/preview_data");
			var2.write(var0);
			var2.close();
		} catch (IOException var3) {
			System.out.println("Unable to write data. Exiting");
			System.exit(-1);
		}

	}

	public static int minRemaining() {
		return -1;
	}
}
