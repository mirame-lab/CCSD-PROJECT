package com.example.ccsd_project.Model.ServicePackage;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "service_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "services")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String category;
    private String description;
    private double rate;
    private double duration;

    public Services() {}

    public Services(String name, String category, String desc) {
        this.name = name;
        this.category = category;
        this.description = desc;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public double getRate() { return rate; }
    public double getDuration() { return duration; }

    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setDescription(String description) { this.description = description; }
    public void setRate(double rate) { this.rate = rate; }
    public void setDuration(double duration) { this.duration = duration; }
}
