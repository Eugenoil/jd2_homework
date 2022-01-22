package by.academy.it.pojos;

import by.academy.it.interfaces.Company;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ItCompany implements Company {
    @Value("EPAN")
    private String name;

    @Value("Software Engeenering")
    private String jobsScope;

    @Value("2000")
    private Integer valueOfEmployess;

    public ItCompany(String name, String jobsScope, Integer valueOfEmployess) {
        this.name = name;
        this.jobsScope = jobsScope;
        this.valueOfEmployess = valueOfEmployess;
    }

    public ItCompany() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobsScope() {
        return jobsScope;
    }

    public void setJobsScope(String jobsScope) {
        this.jobsScope = jobsScope;
    }

    public Integer getValueOfEmployess() {
        return valueOfEmployess;
    }

    public void setValueOfEmployess(Integer valueOfEmployess) {
        this.valueOfEmployess = valueOfEmployess;
    }

    @Override
    public String toString() {
        return "ItCompany{" +
                "name='" + name + '\'' +
                ", jobsScope='" + jobsScope + '\'' +
                ", valueOfEmployess=" + valueOfEmployess +
                '}';
    }
}


