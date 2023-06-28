<!DOCTYPE html>
    <head>
        <title>sample firestore</title>
        <style>
          label{display: inline-block; width:80px}
          input,select {width:120px}
        </style>
    </head>

    <body>
        <label>Name</label> <input id="Namebox" type="text"> <br><br>
        <label>RollNo</label> <input id="Rollbox" type="text"> <br><br>
        <label>Section</label> <input id="Secbox" type="text"> <br><br>
        <label>Gender</label>
        <select id="Genbox">
            <option value="Male">Male</option>"
            <option value="Female">Female</option>
        </select>

        <hr>
        <button id="Insbtn">INSERT</button>
        <button id="Selbtn">SELECT</button>
        <button id="Updbtn">UPDATE</button>
        <button id="Delbtn">DELETE</button>

<!--IMPORTS + CONFIGURATION-->

        <script type="module">
            // Import the functions you need from the SDKs you need
            import { initializeApp } from "https://www.gstatic.com/firebasejs/9.6.7/firebase-app.js";
            // TODO: Add SDKs for Firebase products that you want to use
            // https://firebase.google.com/docs/web/setup#available-libraries
          
            // Your web app's Firebase configuration
            const firebaseConfig = {
              apiKey: "AIzaSyCC1EkQSox41JNshi1SapvCYk_AvQ9ZV8Y",
              authDomain: "sampleproj-54667.firebaseapp.com",
              projectId: "sampleproj-54667",
              storageBucket: "sampleproj-54667.appspot.com",
              messagingSenderId: "780224519716",
              appId: "1:780224519716:web:db06a7332674ea1521c2b1"
            };
          
            // Initialize Firebase
            const app = initializeApp(firebaseConfig);

            import {
                getFirestore, doc, getDoc, setDoc, collection, addDoc, updateDoc, deleteDoc, deleteField
            }
            from "https://www.gstatic.com/firebasejs/9.6.7/firebase-firestore.js";

            const db = getFirestore();

//--References--//

            let NameBox = document.getElementById("Namebox");
            let RollBox = document.getElementById("Rollbox");
            let SecBox = document.getElementById("Secbox");
            let GenBox = document.getElementById("Genbox");

            let InsBtn = document.getElementById("Insbtn");
            let SelBtn = document.getElementById("Selbtn");
            let UpdBtn = document.getElementById("Updbtn");
            let DelBtn = document.getElementById("Delbtn");

//--ADDING DOCUMENT--//

            async function AddDocument_AutoID(){
                var ref = collection(db, "TheStudentsList");

                const docRef = await addDoc (
                    ref, {
                        NameOfStd: NameBox.value,
                        RollNo: RollBox.value,
                        Section: SecBox.value,
                        Gender: GeBox.value
                    }
                )
                .then(()=>{
                    alert("data added successfully");
                })
                .catch((error)=>{
                    alert("Unsuccessful Operation. error:"+ error);
                });
                console.log("document id is "+ docRef.id);
            }

            async function AddDocument_CustomID(){

                var ref = doc(db,"TheStudentsList", RollBox.value);

                await setDoc (
                    ref, {
                        NameOfStd: NameBox.value,
                        RollNo: RollBox.value,
                        Section: SecBox.value,
                        Gender: GenBox.value
                    }
                )
                .then(()=>{
                    alert("data added successfully");
                })
                .catch((error)=>{
                    alert("Unsuccessful Operation, error:"+ error);
                });
            }

//--GETTING DOCUMENT--//

            async function GetADocument(){
                var ref = doc(db,"TheStudentsList", RollBox.value);
                const docSnap = await getDoc(ref);

                if(docSnap.exists()){
                    NameBox.value = docSnap.data().NameOfStd;
                    SecBox.value = docSnap.data().Section;
                    GenBox.value = docSnap.data().Gender;
                }
                else{
                    alert("No such document");
                }
            }


//--UPDATING DOCUMENT DATA--//
            async function UpdateFieldsInADocument(){
                var ref = doc(db,"TheStudentsList", RollBox.value);

                await updateDoc(
                    ref, {
                        NameOfStd: NameBox.value,
                        Section: SecBox.value,
                        Gender: GenBox.value
                    }
                )
                .then(()=>{
                    alert("data updated successfully");
                })
                .catch((error)=>{
                    alert("Unsuccessful Operation, error:"+ error);
                });
            }

//--DELETING DOCUMENT--//
        
            async function DeleteDocument(){
            var ref = doc(db,"TheStudentsList", RollBox.value);
            const docSnap = await getDoc(ref);

            if(!docSnap.exists()){
                alert("Document does not exists");
                return;
                }

                await deleteDoc(ref)
                .then(()=>{
                    alert("data deleted successfully");
                })
                .catch((error)=>{
                    alert("Unsuccessful Operation, error:"+ error);
                });
            }

//--Assign Events To Btns-->

                InsBtn.addEventListener("click", AddDocument_CustomID);
                SelBtn.addEventListener("click", GetADocument);
                UpdBtn.addEventListener("click", UpdateFieldsInADocument);
                DelBtn.addEventListener("click", DeleteDocument);

          </script>

    </body>

</html>