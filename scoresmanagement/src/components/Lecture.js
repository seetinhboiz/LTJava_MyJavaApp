import { useEffect, useState } from "react";
import {
  Card,
  Col,
  Row,
  Button,
} from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";
import { useSearchParams } from "react-router-dom";
import ModalDetail from "../common/ModalDetail";

const Lecture = () => {
  const [lectures, setLectures] = useState(null);
  const [q] = useSearchParams();

  const [isOpenModal, setIsOpenModal] = useState(false);
  const [lectureSelect, setLectureSelect] = useState(null)

  const onClickDetail = (lecture) => {
    setLectureSelect(lecture)
    setIsOpenModal(true);
  };

  const closeModal = () => {
    setIsOpenModal(false);
  };

  useEffect(() => {
    let loadLectures = async () => {
      try {
        let e = endpoints["getlectures"];

        let kw = q.get("kw");
        if (kw !== null) e = `${e}?kw=${kw}`;

        let res = await Apis.get(e);
        setLectures(res.data);
      } catch (ex) {
        alert(ex);
      }
    };

    loadLectures();
  }, [q, isOpenModal]);

  if (lectures === null) {
    return <MySpinner />;
  }

  return (
    <>
      <div className="lecture">
        <h1 className="text-center text-info">GIẢNG VIÊN</h1>
        <Row>
          {lectures.map((l) => {
            return (
              <Col xs={12} md={3} className="mt-2">
                <Card>
                  <Card.Img className="avata" variant="top" src={l.avata} />
                  <Card.Body>
                    <Card.Title style={{ textAlign: "center" }}>
                      {l.name}
                    </Card.Title>
                    <Card.Text>Id: {l.id}</Card.Text>
                    <Card.Text>Email: {l.email}</Card.Text>
                    <Card.Text>Ngày sinh: {l.birth}</Card.Text>
                    <Card.Text>Số điện thoại: {l.phone}</Card.Text>
                    <Button
                      className="buttonDetail"
                      variant="primary"
                      onClick={() => onClickDetail(l)}
                    >
                      Xem chi tiết
                    </Button>
                  </Card.Body>
                </Card>
              </Col>
            );
          })}
        </Row>
        {isOpenModal && <ModalDetail onHide={closeModal} data={lectureSelect}/>}
      </div>
    </>
  );
};

export default Lecture;
