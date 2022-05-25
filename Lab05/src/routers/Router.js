import React, { useContext } from 'react';

import {
    BrowserRouter as Router,
    Switch,
    Route,
    /* Link, */
    Redirect,
} from 'react-router-dom';

const AppRouter = () => {
    const { user } = useContext(UserContext);
    const { logged } = user;

    return (
        <Router>
            <div>
                <Switch>
                    {!logged && (
                        <Route exact path="/login" component={LogInScreen} />
                    )}
                    {logged && (
                        <Route exact path="/home" component={HomeScreen} />
                    )}
                    {!logged && <Redirect to="/login" />}
                    {logged && <Redirect to="/home" />}
                </Switch>
            </div>
        </Router>
    );
};

export default AppRouter;