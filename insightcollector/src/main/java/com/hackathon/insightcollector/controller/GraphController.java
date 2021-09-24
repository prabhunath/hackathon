package com.hackathon.insightcollector.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author pryadav
 */
@Controller
public class GraphController {

    @GetMapping("/barChart")
    public String barChart(Model model) {
        Map<String, Integer> data = new LinkedHashMap<String, Integer>();
        data.put("A", 12);
        data.put("B", 88);
        data.put("C", 45);
        data.put("D", 70);
        model.addAttribute("keySet", data.keySet());
        model.addAttribute("values", data.values());
        return "barChart";

    }

    @GetMapping("/pieChart")
    public String pieChart(Model model) {

        model.addAttribute("pass", 90);
        model.addAttribute("fail", 10);
        return "pieChart";

    }

    @PostMapping("/upload")
    public void process(@RequestParam(value = "data", required = false) MultipartFile data) {
        if (null == data) {
            System.out.println("Data is null");
        } else {
            System.out.println("Recieved file:" + data.getName());
            System.out.println("Recieved file name:" + data.getResource().getFilename());
        }

    }

}
