# ChatApp
ChatApp is a TCP socket-based chat application built in Java.
It supports multiple clients connecting to a single server simultaneously using multithreading and provides a simple JavaFX-based graphical interface for communication.

The project focuses on clean structure, reliability, and correct use of core networking and concurrency concepts.

Problem Addressed
Many basic chat applications:
block the user interface during network operations 
tightly couple client and server logic
fail when connections are unstable

This project is designed to avoid those issues by separating responsibilities and handling communication asynchronously.

Key Features
Multi-client support: The server handles multiple clients concurrently using a thread-per-client model.
Non-blocking client design: Message receiving runs on a background thread, keeping the UI responsive.
Client-side message buffering: Messages are temporarily queued when the connection is unavailable and sent when communication is restored.
Clean client–server separation: Client logic, server logic, shared models, and utilities are clearly separated.

Core Concepts Used
TCP socket programming (Socket, ServerSocket)
Multithreading (Thread, Runnable)
Interfaces for abstraction
Thread-safe collections
JavaFX (FXML + CSS) for GUI
Basic MVC pattern on the client side

Project Structure
src/
├── client/    # Client-side UI and networking
├── server/    # Multi-threaded server logic
├── model/     # Shared message model
└── util/      # Application constants

resources/
├── chat.fxml  # JavaFX layout
└── style.css  # UI styling

lib/           # External libraries (not tracked)

How It Works (High Level)
The server listens for incoming client connections.
Each client connection is handled on a separate thread.
Messages received from a client are broadcast to all connected clients.
The client application sends and receives messages asynchronously to prevent UI blocking.
Running the Application
Start the server application.
Launch one or more client instances.
Connect clients to the server and exchange messages.

Possible Extensions
The current design allows future additions such as:
user identification
message persistence
command-based server controls
enhanced UI features

Author
Developed as part of Advanced programming course project.
