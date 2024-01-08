import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./layout/Header";
import Lecture from "./components/Lecture";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from "react-bootstrap";
import FooterComponent from "./layout/Footer";
import './App.css' 

const App = () => {
  return (
    <BrowserRouter>
    <Header />
      <Container>
        <Routes>
          <Route path="/" element={<Lecture />} />
        </Routes>
      </Container>
    <FooterComponent />
    </BrowserRouter>
  )
}

export default App;