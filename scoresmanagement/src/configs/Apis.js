import axios from "axios";

const SERVER_CONTEXT = "/StudentManagement";

export const endpoints = {
    "getlectures": `${SERVER_CONTEXT}/api/lectures`
}

export default axios.create({
    baseURL: "http://localhost:8080"
})