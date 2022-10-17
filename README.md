# UFood
For students at the University of Florida who need to find food services close to them, the UFood is a website that shows students food options in their budget as well as their proximity. Unlike other sites, our product is catered toward UF students and will have a pleasant user experience free for all. 

## Table of contents
- 🚀 [Tech Stack](#tech-stack)
- 📲 [Application type](#app-type)
- 📒 [System Architecture](#system-architecture)
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
      - `components`: contains the component files
      - `assets`: contains all the assets of the project
      - `styles`: contains all the styles such as CSS
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
    
