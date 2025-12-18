ChatApp
ChatApp is a TCP socket–based chat application built in Java.
It supports multiple clients connecting to a single server simultaneously using multithreading and provides a simple JavaFX graphical interface for communication.
The project focuses on clean structure, reliability, and correct use of core networking and concurrency concepts.

Problem Addressed
Many basic chat applications:
Block the user interface during network operations
Tightly couple client and server logic
Fail when connections are unstable
This project avoids those issues by separating responsibilities and handling communication asynchronously.

Key Features
Multi-client support: The server handles multiple clients concurrently using a thread-per-client model.
Non-blocking client design: Message receiving runs on a background thread, keeping the JavaFX UI responsive.
Client-side message buffering: Messages are temporarily queued when the connection is unavailable and sent once communication is restored.
Clean client–server separation: Client logic, server logic, shared models, and utilities are clearly separated.

Core Concepts Used
TCP socket programming (Socket, ServerSocket)
Multithreading (Thread, Runnable)
Interfaces for abstraction
Thread-safe collections
JavaFX for GUI
Basic MVC pattern on the client side
Maven for dependency and build management

Project Structure (Maven Standard)
ChatApp/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   ├── client/   # Client-side UI and networking
        │   ├── server/   # Multi-threaded server logic
        │   ├── model/    # Shared message model
        │   └── util/     # Application constants
        └── resources/
            └── style.css # JavaFX UI styling

How It Works (High Level)
The server listens for incoming client connections on a fixed port.
Each client connection is handled on a separate thread.
Messages received from a client are broadcast to all connected clients.
The client application sends and receives messages asynchronously to prevent UI blocking.

Requirements
To run this project, the following are required:
Java Development Kit (JDK) 11 or higher
Apache Maven 3.8 or higher
Internet connection (for Maven to download dependencies on first run)
JavaFX is managed automatically through Maven.
No manual JavaFX installation is required.

How to Run the Application
1. Clone the repository
git clone <repository-url>
cd ChatApp

2. Start the server
Run the server first:
mvn exec:java -Dexec.mainClass="server.ServerMain"
The server will start listening for incoming client connections.

3. Start a client
In a new terminal window, run:
mvn javafx:run

Repeat this command in separate terminals to start multiple clients.

Notes
The server must be running before clients are started.
Each client instance opens a separate JavaFX window.
Multiple clients can communicate simultaneously through the server.
Possible Extensions
The current design allows future additions such as:
User identification
Message persistence
Command-based server controls
Enhanced UI features

Author
Developed as part of an Advanced Programming course project.
