interface Command {
    void execute();
}
class Light {
    public void turnOn() {
        System.out.println("The Light is now ON.");
    }

    public void turnOff() {
        System.out.println("The Light is now OFF.");
    }
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command == null) {
            System.out.println("No command assigned to this button.");
            return;
        }
        command.execute();
    }
}

//  Test Class
public class CommandPatternExample {
    public static void main(String[] args) {
        
        System.out.println("--- Setting up Smart Home ---");
        
        Light livingRoomLight = new Light();
        
        Command turnOnLight = new LightOnCommand(livingRoomLight);
        Command turnOffLight = new LightOffCommand(livingRoomLight);
        
        RemoteControl remote = new RemoteControl();

        System.out.println("\n--- Testing Remote Control ---");
        
        remote.setCommand(turnOnLight);
        System.out.print("Button Pressed: ");
        remote.pressButton();

        remote.setCommand(turnOffLight);
        System.out.print("Button Pressed: ");
        remote.pressButton();
    }
}