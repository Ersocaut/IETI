import { useState, useEffect } from "react";
import {Button, TextField, FormControl} from "@mui/material";
import { Box } from "@mui/system";

function App() {
  
  const [data, setData] = useState({email : '', password : ''});
  const [ token, setToken ] = useState(null);

  function getUsername(e) {
    if (e.target.id === "inputUsername"){
      setData({...data, 
        email: e.target.value});
    }
  }

  function getPassword(e){
    if (e.target.id === "inputPassword"){
      setData({...data,
      password: e.target.value});
    }
  }

  const login = () => {
      fetch("http://localhost:8080/auth",{
        method: 'POST',
        headers: {"Access-Control-Allow-Origin": "*",
        "Content-Type": "application/json"},
        body: JSON.stringify(data)
      }).then(res => {
        console.table(res);
      });
  }

  return (
    <div className="App" align="center">
      <Box sx = {{p: 1, 
        bgcolor: 'primary-main',
        alignItems: 'center'}}>
        
        <FormControl>
        <TextField required
        id="inputUsername"
        label="Username"
        onChange={getUsername}></TextField>

        <TextField required
        id="inputPassword"
        label="Password"
        type="password"
        onChange={getPassword}></TextField>
        
        <Button variant="contained"
        onClick={
          login
        }> Log in </Button>

        </FormControl>
      </Box>
    </div>
  );
}

export default App;
