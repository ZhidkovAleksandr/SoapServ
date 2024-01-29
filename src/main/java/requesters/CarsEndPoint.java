package requesters;

import io.spring.guides.gs_producing_web_service.GetCarRequest;
import io.spring.guides.gs_producing_web_service.GetCarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import repositoryDir.CarRepository;

@Endpoint
public class CarsEndPoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private CarRepository carRepository;


    @Autowired
    public CarsEndPoint(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCarResponse getCar(@RequestPayload GetCarRequest request) {
        GetCarResponse response = new GetCarResponse();
        //response.setCountry(countryRepository.findCountry(request.getName()));
        response.setCar(carRepository.findCar(request.getId()));

        return response;
    }
}
