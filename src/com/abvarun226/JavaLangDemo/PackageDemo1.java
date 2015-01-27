package com.abvarun226.JavaLangDemo;

/**
 * Created by bharghav on 1/23/15.
 */
public class PackageDemo1 {
    public static void main(String... args) {
        Package pkg1[];

        pkg1 = Package.getPackages();

        for (int i=0 ; i<pkg1.length ; i++) {
            System.out.println(
                    pkg1[i].getName() + " " +
                    pkg1[i].getImplementationTitle() + " " +
                    pkg1[i].getImplementationVendor() + " " +
                    pkg1[i].getImplementationVersion()
            );
        }
    }
}
