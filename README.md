# Vacations Booking System - Back-End

This project is a Java Spring Boot back-end application designed to manage a travel agency's vacation packages and customer bookings. It serves as the data persistence and API layer for a full-stack web application.
## Project Overview

The primary goal of this project was to develop a functional API that facilitates the booking process for "Exotic Vacations." It manages complex relational data including customers, cart items, vacations, and excursions.
### Key Features

    RESTful API: Exposes endpoints for managing customers, vacations, and cart items.

    Purchase Processing: A custom controller handles the checkout flow, generating unique tracking numbers and managing transaction status.

    Relational Mapping: Implements a robust data model with One-to-Many and Many-to-One relationships.

    Validation: Ensures all required fields are populated during the checkout process to maintain data integrity.

## Technical Architecture

    Language: Java 17

    Framework: Spring Boot 3.3.6

    Build Tools: Maven 4.0.0 / Lombok 1.18.36

    Data Access: Spring Data JPA / Spring Data REST

    Database: MySQL

### Data Model

The back-end architecture is built around several core entities:

    Customer: Stores personal information and links to a specific division.

    Cart & CartItem: Tracks the "in-progress" selections made by a user.

    Vacation & Excursion: Represents the travel packages and add-on activities available for purchase.

## Installation & Setup
### Prerequisites

    Java 17

    Maven

    MySQL Server

### Configuration

    Database Setup: Update the application.properties file with your MySQL credentials:
    Properties

    spring.datasource.url=jdbc:mysql://localhost:3306/vacation_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password

    Run the Back-end:
    Bash

    mvn spring-boot:run

    Front-end Integration: Ensure the Angular front-end is configured to point to http://localhost:8080/api/.

## Custom Implementation Details
### The Purchase Controller

The most critical part of this back-end is the Purchase and PurchaseResponse DTO (Data Transfer Object) logic. When a customer checks out, the system:

    Extracts the Cart and CartItems from the request.

    Generates a Unique Tracking Number (UUID).

    Sets the status to "Ordered".

    Persists the customer data and associated cart items in a single transaction.

### CORS Configuration

To allow the Angular front-end to communicate with this Spring Boot API, a global CORS configuration is applied to the repositories, permitting requests from the front-end origin.
