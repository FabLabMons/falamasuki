/*
 * Copyright 2018 FabLab Mons
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {employees: []};
  }

  componentDidMount() {
    client({method: 'GET', path: '/api/employees'}).done(response => {
      this.setState({employees: response.entity._embedded.employees});
    });
  }

  render() {
    return (
      <EmployeeList employees={this.state.employees}/>
    );
  }
}

class EmployeeList extends React.Component {
  render() {
    var employees = this.props.employees.map(employee =>
      <Employee key={employee._links.self.href} employee={employee}/>,
    );
    return (
      <table>
        <tbody>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Description</th>
        </tr>
        {employees}
        </tbody>
      </table>
    );
  }
}

class Employee extends React.Component {
  render() {
    return (
      <tr>
        <td>{this.props.employee.firstName}</td>
        <td>{this.props.employee.lastName}</td>
        <td>{this.props.employee.description}</td>
      </tr>
    );
  }
}

ReactDOM.render(
  <App/>,
  document.getElementById('react'),
);
