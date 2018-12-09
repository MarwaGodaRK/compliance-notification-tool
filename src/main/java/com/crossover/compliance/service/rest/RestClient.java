package com.crossover.compliance.service.rest;


import com.crossover.compliance.config.ApplicationProperties;
import com.crossover.compliance.model.Activity;
import com.crossover.compliance.model.Dashboard;
import com.crossover.compliance.model.UserDetail;
import com.crossover.compliance.security.AuthenticationToken;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public  class RestClient {

    @Autowired
    private  ApplicationProperties applicationProperties;

    //TODO add error handling

    public ResponseEntity<AuthenticationToken> authenticate(String username, String pass) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Principal> entity = new HttpEntity<>(createHeaders(username, pass));
        return restTemplate.exchange(applicationProperties.getAuthUrl(), HttpMethod.POST, entity, AuthenticationToken.class);
    }

    public ResponseEntity<UserDetail> retrieveUserDetails(String username, String password) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Principal> entity = new HttpEntity<>(createHeaders(username, password));
        return restTemplate.exchange(applicationProperties.getDetailsUrl(), HttpMethod.GET, entity, UserDetail.class);
    }


    public ResponseEntity<Dashboard> getTeamDetails(String username, String password, int id) {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Principal> entity = new HttpEntity<>(createHeaders(username, password));
        return restTemplate.exchange(applicationProperties.getDashboardUrl()+id, HttpMethod.GET, entity, Dashboard.class);
    }

    public ResponseEntity<List<Activity>> getTeamActivities(String token, int managerId, int teamId, String date){
        String activitiesUrl = applicationProperties.getActivityUrl();
        activitiesUrl = activitiesUrl.replace("{managerId}", String.valueOf(managerId))
                .replace("{teamId}", String.valueOf(teamId))
                .replace("{date}",date);
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders acceptHeaders = new HttpHeaders();
        acceptHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString());
        acceptHeaders.set("X-Auth-Token", token);

        return restTemplate.exchange(
                activitiesUrl,
                HttpMethod.GET,
                new HttpEntity<>(acceptHeaders),
                new ParameterizedTypeReference<List<Activity>>(){});
    }

    private HttpHeaders createHeaders(String username, String password) {
        HttpHeaders acceptHeaders = new HttpHeaders();
        acceptHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString());

        String authorization = username + ":" + password;
        String basic = new String(Base64.encode(authorization.getBytes(Charset.forName(StandardCharsets.UTF_8.toString()))));
        acceptHeaders.set("Authorization", "Basic " + basic);

        return acceptHeaders;
    }
}
