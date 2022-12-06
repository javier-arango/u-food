import axios from "axios";

const API = axios.create({ baseURL: "http://localhost:3000" });

export const login = (formData) => API.post("/user/login", formData);
export const signup = (formData) => API.post("/user/signup", formData);
export const restData = API.get("/"); //need path
export const save = (id) => API.post("/", id); //need path and data