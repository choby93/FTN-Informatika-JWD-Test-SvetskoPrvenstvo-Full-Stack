import React, { useCallback, useEffect, useState } from "react";
import { Button, Col, Form, Row, Table } from "react-bootstrap";
import Axios from "../../apis/Axios";
import { useNavigate } from "react-router-dom";

const Utakmica = () => {
  const admin = window.localStorage["role"] == "ROLE_ADMIN";
  const user = window.localStorage["role"] == "ROLE_KORISNIK";
  const ulogovan = window.localStorage["jwt"];

  const [reprezentacija, setReprezentacija] = useState([]);
  const [pretraga, setPretraga] = useState({
    reprezentacijaA: "",
    reprezentacijaB: "",
  });
  const [utakmica, setUtakmica] = useState([]);
  const [pageNo, setPageNo] = useState(0);
  const [totalPage, setTotalPage] = useState(0);
  const navigete = useNavigate();

  //get all utakmice
  const getUtakmice = useCallback((nextPage) => {
    const config = {
      params: {
        pageNo: nextPage,
        reprezentacijaA: pretraga.reprezentacijaA,
        reprezentacijaB: pretraga.reprezentacijaB,
      },
    };
    Axios.get("/utakmice", config)
      .then((ress) => {
        setUtakmica(ress.data);
        console.log(ress);
        setPageNo(nextPage);
        setTotalPage(ress.headers["total-pages"]);
      })
      .catch((err) => {
        console.log(err);
        alert("Došlo je do greške u preuzimanju utakmice! ");
      });
  }, []);

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

  //delete utakmica
  const deleteUtakmica = (id,) => {
    Axios.delete("/utakmice/" + id)
      .then((result) => {
        console.log(result);
        window.location.reload();
      })
      .catch((err) => {
        alert("greska pri brisanju");
        console.log(err);
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

  //render reprezentacija
  const renderUtakmice = () => {
    return utakmica.map((u) => {
      return (
        <tr key={u.id}>
          <td>{u.reprezentacija_AIme}</td>
          <td>{u.reprezentacija_BIme}</td>
          <td>{u.goloviTimA}</td>
          <td>{u.goloviTimB}</td>
          {admin || (user && ulogovan) ? (
            <>
              <td>
                <Button variant="info" onClick={() => golReprezentacijaA(u.id, u.reprezentacija_AId)}>
                  A +1
                </Button>
              </td>
              <td>
                <Button variant="info"  onClick={() => golReprezentacijaB(u.id, u.reprezentacija_BId)}>B + 1</Button>
              </td>
            </>
          ) : null}
          {admin && ulogovan ? (
            <td>
              <Button variant="danger" onClick={() => deleteUtakmica(u.id)}>
                Obriši
              </Button>
            </td>
          ) : null}
        </tr>
      );
    });
  };

  //pretraga utakmice
  const pretragaUtakmice = (e) => {
    let name = e.target.name;
    let value = e.target.value;

    pretraga[name] = value;
    setPretraga(pretraga);
  };

  //promena gola za tim A
  const golReprezentacijaA = (utakmicaId, repId) => {
    Axios.put("/utakmice/" + utakmicaId + "/repAGol")
      .then((res) => {
        console.log(res);
        navigete("/igraci/" + repId);
      })
      .catch((error) => {
        console.log(error);

        alert("Došlo je do greške u dodavanja gola timu A");
      });
  };
  //promena gola za tim A
  const golReprezentacijaB = (utakmicaId, repId) => {
    Axios.put("/utakmice/" + utakmicaId + "/repBGol")
      .then((res) => {
        console.log(res);
        navigete("/igraci/" + repId);
      })
      .catch((error) => {
        console.log(error);

        alert("Došlo je do greške u dodavanja gola timu B");
      });
  };

  //prelazak na stranicu za dodavanje
  const novaUtakmica = () => {
    navigete("/utakmice/novaUtakmica");
  };

  //prelazak na stranicu najbolji strelac
  const najboljiStrelac = () => {
    navigete("/utakmice/najboljiStrelac");
  };

  useEffect(() => {
    getUtakmice(0);
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
                onChange={(e) => pretragaUtakmice(e)}
              >
                <option value={""}></option>
                {selectReprezentacija()}
              </Form.Select>
            </Col>
            <Col>
              <Form.Label>Reprezentacija B</Form.Label>
              <Form.Select
                name="reprezentacijaB"
                onChange={(e) => pretragaUtakmice(e)}
              >
                <option value={""}></option>
                {selectReprezentacija()}
              </Form.Select>
            </Col>
          </Form>
          <Col className="mt-3 d-flex gap-2">
            <Button onClick={() => getUtakmice()}>Pretraga</Button>
            <Button variant="warning" onClick={() => window.location.reload()}>
              Osveži
            </Button>
          </Col>
        </Col>
        <Row className="mt-4">
          {ulogovan ? (
            <Col>
              <Button onClick={() => novaUtakmica()}>Nova utakmica</Button>
            </Col>
          ) : null}

          <Col className="d-flex gap-2">
            <Button
              disabled={pageNo == 0}
              onClick={() => {
                getUtakmice(pageNo - 1);
              }}
            >
              Prethodna
            </Button>
            <Button
              disabled={pageNo + 1 == totalPage || utakmica.length == 0}
              onClick={() => getUtakmice(pageNo + 1)}
            >
              {" "}
              Sledeća
            </Button>
          </Col>
          <Table>
            <thead>
              <tr>
                <th>Reprezentacija A</th>
                <th>Reprezentacija B</th>
                <th>Golovi A</th>
                <th>Golovi B</th>
                <th colSpan="3"></th>
              </tr>
            </thead>
            <tbody>{renderUtakmice()}</tbody>
          </Table>
        </Row>
        <Row>
          <Col>
            <Button variant="success" onClick={najboljiStrelac}>
              Najbolji strelac
            </Button>
          </Col>
        </Row>{" "}
      </Row>
    </>
  );
};

export default Utakmica;
