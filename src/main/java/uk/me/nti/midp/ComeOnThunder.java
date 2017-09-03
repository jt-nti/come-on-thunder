package uk.me.nti.midp;

import java.util.Date;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class ComeOnThunder extends MIDlet implements CommandListener {
	private Display display;

	private Form mainForm;
	private Alert thunderConfirmationAlert;

	private Command lightningCommand;
	private Command thunderCommand;

	private double lightningTime;
	private StringItem thunderDelayText;
	private StringItem lightningDistanceText;

	public ComeOnThunder() {
		this.mainForm = new Form("Come On Lightning!");

		this.thunderDelayText = new StringItem("Thunder delay (seconds)", "-");
		this.mainForm.append(this.thunderDelayText);
		this.lightningDistanceText = new StringItem("Lightning distance (km)", "-");
		this.mainForm.append(this.lightningDistanceText);

		this.lightningCommand = new Command("Flash", Command.SCREEN, 2);
		this.mainForm.addCommand(this.lightningCommand);
		this.mainForm.setCommandListener(this);

		this.thunderConfirmationAlert = new Alert("Come on thunder!", "Waiting for thunder...", null, null);

		this.thunderConfirmationAlert.addCommand(this.lightningCommand);
		this.thunderCommand = new Command("Boom", Command.SCREEN, 1);
		this.thunderConfirmationAlert.addCommand(this.thunderCommand);
		this.thunderConfirmationAlert.setCommandListener(this);
	}

	protected void startApp() {
		this.display = Display.getDisplay(this);
		this.display.setCurrent(this.mainForm);
	}

	protected void pauseApp() {
	}

	protected void destroyApp(boolean unconditional) {
	}

	public void commandAction(Command c, Displayable s) {
		if (c == this.lightningCommand) {
			this.lightningTime = new Date().getTime();
			this.display.setCurrent(this.thunderConfirmationAlert, this.mainForm);
		} else if (c == this.thunderCommand) {
			long thunderTime = new Date().getTime();
			double thunderDelay = (thunderTime - this.lightningTime) / 1000;
			this.thunderDelayText.setText(this.getRoundedString(thunderDelay));
			double lightningDistance = thunderDelay / 3;
			this.lightningDistanceText.setText(this.getRoundedString(lightningDistance));
			this.display.setCurrent(this.mainForm);
		}
	}

	/*
	 * Wow, you don't get much in J2ME! This should round the
	 * results to one decimal place based on...
	 *
	 * - Multiply the number by 10^N
	 * - Add 0.5
	 * - truncate the result to an integer
	 * - Divide by 10^N
	 */
	private String getRoundedString(double num) {
		StringBuffer result = new StringBuffer();

		int truncated = (int)((num * 10) + 0.5);
		result.append(truncated);
		result.insert(result.length() - 1, '.');

		return result.toString();
	}
}
