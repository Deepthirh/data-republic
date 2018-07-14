package com.datarepublic;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenerateReport {

    public static void GenerateMasterthoughtReport() {
        try {
            File reportOutputDirectory = new File("target/Masterthought");
            List<String> jsonFiles = new ArrayList<String>();
            jsonFiles.add("target/cucumber-json-report.json");
            String buildProject = "data-republic";

            Configuration configuration = new Configuration(reportOutputDirectory, buildProject);
            configuration.setParallelTesting(false);
            configuration.setRunWithJenkins(false);
            configuration.setBuildNumber("1");

            ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
            reportBuilder.generateReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
