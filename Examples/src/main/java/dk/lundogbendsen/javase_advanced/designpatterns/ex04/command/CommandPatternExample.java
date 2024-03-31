package dk.lundogbendsen.javase_advanced.designpatterns.ex04.command;

import java.util.LinkedList;
import java.util.List;

//Command interface
interface Command {
	void execute();

	default void undo() {
		// could be implemented this way, but does not make sense for a remote control
	}
}

//Concrete command for turning a device on
class TurnOnCommand implements Command {
	private Device device;

	public TurnOnCommand(Device device) {
		this.device = device;
	}

	@Override
	public void execute() {
		device.turnOn();
	}
}

//Concrete command for turning a device off
class TurnOffCommand implements Command {
	private Device device;

	public TurnOffCommand(Device device) {
		this.device = device;
	}

	@Override
	public void execute() {
		device.turnOff();
	}
}

//Concrete command for adjusting the volume of a stereo
class AdjustVolumeCommand implements Command {
	private VolumeController volumeController;
	private boolean increase;

	public AdjustVolumeCommand(VolumeController stereo, boolean increase) {
		this.volumeController = stereo;
		this.increase = increase;
	}

	@Override
	public void execute() {
		//example of command parameter to further customise the behaviour
		if (increase) {
			volumeController.increaseVolume();
		} else {
			volumeController.decreaseVolume();
		}
	}
}

//Concrete command for changing the channel of a TV
class ChangeChannelCommand implements Command {
	private TV tv;

	public ChangeChannelCommand(TV tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.changeChannel();
	}
}

//Receiver interface
interface Device {
	void turnOn();
	void turnOff();
}

interface VolumeController {
	void increaseVolume();
	void decreaseVolume();
}

//Concrete receiver for a TV
class TV implements Device, VolumeController {
	private int volume = 5;
	
	@Override
	public void turnOn() {
		System.out.println("TV is now on");
	}

	@Override
	public void turnOff() {
		System.out.println("TV is now off");
	}

	public void changeChannel() {
		System.out.println("Channel changed");
	}

	@Override
	public void increaseVolume() {
		System.out.println("incresing volume from: " + volume++ + ", to: " + volume);	
	}

	@Override
	public void decreaseVolume() {
		System.out.println("decresing volume from: " + volume-- + ", to: " + volume);
	}
}

//Concrete receiver for a stereo
class Stereo implements Device, VolumeController {
	private int volume = 16;
	
	@Override
	public void turnOn() {
		System.out.println("Stereo is now on");
	}

	@Override
	public void turnOff() {
		System.out.println("Stereo is now off");
	}

	public void adjustVolume() {
		System.out.println("Volume adjusted");
	}
	
	@Override
	public void increaseVolume() {
		System.out.println("increasing volume from: " + volume++ + ", to: " + volume);	
	}

	@Override
	public void decreaseVolume() {
		System.out.println("decreasing volume from: " + volume-- + ", to: " + volume);
	}
}

//Invoker
class RemoteControl {
	//Example of how commands can be batched (composite) to achieve complex behaviour
	private List<Command> specialButtonCommands = new LinkedList<>();

	public void programSpecialButton(Command command) {
		specialButtonCommands.add(command);
	}

	public void pressButton(Command command) {
		command.execute();
	}
	
	public void pressSpecialButton() {
		specialButtonCommands.forEach(Command::execute);
	}
}

//Example usage
public class CommandPatternExample {
	public static void main(String[] args) {
		// Create devices
		TV tv = new TV();
		Stereo stereo = new Stereo();

		// Create command objects
		Command turnOnTVCommand = new TurnOnCommand(tv);
		Command changeChannelTVCommand = new ChangeChannelCommand(tv);
		Command turnOffTVCommand = new TurnOffCommand(tv);
		
		Command turnOnStereoCommand = new TurnOnCommand(stereo);
		Command adjustVolumeStereoCommand = new AdjustVolumeCommand(stereo, true);
		

		// Create remote control
		RemoteControl remote = new RemoteControl();

		// Set and execute commands
		remote.pressButton(turnOnTVCommand); // Outputs: TV is now on
		remote.pressButton(changeChannelTVCommand); // Outputs: Channel changed
		remote.pressButton(turnOffTVCommand); // Outputs: TV is now off
		
		remote.pressButton(turnOnStereoCommand); // Outputs: Stereo is now on
		remote.pressButton(adjustVolumeStereoCommand); // Outputs: increasing volume from...
		
		remote.programSpecialButton(turnOnTVCommand);
		remote.programSpecialButton(turnOnStereoCommand);
		remote.programSpecialButton(adjustVolumeStereoCommand);
		remote.programSpecialButton(adjustVolumeStereoCommand);
		
		remote.pressSpecialButton();
	}
}
