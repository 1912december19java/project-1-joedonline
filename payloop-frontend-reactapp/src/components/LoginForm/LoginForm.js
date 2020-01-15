import React from 'react';

const LoginForm = props => <>

  <form>
    <label htmlFor="username">Username:</label>
    <input type="text" name="username" placeholder="Your username" />
    <label htmlFor="password">Password:</label>
    <input type="password" name="password" placeholder="Your password" />
    <input className="waves-effect waves-light btn" type="submit" name="submit" placeholder="submit" />
  </form>

</>;

export default LoginForm;
