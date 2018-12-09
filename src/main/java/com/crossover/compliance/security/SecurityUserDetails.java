package com.crossover.compliance.security;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUserDetails extends User {

    private int userId;
    private List<Integer> teamIdList;

    public SecurityUserDetails(String username, String password,
            Collection<? extends GrantedAuthority> authorities, int userId, List<Integer> teamIdList) {
        super(username, password, authorities);
        this.userId = userId;
        this.teamIdList = teamIdList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getTeamIdList() {
        return teamIdList;
    }

    public void setTeamIdList(List<Integer> teamIdList) {
        this.teamIdList = teamIdList;
    }
}
