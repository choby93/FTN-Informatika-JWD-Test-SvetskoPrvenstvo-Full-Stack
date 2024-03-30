import React, { useCallback, useEffect, useState } from "react";
import { Button, Col, Row, Table } from "react-bootstrap";
import Axios from "../../apis/Axios";
import { useNavigate } from "react-router-dom";

const NajboljiStrelac = () => {
  const [igrac, setIgrac] = useState([]);
  const navigate = useNavigate();

  //getAllIgrace
  const getIgraci = useCallback(() => {
    Axios.get("/igraci")
      .then((result) => setIgrac(result.data))
      .catch((error) => {
        alert("Došlo je do greške u preuzimanju igrača");
        console.log(error);
      });
  }, []);

  //retnder igraci
  const igraci = () => {
    return igrac.map((i) => {
      return (
        <tr key={i.id}>
          <td>{i.ime}</td>
          <td>{i.prezime}</td>
          <td>{i.brGolova}</td>
          <td>{i.reprezentacijaIme}</td>
        </tr>
      );
    });
  };

  useEffect(() => {
    getIgraci();
  }, []);

  return (
    <>
      <Row>
        <Col>
          <Table>
            <thead>
              <tr>
                <th>Ime</th>
                <th>Prezima</th>
                <th>Broj golova</th>
                <th>Reprezentacija</th>
              </tr>
            </thead>
            <tbody>{igraci()}</tbody>
          </Table>
          <Button variant="info" onClick={() => navigate("/utakmice")}>
            Nazad
          </Button>
        </Col>
      </Row>
    </>
  );
};

export default NajboljiStrelac;
