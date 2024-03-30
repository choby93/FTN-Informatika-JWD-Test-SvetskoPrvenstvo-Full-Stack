import React from "react";
import { createRoot } from 'react-dom/client';
import { Route, Link, HashRouter as Router, Routes } from "react-router-dom";
import { Navbar, Nav, Container, Button } from "react-bootstrap";
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import 'bootstrap/dist/css/bootstrap.min.css';
import { logout } from "./services/auth";
import { Navigate } from "react-router-dom/dist";
import Login from "./components/authorization/Login";
import Utakmica from "./components/Svetsko prvenstvo/Utakmica";
import NovaUtakmica from "./components/Svetsko prvenstvo/NovaUtakmica";
import NajboljiStrelac from "./components/Svetsko prvenstvo/NajboljiStrelac";
import Strelac from "./components/Svetsko prvenstvo/Strelac";



const App = () => {
  if (window.localStorage["jwt"]) {
    return (
      <>
        <Router>
          <Navbar expand bg="dark" variant="dark">

            <Nav style={{ marginLeft: "20px" }}>
              <Nav.Link as={Link} to="/">SVETSKO PRVENSTVO</Nav.Link>
              <Nav.Link as={Link} to="/utakmice">Utakmice</Nav.Link>
              <Button onClick={logout}>Logout</Button>
            </Nav>
          </Navbar>
          <Container style={{ paddingTop: "25px" }}>
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="*" element={<NotFound />} />
              <Route path="/utakmice" element={<Utakmica />} />
              <Route path="/utakmice/novaUtakmica" element={<NovaUtakmica />} />
              <Route path="/utakmice/najboljiStrelac" element={<NajboljiStrelac />} />
              <Route path="igraci/:id" element={<Strelac />} />
            </Routes>
          </Container>
        </Router>
      </>
    );
  } else {
    return (
      <>
        <Router>
          <Navbar expand bg="dark" variant="dark">

            <Nav>
              <Nav.Link as={Link} to="/">SVETSKO PRVENSTVO</Nav.Link>
              <Nav.Link as={Link} to="/utakmice">Utakmice</Nav.Link>
              <Nav.Link as={Link} to="/login">Login</Nav.Link>
            </Nav>
          </Navbar>
          <Container style={{ paddingTop: "25px" }}>
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/login" element={<Login />} />
              <Route path="*" element={<Navigate replace to="/login" />} />
              <Route path="/utakmice" element={<Utakmica />} />
              <Route path="/utakmice/najboljiStrelac" element={<NajboljiStrelac />} />
            </Routes>
          </Container>
        </Router>
      </>
    );
  }
};

const rootElement = document.getElementById('root');
const root = createRoot(rootElement);

root.render(
  <App />,
);
