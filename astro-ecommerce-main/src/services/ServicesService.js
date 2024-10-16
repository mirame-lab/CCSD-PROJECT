import axios from "axios";

const SERVICES_API_BASE_URL = "http://localhost:8080/"
class ServicesService{
    getServices(){
        return axios.get(SERVICES_API_BASE_URL);
    }
}

export default new ServicesService()