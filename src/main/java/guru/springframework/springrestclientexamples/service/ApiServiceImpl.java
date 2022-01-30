package guru.springframework.springrestclientexamples.service;

import guru.springframework.api.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUsers(Integer limit) {
        List<User> users = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users?_limit=" + limit, List.class);
        return users;
    }
}
