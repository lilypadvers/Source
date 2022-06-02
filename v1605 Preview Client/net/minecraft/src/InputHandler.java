package net.minecraft.src;

import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class InputHandler {
	public static Controller[] gamepads;
	public static Controller activeGamepad;
	public static int EventDWheel = -1;
	public static int EventButton = -1;
	public static int EventDX = -1;
	public static int EventDY = -1;
	public static int EventX = -1;
	public static int EventY = -1;
	public static boolean axis4isMinusOne = true;
	public static boolean EventButtonState = false;
	public static boolean pushedGamepadEvent = false;
	public static boolean LastR1Press = false;
	public static boolean LastL1Press = false;
	public static boolean LastR2Press = false;
	public static boolean LastL2Press = false;
	public static boolean LastStartPress = false;
	public static int KBEventKey = -1;
	public static boolean KBEventKeyState = false;
	public static boolean LastAPress = false;

	public static void UpdateAxis3() {
		if(activeGamepad != null && axis4isMinusOne && (double)activeGamepad.getAxisValue(4) != -1.0D) {
			axis4isMinusOne = false;
		}

	}

	public static void CaptureGamepad() {
		gamepads = new Controller[Controllers.getControllerCount()];

		for(int var0 = 0; var0 != gamepads.length; ++var0) {
			try {
				gamepads[var0] = Controllers.getController(var0);
				if(!gamepads[var0].getName().toLowerCase().contains("controller (")) {
					gamepads[var0] = null;
				} else {
					activeGamepad = gamepads[var0];
					System.out.println("Captured: " + gamepads[var0].getName());
				}
			} catch (NullPointerException var2) {
			}
		}

	}

	public static void InputR1() {
		LastR1Press = activeGamepad.isButtonPressed(5);
		EventDWheel = LastR1Press?-1:0;
		EventDX = 0;
		EventDY = 0;
		EventButton = -1;
		EventButtonState = false;
		pushedGamepadEvent = true;
	}

	public static void InputR2() {
		LastR2Press = activeGamepad.getAxisValue(4) < -0.4F;
		EventDWheel = 0;
		EventDX = 0;
		EventDY = 0;
		EventButton = 0;
		EventButtonState = LastR2Press;
		pushedGamepadEvent = true;
	}

	public static void InputL1() {
		LastL1Press = activeGamepad.isButtonPressed(4);
		EventDWheel = LastL1Press?1:0;
		EventDX = 0;
		EventDY = 0;
		EventButton = -1;
		EventButtonState = false;
		pushedGamepadEvent = true;
	}

	public static void InputL2() {
		LastL2Press = activeGamepad.getAxisValue(4) > 0.4F;
		EventDWheel = 0;
		EventDX = 0;
		EventDY = 0;
		EventButton = 1;
		EventButtonState = LastL2Press;
		pushedGamepadEvent = true;
	}

	public static void InputA() {
		LastAPress = activeGamepad.isButtonPressed(0);
		KBEventKey = 57;
		KBEventKeyState = LastAPress;
	}

	public static void InputStart() {
		LastStartPress = activeGamepad.isButtonPressed(7);
		KBEventKey = 1;
		KBEventKeyState = LastStartPress;
	}

	public static boolean NextKBEvent() {
		if(Keyboard.next()) {
			KBEventKey = Keyboard.getEventKey();
			KBEventKeyState = Keyboard.getEventKeyState();
			return true;
		} else {
			if(activeGamepad != null) {
				if(LastAPress != activeGamepad.isButtonPressed(0)) {
					InputA();
					return true;
				}

				if(LastStartPress != activeGamepad.isButtonPressed(7)) {
					InputStart();
					return true;
				}
			}

			return false;
		}
	}

	public static boolean NextEvent() {
		UpdateAxis3();
		if(Mouse.next()) {
			EventDWheel = Mouse.getEventDWheel();
			EventButton = Mouse.getEventButton();
			EventDX = Mouse.getEventDX();
			EventDY = Mouse.getEventDY();
			EventButtonState = Mouse.getEventButtonState();
			EventX = Mouse.getEventX();
			EventY = Mouse.getEventY();
			pushedGamepadEvent = false;
			return true;
		} else {
			if(activeGamepad != null) {
				if(LastR1Press != activeGamepad.isButtonPressed(5)) {
					InputR1();
					return true;
				}

				if(LastL1Press != activeGamepad.isButtonPressed(4)) {
					InputL1();
					return true;
				}

				if(LastR2Press != activeGamepad.getAxisValue(4) < -0.4F) {
					InputR2();
					return true;
				}

				if(LastL2Press != activeGamepad.getAxisValue(4) > 0.4F) {
					InputL2();
					return true;
				}
			}

			return false;
		}
	}

	public static int GetDWheel() {
		return EventDWheel;
	}

	public static int GetEventButton() {
		return EventButton;
	}

	public static int GetEventDX() {
		return EventDX;
	}

	public static int GetEventDY() {
		return EventDY;
	}

	public static int GetEventX() {
		return EventX;
	}

	public static int GetEventY() {
		return EventY;
	}

	public static boolean GetEventButtonState() {
		return EventButtonState;
	}

	public static int GetKBEventKey() {
		return KBEventKey;
	}

	public static boolean GetKBEventKeyState() {
		return KBEventKeyState;
	}

	public static boolean IsKeyDown(int var0) {
		boolean var1 = false;
		if(var0 == 57 && activeGamepad != null) {
			var1 = activeGamepad.isButtonPressed(0);
		}

		return Keyboard.isKeyDown(var0) || var1;
	}

	public static boolean InputMouseAction(int var0) {
		if(activeGamepad != null && !axis4isMinusOne) {
			boolean var10000;
			if(!Mouse.isButtonDown(var0)) {
				label33: {
					if(var0 == 0) {
						if(activeGamepad.getAxisValue(4) < -0.4F) {
							break label33;
						}
					} else if(var0 == 1 && activeGamepad.getAxisValue(4) > 0.4F) {
						break label33;
					}

					var10000 = false;
					return var10000;
				}
			}

			var10000 = true;
			return var10000;
		} else {
			return Mouse.isButtonDown(var0);
		}
	}
}
