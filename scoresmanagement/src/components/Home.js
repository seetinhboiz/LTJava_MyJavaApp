import { useEffect, useState } from "react";
import { Card, Col, Row, Button } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";
import { useSearchParams } from "react-router-dom";

const Home = () => {
    const [lectures, setLectures] = useState(null);
    const [q] = useSearchParams();

    useEffect(() => {
        let loadLectures = async () => {
            try {
                let e = endpoints['getlectures'];

                let kw = q.get("kw");
                if (kw !== null)
                     e = `${e}?kw=${kw}`;

                let res = await Apis.get(e);
                setLectures(res.data);
                console.log(res.data);
            } catch (ex) {
                console.error(ex)
            };
        };

        loadLectures();
    }, [q]);

    if (lectures === null) {
        return <MySpinner />    
    };

    return (
        <>
            <h1 className="text-center text-info">GIẢNG VIÊN</h1>
            <Row>
                {lectures.map(l => {
                    return <Col xs={12} md={3} className="mt-2">
                        <Card>
                            <Card.Img variant="top" src={l.avata} />
                            <Card.Body>
                                <Card.Title>{l.name}</Card.Title>
                                <Card.Text>{l.degree}</Card.Text>
                                <Button variant="primary">Xem chi tiết</Button>
                            </Card.Body>
                        </Card>
                    </Col>
                })}
            </Row>
        </>
    );
};

export default Home;