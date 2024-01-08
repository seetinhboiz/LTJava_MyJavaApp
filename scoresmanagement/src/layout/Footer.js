import { Col, Container, Row } from "react-bootstrap";

const FooterComponent = () => {
  return (
    <Container className="footer">
      <Row>
        <Col xs>First, but unordered</Col>
        <Col xs={{ order: 12 }}>Second, but last</Col>
        <Col xs={{ order: 1 }}>Third, but second</Col>
      </Row>
    </Container>
  );
};

export default FooterComponent;
