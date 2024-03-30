import React, { useCallback, useEffect, useState } from "react";
import Axios from "../../apis/Axios";
import { Button, Col, Form, Row } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";

const Strelac = () => {
  const [igrac, setIgrac] = useState([]);
  const [igracId, setIgracId] = useState();
  let navigate = useNavigate();
  let params = useParams();
  let reprezentacijaId = params.id;

  //getAllIgrace
  const getIgraci = useCallback(() => {
    const config = {
      params: {
        reprezentacijaId: reprezentacijaId,
      },
    };

    Axios.get("/igraci/reprezentacija", config)
      .then((result) => {
        setIgrac(result.data);
        console.log(result);
      })
      .catch((error) => alert("Došlo je do greške u preuzimanju igrača"));
  }, []);

  //select strelca
  const strelac = () => {
    return igrac.map((i) => {
      return (
        <option value={i.id} key={i.id}>
          {i.ime} {i.prezime}
        </option>
      );
    });
  };

  // strelac
  const strelacGola = (igracId) => {
    Axios.put("/igraci/" + igracId + "/strelac")
      .then((result) => {
        console.log(result);
        navigate("/utakmice");
      })
      .catch((error) => {
        console.log(error);
        alert("Greška pri dodavanju gola igraču!");
      });
  };

  useEffect(() => {
    getIgraci();
  }, []);
  return (
    <Row>
      <Col>
        <Form>
          <Form.Label>Strelac gola</Form.Label>
          <Form.Select
            name="igracId"
            onChange={(e) => setIgracId(e.target.value)}
          >
            <option></option>
            {strelac()}
          </Form.Select>
          <Button className="mt-3" onClick={() => strelacGola(igracId)}>
            Dodajte gol
          </Button>
        </Form>
      </Col>
    </Row>
  );
};

export default Strelac;
