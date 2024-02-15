<p align="center">
    <img src="https://user-images.githubusercontent.com/58098790/205426192-0c38bccc-7325-4144-a566-cf15e304ec24.png" alt="Storybook" width="400" />
</p>

<p align="center"> Find the best location to eat around campus </p>

<br/>

<p align="center">
  <a href="https://dl.circleci.com/status-badge/redirect/gh/javier-arango/u-food/tree/main">
    <img src="https://dl.circleci.com/status-badge/img/gh/javier-arango/u-food/tree/main.svg?style=svg&circle-token=a171409f2e916d7bb610608209b330ec8fa842bf" alt="Build Status on CircleCI" />
  </a>
    
  <a href="https://sonarcloud.io/summary/new_code?id=javier-arango_u-food">
    <img src="https://sonarcloud.io/api/project_badges/measure?project=javier-arango_u-food&metric=vulnerabilities" alt="SonarCloud Vulnerabilities" />
  </a>
    
  <a href="https://sonarcloud.io/summary/new_code?id=javier-arango_u-food">
    <img src="https://sonarcloud.io/api/project_badges/measure?project=javier-arango_u-food&metric=ncloc" alt="SonarCloud report for Lines of Code" />
  </a>
    
  <a href="https://sonarcloud.io/summary/new_code?id=javier-arango_u-food">
    <img src="https://sonarcloud.io/api/project_badges/measure?project=javier-arango_u-food&metric=bugs" alt="SonarCloud report for Bugs" />
  </a>
    
  <a href="https://sonarcloud.io/summary/new_code?id=javier-arango_u-food">
    <img src="https://sonarcloud.io/api/project_badges/measure?project=javier-arango_u-food&metric=sqale_rating" alt="SonarCloud report for Maintainability Rating" />
  </a>
</p>

<p align="center"> For students at the University of Florida who need to find food services close to them, the UFood is a website that shows students food options in their budget as well as their proximity. Unlike other sites, our product is catered toward UF students and will have a pleasant user experience free for all. </p>

## Table of contents
- 🚀 [Tech Stack](#tech-stack)
- 📲 [Application type](#app-type)
- 📒 [System Architecture](#system-architecture)
- 🛠 [Configuration and Customization](#configuration-and-customization)
- 🔐 [Security and Authentication](#security-and-authentication)
- 📝 [Versioning and CI/CD](#versioning-and-cicd)
- 🏅 [Project Structure](#project-structure)
- 👥 [Getting Started](#getting-started)
    - 👨‍💻 [How to run the frontend](#how-to-run-the-frontend)
    - 💵 [How to run the backend](#how-to-run-the-backend)

## Tech Stack:
- `Frontend`: Javascript, HTML, CSS, React JS
- `Backend`: Java, SpringBoot, Yelp API, REST API
- `Database`: MySQL
- `Version Control`: Git, Github
- `CI/CD`: CircleCI

## App Type
We are going to develop a `CRUD` Application:
> Learn more [here](https://www.freecodecamp.org/news/crud-operations-explained/)

|CRUD OPERATION | HTTP REQUEST METHOD|
|---------------|--------------------|
|Create         |POST                |
|Read           |GET                 |
|Update         |PUT or PATCH        |
|Delete         |DELETE              |

## System Architecture
![UFood Architecture Design](https://user-images.githubusercontent.com/58098790/196183233-917bf032-a774-4bcb-87b6-fee185df8a5a.png)

## Project Structure
Project created using Javascript, Java, SpringBoot, and create-react-app. This application is structured in the following way:
- `u-food`: contains all the code for the project (includes server and client side)
    - `client`: contains frontend code
        - `public`: contain all the statics files such as the website favicon and the main html file of the website
        - `src`: contains all the frontend code
            - `components`: contains all the components of the app. The components will be organized as follow.
                - `component-folder`: contains all the files that are uniquely used by the component including other components. Components will be nested if they are only used by one component.
            - `assets`: contains all the assets of the project
        - `__tests__`: contains all the test for each component and functions

    - `src`: contains all the backend code
        - `main`: contains all the logic and server code (we using the [MVC](https://www.tutorialspoint.com/design_pattern/mvc_pattern.htm) pattern)
            - `java/com/api/developer/ufood`: contains the main code
                - `controller`: controller acts on both model and view. It controls the data flow into model object and updates the view whenever data changes. It keeps view and model separate.
                - `model`: dodel represents an object or JAVA POJO carrying data. It can also have logic to update controller if its data changes.
                - `view`: view represents the visualization of the data that model contains.
                - `UFoodApplication`: is the main file that will run the server. (Don't touch)
        - `test`: contains all the test files
            - `java/com/api/developer/ufood`: contains the main code for testing (Please call a test file like this NameHere.Test.java

## API Documentation
Run the backend server in go to [http://localhost:8080/api/v1/swagger-ui/index.html](http://localhost:8080/api/v1/swagger-ui/index.html)

### 🛠 Configuration and Customization
The application architecture of UFood emphasizes adaptability and robust security through strategic configuration and customization:

- **Security Configurations**: UFood incorporates specific security settings to safeguard the platform and its users. Token-based authentication is fortified with a configurable expiration time (`ufood-security.token-expiration-time=15`) and a securely generated token secret (`ufood-security.token-secret`). These settings ensure that session management is both secure and user-friendly.

- **External API Integration**: UFood's diverse dining options are powered by integration with the Yelp API. Customizable properties (`yelp.host-url` and `yelp.api-key`) streamline this process, ensuring reliable access to Yelp's rich database for real-time restaurant data, thereby enhancing the user experience with accurate and varied dining recommendations.

- **System Flexibility**: Through classes like `AppConfiguration` and `RestTemplateConfig`, the application demonstrates flexibility in setup and external communications. These configurations facilitate efficient object mapping and API interactions, laying the foundation for a scalable and maintainable codebase.

- **API Documentation with Swagger UI**: UFood leverages Swagger UI to document its API, configured via `SwaggerConfig`. This approach not only makes the API more accessible to developers but also supports transparent and easy integration, promoting an open developer community around the platform.

### 🔐 Security and Authentication
UFood's security strategy is comprehensive, ensuring the integrity, confidentiality, and availability of user data:

- **HTTPS Enforcement**: All traffic is encrypted using HTTPS, protecting data in transit against eavesdropping and tampering.

- **Token-Based Authentication**: Leveraging JWT for secure, stateless authentication allows for efficient user identification and session management without compromising security.

- **Data Protection**: Sensitive data, including user credentials, is encrypted using advanced algorithms before storage, mitigating risks associated with data breaches.

- **Proactive Security Measures**: Regular security assessments and adherence to best practices in application security help in promptly identifying and mitigating vulnerabilities.

- **Access Control**: Implementing Role-Based Access Control (RBAC) ensures users have access only to features and data pertinent to their role, further securing the application against unauthorized use.

### 📝 Versioning and CI/CD
Version control and continuous integration/continuous deployment (CI/CD) are pivotal in the development lifecycle of UFood, ensuring code quality and facilitating seamless deployments:

- **Semantic Versioning**: Adopting semantic versioning helps manage releases through meaningful version numbers, making it easier to track changes and manage dependencies.

- **Git and GitHub**: Utilizing Git for version control, with GitHub as the repository hosting service, enhances collaboration and streamlines change management, allowing for a well-organized and collaborative development process.

- **CircleCI Integration**: The integration with CircleCI automates the build, test, and deployment pipelines. This setup supports:
    - Continuous testing to maintain high-quality code standards.
    - Automated deployments, enabling quick and reliable delivery of new features and updates to users.
    - Real-time feedback on the health of the application, guiding immediate improvements.


## Getting Started
To run this project you will need Java, Gradle, and npm install in your system:
- Java: `Java 17`
- Gradle: Latest version should be fine
- npm: I think you can use a ^16.0.0 version

## How to run the frontend
> Clone the repo to a folder of you're liking using the command prompt `git clone`.
> Recommended code editor for frontend is [Visual Studio Code](https://code.visualstudio.com)

First you need to navigate to the `client` folder. Example for Mac `cd client`

In the project directory, you can run:

#### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

#### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

## How to run the backend
> Clone the repo to a folder of you're liking using the command prompt `git clone`.
> Recommended IDE for backend is [IntelliJ](https://www.jetbrains.com/idea/)

First you need to setup your IDE, so it can start running the server

1. Check that you are running Java 17 in your IDE
- Go to `file` on the top left
    - Go to `Project Structure`
        - Go to `Project` and make sure that `SDK` is set to Java 17. If you don't have Java 17 you will need to install it
        - After setting Java 17, click `Apply` and `OK`

![project-structure](https://user-images.githubusercontent.com/58098790/191312941-70add29a-2ff8-4ae9-bae3-03c285f4cef6.png)

2. After you are running Java 17 in the IDE, you need to set the run file
3. First you need to build the project by either clicking on the `build` button or by going on the terminal and running ` gradle build`
4. After build is `BUILD SUCCESSFUL` you do this to run the App:
1. Method 1
   - Go to the `UFoodApplication` file inside `main/java/com/api/developer/ufood` and run by clicking on the `Play` green button next to the class name

![run-method-1](https://user-images.githubusercontent.com/58098790/191313836-f226ba9b-1d7c-4cff-8105-140b5d603cfc.png)

2. Method 2
- Set up the Run on the IDE

    1. Step 1 - Click on `Edit Configuration` and it would open a menu

  ![step-1](https://user-images.githubusercontent.com/58098790/191316103-aba061e0-6dd6-4ba1-b811-cbd7c6c5a905.png)

    2. Step 2 - Add a new configuration on the top left of the menu (Add `SpringBoot`)

  ![step-2](https://user-images.githubusercontent.com/58098790/191317246-27689878-1a75-4e78-b6ec-2b3176168a34.png)

    3. Step 3 - Add everything like the one on the picture below

  ![step-3](https://user-images.githubusercontent.com/58098790/191317485-9cec04b3-3330-4e1f-98ed-5e4112fc5dd3.png)

    4. Step 4 - Click `Apply` and then `OK`
    5. Final step - Just run the app by clicking on the `Play` green button on top
    
