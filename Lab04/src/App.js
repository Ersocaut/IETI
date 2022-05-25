import './css/App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Página de login genérica</h1>
        <div>
          <label>Username: </label>
          <input/>
        </div>
        <div>
          <label>Password: </label>
          <input type="password"/>
        </div>
        <div>
          <br/>
        </div>
        <div>
          <button
          className='button'>
            Iniciar sesión.
          </button>
          <button
          className='button'>
            Crear cuenta.
          </button>
        </div>
      </header>
    </div>
  );
}

export default App;
