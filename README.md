# Full Stack Application Form

This is a full-stack web application designed to securely handle a one-time application form submission.
The project uses Angular for the frontend and Spring Boot for the backend, with JWT-based authentication
and file upload capabilities.


## Features

- Signup functionality using JWT authentication  
- Multi-step form divided into sections: personal info, address, education, work experience, training, etc.  
- Auto-saving draft data locally in browser storage for each section  
- Final submission includes file upload (photo and chart) via FormData  
- One-time form submission per user  
- Review page showing submitted data after submission  
- Section-wise edit option after submission (only one-time update allowed)  
- After final update, form becomes locked  
- Route protection using Angular AuthGuard and backend token validation  



## Technologies Used

 Frontend:  
- Angular  
- TypeScript, HTML, CSS  

 Backend:
- Spring Boot  
- Spring Data JPA  
- Hibernate  
- MySQL  

 Security:
- JWT (JSON Web Token)  
- Angular Route Guard  

 Tools:
- Postman (API testing)  
- Git and GitHub (Version control)  



## Project Structure

full-stack-application-form/
│
├── backend/                  ← Spring Boot backend code
│   ├── controller/           ← API controllers
│   ├── dto/                  ← Data Transfer Objects
│   ├── entity/               ← JPA entities
│   ├── service/              ← Business logic
│   ├── repository/           ← Spring Data JPA repositories
│   └── config/               ← JWT security configuration

├── frontend/                 ← Angular frontend code
    ├── components/           ← Step-wise form components
    ├── services/             ← AuthService, FormService
    ├── guards/               ← Route protection (AuthGuard)
    └── review-submit/        ← Final review and submit page

## Application Flow

- The user signs up using their name, email, and password.  
- After signup, a JWT token is issued by the backend and saved in the browser's localStorage.  
- The user fills out the form section by section. Each section is auto-saved as a draft.  
- On submission, the complete form data along with photo and chart files is sent to the backend.  
- Once the form is submitted, the user is redirected to a review page.  
- The review page loads submitted data through a secure API call.  
- Each section on the review page has an edit option for one-time corrections.  
- After the update is completed, the form is locked and cannot be edited again.

## Authentication Logic

- JWT token is generated on signup and stored in the browser  
- All form routes are protected using Angular Route Guard  
- Backend APIs verify the token from the Authorization header  
- Users cannot access or modify form content without being authenticated  
- Form submission and update are restricted to a single attempt per user
