package com.example.ccsd_project.Model.ServicePackage;

public class InteriorPackages extends Services {
    private String packageName,packageDesc;
    public InteriorPackages(){
        super.setName("Interior Cleaning Packages");
        super.setCategory("Automotive");
        super.setDescription("Clean entire interior of your car");
    }
    InteriorPackages(String pkgn,String pkgDesc,int maxDuration){

        super.setDuration(maxDuration);
        this.packageName = pkgn;
        this.packageDesc = pkgDesc;

    }

    public String getPackageName() {return packageName;}
    public void setPackageName(String packageName) {this.packageName = packageName;}
    public String getPackageDesc() {return packageDesc;}
    public void setPackageDesc(String packageDesc) {this.packageDesc = packageDesc;}
}
