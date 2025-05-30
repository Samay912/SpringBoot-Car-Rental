# Car Rental System

## Description
A full-stack application for a car rental system, built with Spring Boot (Java) for the backend, Next.js (React) for the frontend, and MongoDB as the database.

## Key Features
*   User Authentication: Signup, Login, and Profile Management.
*   Car Management: Browse available cars, view car details.
*   Carpool Management: Create, join, and manage carpools.
*   Rental Management: Book cars and manage existing rentals.
*   Admin Panel: For administrative tasks like managing users and car listings.

## Technologies Used
*   **Backend:** Java (JDK 21), Spring Boot, Spring Security, Maven.
*   **Frontend:** Next.js, React, Recoil (for state management), Axios (for HTTP requests), TailwindCSS.
*   **Database:** MongoDB.

## Prerequisites
*   Java Development Kit (JDK) version 21 or higher.
*   Apache Maven.
*   Node.js and npm (or yarn/pnpm).
*   MongoDB instance running (default connection: `mongodb://localhost:27017/car_rental`).

## Setup and Execution Instructions

### General
1.  Clone the repository:
    ```bash
    git clone https://github.com/Samay912/SpringBoot-Car-Rental.git
    ```
2.  Navigate to the cloned directory:
    ```bash
    cd SpringBoot-Car-Rental
    ```

### Backend Setup
1.  Navigate to the backend directory:
    ```bash
    cd backend
    ```
2.  **MongoDB Connection:**
    *   The MongoDB connection URI is configured in `backend/src/main/resources/application.properties`.
    *   The default URI is `spring.data.mongodb.uri=mongodb://localhost:27017/car_rental`.
    *   Modify this URI if your MongoDB instance is running on a different host or port, or requires authentication.
3.  Run the application:
    *   Using Maven Wrapper (recommended):
        ```bash
        ./mvnw spring-boot:run
        ```
    *   If you have Maven installed globally (and for Windows users without WSL):
        ```bash
        mvn spring-boot:run
        ```
4.  The backend server will typically start on port `8080`.

### Frontend Setup
1.  Navigate to the frontend directory:
    ```bash
    cd ../frontend 
    ```
    (Assuming you are in the `backend` directory, otherwise `cd frontend` from the root)
2.  Install dependencies:
    *   Using npm:
        ```bash
        npm install
        ```
    *   Or using yarn:
        ```bash
        yarn install
        ```
    *   Or using pnpm:
        ```bash
        pnpm install
        ```
3.  Start the development server:
    *   Using npm:
        ```bash
        npm run dev
        ```
    *   Or using yarn:
        ```bash
        yarn dev
        ```
    *   Or using pnpm:
        ```bash
        pnpm dev
        ```
4.  The frontend development server will typically start at `http://localhost:3000`.

## Project Structure
The repository is organized as follows:

*   `/backend`: Contains the Spring Boot (Java) backend application.
    *   `src/main/java`: Main source code for the backend.
    *   `src/main/resources`: Configuration files, static assets for the backend.
    *   `pom.xml`: Maven project configuration.
*   `/frontend`: Contains the Next.js (React) frontend application.
    *   `app/`: Main source code for Next.js 13+ (App Router).
    *   `components/`: Reusable React components.
    *   `public/`: Static assets for the frontend.
    *   `package.json`: NPM/Yarn/PNPM project configuration.
*   `README.md`: This file, providing an overview and setup instructions.

## API Endpoints Overview
The backend exposes a set of RESTful APIs to enable communication with the frontend application. Below is a general overview of the main controllers:

*   **`CarController`**: Handles operations related to car listings, such as retrieving available cars, fetching details for a specific car, and potentially managing car inventory (admin).
*   **`CarpoolController`**: Manages functionalities related to carpools, including creating new carpools, joining existing ones, and viewing carpool details.
*   **`RentalController`**: Responsible for processes related to car rentals, such as booking a car, managing existing rental agreements, and viewing rental history.
*   **`UserController`** (or a similar name like `AuthController`): Manages user authentication (signup, login, logout), user profiles, and other user-specific data.


## Contribution Guidelines
Contributions are welcome! If you'd like to contribute to the project, please follow these steps:

1.  **Fork the Repository**: Click the 'Fork' button at the top right of the repository page.
2.  **Clone Your Fork**:
    ```bash
    git clone https://github.com/Samay912/SpringBoot-Car-Rental.git
    cd SpringBoot-Car-Rental
    ```
3.  **Create a New Branch**: Choose a descriptive branch name.
    *   For features:
        ```bash
        git checkout -b feature/your-feature-name
        ```
    *   For bug fixes:
        ```bash
        git checkout -b bugfix/issue-number-or-description
        ```
4.  **Make Your Changes**: Implement your feature or bug fix.
5.  **Commit Your Changes**: Write clear and concise commit messages.
    ```bash
    git add .
    git commit -m "feat: Implement X feature" 
    # or "fix: Resolve Y bug"
    # or "docs: Update Z documentation"
    ```
6.  **Push to Your Fork**:
    ```bash
    git push origin feature/your-feature-name
    ```
7.  **Submit a Pull Request (PR)**:
    *   Go to the original repository on GitHub.
    *   You should see a prompt to create a PR from your recently pushed branch.
    *   Click "Compare & pull request".
    *   Ensure the base repository's `main` (or `master`) branch is selected as the target.
    *   Provide a clear title and description for your PR, explaining the changes and any relevant context.
    *   Submit the PR.

Please ensure your code adheres to any existing coding standards and include tests if applicable.
