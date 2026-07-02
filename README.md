# Smart Home Controller

A Java console application that simulates a smart home controller managing multiple device types (lights, thermostats, and locks). The application intentionally contains bugs and missing features that you must implement across four tasks.

## Prerequisites

- Java 21+
- Maven 3.8+

## Running the Application

```bash
mvn compile exec:java -Dexec.mainClass="com.bootcamp.smarthome.Main"
```

## Project Structure

```
src/main/java/com/bootcamp/smarthome/
├── Main.java                    # Entry point and demo scenarios
├── controller/
│   ├── CommandParser.java       # Parses command strings
│   └── HomeController.java      # Manages registered devices
└── device/
    ├── Device.java              # Abstract base class
    ├── SmartLight.java          # Dimmable light bulb
    ├── SmartThermostat.java     # Programmable thermostat
    └── SmartLock.java           # PIN-protected door lock
```

---

## Task 1 — Custom Exception Hierarchy (Completed)

Implemented a custom exception hierarchy in the `com.bootcamp.smarthome.exception` package:
- `HomeAutomationException` (Checked)
- `DeviceOfflineException` (Checked)
- `InvalidCommandException` (Checked)
- `DeviceNotFoundException` (Unchecked)
- `InvalidValueException` (Checked) with specific field/value/constraint constructor.

---

## Task 2 — Exception Handling (Completed)

- Added range validation to `SmartLight` and `SmartThermostat`.
- Implemented PIN validation in `SmartLock`.
- Refactored `HomeController.sendCommand` with `try-catch-finally` to wrap exceptions and ensure command processing logs are printed.

---

## Task 3 — SLF4J + Logback Logging (Completed)

- Integrated SLF4J loggers in `HomeController` and `SmartLock`.
- Replaced `System.out.println` with appropriate log levels (`DEBUG`, `INFO`, `WARN`, `ERROR`).
- Configured `logback.xml` with `FILE` appender and set root level to `WARN`.

---

## Task 4 — Debug & Fix Planted Bugs (Completed)

All deliberate bugs have been resolved:
1. **Fixed `NullPointerException`** in `SmartLock.validatePin()` by adding null checks.
2. **Fixed `ArrayIndexOutOfBoundsException`** in `HomeController.findDevice()` by correcting loop boundaries.
3. **Fixed Logic Bug** in `SmartThermostat.setTemperature()` range validation.
4. **Fixed Logic Bug** in `CommandParser.extractCommand()` to correctly preserve command values.

---

## Additional Improvements
- **Lombok Integration**: Added Lombok `@Getter` and `@Setter` to `Device.java` to reduce boilerplate code.
