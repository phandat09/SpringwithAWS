import React,{useState,useEffect,useCallback} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from "axios";
import {useDropzone} from 'react-dropzone'

const UserProfiles =() => {
    const [userProfiles , setUserProfiles] = useState([]);
    const fetchUserProfiles = () => {
        axios.get("http://localhost:8080/api/v1/user-profile").then( res => {
            console.log(res);
            setUserProfiles(res.data)
        });
    };
    useEffect(() =>{
        fetchUserProfiles();
    },[]);

    return userProfiles.map((userProfiles,index) =>{
        return (
            <div key={index}>
                {userProfiles.userProfileID ?
                ( <img src ={`http://localhost:8080/api/v1/user-profile/${userProfiles.userProfileID}/images/download`} />) : null}
                <br/>
                <br/>
                <h1>{userProfiles.userName}</h1>
                 <h1>{userProfiles.userProfileID}</h1>
                 <br/>
                   <MyDropzone {...userProfiles} />
            </div>
        )
    })
}

function App() {
  return (
    <div className="App">
        <UserProfiles />
    </div>
  );
}

function MyDropzone( { userProfileID } ) {
      const onDrop = useCallback(acceptedFiles => {
        const file = acceptedFiles[0];
        console.log(file);

        const formData = new FormData();
        formData.append("file",file);
        axios.post(
            `http://localhost:8080/api/v1/user-profile/${userProfileID}/images/upload`,
            formData,
            {
                header : {
                    "content-Type" : "multipart/form-data"
                }
            }
        ).then( () => {
            console.log("file upload successfully");
        }).catch(err => {
            console.log(err);
        })
      }, [])
      const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})

      return (
        <div {...getRootProps()}>
          <input {...getInputProps()} />
          {
            isDragActive ?
              <p>Drop the files here ...</p> :
              <p>Drag 'n' drop some files here, or click to select files</p>
          }
        </div>
      )
    }
export default App;
