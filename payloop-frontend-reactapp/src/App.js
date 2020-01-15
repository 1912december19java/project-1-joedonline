import React, { useState } from 'react';

import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'

import LoginForm from './components/LoginForm/LoginForm';
import Homepage from './views/Homepage/Homepage';
import NavigationBar from './components/NavigationBar/NavigationBar';
import EmployeePage from './views/EmployeePage/EmployeePage';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return <Router>
    <NavigationBar />
    <Switch>
      <Route exact path="/home" component={ Homepage } />
      <Route exact path="/employee" component={ EmployeePage } />
    </Switch>
  </Router>;
}

export default App;
