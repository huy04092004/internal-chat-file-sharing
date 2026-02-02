# Internal Chat and File Sharing System

A backend system for an internal chat and file sharing platform, built with Java and Spring Boot, allowing users to communicate and share files within a local network.

## Features
- Real-time messaging between users
- File upload and download system
- User authentication and authorization
- Role-based access control
- Folder and file management
- Peer-to-peer file transfer
- Online user tracking

## Tech Stack
- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- WebSocket
- FTP

## Demo
Full UI screenshots:  
https://github.com/huy04092004/internal-chat-file-sharing/tree/main/docs


## Project Structure

```text
src/main/java/it/davidenastri/clouddrive/
├── config/              // Security, WebSocket, FTP configurations
├── controller/          // REST controllers (API layer)
├── services/            // Business logic
├── model/               // Entity models
├── mapper/              // Data mappers
└── P2PServerStarter.java // Application entry point
...



## Main APIs
| Method | Endpoint | Description |
|--------|---------|------------|
| POST | /api/auth/login | User login |
| POST | /api/auth/signup | User registration |
| GET | /api/messages | Get chat messages |
| POST | /api/files/upload | Upload file |
| GET | /api/files/download/{id} | Download file |
| GET | /api/users/online | Get online users |


## How to Run Locally

### Requirements
- Java 17+
- MySQL
- Maven

### Steps
```bash
git clone https://github.com/huy04092004/internal-chat-file-sharing.git
cd internal-chat-file-sharing
mvn clean install
mvn spring-boot:run
