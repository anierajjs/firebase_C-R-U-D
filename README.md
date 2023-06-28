# firebase_C-R-U-D

This repository contains the code for two  websites that perform same CRUD (Create, Read, Update, Delete) operations on Firebase databases such as realtime and firestore. Each website allows you to manage student records with different fields.

## READ, WRITE, UPDATE, DELETE (firebase_C-R-U-D/realtime/firebase.html)
### Website Output:
you will see:
> - Name (input)
> - Student Number (input)
> - Section (input)
> - Gender (dropdown button)
> - INSERT SELECT UPDATE DELETE (buttons)

### Firebase Firestore Database Configuration:
Firebase Console URL: [Sampleproj](https://console.firebase.google.com/project/sampleproj-9499a/firestore/data/)
> - Project ID: sampleproj-9499a
> - Collection Name: TheStudentsList

Firestore Collection Structure:
> - Document ID: auto/custom
>    - Gender: int
>    - NameofStd: int
>    - Section: int
>    - StudentNumber: str


## sample firestore (firebase_C-R-U-D/firestore/firestore.html)
### Website Output:
you will see:
> - Name (input)
> - RollNo (input)
> - Section (input)
> - Gender (dropdown button)
> - INSERT SELECT UPDATE DELETE (buttons)


### Firebase Firestore Database Configuration:
Firebase Console URL: [sampleproj](https://console.firebase.google.com/u/0/project/sampleproj-54667/firestore/data/)
> - Project ID: sampleproj-54667
> - Collection Name: TheStudentsList

Firestore Collection Structure:
> - Document ID: auto/custom
>    - Gender: int
>    - NameOfStd: init
>    - RollNo: str
>    - Section: int

## Usage
- Clone the respective repository for the desired website to your local machine.
- Open the html file in a web browser.
- Enter the student information in the respective input fields.
- Select the desired operation (INSERT, SELECT, UPDATE, DELETE) using the provided buttons.
- View the results on the website.

## Disclaimer
These projects are for educational purposes and serve as demonstrations of CRUD operations using Firebase. Ensure you have appropriate security measures in place when deploying them to a production environment.
For any issues or questions regarding the system, please contact the system administrator or the developer.
