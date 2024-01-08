import {
  Button,
  ModalDialog,
  ModalHeader,
  ModalTitle,
  ModalBody,
  ModalFooter,
  Row,
  Col,
  Image,
} from "react-bootstrap";

const ModalDetail = ({ onHide, data }) => {
  console.log("data: ", data);
  return (
    <div
      className="modal show modalDetail"
      style={{ display: "block", position: "initial" }}
    >
      <ModalDialog size="lg" centered onHide={onHide}>
        <ModalHeader>
          <ModalTitle>Chi tiết giảng viên</ModalTitle>
        </ModalHeader>

        <ModalBody>
          <Row>
            <Col md={4}>
              <Image src={data.avata} rounded fluid/>
            </Col>
            <Col md={8} className="textWrapper">
              {data.id && <div className="textInfo"><strong>Id:</strong> {data.id}</div>}
              {data.name && <div className="textInfo"><strong>Tên: </strong>{data.name}</div>}
              {data.degree && <div className="textInfo"><strong>Bằng cấp: </strong>{data.degree}</div>}
              {data.email && <div className="textInfo"><strong>Email: </strong>{data.email}</div>}
              {data.birth && <div className="textInfo"><strong>Ngày sinh: </strong>{data.birth}</div>}
              {data.phone && <div className="textInfo"><strong>Số diện thoại: </strong>{data.phone}</div>}
              {data.address && <div className="textInfo"><strong>Địa chỉ: </strong>{data.address}</div>}
            </Col>
          </Row>
        </ModalBody>

        <ModalFooter>
          <Button variant="secondary" onClick={onHide}>
            Đóng
          </Button>
          <Button variant="primary">Chỉnh sửa</Button>
        </ModalFooter>
      </ModalDialog>
    </div>
  );
};

export default ModalDetail;
