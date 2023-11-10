import { useEffect, useState } from "react";
import { Button, Col, Container, Form, Nav, NavDropdown, Navbar, Row } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "./MySpinner";
import { useNavigate } from "react-router-dom";

const Header = () => {
    const [lectures, setLectures] = useState(null);
    const [kw, setKw] = useState(""); 
    const nav = useNavigate();

    useEffect(() => {
        const loadLectures = async () => {
            let res = await Apis.get(endpoints['getlectures'])

            setLectures(res.data);
        };

        loadLectures();
    }, []); 

    const search = (evt) => {
        evt.preventDefault();
        nav(`/?kw=${kw}`);
    };

    if (lectures === null) {
        return <MySpinner />
    }

    return (
        <>
            <Navbar expand="lg" className="bg-body-tertiary">
                <Container>
                    <Navbar.Brand href="#home">React-Bootstrap</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link href="#home">Trang chủ</Nav.Link>
                            <NavDropdown title="Danh mục" id="basic-nav-dropdown">
                                {lectures.map(l => <NavDropdown.Item href="#action/3.1" key={l.id}>{l.name}</NavDropdown.Item>)}
                            </NavDropdown>
                        </Nav>
                    </Navbar.Collapse>

                    <Form inline onSubmit={search}>
                        <Row>
                            <Col xs="auto">
                                <Form.Control
                                    type="text"
                                    value={kw}
                                    onChange={e => setKw(e.target.value)}
                                    placeholder="Search"
                                    className=" mr-sm-2"
                                />
                            </Col>
                            <Col xs="auto">
                                <Button type="submit">Submit</Button>
                            </Col>
                        </Row>
                    </Form>
                </Container>
            </Navbar>
        </>
    )
}

export default Header;