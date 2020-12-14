package com.by.gsu.pms.builder;

import com.by.gsu.pms.repo.RegistrationRepository;

import java.util.stream.Collectors;

public class ReportBuilder {

    private StringBuffer report;
    private RegistrationRepository repo;

    public ReportBuilder(RegistrationRepository repo) {
        this.repo = repo;
        this.report = new StringBuffer("");
    }

    public ReportBuilder withNames() {
        this.report.append("\n" + repo.findAll().stream().map((t) -> t.getUser() + ", ").collect(Collectors.joining()));
        return this;
    }

    public ReportBuilder withDates() {
        this.report.append("\n" + repo.findAll().stream().map((t) -> t.getDate() + ", ").collect(Collectors.joining()));
        return this;
    }

    public ReportBuilder withPassport() {
        this.report.append("\n" + repo.findAll().stream().map((t) -> t.getPassportNumber() + ", ").collect(Collectors.joining()));
        return this;
    }

    public ReportBuilder withFlight() {
        this.report.append("\n" + repo.findAll().stream().map((t) -> t.getFlight() + ", ").collect(Collectors.joining()));
        return this;
    }

    public ReportBuilder withFare() {
        this.report.append("\n" + repo.findAll().stream().map((t) -> t.getTotalFare() + ", ").collect(Collectors.joining()));
        return this;
    }

    public String buildReportString() {
        return this.report.toString();
    }
}
