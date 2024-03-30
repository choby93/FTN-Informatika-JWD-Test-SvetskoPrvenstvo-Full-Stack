import React, { useCallback, useEffect, useState } from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import Axios from "../../apis/Axios";
import { useNavigate } from "react-router-dom";

const NovaUtakmica = () => {
  const init = {
    reprezentacijaA: "",
    reprezentacijaB: "",
  };

  const [reprezentacija, setReprezentacija] = useState([]);
  const [novaUtakmica, setNovaUtakmica] = useState(init);
  const [valid, setValid] = useState(false);
  const navigate = useNavigate();

  //get all reprezentacija
  const getReprezentacija = useCallback(() => {
    Axios.get("/reprezentacije")
      .then((ress) => {
        setReprezentacija(ress.data);
        console.log(ress);
      })
      .catch((err) => {
        console.log(err);
        alert("Došlo je do greške u preuzimanju reprezentacija! ");
      });
  }, []);

  //const add utakmica
  const addUtakmica = () => {
    let params = {
      reprezentacija_AId: novaUtakmica.reprezentacijaA,
      reprezentacija_BId: novaUtakmica.reprezentacijaB,
    };

    Axios.post("/utakmice", params)
      .then((res) => {
        console.log(res);
        navigate("/utakmice");
      })
      .catch((err) => {
        console.log(err);
        alert("Došlo je do greške u kreiranju nove utakmice");
      });
  };

  // select reprezentacija
  const selectReprezentacija = () => {
    return reprezentacija.map((r) => {
      return (
        <option key={r.id} value={r.id}>
          {r.skraceniNaziv}
        </option>
      );
    });
  };
  // promena
  const onInputChange = (e) => {
    let name = e.target.name;
    let value = e.target.value;

    let novMec = novaUtakmica;
    novMec[name] = value;
    setNovaUtakmica(novMec);
    validacija()
  };

  //provaera unosa
  const validacija = () => {
    if (
      novaUtakmica.reprezentacijaA === "" ||
      novaUtakmica.reprezentacijaB === "" ||
      novaUtakmica.reprezentacijaA === novaUtakmica.reprezentacijaB
    ) {
      setValid(false);
    } else {
      setValid(true);
    }
  };

  useEffect(() => {
    getReprezentacija();
  }, []);
  return (
    <>
      <Row>
        <Col>
          <Form className="d-flex gap-3">
            <Col>
              <Form.Label>Reprezentacija A</Form.Label>
              <Form.Select
                name="reprezentacijaA"
                onChange={(e) => onInputChange(e)}
               
              >
                <option></option>
                {selectReprezentacija()}
              </Form.Select>
            </Col>
            <Col>
              <Form.Label>Reprezentacija B</Form.Label>
              <Form.Select
                name="reprezentacijaB"
                onChange={(e) => onInputChange(e)}
              >
                <option></option>
                {selectReprezentacija()}
              </Form.Select>
            </Col>
          </Form>
          <Col className="d-flex gap-2 mt-3">
            <Button onClick={() => addUtakmica()}  disabled={!valid}>Kreirajte utakmicu</Button>
            <Button variant="danger " onClick={() => navigate("/utakmice")}>
              Odustani
            </Button>
          </Col>
        </Col>
      </Row>
    </>
  );
};

export default NovaUtakmica;
