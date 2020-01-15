import React from 'react';

import { Link } from 'react-router-dom';

const NavigationBar = props => <>
  <nav>
    <div className="nav-wrapper">
      <Link to="#" className="brand-logo">Payloop</Link>
      <ul id="nav-mobile" className="right hide-on-med-and-down">
        <li><Link to="/home">Homepage</Link></li>
        <li><Link to="/employee">Employee Page</Link></li>
      </ul>
    </div>
  </nav>
</>;

export default NavigationBar;
