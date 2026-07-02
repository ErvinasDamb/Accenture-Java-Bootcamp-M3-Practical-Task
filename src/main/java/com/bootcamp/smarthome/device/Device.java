package com.bootcamp.smarthome.device;

import lombok.Getter;
import lombok.Setter;

import com.bootcamp.smarthome.exception.HomeAutomationException;

/**
 * Abstract base class representing a smart home device.
 *
 * Every device has a unique ID, a display name, an online/offline status,
 * and an on/off power state. Concrete subclasses define device-specific
 * behaviour by implementing {@link #executeCommand(String)}.
 *
 * Prior knowledge required: abstract classes, encapsulation, inheritance.
 */
@Getter
public abstract class Device {

    private final String deviceId;
    private final String name;
    @Setter
    private boolean isOnline;
    private boolean isOn;

    public Device(String deviceId, String name, boolean isOnline) {
        this.deviceId = deviceId;
        this.name = name;
        this.isOnline = isOnline;
        this.isOn = false;
    }

    // -------------------------------------------------------------------------
    // Abstract behaviour — each device type handles its own commands
    // -------------------------------------------------------------------------

    /**
     * Executes a command string on this device.
     * The format and valid values depend on the concrete device type.
     *
     * Examples:
     *   "TURN_ON"
     *   "SET_BRIGHTNESS 75"
     *   "SET_TEMP 22.5"
     *   "UNLOCK 1234"
     */
    public abstract void executeCommand(String command) throws HomeAutomationException;

    // -------------------------------------------------------------------------
    // Shared behaviour
    // -------------------------------------------------------------------------

    public void turnOn() {
        isOn = true;
        System.out.println(name + " turned ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " turned OFF.");
    }

    @Override
    public String toString() {
        return String.format("[%s] %-20s | online=%-5b | on=%b",
                deviceId, name, isOnline, isOn);
    }
}
