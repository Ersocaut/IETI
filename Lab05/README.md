
# Hooks / React Router

1. Connect your login page submit button to your API Login Endpoint using **useEffect** hook and **fetch**:
	```javascript
	// Example
	const Login () => {
		const [ token, setToken ] = useState(null);
		const navigate = useNavigate();
		useEffect(() => {
			fetch("www.example.com")
				.then((response) => {
					// Just an example, it actually should set this token into a localStorage variable or some kind of global state.
					setToken(response.token);
					// Once the user have been authenticated the app will navigate to the landing page
					navigate("/test");
				})
		}, [])
	}
	```
2. Implement basic **React Router** scaffolding files and a basic **landing page component**
3. Render on your landing page the **tasks list** using your **/tasks endpoint**, make sure you populate your **MongoDB Database** with tasks, map every task to your **UI component design**.
